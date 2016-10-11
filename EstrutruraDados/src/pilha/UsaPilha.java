package pilha;

public class UsaPilha {
	public static void main(String[] args) {
		Pilha p = new Pilha();
		p.empilha("Lasanha");
		p.empilha(2);
		p.empilha("Unidades");
		p.empilha("Refrigerante");
		p.empilha(2.5);
		p.empilha("Litros");
		while (!p.estaVazia())
			System.out.println(p.desempilhar());
	}
}
