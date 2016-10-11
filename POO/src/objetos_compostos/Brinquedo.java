package objetos_compostos;

import javax.swing.JOptionPane;

public class Brinquedo {
	String nome="";
	int idade;
	
	void cadastra(){
		nome = JOptionPane.showInputDialog("Digite o nome do brinquedo");
		idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade mínima de "+nome));
	}
	
	String mostraBrinquedo(){
		return nome; 
	}
}
