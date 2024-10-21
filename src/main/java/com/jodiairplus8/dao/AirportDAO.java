package com.jodiairplus8.dao;

import java.util.List;

import com.jodiairplus8.dao.GenericDAO;
import com.jodiairplus8.domain.Airport;





public interface AirportDAO extends GenericDAO<Airport, Integer> {
  
	List<Airport> findAll();
	






}


