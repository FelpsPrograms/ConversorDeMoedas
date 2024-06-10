package main;

import pesquisa.PesquisaJsonParser;

public class Main {
	public static void main(String[] args) {
		
		PesquisaJsonParser pesquisa = new PesquisaJsonParser();
		
		System.out.println(pesquisa.buscarMoedas());
		
	}
}
