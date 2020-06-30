package com.testapi.thecatapi.cadastrar;

import org.junit.Test;
import com.testapi.suporte.ParamsTheCatApi;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;

public class TestApiCadastrar {
	
	@Test
	public void cadastrarUsuario() {
		Response response = given()
				.contentType("application/json")
				.body(ParamsTheCatApi.bodyCadastro)
				.when().post(ParamsTheCatApi.UrlCadastro);
		System.out.println("CADASTRO => " + response.body().asString());
		response.then().body("message", containsString("SUCCESS")).statusCode(200);			
	}

}