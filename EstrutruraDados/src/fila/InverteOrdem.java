package fila;

import pilha_dinamica.PilhaDinamica;

public class InverteOrdem {
	public static void main(String[] args) {
		
		Fila f = new Fila();
		PilhaDinamica p = new PilhaDinamica();
		
		f.insere(0);
		f.insere(1);
		f.insere(2);
		f.insere(3);
		f.insere(4);
		while(!f.estaVazia())
			p.empilha(f.retira());
		while(!p.estaVazia())
			System.out.println(p.desempilha());
	}
}
