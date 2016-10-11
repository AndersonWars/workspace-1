package pilha;

public class PilhaDeString {
	public String[] pilha;
	public int index;
	
	public PilhaDeString(){
		this.pilha = new String[100];
		this.index = -1;
	}
	
	public int tamanho(){
		return index+1;
	}
	
	public boolean estaVazia(){
		return this.index==-1;
	}
	
	public String mostraTopo(){
		if(estaVazia())
			return "A pilha está vazia";
		return this.pilha[this.index];
	}
	
	public String desempilhar(){
		if (estaVazia())
			return "A pilha está vazia";
		return this.pilha[this.index--];
	}
	
	public void empilhar(String v){
		if (this.index<100){
			this.index++;
			this.pilha[this.index] = v;
		}
	}
}
