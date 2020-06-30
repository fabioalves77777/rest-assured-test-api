package com.testapi.thecatapi.votacao;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import com.testapi.suporte.ParamsTheCatApi;

import io.restassured.response.Response;

public class TestApiRecuperarMeusVotos {
	
	@Test
	public void recuperaMeusVotos() {
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", ParamsTheCatApi.key)
				.when().get(ParamsTheCatApi.urlVotos);
		System.out.println("MEUS VOTOS => " + response.body().asString().replace("},", "},\r\n"));
		response.then().statusCode(200);
	}

}
