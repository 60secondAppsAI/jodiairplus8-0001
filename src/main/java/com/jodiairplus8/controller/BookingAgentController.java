package com.jodiairplus8.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.jodiairplus8.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.jodiairplus8.domain.BookingAgent;
import com.jodiairplus8.dto.BookingAgentDTO;
import com.jodiairplus8.dto.BookingAgentSearchDTO;
import com.jodiairplus8.dto.BookingAgentPageDTO;
import com.jodiairplus8.service.BookingAgentService;
import com.jodiairplus8.dto.common.RequestDTO;
import com.jodiairplus8.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/bookingAgent")
@RestController
public class BookingAgentController {

	private final static Logger logger = LoggerFactory.getLogger(BookingAgentController.class);

	@Autowired
	BookingAgentService bookingAgentService;



	//@AllowSystem(AuthScopes.READ)
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<BookingAgent> getAll() {

		List<BookingAgent> bookingAgents = bookingAgentService.findAll();
		
		return bookingAgents;	
	}

	//@ReadAccess
	@GetMapping(value = "/{bookingAgentId}")
	@ResponseBody
	public BookingAgentDTO getBookingAgent(@PathVariable Integer bookingAgentId) {
		
		return (bookingAgentService.getBookingAgentDTOById(bookingAgentId));
	}

 	//@WriteAccess
 	@RequestMapping(value = "/addBookingAgent", method = RequestMethod.POST)
	public ResponseEntity<?> addBookingAgent(@RequestBody BookingAgentDTO bookingAgentDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = bookingAgentService.addBookingAgent(bookingAgentDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}
		
		return result.asResponseEntity();
	}

	//@ReadAccess
	@GetMapping("/bookingAgents")
	public ResponseEntity<BookingAgentPageDTO> getBookingAgents(BookingAgentSearchDTO bookingAgentSearchDTO) {
 
		return bookingAgentService.getBookingAgents(bookingAgentSearchDTO);
	}	

 	//@WriteAccess
	@RequestMapping(value = "/updateBookingAgent", method = RequestMethod.POST)
	public ResponseEntity<?> updateBookingAgent(@RequestBody BookingAgentDTO bookingAgentDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = bookingAgentService.updateBookingAgent(bookingAgentDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
