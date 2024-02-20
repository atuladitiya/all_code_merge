package com.example.aditya;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aditya.xml.school.Acknowledgement;
import com.aditya.xml.school.CustomerRequest;

@Service
public class LoanEligibilityService {
	
	public Acknowledgement checkLoanEligibility(CustomerRequest request) {
		Acknowledgement acknowledgement= new Acknowledgement();
		List<String> mismatchCriteriaList= acknowledgement.getCriteriaMismatch();
		
		if (!(request.getAge()>30 && request.getAge()<60)){
			mismatchCriteriaList.add("The age should be in between 30 and 60");
			
		}
		if (!(request.getYearlyIncome()>200000)){
			mismatchCriteriaList.add("The Yearly income should be more than 200000");
			
		}
		if (!(request.getCibilScore()>500)){
			mismatchCriteriaList.add("The cibil score should be more than 500 ");
			
		}
		if(mismatchCriteriaList.size()>0) {
			acknowledgement.setIsEligible(false);
			acknowledgement.setApprovedAmount(0);
			
		}
		else {
			if(request.getYearlyIncome()>=200000 && request.getYearlyIncome()<=500000) {
			acknowledgement.setIsEligible(true);
			acknowledgement.setApprovedAmount(500000);
			mismatchCriteriaList.clear();
		}
			if(request.getYearlyIncome()>500000 && request.getYearlyIncome()<=1000000) {
				acknowledgement.setIsEligible(true);
				acknowledgement.setApprovedAmount(750000);
				mismatchCriteriaList.clear();
			}
			if(request.getYearlyIncome()>1000000 && request.getYearlyIncome()<=1500000) {
				acknowledgement.setIsEligible(true);
				acknowledgement.setApprovedAmount(1000000);
				mismatchCriteriaList.clear();
			}
			if(request.getYearlyIncome()>1500000) {
				acknowledgement.setIsEligible(true);
				acknowledgement.setApprovedAmount(2000000);
				mismatchCriteriaList.clear();
			}
			
		}
		return acknowledgement;
	}


}
