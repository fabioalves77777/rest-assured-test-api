package com.testapi.thecatapi.votacao;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import com.testapi.utilitarios.Params;

import io.restassured.response.Response;

public class TestApiRecuperarMeusVotos {
	
	@Test
	public void recuperaMeusVotos() {
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", Params.key)
				.when().get(Params.urlVotos);
		System.out.println("MEUS VOTOS => " + response.body().asString().replace("},", "},\r\n"));
		response.then().statusCode(200);
	}

}
