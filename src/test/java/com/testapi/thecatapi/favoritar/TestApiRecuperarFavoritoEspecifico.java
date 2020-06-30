package com.testapi.thecatapi.favoritar;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import com.testapi.suporte.ParamsTheCatApi;

import io.restassured.response.Response;

public class TestApiRecuperarFavoritoEspecifico {
	
	@Test
	public void recuperaFavoritoEspecificoTest() {
		String id = new TestApiFavoritar().favoritar();
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", ParamsTheCatApi.key)
				.pathParam("favourite_id", id).when().get(ParamsTheCatApi.urlFavoritosPorId);
		System.out.println("INFOS DO FAVORITO => " + response.body().asString());
		response.then().statusCode(200);
	}

	public void recuperaFavoritoEspecifico(String id) {
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", ParamsTheCatApi.key)
				.pathParam("favourite_id", id).when().get(ParamsTheCatApi.urlFavoritosPorId);
		System.out.println("INFOS DO FAVORITO => " + response.body().asString());
		response.then().statusCode(200);
	}

}