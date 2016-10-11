package preprova;

public class Produto {
	private String nome;
	private int qt;
	private double preco, subtotal;
	
	public Produto(String nome, int qt, double preco){
		setNome(nome);
		setQt(qt);
		setPreco(preco);
		setSubtotal(preco*qt);
	}
	
	public String[] toArray(){
		String v[] = new String[4];
		v[0] = getNome();
		v[1] = getQt()+"";
		v[2] = getPreco()+"";
		v[3] = getSubtotal()+"";
		return v;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQt() {
		return qt;
	}
	public void setQt(int qt) {
		this.qt = qt;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	
}
