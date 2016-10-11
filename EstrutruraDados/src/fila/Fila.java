package fila;

public class Fila {
	private Elemento inicio, fim;
	private int tamanho = 0;
	
	public Fila() {
		inicio = null;
		fim = null;
	}
	
	public boolean estaVazia(){
		return inicio==null;
	}
	
	public void insere(int v){
		if (estaVazia()){
			Elemento novo = new Elemento(v);
			inicio = novo;
			fim = novo;
			tamanho++;
		}else{
			Elemento novo = new Elemento(v);
			fim.proximo = novo;
			fim = novo;
			tamanho++;
		}
	}
	
	public int retira(){
		if(!estaVazia()){
			int v = inicio.valor;
			inicio = inicio.proximo;
			tamanho--;
			return v;
		}
		return 0;
	}
	
	public int frente(){
		return inicio.valor;
	}
	
	public int tamanho(){
		return tamanho;
	}
}
