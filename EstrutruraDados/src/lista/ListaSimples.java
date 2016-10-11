package lista;

public class ListaSimples {
	private NoProjeto primeiro, ultimo, atual;
	
	public ListaSimples(){
		primeiro = ultimo = atual = null;
	}
	
	public boolean estaVazio(){
		return primeiro==null;
	}
	
	public int comprimento(){
		int comp = 0;
		atual = primeiro;
		while(atual!=null){
			comp++;
			atual = atual.proximo;
		}
		return comp;
	}
	
	public void inserePrimeiro(String n, int t){
		NoProjeto novo = new NoProjeto(n, t);
		if(estaVazio()){
			primeiro = novo;
			ultimo = novo;
			atual = novo;
		}else{
			novo.proximo = primeiro;
			primeiro = novo;
		}
	}
	
	public void insereUltimo(String n, int t){
		NoProjeto novo = new NoProjeto(n, t);
		if (estaVazio()){
			primeiro = novo;
			ultimo = novo;
			atual = novo;
		}else{
			ultimo.proximo = novo;
			ultimo = novo;
		}
	}
	
	public void moveParaPosicao(int pos){
		atual = primeiro;
		for (int i=1;i<pos;i++){
			atual = atual.proximo;
		}
	}
	
	public void insereNaPosicao(String n, int t, int pos){
		NoProjeto novo = new NoProjeto(n, t);
		moveParaPosicao(pos);
		novo.proximo = atual.proximo;
		atual.proximo = novo;
	}
	
	public NoProjeto primeiro(){
		return primeiro;
	}
	
	public NoProjeto ultimo(){
		return ultimo;
	}
	
	public NoProjeto elementoNaPosicao(int pos){
		moveParaPosicao(pos);
		return atual;
	}
	
	public int buscaElemento(String n){
		int cont = 0;
		atual = primeiro;
		while(atual!=null && !atual.nomeEtapa.equals(n)){
			atual = atual.proximo;
			cont++;
		}
		if(atual!=null){
			return cont;
		}
		return -1;
	}
	
	public void removePrimeiro(){
		primeiro = primeiro.proximo;
	}
	
	public void removeUltimo(){
		int pos;
		pos = comprimento()-1;
		moveParaPosicao(pos);
		atual.proximo = null;
		ultimo = atual;
	}
	
	public void removeNaPosicao(int pos){
		NoProjeto temp;
		moveParaPosicao(pos);
		temp = atual.proximo;
		pos = pos-1;
		moveParaPosicao(pos);
		atual.proximo = temp;
	}
	
	public void removeElemento(String v){
		int pos;
		NoProjeto temp;
		pos = buscaElemento(v);
		if(pos>-1){
			 temp = atual.proximo;
			 pos = pos-1;
			 moveParaPosicao(pos);
			 atual.proximo = temp;
		}
	}
	
}
