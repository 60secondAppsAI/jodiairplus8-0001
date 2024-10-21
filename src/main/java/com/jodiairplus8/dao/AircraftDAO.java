package com.jodiairplus8.dao;

import java.util.List;

import com.jodiairplus8.dao.GenericDAO;
import com.jodiairplus8.domain.Aircraft;





public interface AircraftDAO extends GenericDAO<Aircraft, Integer> {
  
	List<Aircraft> findAll();
	






}


