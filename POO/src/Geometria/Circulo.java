package Geometria;

public class Circulo extends Forma {

	private int raio = 0;
	
	public Circulo(int r){
		setRaio(r);
	}
	
	@Override
	public double calculaPerimetro() {
		 return 2*Math.PI*getRaio();
	}
	
	@Override
	public double calculaArea() {
		return Math.PI*getRaio()*getRaio();
	}
	
	@Override
	public String toString() {
		return "Círculo\n"+
				"Raio = "+ getRaio()+"\n";
	}

	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}
	
	
	

}
