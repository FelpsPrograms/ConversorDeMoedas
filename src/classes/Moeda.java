package classes;

public record Moeda(String abreviacao, String nome) {
	
	@Override
	public final String toString() {
		return abreviacao + " - " + nome;
	}

}
