package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pesquisa.Pesquisa;

public class Main {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		
		Pesquisa pesquisa = new Pesquisa();
		System.out.println(gson.toJson(pesquisa.buscarCotacao()));
		System.out.println(gson.toJson(pesquisa.buscarMoedas()));
		System.out.println(gson.toJson(pesquisa.converter("BRL", "IDR", 100)));
	}
}
