package com.testapi.thecatapi.main;

import org.junit.Test;

import com.testapi.thecatapi.cadastrar.TestApiCadastrar;
import com.testapi.thecatapi.favoritar.TestApiDesfavoritar;
import com.testapi.thecatapi.favoritar.TestApiFavoritar;
import com.testapi.thecatapi.favoritar.TestApiRecuperarFavoritoEspecifico;
import com.testapi.thecatapi.favoritar.TestApiRecuperarMeusFavoritos;
import com.testapi.thecatapi.votacao.TestApiDeletarVoto;
import com.testapi.thecatapi.votacao.TestApiRecuperarMeusVotos;
import com.testapi.thecatapi.votacao.TestApiRecuperarVotoEspecifico;
import com.testapi.thecatapi.votacao.TestApiVotar;

public class TestTheCatApi {
	
	// CADASTRO
	TestApiCadastrar cadastrar = new TestApiCadastrar();
	// VOTO
	TestApiVotar votar = new TestApiVotar();
	TestApiDeletarVoto deletarVoto = new TestApiDeletarVoto();
	TestApiRecuperarVotoEspecifico recuperarVoto = new TestApiRecuperarVotoEspecifico();
	TestApiRecuperarMeusVotos recuperarMeusVotos = new TestApiRecuperarMeusVotos();
	String idVoto;
	// FAVORITO
	TestApiFavoritar favoritar = new TestApiFavoritar();
	TestApiDesfavoritar desfavoritar = new TestApiDesfavoritar();
	TestApiRecuperarFavoritoEspecifico recuperarFavorito = new TestApiRecuperarFavoritoEspecifico();
	TestApiRecuperarMeusFavoritos recuperarMeusFavoritos = new TestApiRecuperarMeusFavoritos();
	String idFavorito;
	
	@Test
	public void testApiTheCat() {		
		// CADASTRAMENTO
		//cadastrar.cadastrarUsuario();
		
		// VOTAÇÃO
		idVoto = votar.votarLoveIt();
		recuperarVoto.recuperaVotoEspecifico(idVoto);
		recuperarMeusVotos.recuperaMeusVotos();
		deletarVoto.deletarVoto(idVoto);
		idVoto = votar.votarNopeIt();
		recuperarVoto.recuperaVotoEspecifico(idVoto);
		recuperarMeusVotos.recuperaMeusVotos();
		deletarVoto.deletarVoto(idVoto);
		
		// FAVORITAR
		idFavorito = favoritar.favoritar();
		recuperarFavorito.recuperaFavoritoEspecifico(idFavorito);
		recuperarMeusFavoritos.recuperaMeusFavoritos();
		desfavoritar.desfavoritar(idFavorito);		
	}

}