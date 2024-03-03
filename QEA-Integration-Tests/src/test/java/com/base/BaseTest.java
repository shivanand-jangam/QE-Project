package com.base;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class BaseTest {

	public RestUtil restUtil= new RestUtil();
	public ObjectMapper mapper = new ObjectMapper();
	public Response responseHolder;
	
}
