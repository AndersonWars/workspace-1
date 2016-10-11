package fila;

import javax.swing.JOptionPane;


import pilha_dinamica.PilhaDinamica;

public class Exerc3 {
	public static void main(String[] args) {
		Fila par = new Fila();
		Fila impar = new Fila();
		
		PilhaDinamica p = new PilhaDinamica();
		int input = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro"));
		while(input!=0){	
			if (input%2==0){
				par.insere(input);
			}else{
				impar.insere(input);
			}
			input = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro"));
		}
		
		while(!impar.estaVazia() || !par.estaVazia()){
			if(!impar.estaVazia()){
				if(impar.frente()>0){
					p.empilha(impar.retira());
				}else if (impar.frente()<0){
					if(!p.estaVazia())
						p.desempilha();
					impar.retira();
				}
			}
			if(!par.estaVazia()){
				if(par.frente()>0){
					p.empilha(par.retira());
				}else if(par.frente()<0){
					if(!p.estaVazia())
						p.desempilha();
					par.retira();
				}
			}
		}
		
		while(!p.estaVazia()){
			System.out.println(p.desempilha());
		}
	}
}
