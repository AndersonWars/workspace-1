package Geometria;

public class Quadrado extends Quadrilateros {

	public Quadrado(int l1, int l2){
		super(l1, l2);
	}
	
	@Override
	public double calculaPerimetro() {
		return super.calculaPerimetro();
	}
	
	@Override
	public double calculaArea() {
		return super.calculaArea();
	}
	
	@Override
	public String toString() {
		return "Quadrado\n"+
				"Lados --> L1 = L2 = L3 = L4 = "+ getL1()+"\n";
	}
}
