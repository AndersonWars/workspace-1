package lista;

public class ListaDupla {
	private ElementoListaDupla primeiro, ultimo, atual;
	private int comprimento = 0;
	
	public ListaDupla() {
		primeiro = atual = ultimo = null;
	}
	
	public int comprimento(){
		return comprimento;
	}
	
	public boolean estaVazio(){
		return primeiro == null;
	}
	
	public void inserePrimeiro(String v, int t){
		ElementoListaDupla novo = new ElementoListaDupla(v, t);
		if(estaVazio()){
			primeiro = novo;
			ultimo = novo;
			atual = novo;
		}else{
			primeiro.anterior = novo;
			novo.proximo = primeiro;
			primeiro = novo;
		}
		comprimento++;
	}
	
	public void insereUltimo(String v, int t){
		ElementoListaDupla novo = new ElementoListaDupla(v, t);
		if(estaVazio()){
			primeiro = novo;
			ultimo = novo;
			atual = novo;
		}else{
			ultimo.proximo = novo;
			novo.anterior = ultimo;
			ultimo = novo;
		}
		comprimento++;
	}
	
	public void moveParaPosicao(int pos){
		atual = primeiro;
		for(int i=1;i<pos;i++){
			atual = atual.proximo;
		}
	}
	
	public void insereNaPosicao(String v, int t, int pos){
		ElementoListaDupla novo = new ElementoListaDupla(v, t);
		moveParaPosicao(pos);
		ElementoListaDupla temp = atual.proximo;
		atual.proximo = novo;
		novo.anterior = atual;
		novo.proximo = temp;
		temp.anterior = novo;
	}
	
	public ElementoListaDupla primeiro(){
		return primeiro;
	}
	
	public ElementoListaDupla ultimo(){
		return ultimo;
	}
	
	public ElementoListaDupla elementoNaPosicao(int pos){
		moveParaPosicao(pos);
		return atual;
	}
	
	public int buscaElemento(String v){
		int cont = 0;
		atual = primeiro;
		while(atual!=null && !atual.nomeEtapa.equals(v)){
			atual = atual.proximo;
			cont++;
		}
		if(atual!=null)
			return cont;
		return -1;
	}
	
	public void removePrimeiro(){
		primeiro = primeiro.proximo;
		primeiro.anterior = null;
		comprimento--;
	}
	
	public void removeUltimo(){
		ultimo = ultimo.anterior;
		ultimo.proximo = null;
		comprimento--;
	}
	
	public void removeNaPosicao(int pos){
		ElementoListaDupla temp;
		moveParaPosicao(pos);
		temp = atual;
		temp.anterior.proximo = temp.proximo;
		temp.proximo.anterior = temp.anterior;
		comprimento--;
	}
	
	public void removeElemento(String v){
		int pos;
		ElementoListaDupla temp;
		pos = buscaElemento(v);
		temp = atual;
		temp.anterior.proximo = temp.proximo;
		temp.proximo.anterior = temp.anterior;
		comprimento--;
	}
}
