package objetos_compostos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BrinquedosCriancas {
	static ArrayList<Crianca> listaCriancas = new ArrayList<Crianca>();
	public static void main(String[] args) {
		String menu = "1 - Cadastrar Criança\n"
				+"2 - Listar Brinquedos de uma criança\n"
				+"3 - Listar todas as crianças e seus brinquedos\n"
				+"4 - Listar crianças que possuem um brinquedo\n"
				+"5 - Sair";
		int op=0;
		do{
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op) {
			case 1:
				cadastra();
				break;
			case 2:
				listaBrinquedos();
				break;
			case 3:
				listaTodos();
				break;
			case 4:
				mostraCriancas();
				break;
			}
		}while(op!=5);
	}
	
	static void cadastra(){
		Crianca c = new Crianca();
		c.cadastra();
		listaCriancas.add(c);
	}
	
	static void listaBrinquedos(){
		String nomeBusca = JOptionPane.showInputDialog("Digite o nome da criança");
		String ret ="";
		for (Crianca c : listaCriancas) {
			if (c.nome.equals(nomeBusca))
				ret+=c.listaBrinquedos();
		}
		if (ret.equals(""))
			ret = nomeBusca+" não foi encontrado no cadastro";
		JOptionPane.showMessageDialog(null, ret);
	}
	
	static void listaTodos(){
		String ret="";
		for (Crianca c : listaCriancas) {
			ret+=c.mostraDados();
		}
		JOptionPane.showMessageDialog(null, ret);
	}
	
	static void mostraCriancas(){
		String brinquedoBusca = JOptionPane.showInputDialog("Nome do Brinquedo");
		String ret="";
		for (Crianca c : listaCriancas) {
			if (c.possuiBrinquedo(brinquedoBusca))
				ret+=c.nome+"\n";
		}
		if (ret.equals(""))
			ret = "Brinquedo não encontrado";
		JOptionPane.showMessageDialog(null, ret);
	}
	
}
