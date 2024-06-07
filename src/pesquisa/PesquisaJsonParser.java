package pesquisa;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Classe que pega as informações essenciais de cada pesquisa
 * @author Felipe
 */

public class PesquisaJsonParser {
	Pesquisa pesquisa = new Pesquisa();
	
	/** Método que trabalha com converter() */
	public String jsonParserConverter(String moedaBase, String moedaAlvo, double valor) {
		/** Conversão da pesquisa em JsonObject para que seja possível pegar os dados do JSON individualmete */
		JsonObject conversaoObject = JsonParser.parseString(pesquisa.converter(moedaBase, moedaAlvo, valor)).getAsJsonObject();
		String baseCode = conversaoObject.get("base_code").getAsString();
		String targetCode = conversaoObject.get("target_code").getAsString();
		String conversionRate = conversaoObject.get("conversion_rate").getAsString();
		String conversionResult = conversaoObject.get("conversion_result").getAsString();
		
		int comprimentoValor = String.valueOf(valor).length();
		String espacamento = " ".repeat(comprimentoValor);
		/** Montagem da estrutura dos dados a serem apresentados */
		String estrutura = 
				baseCode + espacamento + targetCode + "\n" +
				"-".repeat(6 + comprimentoValor) + "\n" +
				"1" + espacamento + "- " + conversionRate + "\n" +
				valor + " - " + conversionResult;
		return estrutura;
	}
	
}
