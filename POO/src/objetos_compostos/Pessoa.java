package objetos_compostos;



import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Pessoa {
	String nome;
	double peso,altura;
	ArrayList<Dvd> listaDvs = new ArrayList<Dvd>();
	
	double calculaImc(){
		return peso/(altura*altura);
	}
	
	void cadastra(){
		nome = JOptionPane.showInputDialog("Nome pessoa");
		peso = Double.parseDouble(JOptionPane.showInputDialog("Peso"));
		altura = Double.parseDouble(JOptionPane.showInputDialog("Altura"));
		String mais = JOptionPane.showInputDialog("Cadastrar DVDs? (S/N)");
		while (mais.equals("S")){
			Dvd d = new Dvd();
			d.cadastra();
			listaDvs.add(d);
			mais = JOptionPane.showInputDialog("Cadastrar DVDs? (S/N)");
		}
	}
	
	String seApresente(){
		//DecimalFormat df = new DecimalFormat("##.00");
		return nome +"\n";
	}
	
	String listarDvds(){
		String ret ="";
		for (Dvd d : listaDvs) {
			ret+= d.lista();
		}
		if (ret.equals(""))
			ret = "Não possui DVDs\n";
		return ret;
	}
	
	boolean possuiDvd(String nmDvd){
		for (Dvd d : listaDvs) {
			if (d.nome.equals(nmDvd))
				return true;
		}
		return false;
	}
	
	String categoria(){
		if (calculaImc()<18) 
			return "abaixo do peso";
		else if (calculaImc()>29)
			return "acima do peso";
		else
			return "peso ideal";
	}

}
