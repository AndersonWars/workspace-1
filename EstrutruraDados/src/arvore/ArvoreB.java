package arvore;

public class ArvoreB {
	private NodeB raiz;
	
	public ArvoreB() {
		raiz = null;
	}
	
	public void insereB(NodeB pai, NodeB filho){
		if(raiz==null){
			raiz = filho;
		}else{
			if(pai.filhoEsq==null)
				pai.filhoEsq = filho;
			else if(pai.filhoDir == null)
				pai.filhoDir = filho;
			filho.pai = pai;
		}
	}
	
	
}
