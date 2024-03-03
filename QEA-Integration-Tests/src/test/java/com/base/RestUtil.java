package com.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.utils.PropertyFileReader;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestUtil {

	private static final Logger log = LogManager.getLogger(RestUtil.class);

	PropertyFileReader propertyFileReader;

	public static Map<String, String> headers = new HashMap<>();

	public static String PAYLOAD = "";
	public static String ENDPOINT = "";

	public static Response response;

	public RestUtil() {
		propertyFileReader = new PropertyFileReader();
		RestAssured.baseURI = propertyFileReader.getProperty("api.uri");
	}

	public void setContentTypeAsApplicationJson() {
		headers.put("Content-Type", "application/json");
	}

	public void setContentType(String key, String value) {
		headers.put(key, value);
	}

	public void setPayloadAs(String payload) {
		PAYLOAD = payload;
	}

	public void setEndpoint(String endpoint) {
		ENDPOINT = endpoint;
	}

	public Response hitAPIRequest(String request) {
		if (request.equalsIgnoreCase("GET")) {
			response = RestAssured.given().headers(headers).get(ENDPOINT);
		} else if (request.equalsIgnoreCase("POST")) {
			response = RestAssured.given().headers(headers).body(PAYLOAD)
					.get(ENDPOINT);
		} else if (request.equalsIgnoreCase("PUT")) {
			response = RestAssured.given().headers(headers).body(PAYLOAD)
					.put(ENDPOINT);
		} else if (request.equalsIgnoreCase("PATCH")) {
			response = RestAssured.given().headers(headers).body(PAYLOAD)
					.patch(ENDPOINT);
		} else if (request.equalsIgnoreCase("DELETE")) {
			response = RestAssured.given().headers(headers).delete(ENDPOINT);
		}
		System.out.println(response.getBody().asPrettyString());
		return response;
	}

	public void verifyStatusCodeAs(int statusCode) {
		Assert.assertEquals(response.getStatusCode(), statusCode);
		log.info("Verified Response status code: " + response.getStatusCode());
	}

	public void verifyExpectedMatchWithActual(String expected, String actual) {
		Assert.assertEquals(actual, expected, " Expected value: " + expected
				+ " Is not macthing with the Actual value: " + actual);
		log.info("Verified Expected: " + expected
				+ " is matching with the Actual value: " + actual);
	}

	public void verifyExpectedMatchWithActual(int expected, int actual) {
		Assert.assertEquals(actual, expected, " Expected value: " + expected
				+ " Is not macthing with the Actual value: " + actual);
		log.info("Verified Expected: " + expected
				+ " is matching with the Actual value: " + actual);
	}

}
