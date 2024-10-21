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
            <reservation-table
            v-if="reservations && reservations.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:reservations="reservations"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-reservations="getAllReservations"
             >

            </reservation-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/index";

import ReservationTable from "@/components/ReservationTable";
import ReservationService from "../services/ReservationService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    ReservationTable,
  },
  data() {
    return {
      reservations: [],
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
    async getAllReservations(sortBy='reservationId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await ReservationService.getAllReservations(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.reservations.length) {
					this.reservations = response.data.reservations;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching reservations:", error);
        }
        
      } catch (error) {
        console.error("Error fetching reservation details:", error);
      }
    },
  },
  mounted() {
    this.getAllReservations();
  },
  created() {
    this.$root.$on('searchQueryForReservationsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllReservations();
    })
  }
};
</script>
<style></style>
