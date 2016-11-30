package banco_de_dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Pessoa {
	private String nome;
	private int idade, codigo;
	private char sexo;
	
	public Pessoa(String nome, int idade, char sexo) throws NumberFormatException, NullPointerException {
		if (nome.equals(" ") || nome.equals("") || nome==null)
			throw new NullPointerException();
		else
			this.nome = nome;
		if (idade<0)
			throw new NumberFormatException();
		else
			this.idade = idade;
		this.sexo = sexo;
	}
	
	public int cadastra(){
		int feito = 0;
		String sql = "insert into pessoa (nome,idade,sexo) values (?,?,?)";
		try{
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ps.setString(1, this.nome);
			ps.setInt(2, this.idade);
			ps.setString(3, this.sexo+"");
			feito = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return feito;
	}
	
	public int altera(){
		int feito = 0;
		String sql = "update Pessoa set nome=?,idade=?,sexo=? where codigo=?";
		try{
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ps.setString(1, this.nome);
			ps.setInt(2, this.idade);
			ps.setString(3, this.sexo+"");
			ps.setInt(4, this.codigo);
			feito = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return feito;
	}
	
	public int deleta(){
		int feito = 0;
		String sql = "update Pessoa set ativo='f' where codigo=?";
		try{
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ps.setInt(1, this.codigo);
			feito = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return feito;
	}
	
	
	public static ArrayList<Pessoa> listarTudo(){
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		String sql = "select * from Pessoa where ativo='s'";
		try{
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Pessoa p = new Pessoa(rs.getString("nome"), 
						rs.getInt("idade"), rs.getString("sexo").charAt(0));
				p.codigo = rs.getInt("codigo");
				pessoas.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pessoas;
	}
	
	public static ArrayList<Pessoa> listaFiltro(String filtro){
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		String sql = "select * from Pessoa where ativo='s' and nome like ?";
		try{
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ps.setString(1, filtro+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Pessoa p = new Pessoa(rs.getString("nome"), 
						rs.getInt("idade"), rs.getString("sexo").charAt(0));
				p.codigo = rs.getInt("codigo");
			pessoas.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pessoas;
	}
	
	public String[] toArray(){
		String[] lista = new String[3];
		lista[0] = nome;
		lista[1] = idade+"";
		lista[2] = sexo=='M'?"Masculino":"Feminino";
		return lista;
	}
	
	public Pessoa buscaPorId(int id){
		String sql = "select * from Pessoa where codigo="+id;
		Pessoa p = null;
		try{
			PreparedStatement ps = Tela3.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			p = new Pessoa(rs.getString("nome"), rs.getInt("idade"), rs.getString("sexo").charAt(0));
			p.setCodigo(rs.getInt("codigo"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return p;
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	
}
