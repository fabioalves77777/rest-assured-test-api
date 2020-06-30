package com.testapi.thecatapi.favoritar;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import com.testapi.suporte.ParamsTheCatApi;

import io.restassured.response.Response;

public class TestApiRecuperarMeusFavoritos {
	
	@Test
	public void recuperaMeusFavoritos() {
		Response response = given()
				.contentType("application/json")
				.header("x-api-key", ParamsTheCatApi.key)
				.when().get(ParamsTheCatApi.urlFavoritos);
		System.out.println("MEUS FAVORITOS => " + response.body().asString().replace("},", "},\r\n"));
		response.then().statusCode(200);
	}

}