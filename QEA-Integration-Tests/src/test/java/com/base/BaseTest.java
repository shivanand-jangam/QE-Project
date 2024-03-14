package com.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojos.userdetails.Booking;
import com.pojos.userdetails.BookingDetails;
import com.pojos.userdetails.GenerateTokenPOJO;

import io.restassured.response.Response;

public class BaseTest {

	public RestUtil restUtil = new RestUtil();
	public ObjectMapper mapper = new ObjectMapper();
	public Response responseHolder;

	public static BookingDetails bookingDetails;
	public static BookingDetails bookingDetails2;
	public static Booking updatebookingUserDetails;
	public static Booking partialupdatebookingUserDetails;
	public static GenerateTokenPOJO tokengen;

}
