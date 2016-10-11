package lista;

public class ElementoListaDupla {
	String nomeEtapa;
	int tempo;
	ElementoListaDupla anterior, proximo;
	
	public ElementoListaDupla(String v, int t) {
		nomeEtapa = v;
		tempo = t;
		anterior = null;
		proximo = null;
	}
	
	
}
