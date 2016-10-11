package swt;

public class Pessoa {
	private String nome;
	private int idade;
	private char sexo;
	
	
	public String[] toArray(){
		String v[] = new String[3];
		v[0] = getNome();
		v[1] = getIdade()+"";
		v[2] = getSexo()=='M'?"Masculino":"Feminino";
		return v;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	
}
