package relembrando;

import javax.swing.JOptionPane;

public class MediaAlinos {
	static TipoAluno[] alunos = new TipoAluno [32];
	static int qt=0;
	public static void main(String[] args) {
		int op=0;
		while (op>=0 && op<5){
		op = menu();
		switch (op){
			case 1:
				alunos[qt]=cadastra();
				qt++;
				break;
			case 2:
				String aprovados = "";
				for (int i=0;i<qt;i++){
					if (alunos[i].media >= 7){
						aprovados = lista(i);
					}
				}
				JOptionPane.showMessageDialog(null, aprovados);
				break;
			case 3:
				String recuperacao = "";
				for (int i=0;i<qt;i++){
					if (alunos[i].media>=2 && alunos[i].media<=6.9){
						recuperacao = alunos[i].nome+": média "+alunos[i].media+"; precisa de "+(12-alunos[i].media)+"\n";
					}
				}
				JOptionPane.showMessageDialog(null, recuperacao);
				break;
			case 4:
				String reprovados = "";
				for (int i=0;i<qt;i++){
					if (alunos[i].media<2){
						reprovados = lista(i);
					}
				}
				JOptionPane.showMessageDialog(null, reprovados);
				break;
		}
		}
	}
	
	static int menu(){
		String menu = "1- Cadastra Aluno\n"
				+"2 - Lista Aprovados\n"
				+"3 - Lista Recuperação\n"
				+"4 - Lista Reprovados\n";
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return op;
	}
	
	static TipoAluno cadastra(){
		TipoAluno a = new TipoAluno();
		a.nome = JOptionPane.showInputDialog("Digite o nome do aluno");
		a.n1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota 1 de "+a.nome));
		a.n2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota 2 de "+a.nome));
		a.n3 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota 3 de "+a.nome));
		a.n4 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota 4 de "+a.nome));
		a.media = ((a.n1*30)+(a.n2*30)+(a.n3*30)+(a.n4*10))/100;
		return a;
	}
	
	static String lista(int i){
		String lista = alunos[i].nome+": média "+alunos[i].media+"\n";
		return lista;
	}
}
