import http from "../http-common";

class ReservationService {
  getAllReservations(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/reservation/reservations`, searchDTO);
  }

  get(reservationId) {
    return this.getRequest(`/reservation/${reservationId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/reservation?field=${matchData}`, null);
  }

  addReservation(data) {
    return http.post("/reservation/addReservation", data);
  }

  update(data) {
  	return http.post("/reservation/updateReservation", data);
  }
  
  uploadImage(data,reservationId) {
  	return http.postForm("/reservation/uploadImage/"+reservationId, data);
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

export default new ReservationService();
