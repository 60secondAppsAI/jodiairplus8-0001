import http from "../http-common";

class BookingAgentService {
  getAllBookingAgents(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/bookingAgent/bookingAgents`, searchDTO);
  }

  get(bookingAgentId) {
    return this.getRequest(`/bookingAgent/${bookingAgentId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/bookingAgent?field=${matchData}`, null);
  }

  addBookingAgent(data) {
    return http.post("/bookingAgent/addBookingAgent", data);
  }

  update(data) {
  	return http.post("/bookingAgent/updateBookingAgent", data);
  }
  
  uploadImage(data,bookingAgentId) {
  	return http.postForm("/bookingAgent/uploadImage/"+bookingAgentId, data);
  }




	postRequest(url, data) {
		return http.post(url, data);
      };

	getRequest(url, params) {
        return http.get(url, {
        	params: params
        });
    };

}

export default new BookingAgentService();
