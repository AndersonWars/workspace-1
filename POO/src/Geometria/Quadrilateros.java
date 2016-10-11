package Geometria;

public abstract class Quadrilateros extends Forma {

	protected int l1 = 0, l2 = 0;
	
	public Quadrilateros(int l1, int l2){
		setL1(l1);
		setL2(l2);
	}
	
	public double calculaPerimetro() {
		return getL1()*2 + getL2()*2;
	}
	
	@Override
	public double calculaArea() {	
		return getL1()*getL2();
	}
	
	@Override
	public String toString() {
		return "";
	}

	public int getL1() {
		return l1;
	}

	public void setL1(int l1) {
		this.l1 = l1;
	}

	public int getL2() {
		return l2;
	}

	public void setL2(int l2) {
		this.l2 = l2;
	}
	
}
