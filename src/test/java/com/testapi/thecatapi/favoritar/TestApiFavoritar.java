package com.testapi.thecatapi.favoritar;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import org.junit.Test;

import com.testapi.suporte.ParamsTheCatApi;

import io.restassured.response.Response;

public class TestApiFavoritar {

	@Test
	public void favoritarTest() {					
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", ParamsTheCatApi.key)
				.body(ParamsTheCatApi.bodyFavoritar)
				.when().post(ParamsTheCatApi.urlFavoritos);
		System.out.println("FAVORITAR => " + response.body().asString());
		response.then().body("message", containsString("SUCCESS")).statusCode(200);		
	}
	
	public String favoritar() {					
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", ParamsTheCatApi.key)
				.body("{\"image_id\": \"50s" + ParamsTheCatApi.retornaDiaHora() + "\", \"sub_id\": \"demo-afb247\"}")
				.when().post(ParamsTheCatApi.urlFavoritos);
		System.out.println("FAVORITAR => " + response.body().asString());
		response.then().body("message", containsString("SUCCESS")).statusCode(200);			
		String id = response.jsonPath().getString("id");
		return id;
	}	
	
}
