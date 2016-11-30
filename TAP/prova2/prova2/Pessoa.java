package prova2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Pessoa {

	private String nome;
	private int idade, id;
	
	public Pessoa(String nome, int idade) {
		setNome(nome);
		setIdade(idade);
	}
	
	public int cadastra(){
		int feito = 0;
		String sql = "insert into pessoa (nome_pessoa,idade_pessoa) values (?,?)";
		try{
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ps.setString(1, getNome());
			ps.setInt(2, getIdade());
			feito = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return feito;
	}
	
	public int altera(){
		int feito = 0;
		String sql = "update pessoa set nome_pessoa=?,idade_pessoa=? where id=?";
		try{
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ps.setString(1, getNome());
			ps.setInt(2, getIdade());
			ps.setInt(3, getId());
			feito = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return feito;
	}
	 
	public int exclui(){
		int feito = 0;
		String sql = "delete from pessoa where id=?";
		try{
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ps.setInt(1,getId());
			feito = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return feito;
	}
	
	public static ArrayList<Pessoa> listaTudo(){
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		String sql = "select * from pessoa order by nome_pessoa";
		try{
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Pessoa p = new Pessoa(rs.getString("nome_pessoa"), rs.getInt("idade_pessoa"));
				p.setId(rs.getInt("id"));
				pessoas.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pessoas;
	}
	
	public String[] toArray(){
		String[] linha = new String[2];
		linha[0] = getNome();
		linha[1] = getIdade()+"";
		return linha;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
