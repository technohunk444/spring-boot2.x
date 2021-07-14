package com.rab3tech.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rab3tech.dao.entity.CreditCard;

public interface CreditCardRepository extends  JpaRepository<CreditCard, Integer>{
	
	//Who will give implementation of it ->>>> spring data jpa
	public Optional<CreditCard> findByCcno(String ccno);

}
