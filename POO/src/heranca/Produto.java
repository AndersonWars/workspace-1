package heranca;

import javax.swing.JOptionPane;

public class Produto {
	protected String nome = "";
	protected int estoque = 0;
	protected double valor = 0;
	
	public boolean vender(Cliente c, int qt){
		if (getEstoque() >= qt){
			setEstoque(getEstoque()-qt);
			c.setDivida(c.getDivida()+valor*qt);
			return true;
		}
		JOptionPane.showMessageDialog(null, "Produto com estoque abaixo da quantia desejada");
		return false;
	}
	
	public Produto(){
		cadastra();
	}
	
	public void cadastra(){
		setNome(JOptionPane.showInputDialog("Digite o nome do produto"));
		setEstoque(Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque de "+ getNome())));
		setValor(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de "+ getNome())));
	}
	
	public String toString() {
		return getNome()+" - "+getEstoque()+" unidades - Valor: R$"+getValor()+"\n";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
