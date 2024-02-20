package com.example.aditya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.aditya.xml.school.Acknowledgement;
import com.aditya.xml.school.CustomerRequest;

@Endpoint
public class LoanEligibilityindicatorEndpoint {
	
	private static final String NAMESPACE="http://www.aditya.com/xml/school";
	@Autowired
	private LoanEligibilityService service;
	@PayloadRoot(namespace=NAMESPACE,localPart ="CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkLoanEligibility(request);
	}

}
