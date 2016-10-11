package excecao;

public class Carro {
	public void dirigir(String distancia) throws Exception/*Propaga erro nível mais exterior (classe pai)*/{
		try{
			double d = Double.parseDouble(distancia);
			double gasto = 3.39*d/14;
			System.out.println(gasto);
		}catch(Exception e){
			System.out.println("Erro da classe carro");
			throw new Exception();
		}
	}
}
