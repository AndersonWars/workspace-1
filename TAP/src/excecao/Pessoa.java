package excecao;

import javax.swing.JOptionPane;

public class Pessoa {
	String nome;
	Carro c = new Carro();
	
	public void inicia(){
		try{
			String d = JOptionPane.showInputDialog("Distância");
			c.dirigir(d);
		}catch(Exception e){
			System.out.println("Erro da classe Pessoa");
		}
	}
}
