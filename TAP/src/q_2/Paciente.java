package q_2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Paciente {
	private int codigo;
	private String nome;
	private int idade;
	private char sexo;
	
	public Paciente(String nome, int idade, char sexo) throws NumberFormatException {
		if(idade>=0 && nome!=null){
			setNome(nome);
			setIdade(idade);
		}else
			throw new NumberFormatException();
		setSexo(sexo);
	}
	
	public int cadastra(){
		int qt = 0;
		String sql = "insert into paciente (nome, idade, sexo) values (?,?,?)";
		try{
			PreparedStatement ps = JanelaSwt.conn.prepareStatement(sql);
			ps.setString(1, getNome());
			ps.setInt(2, getIdade());
			ps.setString(3, getSexo()+"");
			qt = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return qt;
	}
	
	public int altera(){
		int qt = 0;
		String sql = "update paciente set nome=?, idade=?, sexo=? where codigo=? ";
		try{
			PreparedStatement ps = JanelaSwt.conn.prepareStatement(sql);
			ps.setString(1, getNome());
			ps.setInt(2, getIdade());
			ps.setString(3, getSexo()+"");
			ps.setInt(4, getCodigo());
			qt = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return qt;
	}
	
	public int exclui(){
		int qt = 0;
		String sql = "update paciente set ativo='n' where codigo=?";
		try{
			PreparedStatement ps = JanelaSwt.conn.prepareStatement(sql);
			ps.setInt(1, getCodigo());
			qt = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return qt;
	}
	
	public static ArrayList<Paciente> listaTudo(){
		ArrayList<Paciente> lista = new ArrayList<Paciente>();
		String sql = "select * from paciente where ativo='s' order by nome";
		try{
			PreparedStatement ps = JanelaSwt.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Paciente p = new Paciente(rs.getString("nome"), rs.getInt("idade"), rs.getString("sexo").charAt(0));
				p.setCodigo(rs.getInt("codigo"));
				lista.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public static ArrayList<Paciente> listaFiltro(String filtro, int op){
		ArrayList<Paciente> lista = new ArrayList<Paciente>();
		String sql = "select * from paciente where ativo='s' and nome like ? order by nome";
		try{
			PreparedStatement ps = JanelaSwt.conn.prepareStatement(sql);
			if(op==1)
				ps.setString(1, filtro+"%");
			else if(op==2)
				ps.setString(1, "%"+filtro+"%");
			else
				ps.setString(1, "%"+filtro);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Paciente p = new Paciente(rs.getString("nome"), rs.getInt("idade"), rs.getString("sexo").charAt(0));
				p.setCodigo(rs.getInt("codigo"));
				lista.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	
	
}
