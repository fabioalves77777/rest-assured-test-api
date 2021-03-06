package com.testapi.thecatapi.votacao;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import org.junit.Test;

import com.testapi.utilitarios.Params;

import io.restassured.response.Response;

public class TestApiVotar {

	@Test
	public void votarLoveItTest() {					
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", Params.key)
				.body(Params.bodyVotarLoveIt)
				.when().post(Params.urlVotos);
		System.out.println("VOTO LOVE IT => " + response.body().asString());
		response.then().body("message", containsString("SUCCESS")).statusCode(200);		
	}
	
	@Test
	public void votarNopeItTest() {			
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", Params.key)
				.body(Params.bodyVotarNopeIt)
				.when().post(Params.urlVotos);
		System.out.println("VOTO NOPE IT => " + response.body().asString());
		response.then().body("message", containsString("SUCCESS")).statusCode(200);		
	}
	
	public String votarLoveIt() {					
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", Params.key)
				.body(Params.bodyVotarLoveIt)
				.when().post(Params.urlVotos);
		System.out.println("VOTO LOVE IT => " + response.body().asString());
		response.then().body("message", containsString("SUCCESS")).statusCode(200);			
		String id = response.jsonPath().getString("id");
		return id;
	}	
	
	public String votarNopeIt() {			
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", Params.key)
				.body(Params.bodyVotarNopeIt)
				.when().post(Params.urlVotos);
		System.out.println("VOTO NOPE IT => " + response.body().asString());
		response.then().body("message", containsString("SUCCESS")).statusCode(200);				
		String id = response.jsonPath().getString("id");
		return id;
	}
	
}
