package com.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojos.userdetails.Booking;
import com.pojos.userdetails.BookingDetails;

import io.restassured.response.Response;

public class BaseTest {

	public RestUtil restUtil = new RestUtil();
	public ObjectMapper mapper = new ObjectMapper();
	public Response responseHolder;
	public static String generatedToken;
	public static BookingDetails bookingDetails;
	public static Booking bookingUserDetails;

}
