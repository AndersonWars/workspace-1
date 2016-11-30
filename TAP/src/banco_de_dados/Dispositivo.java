package banco_de_dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dispositivo {
	private String nome;
	private double valor;
	private int codigo;
	
	public Dispositivo(String nome, double valor){
		setNome(nome);
		setValor(valor);
	}
	
	public int cadastra(){
		int feito = 0;
		String sql = "insert into Dispositivos (nome,valor) values (?,?)";
		try{
			PreparedStatement ps = Principal2.conn.prepareStatement(sql);
			ps.setString(1, getNome());
			ps.setDouble(2, getValor());
			feito = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return feito;
	}
	
	public int altera(){
		int feito = 0;
		String sql = "update Dispositivos set nome=?,valor=? where codigo=?";
		try{
			PreparedStatement ps = Principal2.conn.prepareStatement(sql);
			ps.setString(1, getNome());
			ps.setDouble(2, getValor());
			ps.setInt(3, getCodigo());
			feito = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return feito;
	}
	
	public int exclui(){
		int feito = 0;
		String sql = "update Dispositvos set ativo='f' where codigo=?";
		try{
			PreparedStatement ps = Principal2.conn.prepareStatement(sql);
			ps.setInt(1, getCodigo());
			feito = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return feito;
	}
	
	public static ArrayList<Dispositivo> listaTudo(){
		ArrayList<Dispositivo> dispositivos = new ArrayList<>();
		String sql = "select * from Dispositivos where ativo='s' order by nome";
		try{
			PreparedStatement ps = Principal2.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Dispositivo d = new Dispositivo(rs.getString("nome"), rs.getDouble("valor"));
				d.setCodigo(rs.getInt("codigo"));
				dispositivos.add(d);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dispositivos;
	}
	
	public static ArrayList<Dispositivo> listaFiltro(String filtro){
		ArrayList<Dispositivo> dispositivos = new ArrayList<>();
		String sql = "select * from Dispositivos where ativo='s' and nome like ? order by nome";
		try{
			PreparedStatement ps = Principal2.conn.prepareStatement(sql);
			ps.setString(1, filtro+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Dispositivo d = new Dispositivo(rs.getString("nome"), rs.getDouble("valor"));
				d.setCodigo(rs.getInt("codigo"));
				dispositivos.add(d);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dispositivos;
	} 
	
	public String[] toArray(){
		String[] lista = new String[2];
		lista[0] = getNome();
		lista[1] = getValor()+"";
		return lista;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
}
