package arvore;

public class UsaArvoreBin {
	 
	 
	 public static void main(String[] args) {
		 ArvoreBusca arBin = new ArvoreBusca();
		 
		 arBin.insere(27);
		 //arBin.insere(17);
		 arBin.insere(30);
		 //arBin.insere(2);
		 arBin.insere(48);
		 arBin.insere(47);
		 arBin.insere(64);
		 arBin.insere(63);
		 arBin.insere(65);
		 
		 arBin.remove(27);
		 //arBin.remove(48);
		 System.out.println(arBin.raiz().valor);
	}
}
