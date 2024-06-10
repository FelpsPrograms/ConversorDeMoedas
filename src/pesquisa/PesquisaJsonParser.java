package pesquisa;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import classes.Moeda;
import classes.ValorConvertido;

/**
 * Classe que pega as informações essenciais de cada pesquisa
 * @author Felipe
 */

public class PesquisaJsonParser {
	
	/** Método que trabalha com buscarMoedas() */
	public ArrayList<Moeda> buscarMoedas() {
		ArrayList<Moeda> moedas = new ArrayList<>();
		JsonObject conversaoObject = JsonParser.parseString(new Pesquisa().buscarMoedas()).getAsJsonObject();
		JsonArray conversaoArray = conversaoObject.get("supported_codes").getAsJsonArray();
		for (JsonElement elemento : conversaoArray) {
			String abreviacao = elemento.getAsJsonArray().get(0).getAsString();
			String nome = elemento.getAsJsonArray().get(1).getAsString();
			Moeda moeda = new Moeda(abreviacao, nome);
			moedas.add(moeda);
		}
		return moedas;
	}
	
	/** Método que trabalha com converter() */
	public ValorConvertido converter(String moedaBase, String moedaAlvo, double valor) {
		/** Conversão da pesquisa em JsonObject para que seja possível pegar os dados do JSON individualmete */
		JsonObject conversaoObject = JsonParser.parseString(new Pesquisa().converter(moedaBase, moedaAlvo, valor)).getAsJsonObject();
		String baseCode = conversaoObject.get("base_code").getAsString();
		String targetCode = conversaoObject.get("target_code").getAsString();
		String conversionRate = conversaoObject.get("conversion_rate").getAsString();
		String conversionResult = conversaoObject.get("conversion_result").getAsString();
		ValorConvertido valorConvertido = new ValorConvertido(baseCode, targetCode, conversionRate, conversionResult);
		
		return valorConvertido;
	}
	
}
