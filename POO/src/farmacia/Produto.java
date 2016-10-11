package farmacia;

import javax.swing.JOptionPane;

public class Produto {
	protected String nome = "";
	protected int estoque = 0;
	protected double preco = 0;
	
	public Produto(){
		cadastra();
	}
	
	public String toString() {
		return getNome()+" - Estoque: "+getEstoque()+" unidades - Preço: R$ "+getPreco();
	}
	
	public void cadastra(){
		setNome(JOptionPane.showInputDialog("Digite o nome do produto"));
		setEstoque(Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque de "+getNome())));
		setPreco(Double.parseDouble(JOptionPane.showInputDialog("Digite o preço de "+getNome())));
	}
	
	public boolean venda(int qt, Cliente c){
		if (qt>0){
			setEstoque(getEstoque() - qt);
			c.setDivida(c.getDivida() + (qt*getPreco()));
			return true;
		}
		return false;
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
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
