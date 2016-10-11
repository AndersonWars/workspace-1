package barbeiro;

import java.util.Random;

public class Barbeiro implements Runnable{

	private int cadeiraDeEspera;
	boolean cadeiraOcupada = false;
	int[] clientes;
	boolean barbeiroDorme = false;
	private String nome;
	private int cliNovos;
	int nClientes;
	
	public Barbeiro(String nome, int cadeiraDeEspera, int clientes){
		cliNovos = clientes;
		this.nome = nome;
		this.cadeiraDeEspera = cadeiraDeEspera;
		System.out.println("O barbeiro "+nome+" chegou no salão");
	}
	
	public void clientes(){
		Random r = new Random();
		nClientes = r.nextInt(cliNovos);
		clientes = new int[nClientes];
		for (int i=0;nClientes<clientes.length;i++){
			clientes[i] = i;
		}
	}
	
	public void barbeiroDorme() throws InterruptedException{
		System.out.println("Não existem clientes no salão do barbeiro "+nome+".");
		System.out.println("O barbeiro "+nome+" está esperando a chegada de clientes");
		Thread.sleep(2000);
		System.out.println("A cadeira do barbeiro "+nome+" está livre");
		clientes();
	}
	
	public void barbeiroAtende() throws InterruptedException{
		if (nClientes!=0){
			if(nClientes>1 && cadeiraOcupada == false){
				System.out.println("Entraram "+nClientes+" clientes no salão");
			}else{
				System.out.println("Existem "+nClientes+ " clientes esperando por atendimento "+nome);
			}
			System.out.println("Um cliente ocupou a cadeira do barbeiro");
			nClientes--;
			System.out.println("Um cliente está sendo atendido pelo barbeiro");
			cadeiraOcupada = true;
			Thread.sleep(1000);
			if(nClientes>cadeiraDeEspera){
				int cli = nClientes - cadeiraDeEspera;
				nClientes = nClientes-cli;
				for (int i=0;i<clientes.length;i++){
					clientes[i]=0;
				}
				for (int j=0;j<nClientes;j++){
					clientes[j] = j+1;
				}
				System.out.println(cli+" clientes foram embora");
				System.out.println(nClientes+" clientes esperando");
			}
			System.out.println("Um cliente ja foi atendido pelo barbeiro");
		}else if(nClientes == 1){
			System.out.println("A cadeira do barbeiro está livre");
			System.out.println("A cadeira bo barbeiro está ocupada não existem clientes esperando");
			Thread.sleep(1000);
			nClientes--;
			System.out.println("Um cliente já foi atendido pelo barbeiro");
		}else{
			System.out.println("A cadeira do barbeiro esta livre");
			cadeiraOcupada = false;
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(nClientes<=0){
				try{
					barbeiroDorme();
				}catch (InterruptedException e){
					e.printStackTrace();
				}
			}else{
				try{
					barbeiroAtende();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
