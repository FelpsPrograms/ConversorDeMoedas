package pesquisa;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.google.gson.Gson;

import classes.Moeda;

public class Pesquisa {

	public String buscarCotacao(String moeda) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
		        .uri(URI.create("https://v6.exchangerate-api.com/v6/d89ee5ac23bc3ab861b97c2b/latest/USD"))
		        .build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		
		return response.body();
		//return new Gson().fromJson(response.body(), Moeda.class);
	}
}
