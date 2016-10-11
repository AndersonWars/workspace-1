package excecao;

import javax.swing.JOptionPane;

public class Exemplo1 {
	public static void main(String[] args) {
		try{
			Calc c = new Calc();
			int n1 = Integer.parseInt(JOptionPane.showInputDialog("N1"));
			int n2 = Integer.parseInt(JOptionPane.showInputDialog("N2"));
			int resp = c.soma(n1, n2);
			System.out.println(resp);
			// Foram erros throw new ArrayIndexOutOfBoundsException("");
		}catch(NumberFormatException e){
			System.out.println("NÃºmero invÃ¡lido");
		}catch(NullPointerException e){
			System.out.println("Ponteiro nulo");
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Ã�ndice invÃ¡lido");
		}catch(Exception e){
			System.out.println("Erro desconhecido");
		}
	}
}
