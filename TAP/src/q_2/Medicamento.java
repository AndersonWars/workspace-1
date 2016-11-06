package q_2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Medicamento {
	private int codigo;
	private String nome;
	private int qtd;
	private double valor;
	
	public Medicamento(String nome, int qtd, double valor) throws NumberFormatException{
		setNome(nome);
		if (qtd>0 && valor>0){	
			setQtd(qtd);
			setValor(valor);
		}else
			throw new NumberFormatException();
	}
	
	public Medicamento() {
	}
	
	/*SQL de alteração
	 * update medicamento set nome=?, valor=?, qt_caixa=?
	 * where codigo=?
	 * 
	 * SQL para exclusão
	 * delete from medicamento where codigo=?
	 * 
	 * SQL listar tudo
	 * 
	 * select * from medicamento order by nome
	 * 
	 */
	
	public int cadastra(){
		int qt = 0;
		String sql = "insert into medicamento (nome, valor, qt_caixa) values (?,?,?)";
		try{
			PreparedStatement ps = JanelaSwt.conn.prepareStatement(sql);
			ps.setString(1, getNome());
			ps.setDouble(2, getValor());
			ps.setInt(3, getQtd());
			qt = ps.executeUpdate();
			//ResultSet rs = ps.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}
		return qt;
	}
	
	public int altera(){
		int qt = 0;
		String sql = "update medicamento set nome=?, valor=?, qt_caixa=? where codigo=?";
		try{
			PreparedStatement ps = JanelaSwt.conn.prepareStatement(sql);
			ps.setString(1, getNome());
			ps.setDouble(2, getValor());
			ps.setInt(3, getQtd());
			ps.setInt(4, getCodigo());
			qt = ps.executeUpdate();
			//ResultSet rs = ps.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}
		return qt;
	}
	
	public int exclui(){
		int qt = 0;
		String sql = "update medicamento set ativo='n' where codigo=?";
		try{
			PreparedStatement ps = JanelaSwt.conn.prepareStatement(sql);
			ps.setInt(1, getCodigo());
			qt = ps.executeUpdate();
			//ResultSet rs = ps.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}
		return qt;
	}
	
	public static ArrayList<Medicamento> listaTodos(){
		ArrayList<Medicamento> lista = new ArrayList<Medicamento>();
		String sql = "select * from medicamento where ativo='s' order by nome";
		try{
			PreparedStatement ps = JanelaSwt.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Medicamento m = new Medicamento(rs.getString("nome"), rs.getInt("qt_caixa"), rs.getDouble("valor"));
				m.setCodigo(rs.getInt("codigo"));
				lista.add(m);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public static ArrayList<Medicamento> listaFiltro(String filtro){
		ArrayList<Medicamento> lista = new ArrayList<Medicamento>();
		String sql = "select * from medicamento where ativo='s' and nome like ? order by nome";
		try{
			PreparedStatement ps = JanelaSwt.conn.prepareStatement(sql);
			ps.setString(1, filtro+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Medicamento m = new Medicamento(rs.getString("nome"), rs.getInt("qt_caixa"), rs.getDouble("valor"));
				m.setCodigo(rs.getInt("codigo"));
				lista.add(m);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public static Medicamento buscaPorId(int id){
		Medicamento m = null;
		String sql = "select * from medicamento where ativo='s' and codigo=? order by nome";
		try{
			PreparedStatement ps = JanelaSwt.conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				m = new Medicamento((rs.getString("nome")), (rs.getInt("qt_caixa")), (rs.getDouble("valor")));
				m.setCodigo(rs.getInt("codigo"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return m;
	}
	
	public String[] toArray(){
		String v[] = new String[4];
		v[0] = getNome();
		v[1] = "R$"+getValor()+"";
		v[2] = getQtd()+"";
		v[3] = "R$"+(getValor()/getQtd())+"";
		return v;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
