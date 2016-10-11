package objetos_compostos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Crianca {
	String nome="", sexo="";
	int idade;
	ArrayList<Brinquedo> listaBrinquedos = new ArrayList<Brinquedo>();
	
	void cadastra(){
		nome = JOptionPane.showInputDialog("Nome da criança");
		sexo = JOptionPane.showInputDialog("Qual o sexo de "+nome);
		idade = Integer.parseInt(JOptionPane.showInputDialog("Qual a idade de "+nome));
		char op = JOptionPane.showInputDialog("Deseja cadastrar algum brinquedo  (S/N)").charAt(0);
		while (op=='S' || op=='s'){
			Brinquedo b = new Brinquedo();
			b.cadastra();
			if (idade>=b.idade)
				listaBrinquedos.add(b);
			else
				JOptionPane.showMessageDialog(null, "Proibido cadastrar brinquedos com idade mínima maior que a de "+nome);
			op = JOptionPane.showInputDialog("Deseja cadastrar algum brinquedo  (S/N)").charAt(0);
		}
	}
	
	String mostraDados(){
		return nome+" || "+sexo+" || "+idade+" || \n"+listaBrinquedos()+"\n";
	}
	
	String listaBrinquedos(){
		String ret="";
		for (Brinquedo b : listaBrinquedos) {
			ret+=b.mostraBrinquedo()+"\n";
		}
		if (ret.equals(""))
			ret = "Não possui brinquedos";
		return ret;
	}
	
	boolean possuiBrinquedo(String nmBrinquedo){
		for (Brinquedo b : listaBrinquedos) {
			if (b.nome.equals(nmBrinquedo))
				return true;
		}
		return false;
	}
	
}