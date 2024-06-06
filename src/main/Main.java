package main;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pesquisa.Pesquisa;

public class Main {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		
		Pesquisa pesquisa = new Pesquisa();
		try {
			System.out.println(gson.toJson(pesquisa.buscarCotacao("USD")));
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}
