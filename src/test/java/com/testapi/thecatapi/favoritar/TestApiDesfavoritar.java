package com.testapi.thecatapi.favoritar;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import org.junit.Test;

import com.testapi.suporte.ParamsTheCatApi;

import io.restassured.response.Response;

public class TestApiDesfavoritar {

	@Test
	public void desfavoritarTest() {
		String id = new TestApiFavoritar().favoritar();		
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", ParamsTheCatApi.key)
				.pathParam("favourite_id", id).when().delete(ParamsTheCatApi.urlFavoritosPorId);
		System.out.println("DESFAVORITAR => " + response.body().asString());
		response.then().body("message", containsString("SUCCESS")).statusCode(200);
	}
	
	public void desfavoritar(String id) {
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", ParamsTheCatApi.key)
				.pathParam("favourite_id", id).when().delete(ParamsTheCatApi.urlFavoritosPorId);
		System.out.println("DESFAVORITAR => " + response.body().asString());
		response.then().body("message", containsString("SUCCESS")).statusCode(200);
	}
	
}