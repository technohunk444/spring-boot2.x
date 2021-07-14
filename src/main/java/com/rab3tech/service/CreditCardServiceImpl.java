package com.rab3tech.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab3tech.dao.CreditCardRepository;
import com.rab3tech.dao.entity.CreditCard;
import com.rab3tech.dto.CreditCardDTO;
import com.rab3tech.rest.exception.BankServiceException;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	private CreditCardRepository cardRepository;

	// Who will call this persist ??? controller -<<< it;s rest api
	@Override
	public void persist(CreditCardDTO cardDTO) {
		CreditCard creditCard = new CreditCard();
		BeanUtils.copyProperties(cardDTO, creditCard);
		// Creating instance of Timestamp
		Timestamp timestamp = new Timestamp(new Date().getTime());
		creditCard.setDoe(timestamp);
		cardRepository.save(creditCard);
	}

	@Override
	public CreditCardDTO findByCcid(int ccid) {
		Optional<CreditCard> creditCardOptional = cardRepository.findById(ccid);
		if (!creditCardOptional.isPresent()) {
			BankServiceException bankServiceException = new BankServiceException("Ccid does not exist into database!");
			throw bankServiceException;

		}
		CreditCardDTO cardDTO = new CreditCardDTO();
		BeanUtils.copyProperties(creditCardOptional.get(), cardDTO);
		return cardDTO;
	}

	@Override
	public void removeByCcid(int ccid) {
		cardRepository.deleteById(ccid);
	}

	@Override
	public List<CreditCardDTO> findAll() {
		List<CreditCardDTO> cardDTOs = new ArrayList<CreditCardDTO>();
		List<CreditCard> creditCards = cardRepository.findAll();
		for (CreditCard creditCard : creditCards) {
			CreditCardDTO cardDTO = new CreditCardDTO();
			BeanUtils.copyProperties(creditCard, cardDTO);
			cardDTOs.add(cardDTO);
		}
		return cardDTOs;
	}

}
