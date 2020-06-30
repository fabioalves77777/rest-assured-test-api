package com.testapi.suporte;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ParamsTheCatApi {

	// CADASTRAR
	public static final String UrlCadastro = "https://api.thecatapi.com/v1/user/passwordlesssignup";
	public static final String bodyCadastro = "{\"email\": \"fabioalves77777@gmail.com\", \"appDescription\": \"teste the cat api\"}";
	
	// CHAVE DO CADASTRO
	public static final String key = "8b5d8b96-8f81-40c2-9682-403a6903344f";
	
	// VOTAR
	public static final String urlVotos = "https://api.thecatapi.com/v1/votes/";
	public static final String urlVotosPorId = "https://api.thecatapi.com/v1/votes/{vote_id}";
	public static final String bodyVotarLoveIt = "{\"image_id\": \"vli" + retornaDiaHora() + "\", \"value\": \"true\", \"sub_id\": \"demo-4b3faa\"}";
	public static final String bodyVotarNopeIt = "{\"image_id\": \"npi" + retornaDiaHora() + "\", \"value\": \"false\", \"sub_id\": \"demo-4b3faa\"}";	
		
	// FAVORITAR
	public static final String urlFavoritos = "https://api.thecatapi.com/v1/favourites/";
	public static final String bodyFavoritar = "{\"image_id\": \"50s\", \"sub_id\": \"demo-afb247\"}";
	public static final String urlFavoritosPorId = "https://api.thecatapi.com/v1/favourites/{favourite_id}";	
	
	public static String retornaDiaHora() {
		return new SimpleDateFormat("ddhhmmss").format(Calendar.getInstance().getTime());
	}

}