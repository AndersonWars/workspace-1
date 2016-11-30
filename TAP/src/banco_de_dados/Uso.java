package banco_de_dados;

import java.sql.PreparedStatement;

public class Uso {
	
	private Pessoa pessoa;
	private Dispositivo dispositivo;
	private int qtd;
	
	public int cadastra(){
		int feito=0;
		String sql = "insert into DispPes (cod_disp,cod_pessoa,qtd) values (?,?,?)";
		try{
			PreparedStatement ps = Tela3.conn.prepareStatement(sql);
			ps.setInt(1, dispositivo.getCodigo());
			ps.setInt(2, pessoa.getCodigo());
			ps.setInt(3, qtd);
			feito = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return feito;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	
}
