package com.jodiairplus8.dao;

import java.util.List;

import com.jodiairplus8.dao.GenericDAO;
import com.jodiairplus8.domain.Airline;





public interface AirlineDAO extends GenericDAO<Airline, Integer> {
  
	List<Airline> findAll();
	






}


