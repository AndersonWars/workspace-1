package arvore;

//import java.util.ArrayList;

public class ArvoreBusca {
	private NodeB raiz;
	
	public ArvoreBusca() {
		raiz = null;
	}
	
	public NodeB raiz(){
		return raiz;
	}
	
	public void insere(int x){
		NodeB novo = new NodeB(x);
		NodeB percorre = raiz;
		if (this.raiz==null){
			raiz = novo;
		}else{
			percorre = raiz;
			while(novo.pai==null){
			if(percorre.valor>x){
				
					if(percorre.filhoEsq==null){
						percorre.filhoEsq = novo;
						novo.pai = percorre;
					}else{
							percorre = percorre.filhoEsq;
						}
				}else{
					if(percorre.filhoDir==null){
						percorre.filhoDir = novo;
						novo.pai = percorre;
					}else{
							percorre = percorre.filhoDir;
						}
				}	
			}
		}
	}
	
	public NodeB buscaMenorElemento(){
		NodeB busca = raiz;
		while(busca.filhoEsq!=null){
			busca = busca.filhoEsq;
		}
		return busca;
	}
	
	public NodeB buscaMenorElemento(NodeB dir){
		NodeB busca = dir;
		while(busca.filhoEsq!=null){
			busca = busca.filhoEsq;
		}
		return busca;
	}
	
	public NodeB buscaMaiorElemento(){
		NodeB busca = raiz;
		while(busca.filhoDir!=null){
			busca = busca.filhoDir;
		}
		return busca;
	}
	
	public NodeB buscaMaiorElemento(NodeB esq){
		NodeB busca = esq;
		while(busca.filhoDir!=null){
			busca = busca.filhoDir;
		}
		return busca;
	}
	
	public NodeB buscaPorElemento(int v){
		NodeB busca=raiz;
		while(busca!=null && v!=busca.valor){
			if(v>busca.valor){
				busca = busca.filhoDir;
			}else{
				busca = busca.filhoEsq;
			}
		}
		return busca;
	}
	
	public boolean eFolha(NodeB no){
		return (no.filhoDir==null && no.filhoEsq==null);
	}
	
	public NodeB irmao(NodeB no){
		if(no.pai.filhoDir == no)
			return no.pai.filhoEsq;
		else
			return no.pai.filhoDir;
	}
	
	public void remove(int x){
		NodeB noRm = buscaPorElemento(x);
		if(noRm==null){
			System.out.println("Elemento não foi encontrado");
		}else{
			if(eFolha(noRm)){
				if(noRm.pai.filhoDir == noRm)
					noRm.pai.filhoDir=null;
				else
					noRm.pai.filhoEsq=null;
				noRm = null;
				
			}else if(noRm==raiz){
				if(eFolha(noRm))
					noRm=raiz=null;
				else if(noRm.filhoDir!=null && noRm.filhoEsq==null)
					removeElmFilhoD(noRm,true);
				else if(noRm.filhoEsq!=null && noRm.filhoDir==null)
					removeElmFilhoE(noRm,true);
				else
					removeElm2Filhos(noRm,true);
				
			}else if(noRm.filhoDir!=null && noRm.filhoEsq==null){
				removeElmFilhoD(noRm,false);
				
			}else if(noRm.filhoEsq!=null && noRm.filhoDir==null){
				removeElmFilhoE(noRm,false);
				
			}else{
				removeElm2Filhos(noRm,false);
			}
			
		}
	}
	
	private void removeElm2Filhos(NodeB noRm, boolean raiz){
		NodeB aux = buscaMenorElemento(noRm.filhoDir);
		if(raiz==false){
			if(aux.filhoDir!=null){
				aux.filhoDir.pai = aux.pai;
			}
			if(noRm == noRm.pai.filhoDir){
				noRm.pai.filhoDir = aux;
			}else{
				noRm.pai.filhoEsq = aux;
			}
			if(aux.pai == noRm){
				aux.filhoEsq = noRm.filhoEsq;
			}else{
				aux.filhoDir = noRm.filhoDir;
				aux.filhoEsq = noRm.filhoEsq;
			}
			aux.pai = noRm.pai;
			
		}else{
			if(aux.filhoDir!=null){
				aux.filhoDir.pai = aux.pai;
			}
			if(aux.pai == noRm){
				aux.filhoEsq = noRm.filhoEsq;
			}else{
				aux.filhoDir = noRm.filhoDir;
				aux.filhoEsq = noRm.filhoEsq;
			}
			this.raiz = aux;
		}
	}
	
	private void removeElmFilhoE(NodeB noRm, boolean raiz){
		if(raiz==false){
			noRm.filhoEsq.pai = noRm.pai;
			if(noRm == noRm.pai.filhoDir){
				noRm.pai.filhoDir = noRm.filhoEsq;
			}else{
				noRm.pai.filhoEsq = noRm.filhoEsq;
			}
		}else{
			this.raiz = noRm.filhoEsq;
			this.raiz.filhoDir = noRm.filhoDir;
		}
	}
	
	private void removeElmFilhoD(NodeB noRm, boolean raiz){
		if(raiz==false){
			noRm.filhoDir.pai = noRm.pai;
			if(noRm == noRm.pai.filhoDir){
				noRm.pai.filhoDir = noRm.filhoDir;
			}else{
				noRm.pai.filhoEsq = noRm.filhoDir;
			}
		}else{
			this.raiz = noRm.filhoDir;
			this.raiz.filhoEsq = noRm.filhoEsq;
		}
	}
	
	/*public ArrayList<String> listaElementosPre(){
		ArrayList<String> lista = new ArrayList<String>();
		
		return lista;
	}*/
	
	
}
