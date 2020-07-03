package com.testapi.soap.calculadora.multiplicacao;

import org.junit.Test;

import com.testapi.utilitarios.Operacoes;
import com.testapi.utilitarios.OperacoesCalculadora;
import com.testapi.utilitarios.Params;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasToString;

public class TestSoapApiMultiplicacao {

	public OperacoesCalculadora operacoes = new OperacoesCalculadora();
	public static final int intA = 15;
	public static final int intB = 3;
	
	@Test
	public void multiplicar() {
		Response response = given().contentType("text/xml").body(operacoes.setIntA(intA).setIntB(intB).realizaOperacao(Operacoes.MULTIPLICACAO))
		.when().post(Params.urlCalculadora);
		response.then().body(hasToString(containsString("<MultiplyResult>" + (intA * intB) +"</MultiplyResult>"))).statusCode(200);	
		System.out.println("RESULTADO DA MULTIPLICAÇÃO: " + new XmlPath(response.body().asString()).get("MultiplyResult"));
	}

}
