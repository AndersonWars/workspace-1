package lista;

public class UsaListaD {
	public static void main(String[] args) {
		ListaDupla l = new ListaDupla();
		
		l.inserePrimeiro("B", 1);
		l.inserePrimeiro("A", 1);
		l.insereUltimo("D", 1);
		l.insereNaPosicao("C", 1, 2);
		
		String msg = "Atual: "+l.primeiro().nomeEtapa+" | Anterior: null"+" | Próximo: "+l.primeiro().proximo.nomeEtapa+"\n";
		for(int i=2;i<=l.comprimento();i++){
			l.moveParaPosicao(i);
			msg += "Atual: "+l.elementoNaPosicao(i).nomeEtapa+" | Anterior: "+l.elementoNaPosicao(i).anterior.nomeEtapa+" | Próximo: "+l.elementoNaPosicao(i).proximo.nomeEtapa+"\n";
		}
		msg += "Atual: "+l.ultimo().nomeEtapa+" | Anterior:"+l.ultimo().anterior.nomeEtapa+" | Próximo: null";
		System.out.println(msg);
	}
}
