package times_futebol;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Time {
	private String nome;
	public ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	
	public void cadastra(){
		setNome(JOptionPane.showInputDialog("Insira o nome do time:"));
		for (int i=0;i<3;i++){
			Jogador x = new Jogador();
			x.cadastra();
			jogadores.add(x);
		}
	}
	
	public void listaJogadores(){
		String jogadoresDoTime = "Jogadores do Time\n";
		for (Jogador j : jogadores) {
			jogadoresDoTime += j.toString();
		}
		JOptionPane.showMessageDialog(null, jogadoresDoTime);
	}
	
	public Jogador artilheiroTime(){
		Jogador artilheiro = new Jogador();
		for (Jogador jogador : jogadores) {
			if (jogador.getQtdGols() > artilheiro.getQtdGols()){
				artilheiro.setNome(jogador.getNome());
				artilheiro.setNumCamisa(jogador.getNumCamisa());
				artilheiro.setQtdGols(jogador.getQtdGols());
			}
		}
		return artilheiro;
	}
	
	public int somaGols(){
		int g=0;
		for (Jogador jogador : jogadores) {
			 g+=jogador.getQtdGols();
		}
		System.out.println(g);
		return g;
	}
	
	public String toString() {
		return getNome();
	}
	
	public Time clone(){
		Time novo = new Time();
		novo.setNome(getNome());
		return novo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
