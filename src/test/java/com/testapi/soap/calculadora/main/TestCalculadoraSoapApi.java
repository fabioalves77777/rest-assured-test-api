package com.testapi.soap.calculadora.main;

import org.junit.Test;

import com.testapi.utilitarios.Operacoes;
import com.testapi.utilitarios.OperacoesCalculadora;
import com.testapi.utilitarios.Params;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasToString;

public class TestCalculadoraSoapApi {

	public OperacoesCalculadora operacoes = new OperacoesCalculadora();
	public static final int intA = 10;
	public static final int intB = 5;

	@Test
	public void realizarOperacoes() {
		// SOMAR
		Response response = given().contentType("text/xml")
				.body(operacoes.setIntA(intA).setIntB(intB).realizaOperacao(Operacoes.SOMA))
				.when().post(Params.urlCalculadora);
		response.then().body(hasToString(containsString("<AddResult>" + (intA + intB) + "</AddResult>"))).statusCode(200);
		System.out.println("RESULTADO DA SOMA: " + new XmlPath(response.body().asString()).get("AddResult"));

		// SUBTRAIR
		response = given().contentType("text/xml")
				.body(operacoes.setIntA(intA).setIntB(intB).realizaOperacao(Operacoes.SUBTRACAO))
				.when().post(Params.urlCalculadora);
		response.then().body(hasToString(containsString("<SubtractResult>" + (intA - intB) + "</SubtractResult>"))).statusCode(200);
		System.out.println("RESULTADO DA SUBTRAÇÃO: " + new XmlPath(response.body().asString()).get("SubtractResult"));

		// DIVIDIR
		response = given().contentType("text/xml")
				.body(operacoes.setIntA(intA).setIntB(intB).realizaOperacao(Operacoes.DIVISAO))
				.when().post(Params.urlCalculadora);
		response.then().body(hasToString(containsString("<DivideResult>" + (intA / intB) + "</DivideResult>"))).statusCode(200);
		System.out.println("RESULTADO DA DIVISÃO: " + new XmlPath(response.body().asString()).get("DivideResult"));

		// MULTIPLICAR
		response = given().contentType("text/xml")
				.body(operacoes.setIntA(intA).setIntB(intB).realizaOperacao(Operacoes.MULTIPLICACAO))
				.when().post(Params.urlCalculadora);
		response.then().body(hasToString(containsString("<MultiplyResult>" + (intA * intB) + "</MultiplyResult>"))).statusCode(200);
		System.out.println("RESULTADO DA MULTIPLICAÇÃO: " + new XmlPath(response.body().asString()).get("MultiplyResult"));
	}

}
