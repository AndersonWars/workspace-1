package pilha;

public class PilhaDeInteiros {
	public double pilha[];
	public int index;
	
	public PilhaDeInteiros() {
		this.pilha = new double[100];
		this.index = -1;
	}
	
	public boolean estaVazia(){
		return this.index==-1;
	}
	
	public int tamanho(){
		return this.index+1;
	}
	
	public double mostraTopo(){
		if (!estaVazia())
			return this.pilha[this.index];
		return 0;
	}
	
	public double desempilhar(){
		if (estaVazia()){
			System.out.println("Pilha vazia");
			return mostraTopo();
		}else
			return this.pilha[this.index--];
	}
	
	public void empilhar(double valor){
		if (this.index<100){
			this.index++;
			this.pilha[this.index] = valor;
		}
	}
}
