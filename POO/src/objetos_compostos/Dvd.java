package objetos_compostos;

import javax.swing.JOptionPane;

public class Dvd {
	String nome;
	int ano;
	double valor;
	
	void cadastra(){
		nome = JOptionPane.showInputDialog("Nome DVD");
		ano = Integer.parseInt(JOptionPane.showInputDialog("Ano de Lançamento"));
		valor = Double.parseDouble(JOptionPane.showInputDialog("Valor"));
	}
	
	String lista(){
		return "DVD("+nome+" || "+ano+" || "+valor+")\n";
	}
		
}
