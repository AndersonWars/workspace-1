package introducao_oo;

import javax.swing.JOptionPane;

public class Dvd {
	String nome;
	int ano;
	double valor;
	
	void cadastra(){
		nome = JOptionPane.showInputDialog("Nome");
		ano = Integer.parseInt(JOptionPane.showInputDialog("Ano de Lançamento"));
		valor = Double.parseDouble(JOptionPane.showInputDialog("Valor"));
	}
	
	String lista(){
		return nome+" || Lançamento: "+ano+" || Valor: "+valor+"\n";
	}
		
}
