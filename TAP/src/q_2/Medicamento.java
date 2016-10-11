package q_2;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		String sql = "select * from medicamento order by nome";
		try{
			PreparedStatement ps = JanelaSwt.conn.prepareStatement(sql);
			ps.setString(1, "2");
			//ps.setDouble(2, getValor());
			//ps.setInt(3, getQtd());
			qt = ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
		}
		return qt;
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
