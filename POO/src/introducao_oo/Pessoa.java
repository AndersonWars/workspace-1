package introducao_oo;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Pessoa {
	String nome;
	double peso,altura;
	
	double calculaImc(){
		return peso/(altura*altura);
	}
	
	void cadastra(){
		nome = JOptionPane.showInputDialog("Nome");
		peso = Double.parseDouble(JOptionPane.showInputDialog("Peso"));
		altura = Double.parseDouble(JOptionPane.showInputDialog("Altura"));
	}
	
	String seApresente(){
		DecimalFormat df = new DecimalFormat("##.00");
		return nome +": "+df.format(calculaImc())+": "+categoria()+"\n";
	}
	
	String categoria(){
		if (calculaImc()<18) 
			return " abaixo do peso"+"\n";
		else if (calculaImc()>29)
			return " acima do peso"+"\n";
		else
			return " peso ideal"+"\n";
	}

}
