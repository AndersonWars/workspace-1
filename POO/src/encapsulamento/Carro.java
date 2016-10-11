package encapsulamento;

import javax.swing.JOptionPane;

public class Carro {
	private String nome, placa;
	
	public void cadastra(){
		setNome(JOptionPane.showInputDialog("Insira o nome"));
		setPlaca(JOptionPane.showInputDialog("Insira a placa"));
	}

	public String getNome() {
		return nome.toUpperCase();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		if (validaPlaca(placa))
			this.placa = placa;
		else
			setPlaca(JOptionPane.showInputDialog("Insira uma placa válida"));
	}
	
	private boolean validaPlaca(String p){
		return(p.length()==8 && p.indexOf(' ')==3);
	}
}
