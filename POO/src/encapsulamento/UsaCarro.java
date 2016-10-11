package encapsulamento;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class UsaCarro {
	public static void main(String[] args) {
		ArrayList<Carro> lista = new ArrayList<Carro>();
		String menu = "1- Cadastrar\n"
				+"2 - Listar\n"
				+"3 - Sair";
		int op = 0;
		do{
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			if (op==1){
				Carro c = new Carro();
				c.cadastra();
				lista.add(c);
			}
			else if (op==2){
				String result="";
				for (Carro car : lista) {
					result+= car.getNome()+" - "+car.getPlaca();
				}
				JOptionPane.showMessageDialog(null, result);
			}
		}while (op!=3);
	}
}
