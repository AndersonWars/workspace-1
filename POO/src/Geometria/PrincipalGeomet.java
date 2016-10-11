package Geometria;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PrincipalGeomet {
	static ArrayList<Forma> lista = new ArrayList<Forma>();
	public static void main(String[] args) {
		int op = 0;
		do{
			op = menu();
			switch (op){
			case 1:
				int lado = Integer.parseInt(JOptionPane.showInputDialog("Qual o lado do quadrado"));
				lista.add(new Quadrado(lado, lado));
				break;
			case 2:
				int base = Integer.parseInt(JOptionPane.showInputDialog("Qual a base do retângulo"));
				int altura = Integer.parseInt(JOptionPane.showInputDialog("Qual a altura do retângulo"));
				lista.add(new Retangulos(base, altura));
				break;
			case 3:
				int raio = Integer.parseInt(JOptionPane.showInputDialog("Qual o raio do círculo"));
				lista.add(new Circulo(raio));
				break;
			case 4:
				mostraLados();
				break;
			case 5:
				mostraPerimetros();
				break;
			case 6:
				mostraAreas();
				break;
			}
			
		}while (op!= 7);

	}
	
	public static int menu(){
		String menu = "1 - Criar quadrado\n"
				+"2 - Criar retângulo\n"
				+"3 - Criar Circulo\n"
				+"4 - Mostrar lados/raio\n"
				+"5 - Mostrar perímetros\n"
				+"6 - Mostrar áreas\n"
				+"7 - Sair";
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return op;
	}
	
	public static void mostraLados(){
		int index = 1;
		String listF = "Lista de Formas Geométricas\n\n";
		for (Forma f : lista) {
			listF += index+" "+f.toString()+"\n";
			index++;
		}
		JOptionPane.showMessageDialog(null, listF);
	}
	
	public static void mostraPerimetros(){
		String listP = "Lista de perímetros geométricos\n\n";
		int index = 1;
		for (Forma f : lista) {
			if (f instanceof Quadrado){
				listP += index+" Quadrado --> Perímetro = "+f.calculaPerimetro()+"\n";
				index++;
			}else if (f instanceof Retangulos){
				listP += index+" Retângulo --> Perímetro = "+f.calculaPerimetro()+"\n";
				index++;
			}else{
				listP += index+" Círculo --> Perímetro = "+f.calculaPerimetro()+"\n";
				index++;
			}
		}
		JOptionPane.showMessageDialog(null, listP);
	}
	
	public static void mostraAreas(){
		int index = 1;
		String listA = "Lista de Áreas geométricas\n\n";
		for (Forma f : lista) {
			if (f instanceof Quadrado){
				listA += index+" Quadrado --> Área = "+f.calculaArea()+"\n";
				index++;
			}else if (f instanceof Retangulos){
				listA += index+" Retângulo --> Área = "+f.calculaArea()+"\n";
				index++;
			}else{
				listA += index+" Círculo --> Área = "+f.calculaArea()+"\n";
				index++;
			}
		}
		JOptionPane.showMessageDialog(null, listA);
	}
}
