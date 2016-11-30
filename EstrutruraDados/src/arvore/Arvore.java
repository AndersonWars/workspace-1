package arvore;

import java.util.ArrayList;

public class Arvore {
	private Node raiz;
	
	public Arvore() {
		raiz = null;
	}
	
	public void insere(Node pai, Node filho){
		if(raiz == null){
			raiz = filho;
		}else{
			filho.pai = pai;
			pai.filhos.add(filho);
		}
	}
	
	public boolean verificaInterno(Node n){
		return n.filhos.size()>0;
	}
	
	public boolean verificaExterno(Node n){
		return !verificaInterno(n);
	}
	
	public boolean verificaRaiz(Node n){
		return n==raiz;
	}
	
	public ArrayList<Node> elementos(){
		ArrayList<Node> lista = new ArrayList<>();
		lista.add(raiz);
		int i = 0;
		while(i<lista.size()){
			Node atual = lista.get(i);
			for (Node n : atual.filhos) {
				lista.add(n);
			}
			i++;
		}
		return lista;
	}
	
	public int tamanho(){
		return elementos().size();
	}
	
	public int atualizaElemento(Node elementoAntigo, Node elementoNovo){
		
		return 1;
	}
}
