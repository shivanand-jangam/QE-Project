package com.stepdefinations;

import java.util.List;

import com.base.BaseTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class createMultipleBookingwithListStepDefination extends BaseTest{
	@When("I provide User details")
	public void i_provide_user_details(DataTable dataTable) {
		
		 List<List<String>> data = dataTable.asLists(String.class);
		
		for(int i=0;i<data.get(i).size();i++) {
			
			for(int j=0;j<data.get(i).size()-1;j++) {
			 String firstname = data.get(i).get(j);
			 String lastname=data.get(i).get(j+1);
			//   String city=data.get(i).get(j+2);      //as number of data increase this statement also going to increase
			 System.out.println("************************88");
			 System.out.println(" "+firstname+" "+lastname);
			 
			 String payload = "{\"firstname\":\"" + firstname + "\",\"lastname\":\""
						+ lastname
						+ "\",\"totalprice\":111,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2018-01-01\",\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}";	 
			 restUtil.setPayloadAs(payload);
			 restUtil.hitAPIRequest("POST");
			 restUtil.verifyStatusCodeAs(200);
		}
		}
		
		
	    
	}

	@When("I Hit request as {string}")
	public void i_hit_request_as(String requesttype) {
	   restUtil.hitAPIRequest(requesttype);
	}

}
