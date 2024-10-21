package com.jodiairplus8.dao;

import java.util.List;

import com.jodiairplus8.dao.GenericDAO;
import com.jodiairplus8.domain.BookingAgent;





public interface BookingAgentDAO extends GenericDAO<BookingAgent, Integer> {
  
	List<BookingAgent> findAll();
	






}


