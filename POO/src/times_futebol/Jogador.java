package times_futebol;

import javax.swing.JOptionPane;

public class Jogador {
	private String nome = "";
	private int numCamisa = 0, qtdGols = 0;
	
	public void cadastra(){
		setNome(JOptionPane.showInputDialog("Insira o nome do jogador"));
		setNumCamisa(Integer.parseInt(JOptionPane.showInputDialog("Insira o nº de "+getNome())));
		setQtdGols(Integer.parseInt(JOptionPane.showInputDialog("Quantos gols "+getNome()+" marcou?")));
	}
	
	public String toString() {
		return getNome()+" - Camisa "+getNumCamisa()+" - "+getQtdGols()+" gols.\n";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumCamisa() {
		return numCamisa;
	}
	public void setNumCamisa(int numCamisa) {
		if (numCamisa>0)
			this.numCamisa = numCamisa;
		else setNumCamisa(Integer.parseInt(JOptionPane.showInputDialog("ERRO.  Nº de camisa deve ser maior que 0")));
	}
	public int getQtdGols() {
		return qtdGols;
	}
	public void setQtdGols(int qtdGols) {
		this.qtdGols = qtdGols;
	}
	
	
}
