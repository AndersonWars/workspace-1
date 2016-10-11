package heranca;

import javax.swing.JOptionPane;

public class Cliente {
	private String nome = "";
	private double divida = 0;
	
	public Cliente(){
		cadastra();
	}
	
	public void cadastra(){
		setNome(JOptionPane.showInputDialog("Digite o nome do cliente"));
	}
	
	public String toString() {	
		return getNome()+": Saldo de dívida = "+getDivida()+"\n";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getDivida() {
		return divida;
	}
	public void setDivida(double divida) {
		this.divida = divida;
	}
	
	
}
