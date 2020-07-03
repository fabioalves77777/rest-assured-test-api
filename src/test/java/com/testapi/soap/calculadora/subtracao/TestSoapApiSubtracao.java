package com.testapi.soap.calculadora.subtracao;

import org.junit.Test;

import com.testapi.utilitarios.Operacoes;
import com.testapi.utilitarios.OperacoesCalculadora;
import com.testapi.utilitarios.Params;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasToString;

public class TestSoapApiSubtracao {

	public OperacoesCalculadora operacoes = new OperacoesCalculadora();
	public static final int intA = 9;
	public static final int intB = 5;
	
	@Test
	public void subtrair() {
		Response response = given().contentType("text/xml").body(operacoes.setIntA(intA).setIntB(intB).realizaOperacao(Operacoes.SUBTRACAO))
		.when().post(Params.urlCalculadora);
		response.then().body(hasToString(containsString("<SubtractResult>" + (intA - intB) +"</SubtractResult>"))).statusCode(200);	
		System.out.println("RESULTADO DA SUBTRAÇÃO: " + new XmlPath(response.body().asString()).get("SubtractResult"));
	}

}
