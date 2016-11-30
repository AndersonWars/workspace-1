package q_2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Prescricao {
	
	private Medicamento medicamento = new Medicamento();
	private Paciente paciente = new Paciente();
	private int qt;
	
	public int cadastra(){
		String sql = "insert into medicamento_paciente (cod_medicamento,cod_paciente,qt_diaria) values (?,?,?)";
		try{
			PreparedStatement ps = JanelaSwt.conn.prepareStatement(sql);
			ps.setInt(1, medicamento.getCodigo());
			ps.setInt(2, paciente.getCodigo());
			ps.setInt(3, qt);
			return ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public static ArrayList<Prescricao> retornaLista(){
		return TelaMedUtilz.presc;
	}
	
	public static ArrayList<Prescricao> buscaPorPaciente(Paciente p){
		ArrayList<Prescricao> lista = new ArrayList<>();
		String sql = "select * from medicamento_paciente where cod_paciente=?";
		try{
			PreparedStatement ps = JanelaSwt.conn.prepareStatement(sql);
			ps.setInt(1, p.getCodigo());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Prescricao presc = new Prescricao();
				presc.setPaciente(p);
				presc.setMedicameneto(Medicamento.buscaPorId(rs.getInt("cod_medicamento")));
				presc.setQt(rs.getInt("qt_diaria"));
				lista.add(presc);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public static ArrayList<Prescricao> buscaPorMedicamento(Medicamento m){
		ArrayList<Prescricao> lista = new ArrayList<>();
		String sql = "select * from medicamento_paciente where cod_medicamento=?";
		try{
			PreparedStatement ps = JanelaSwt.conn.prepareStatement(sql);
			ps.setInt(1, m.getCodigo());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Prescricao p = new Prescricao();
				p.setMedicameneto(m);
				p.setPaciente(Paciente.buscarPorId(rs.getInt("cod_paciente")));
				p.setQt(rs.getInt("qt_diaria"));
				lista.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public String[] colunasCon1(){
		DecimalFormat df = new DecimalFormat("##,00");
		double subTotal = medicamento.getValor()/medicamento.getQtd();
		return new String[]{medicamento.getNome(), medicamento.getValor()+"", medicamento.getQtd()+"", getQt()+"",(df.format(subTotal))};
	}
	
	public String[] colunasCon2(){
		return new String[]{paciente.getNome(), paciente.getIdade()+"",(paciente.getSexo()=='M'?"Masculino":"Feminino"), getQt()+""}; 
	}

	public Medicamento getMedicameneto() {
		return medicamento;
	}

	public void setMedicameneto(Medicamento medicameneto) {
		this.medicamento = medicameneto;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public int getQt() {
		return qt;
	}

	public void setQt(int qt) {
		this.qt = qt;
	}
	
	
	
}
