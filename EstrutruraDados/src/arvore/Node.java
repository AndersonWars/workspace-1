package arvore;

import java.util.ArrayList;

public class Node {
	int valor;
	Node pai;
	ArrayList<Node> filhos;
	
	public Node(int valor){
		pai = null;
		filhos = new ArrayList<>();
		this.valor = valor;
	}
}
