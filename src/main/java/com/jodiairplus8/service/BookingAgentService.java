package com.jodiairplus8.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.jodiairplus8.domain.BookingAgent;
import com.jodiairplus8.dto.BookingAgentDTO;
import com.jodiairplus8.dto.BookingAgentSearchDTO;
import com.jodiairplus8.dto.BookingAgentPageDTO;
import com.jodiairplus8.dto.BookingAgentConvertCriteriaDTO;
import com.jodiairplus8.service.GenericService;
import com.jodiairplus8.dto.common.RequestDTO;
import com.jodiairplus8.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface BookingAgentService extends GenericService<BookingAgent, Integer> {

	List<BookingAgent> findAll();

	ResultDTO addBookingAgent(BookingAgentDTO bookingAgentDTO, RequestDTO requestDTO);

	ResultDTO updateBookingAgent(BookingAgentDTO bookingAgentDTO, RequestDTO requestDTO);

    Page<BookingAgent> getAllBookingAgents(Pageable pageable);

    Page<BookingAgent> getAllBookingAgents(Specification<BookingAgent> spec, Pageable pageable);

	ResponseEntity<BookingAgentPageDTO> getBookingAgents(BookingAgentSearchDTO bookingAgentSearchDTO);
	
	List<BookingAgentDTO> convertBookingAgentsToBookingAgentDTOs(List<BookingAgent> bookingAgents, BookingAgentConvertCriteriaDTO convertCriteria);

	BookingAgentDTO getBookingAgentDTOById(Integer bookingAgentId);







}





