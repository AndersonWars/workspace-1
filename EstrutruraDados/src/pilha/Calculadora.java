package pilha;

//import javax.swing.JOptionPane;

public class Calculadora {
	static PilhaDeString p = new PilhaDeString();
	static PilhaDeInteiros q = new PilhaDeInteiros();
	static PilhaDeString s = new PilhaDeString();

	public static void main(String[] args) {
		p.empilhar("10");
		p.empilhar("15");
		p.empilhar("*");
		p.empilhar("9");
		p.empilhar("1");
		p.empilhar("+");
		p.empilhar("/");
		//leString(JOptionPane.showInputDialog("Insira a expressão em método pos fixado"));
		desempilhaP();
		while(!s.estaVazia()){
			String op = s.desempilhar();
			if(op.equals("+"))
				soma();
			else if(op.equals("-"))
				sub();
			else if(op.equals("*"))
				mult();
			else
				div();
		}
		//System.out.println(p.mostraTopo());
	}
	
	public static void confereNumero(String aux){
		if(!aux.equals("+") && !aux.equals("-") && !aux.equals("*") && !aux.equals("/")){
			q.empilhar(Double.parseDouble(aux));
		}else{
			s.empilhar(aux);
		}
	}
	
	public static void soma(){
		double num1 = q.desempilhar();
		double num2 = q.desempilhar();
		double resp = num1+num2;
		if(s.tamanho()!=0){
			while(!q.estaVazia()){
				p.empilhar(q.desempilhar()+"");
			}
			p.empilhar(resp+"");
			desempilhaP();
		}else
			System.out.println(resp);
	}
	
	public static void sub(){
		double num1 = q.desempilhar();
		double num2 = q.desempilhar();
		double resp = num1-num2;
		if(s.tamanho()!=0){
			while(!q.estaVazia()){
				p.empilhar(q.desempilhar()+"");
			}
			p.empilhar(resp+"");
			desempilhaP();
		}else
			System.out.println(resp);
	}
	
	public static void mult(){
		double num1 = q.desempilhar();
		double num2 = q.desempilhar();
		double resp = num1*num2;
		if(s.tamanho()!=0){
			while(!q.estaVazia()){
				p.empilhar(q.desempilhar()+"");
			}
			p.empilhar(resp+"");
			desempilhaP();
		}else
			System.out.println(resp);
	}
	
	public static void div(){
		double num1 = q.desempilhar();
		double num2 = q.desempilhar();
		double resp = num1/num2;
		if(s.tamanho()!=0){
			while(!q.estaVazia()){
				p.empilhar(q.desempilhar()+"");
			}
			p.empilhar(resp+"");
			desempilhaP();
		}else
			System.out.println(resp);
	}
	
	public static void desempilhaP(){
		while(!p.estaVazia()){
			String aux = p.desempilhar();
			confereNumero(aux);
		}
	}
	
	public static void leString(String input){
		for (int i=0;i<input.length();i++){
			p.empilhar(input.substring(i, i+1));
		}
	}
}
