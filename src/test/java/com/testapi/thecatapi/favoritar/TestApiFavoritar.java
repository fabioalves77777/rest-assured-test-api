package com.testapi.thecatapi.favoritar;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import org.junit.Test;

import com.testapi.utilitarios.Params;

import io.restassured.response.Response;

public class TestApiFavoritar {

	@Test
	public void favoritarTest() {					
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", Params.key)
				.body(Params.bodyFavoritar)
				.when().post(Params.urlFavoritos);
		System.out.println("FAVORITAR => " + response.body().asString());
		response.then().body("message", containsString("SUCCESS")).statusCode(200);		
	}
	
	public String favoritar() {					
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", Params.key)
				.body("{\"image_id\": \"50s" + Params.retornaDiaHora() + "\", \"sub_id\": \"demo-afb247\"}")
				.when().post(Params.urlFavoritos);
		System.out.println("FAVORITAR => " + response.body().asString());
		response.then().body("message", containsString("SUCCESS")).statusCode(200);			
		String id = response.jsonPath().getString("id");
		return id;
	}	
	
}
