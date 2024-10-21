<template>
  <div class="content">
    <div class="row">
      <div class="col-12">
        <card class="card-plain">
          <!-- <template slot="header">
            <h4 class="card-title">Table on Plain Background</h4>
            <p class="category">Here is a subtitle for this table</p>
          </template>-->
          <div class="table-full-width text-left">
            <bookingAgent-table
            v-if="bookingAgents && bookingAgents.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:bookingAgents="bookingAgents"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-booking-agents="getAllBookingAgents"
             >

            </bookingAgent-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/index";

import BookingAgentTable from "@/components/BookingAgentTable";
import BookingAgentService from "../services/BookingAgentService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    BookingAgentTable,
  },
  data() {
    return {
      bookingAgents: [],
	  totalElements: 0,
      page: 0,
      searchQuery: '',     
      table1: {
        title: "Simple Table",
        columns: [...tableColumns],
        data: [...tableData],
      },
    };
  },
  methods: {
    async getAllBookingAgents(sortBy='bookingAgentId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await BookingAgentService.getAllBookingAgents(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.bookingAgents.length) {
					this.bookingAgents = response.data.bookingAgents;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching bookingAgents:", error);
        }
        
      } catch (error) {
        console.error("Error fetching bookingAgent details:", error);
      }
    },
  },
  mounted() {
    this.getAllBookingAgents();
  },
  created() {
    this.$root.$on('searchQueryForBookingAgentsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllBookingAgents();
    })
  }
};
</script>
<style></style>
