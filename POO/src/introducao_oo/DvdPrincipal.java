package introducao_oo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DvdPrincipal {
	static ArrayList<Dvd> dvds = new ArrayList<Dvd>();
	public static void main(String[] args) {
		String menu = "1 - Cadastra DVD\n"
				+"2 - Lista todos\n"
				+"3 - Soma os valores\n"
				+"4 - Procura DVD por ano de lançamento\n"
				+"5 - Procura DVD por título\n"
				+"6 - Sair\n";
		int op = 0;
		do{
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op) {
			case 1:
				Dvd d = new Dvd();
				d.cadastra();
				dvds.add(d);
				break;
			case 2:
				String lista ="";
				for (Dvd dvd : dvds) {
					lista += dvd.lista();
				}
				JOptionPane.showMessageDialog(null, lista);
				break;
			case 3:
				double somaValores=0;
				for (Dvd dvd : dvds) {
					somaValores+=dvd.valor;
				}
				JOptionPane.showMessageDialog(null, "A soma dos valores é igual a "+somaValores);
				break;
			case 4:
				int buscaAno = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de lançamento do DVD"));
				String listaAno ="";
				for (Dvd dvd : dvds) {
					if (buscaAno==dvd.ano) {
						listaAno+= dvd.lista();
					}
				}
				JOptionPane.showMessageDialog(null, listaAno);
				break;
			case 5:
				String buscaTitulo = JOptionPane.showInputDialog("Digite o título do DVD");
				String listadvd="";
				for (Dvd dvd : dvds) {
					if (buscaTitulo.equals(dvd.nome))
						listadvd+= dvd.lista();
				}
				JOptionPane.showMessageDialog(null, listadvd);
				break;
			}
		}while (op!=6);
	}

}
