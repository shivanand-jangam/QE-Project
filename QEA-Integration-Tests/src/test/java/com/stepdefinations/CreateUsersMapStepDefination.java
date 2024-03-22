package com.stepdefinations;

import java.util.List;
import java.util.Map;

import com.base.BaseTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class CreateUsersMapStepDefination extends BaseTest {
	@When("I provide User details with map and Hit {string} request")
	public void i_provide_user_details_with_map_and_hit_request(String requesttype, DataTable dataTable) {
		
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		
		for(int i=0;i<=data.get(i).size()-1;i++) {
			
			
				
				String firstname = data.get(i).get("Username");
				String lastname = data.get(i).get("Lastname");
				
				System.out.println(" "+firstname+" "+lastname);
				 String payload = "{\"firstname\":\"" + firstname + "\",\"lastname\":\""
							+ lastname
							+ "\",\"totalprice\":111,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2018-01-01\",\"checkout\":\"2019-01-01\"},\"additionalneeds\":\"Breakfast\"}";
				restUtil.setPayloadAs(payload);
				restUtil.hitAPIRequest(requesttype);
				restUtil.verifyStatusCodeAs(200);
				
			
			
		}
	   
	}


}
