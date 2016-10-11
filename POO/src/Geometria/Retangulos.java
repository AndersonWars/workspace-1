package Geometria;

public class Retangulos extends Quadrilateros {
	
	public Retangulos(int l1, int l2){
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
		return "Retangulo\n"+
				"Lados: Bases: L1 = L3 = "+ getL1()+ "; Altura: L2 = L4 ="+getL2()+"\n";
	}
}
