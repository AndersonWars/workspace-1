package times_futebol;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Campeonato {
	static ArrayList<Time> lista = new ArrayList<Time>();
	public static void main(String[] args) {
		String menu = " ***UEFA Semi-Champions League***\n\n"
				+"1 - Cadastrar times\n"
				+"2 - Listar todos os jogadores de um time\n"
				+"3 - Verificar artilheiro do campeonato\n"
				+"4 - Verificar qual time fez mais gols no campeonato\n"
				+"5 - Sair";
		int op = 0;
		do{
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op){
			case 1:
				Time t = new Time();
				t.cadastra();
				lista.add(t);
				break;
			case 2:
				listaJogadores();
				break;
			case 3:
				verificaArtilheiro();
				break;
			case 4:
				verificaTimeGols();
			}
			
		}while(op<5);
	}
	
	public static void cadastra(){
		Time t = new Time();
		lista.add(t);
	}
	
	public static void listaJogadores(){
		String timeUsr = JOptionPane.showInputDialog("Digite o time de que você quer saber os jogadores");
		for (Time time : lista) {
			if (timeUsr.equals(time.getNome())){
				time.listaJogadores();
				break;
			}
		}
	}
	
	public static void verificaArtilheiro(){
		Jogador maiorArtilheiro = new Jogador();
		for (Time time : lista) {
			if (time.artilheiroTime().getQtdGols() > maiorArtilheiro.getQtdGols()){
				maiorArtilheiro.setNome(time.artilheiroTime().getNome());
				maiorArtilheiro.setNumCamisa(time.artilheiroTime().getNumCamisa());
				maiorArtilheiro.setQtdGols(time.artilheiroTime().getQtdGols());
			}
		}
		JOptionPane.showMessageDialog(null, maiorArtilheiro.getNome()+" - Camisa "+maiorArtilheiro.getNumCamisa()+" - "+maiorArtilheiro.getQtdGols()+" gols");
	}
	
	public static void verificaTimeGols(){
		int maisGols = 0;
		Time t = new Time();
		for (Time time : lista) {
			if (time.somaGols() > maisGols){
				t = time.clone();
			}
		}
		JOptionPane.showMessageDialog(null, t, "Jogadores do time", JOptionPane.INFORMATION_MESSAGE); 
	}
}
