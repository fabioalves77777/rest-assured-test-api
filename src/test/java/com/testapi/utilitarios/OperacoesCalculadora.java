package com.testapi.utilitarios;

public class OperacoesCalculadora {

	private int intA = 0;
	private int intB = 0;

	public int getIntA() {
		return intA;
	}

	public OperacoesCalculadora setIntA(int intA) {
		this.intA = intA;
		return this;
	}

	public int getIntB() {
		return intB;
	}

	public OperacoesCalculadora setIntB(int intB) {
		this.intB = intB;
		return this;
	}

	public String realizaOperacao(Enum<?> operacao) {
		String body = "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
					+ "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
					+ "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">";
		if (operacao.equals(Operacoes.SOMA)) {
			body += "	<soap:Body>" 
					+ "		<Add xmlns=\"http://tempuri.org/\">" 
					+ "			<intA>" + intA + "</intA>"
					+ "			<intB>" + intB + "</intB>" 
					+ "		</Add>" 
					+ "	</soap:Body>";
		} else if (operacao.equals(Operacoes.SUBTRACAO)) {
			body += "	<soap:Body>" 
					+ "		<Subtract xmlns=\"http://tempuri.org/\">" 
					+ "			<intA>" + intA + "</intA>"
					+ "			<intB>" + intB + "</intB>" 
					+ "		</Subtract>" 
					+ "	</soap:Body>";
		} else if (operacao.equals(Operacoes.DIVISAO)) {
			body += "	<soap:Body>" 
					+ "		<Divide xmlns=\"http://tempuri.org/\">" 
					+ "			<intA>" + intA + "</intA>"
					+ "      	<intB>" + intB + "</intB>" 
					+ " 	</Divide>" 
					+ "	</soap:Body>";
		} else if (operacao.equals(Operacoes.MULTIPLICACAO)) {
			body += "	<soap:Body>" 
					+ " 	<Multiply xmlns=\"http://tempuri.org/\">" 
					+ "      	<intA>" + intA + "</intA>"
					+ "      	<intB>" + intB + "</intB>" 
					+ "  	</Multiply>" 
					+ "	</soap:Body>";
		}
		return body += "</soap:Envelope>";
	}

}