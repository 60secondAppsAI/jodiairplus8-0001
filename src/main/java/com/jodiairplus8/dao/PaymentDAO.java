package com.jodiairplus8.dao;

import java.util.List;

import com.jodiairplus8.dao.GenericDAO;
import com.jodiairplus8.domain.Payment;





public interface PaymentDAO extends GenericDAO<Payment, Integer> {
  
	List<Payment> findAll();
	






}


