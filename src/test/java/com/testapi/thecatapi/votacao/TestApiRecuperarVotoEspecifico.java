package com.testapi.thecatapi.votacao;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import com.testapi.utilitarios.Params;

import io.restassured.response.Response;

public class TestApiRecuperarVotoEspecifico {
	
	@Test
	public void recuperaVotoEspecificoTest() {
		String id = new TestApiVotar().votarLoveIt();
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", Params.key)
				.pathParam("vote_id", id).when().get(Params.urlVotosPorId);
		System.out.println("INFOS DO VOTO => " + response.body().asString());
		response.then().statusCode(200);
	}

	public void recuperaVotoEspecifico(String id) {
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", Params.key)
				.pathParam("vote_id", id).when().get(Params.urlVotosPorId);
		System.out.println("INFOS DO VOTO => " + response.body().asString());
		response.then().statusCode(200);
	}

}