package objetos_compostos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PrincipalPessoaDvd {
	static ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
	public static void main(String[] args) {
		String menu = "1 - Cadastrar pessoa\n"
				+"2 - Listar Dvds de uma pessoa\n"
				+"3 - Listar todas as pessoas que possuem um DVD\n"
				+"4 - Listar DVDs de todas as pessoas que estão abaixo do peso\n"
				+"5 - Sair";
		int op = 0;
		do{
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op){
				case 1:
					cadastra();
					break;
				case 2:
					mostraDvdsPessoa();
					break;
				case 3:
					pessoasPossuemDvd();
					break;
				case 4:
					dvdPessoasAbaixoPeso();
					break;
			}
		}while (op!=5);
	}
	
	static void cadastra(){
		Pessoa p = new Pessoa();
		p.cadastra();
		lista.add(p);
		
	}
	
	static void mostraDvdsPessoa(){
		String nomeBusca = JOptionPane.showInputDialog("Nome da pessoa");
		String ret ="";
		for (Pessoa p : lista) {
			if (p.nome.equals(nomeBusca))
				ret+= p.listarDvds();
		}
		if (ret.equals(""))
			ret = "Pessoa não encontrada";
		JOptionPane.showMessageDialog(null, ret);
	}
	
	static void pessoasPossuemDvd(){
		String dvdBusca = JOptionPane.showInputDialog("Nome do DVD");
		String ret ="";
		for (Pessoa p : lista) {
			if (p.possuiDvd(dvdBusca))
				ret+= p.nome+"\n";
		}
		if (ret.equals(""))
			ret = "DVD não encontrado";
		JOptionPane.showMessageDialog(null, ret);
	}
	
	static void dvdPessoasAbaixoPeso(){
		String ret = "";
		for (Pessoa p : lista) {
			if (p.categoria().equals("abaixo do peso"))
				ret+= p.listarDvds();
		}
		if (ret.equals(""))
			ret = "Não existem pessoas abaixo do peso";
		JOptionPane.showMessageDialog(null, ret);
	}
}
