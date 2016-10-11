package swt;

public class Produto {
	private String produto = "";
	private double vl, subTotal;
	private int qt;
	//private static int index = -1;
	
	public String[] toArray(){
		String[] x = new String[4];
		x[0] = getProduto();
		x[1] = getQt()+"";
		x[2] = getVl()+"";
		x[3] = getSubTotal()+"";
		return x;
	}
	
	public Produto(String prod, double val, int qtd){
		setProduto(prod);
		setVl(val);
		setQt(qtd);
		setSubTotal(getVl()*getQt());
		//this.index++;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public double getVl() {
		return vl;
	}

	public void setVl(double vl) {
		this.vl = vl;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public int getQt() {
		return qt;
	}

	public void setQt(int qt) {
		this.qt = qt;
	}
	
	
}
