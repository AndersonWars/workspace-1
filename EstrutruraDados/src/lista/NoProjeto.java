package lista;

public class NoProjeto {
	String nomeEtapa;
	int tempo;
	NoProjeto proximo;
	
	public NoProjeto(String pnomeProjeto, int tempo) {
		nomeEtapa = pnomeProjeto;
		this.tempo = tempo;
		proximo = null;
	}
}
