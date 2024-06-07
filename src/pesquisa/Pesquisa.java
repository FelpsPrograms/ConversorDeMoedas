package pesquisa;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * Classe responsável pelas pesquisas na API e retorno em formato JSON
 * @author Felipe
 */

public class Pesquisa {

	/** Método que busca a cotação de todas as moedas suportadas, com base no dólar americano */
	public String buscarCotacao() {
		HttpRequest request = HttpRequest.newBuilder()
		        .uri(URI.create("https://v6.exchangerate-api.com/v6/d89ee5ac23bc3ab861b97c2b/latest/USD"))
		        .build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
			return response.body();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		//return new Gson().fromJson(response.body(), Moeda.class);
	}
	
	/** Método que busca todas as moedas suportadas */
	public String buscarMoedas() {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://v6.exchangerate-api.com/v6/d89ee5ac23bc3ab861b97c2b/codes"))
				.build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
			return response.body();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	/** Método que converte um valor passado como parâmetro de uma moeda para outra */
	public String converter(String moedaBase, String moedaAlvo, double valor) {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://v6.exchangerate-api.com/v6/d89ee5ac23bc3ab861b97c2b/pair/" + moedaBase + "/" + moedaAlvo + "/" + valor))
				.build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
			return response.body();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
