package arvore;

public class NodeB {
	int valor;
	NodeB pai;
	NodeB filhoEsq;
	NodeB filhoDir;
	
	public NodeB(int valor){
		this.valor = valor;
		pai = null;
		filhoDir = null;
		filhoEsq = null;
	}
}
