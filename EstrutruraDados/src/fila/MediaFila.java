package fila;

public class MediaFila {
	public static void main(String[] args) {
		Fila f = new Fila();
		
		f.insere(12);
		f.insere(15);
		f.insere(20);
		f.insere(5);
		
		double media = 0;
		int maior=0, menor=9999;
		int tamanho = f.tamanho();
		while(!f.estaVazia()){
			if(f.frente()>maior)
				maior = f.frente();
			else if(f.frente()<menor)
				menor = f.frente();
			media += f.retira();
		}
		System.out.println("Maior: "+maior);
		System.out.println("Menor: "+menor);
		System.out.println("Media: "+(media/tamanho));
	}
}
