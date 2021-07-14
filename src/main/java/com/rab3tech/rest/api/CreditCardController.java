package com.rab3tech.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.rab3tech.dto.AppVO;
import com.rab3tech.dto.CreditCardDTO;
import com.rab3tech.rest.exception.CreditCardException;
import com.rab3tech.service.CreditCardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author javahunk
 *
 */
@RestController
@RequestMapping("/v4")
@Api(value = "CreditCardController", description = "REST APIs related to CreditCard Entity!!!!")
public class CreditCardController {

	@Autowired
	private CreditCardService creditCardService;

	@PostMapping("/creditcards")
	@ResponseStatus(code = HttpStatus.CREATED)
	public AppVO postCreditCard(@RequestBody CreditCardDTO  creditCardDTO) {
		creditCardService.persist(creditCardDTO);
		AppVO appVO = new AppVO();
		appVO.setCode("200");
		appVO.setMessage("Credit card details is uploaded successfully!!!!!!!!!");
		return appVO;
	}

	// Expose rest API
	@DeleteMapping("/creditcards/{ccid}")
	@ResponseStatus(code = HttpStatus.OK)
	public AppVO deleteCreditCard(@PathVariable("ccid") int ccid) {
		creditCardService.removeByCcid(ccid);
		AppVO appVO = new AppVO();
		appVO.setCode("200");
		appVO.setMessage("Credit card details is deleted successfully!!!!!!!!!");
		return appVO;
	}

	// Expose rest API
	@GetMapping("/creditcards/{ccid}")
	@ResponseStatus(code = HttpStatus.OK)
	public CreditCardDTO getCreditCard(@PathVariable("ccid") int ccid) {
		if(ccid<1) {
			CreditCardException cardException=new CreditCardException("Sorry ccid cannot be negative!!!!!!!!!!!!!");
			throw cardException;
		}
		return creditCardService.findByCcid(ccid);
	}
	
	
	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/creditcards")
	@ResponseStatus(code = HttpStatus.OK)
	public List<CreditCardDTO> getCreditCard() {
		return creditCardService.findAll();
	}

}
