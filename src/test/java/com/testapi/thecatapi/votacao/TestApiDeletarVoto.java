package com.testapi.thecatapi.votacao;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import org.junit.Test;

import com.testapi.suporte.ParamsTheCatApi;

import io.restassured.response.Response;

public class TestApiDeletarVoto {

	@Test
	public void deletarVotoTest() {
		String id = new TestApiVotar().votarLoveIt();		
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", ParamsTheCatApi.key)
				.pathParam("vote_id", id).when().delete(ParamsTheCatApi.urlVotosPorId);
		System.out.println("DELETAR VOTO LOVE IT => " + response.body().asString());
		response.then().body("message", containsString("SUCCESS")).statusCode(200);
	}
	
	public void deletarVoto(String id) {
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", ParamsTheCatApi.key)
				.pathParam("vote_id", id).when().delete(ParamsTheCatApi.urlVotosPorId);
		System.out.println("DELETAR VOTO => " + response.body().asString());
		response.then().body("message", containsString("SUCCESS")).statusCode(200);
	}
	
}