package prova2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Vacina {
	
	private String nome;
	private int idadeNormal, idadeApl, id, idPaciente;
	
	public Vacina(String nome, int idade, int idadeApl) {
		setNome(nome);
		setIdadeNormal(idade);
		setIdadeApl(idadeApl);
	}
	
	public int cadastra(){
		int feito = 0;
		String sql = "insert into vacina (nome, idade_vacina, idade_apl, id_pessoa) values (?,?,?,?)";
		try{
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ps.setString(1, getNome());
			ps.setInt(2, getIdadeNormal());
			ps.setInt(3, getIdadeApl());
			ps.setInt(4, getIdPaciente());
			feito = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return feito;
	}
	
	public int altera(){
		int feito = 0;
		String sql = "update vacina set nome=?, idade_vacina=?, idade_apl=?, id_pessoa=? where id=?";
		try{
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ps.setString(1, getNome());
			ps.setInt(2, getIdadeNormal());
			ps.setInt(3, getIdadeApl());
			ps.setInt(4, getIdPaciente());
			ps.setInt(5, getId());
			feito = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return feito;
	}
	 
	public int exclui(){
		int feito = 0;
		String sql = "delete from vacina where id=?";
		try{
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ps.setInt(1,getId());
			feito = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return feito;
	}
	
	public static ArrayList<Vacina> listaTudo(){
		ArrayList<Vacina> vacina = new ArrayList<Vacina>();
		String sql = "select * from vacina order by nome";
		try{
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Vacina v = new Vacina(rs.getString("nome"), rs.getInt("idade_vacina"), rs.getInt("idade_apl"));
				v.setId(rs.getInt("id"));
				v.setIdPaciente(rs.getInt("id_pessoa"));
				vacina.add(v);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return vacina;
	}
	
	public static ArrayList<String[]> consulta(){
		ArrayList<String[]> linha = new ArrayList<>();
		String[] l = new String[2]; 
		String sql = "SELECT P.NOME_PESSOA AS NAME, V.NOME AS NOME FROM VACINA V JOIN PESSOA P ON V.ID_PESSOA = P.ID WHERE V.IDADE_VACINA < V.IDADE_APL";
		try{
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				l[0] = rs.getString("NOME");
				l[1] = rs.getString("NAME");
				linha.add(l);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return linha;
	}
	
	public String retornaNome(){
		String p="";
		String sql = "SELECT NOME_PESSOA FROM PESSOA WHERE ID = "+getIdPaciente();
		try{
			PreparedStatement ps = Principal.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			p = rs.getString("nome_pessoa");
		}catch(Exception e){
			e.printStackTrace();
		}
		return p;
	}
	
	public String[] toArray(){
		String[] linha = new String[4];
		linha[0] = getNome();
		linha[1] = getIdadeNormal()+"";
		linha[2] = getIdadeApl()+"";
		linha[3] = retornaNome();
		return linha;
	}
	
	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public int getIdadeNormal() {
		return idadeNormal;
	}

	public void setIdadeNormal(int idadeNormal) {
		this.idadeNormal = idadeNormal;
	}

	public int getIdadeApl() {
		return idadeApl;
	}

	public void setIdadeApl(int idadeApl) {
		this.idadeApl = idadeApl;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
