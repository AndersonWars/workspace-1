package lista;

public class UsaListaS {
	public static void main(String[] args) {
		ListaSimples l = new ListaSimples();
		l.inserePrimeiro("A", 1);
		l.inserePrimeiro("A", 1);
		l.inserePrimeiro("A", 1);
		
		while(!l.estaVazio()){
			System.out.println(l.primeiro().nomeEtapa);
			l.removePrimeiro();
		}
	}
}
