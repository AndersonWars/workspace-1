package farmacia;

import javax.swing.JOptionPane;

public class Medicametos extends Produto {
	private boolean receita;

	public Medicametos(){
		char rec = JOptionPane.showInputDialog("O produto precisa de receita (S/N)").charAt(0);
		setReceita(rec == 'S' || rec == 's');
	}
	
	@Override
	public boolean venda(int qt, Cliente c) {
		if (isReceita()){
			JOptionPane.showInputDialog("Qual o nome do médico?");
			if (qt <= getEstoque()) 
				return super.venda(qt, c);
		}
			return false;
	}
	
	public boolean isReceita() {
		return receita;
	}

	public void setReceita(boolean receita) {
		this.receita = receita;
	}
	
	
	
}
