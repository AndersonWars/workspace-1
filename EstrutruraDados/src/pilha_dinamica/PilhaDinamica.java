package pilha_dinamica;

public class PilhaDinamica {
	private No topo = null;
	
	public boolean estaVazia(){
		return this.topo==null;
	}
	
	public void empilha(int v){
		No novo = new No(v);
		novo.proximo = this.topo;
		this.topo = novo;
	}
	
	public int desempilha(){
		int ret = this.topo.valor;
		this.topo = topo.proximo;
		return ret;
	}
}
