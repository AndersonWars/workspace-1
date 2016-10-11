package pilha;

public class Pilha {
	public Object pilha[];
	public int index;
	
	public Pilha(){
		this.pilha = new Object[100];
		this.index = -1;
	}
	
	public boolean estaVazia(){
		return this.index==-1;
	}
	
	public Object mostraTopo(){
		if(estaVazia())
			return "A pilha está vazia";
		return this.pilha[this.index];
	}
	
	public Object desempilhar(){
		if(estaVazia())
			return "A pilha está vazia";
		return this.pilha[this.index--];
	}
	
	public void empilha(Object valor){
		if(this.index<100){
			this.index++;
			this.pilha[index] = valor;
		}
	}
}
