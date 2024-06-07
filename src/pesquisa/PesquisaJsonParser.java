package pesquisa;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import classes.ValorConvertido;

/**
 * Classe que pega as informações essenciais de cada pesquisa
 * @author Felipe
 */

public class PesquisaJsonParser {
	
	/** Método que trabalha com converter() */
	public ValorConvertido jsonParserConverter(String moedaBase, String moedaAlvo, double valor) {
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
