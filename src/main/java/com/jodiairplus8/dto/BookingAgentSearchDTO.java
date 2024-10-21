package com.jodiairplus8.dto;

import java.sql.Timestamp;
import java.time.Year;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookingAgentSearchDTO {

	private Integer page = 0;
	private Integer size;
	private String sortBy;
	private String sortOrder;
	private String searchQuery;

	private Integer bookingAgentId;
	
	private String name;
	
	private String contactEmail;
	
	private String agencyName;
	
}
