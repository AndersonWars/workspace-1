package avaliacao_bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Carro {
	
	private String marca, modelo, outro="";
	private int ano, id;
	private double valor;
	private char ar, direcao, piloto, abs;
	
	public Carro(String marca, String modelo, int ano, double valor, char ar, char direcao, char piloto, char abs) throws NumberFormatException{
		setMarca(marca);
		if (modelo.isEmpty() || modelo.startsWith(" "))
			throw new NumberFormatException();
		else
			setModelo(modelo);
		setAno(ano);
		setValor(valor);
		setAr(ar);
		setDirecao(direcao);
		setPiloto(piloto);
		setAbs(abs);
	}
	
	public int cadastra(){
		int feito = 0;
		String sql = "insert into carro (marca,modelo,ano,valor,ar,direcao,piloto,abs,outro) values (?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement ps = JanelaPrincipal.conn.prepareStatement(sql);
			ps.setString(1, getMarca());
			ps.setString(2, getModelo());
			ps.setInt(3, getAno());
			ps.setDouble(4, getValor());
			ps.setString(5, getAr()+"");
			ps.setString(6, getDirecao()+"");
			ps.setString(7, getPiloto()+"");
			ps.setString(8, getAbs()+"");
			ps.setString(9, getOutro());
			feito = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return feito;
	}
	
	public static ArrayList<Carro> listaTudo(){
		ArrayList<Carro> carros = new ArrayList<Carro>();
		String sql = "select * from carro order by ano";
		try{
			PreparedStatement ps = JanelaPrincipal.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Carro c = new Carro(rs.getString("marca"), rs.getString("modelo"), rs.getInt("ano"), rs.getDouble("valor"), 
						rs.getString("ar").charAt(0), rs.getString("direcao").charAt(0), rs.getString("piloto").charAt(0), 
						rs.getString("abs").charAt(0));
				c.setOutro(rs.getString("outro"));
				c.setId(rs.getInt("id"));
				carros.add(c);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return carros;
	}
	
	public String[] toArray(){
		DecimalFormat df = new DecimalFormat("##.00");
		String[] linha = new String[9];
		linha[0] = getMarca();
		linha[1] = getModelo();
		linha[2] = getAno()+"";
		linha[3] = df.format(getValor());
		linha[4] = getAr()+"";
		linha[5] = getDirecao()+"";
		linha[6] = getPiloto()+"";
		linha[7] = getAbs()+"";
		linha[8] = getOutro();
		return linha;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getOutro() {
		return outro;
	}

	public void setOutro(String outro) {
		this.outro = outro;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public char getAr() {
		return ar;
	}

	public void setAr(char ar) {
		this.ar = ar;
	}

	public char getDirecao() {
		return direcao;
	}

	public void setDirecao(char direcao) {
		this.direcao = direcao;
	}

	public char getPiloto() {
		return piloto;
	}

	public void setPiloto(char piloto) {
		this.piloto = piloto;
	}

	public char getAbs() {
		return abs;
	}

	public void setAbs(char abs) {
		this.abs = abs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
