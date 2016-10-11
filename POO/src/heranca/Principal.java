package heranca;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {
	
	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<Medicamentos> medicamentos = new ArrayList<Medicamentos>();
	public static ArrayList<Perfumaria> perfumarias = new ArrayList<Perfumaria>();
	
	public static void main(String[] args) {
		String menu = "1 - Cadastrar clientes\n"
				+"2 - Cadastrar medicamentos\n"
				+"3 - Cadastrar perfumaria\n"
				+"4 - Vender medicamentos\n"
				+"5 - Vender perfumaria\n"
				+"6 - Mostrar dados dos clientes\n"
				+"7 - Mostrar dados dos produtos\n"
				+"8 - Sair";
		int op = 0;
		do{
			op = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Módulo de Vendas", JOptionPane.QUESTION_MESSAGE));
			switch (op) {
			case 1:
				clientes.add(new Cliente());
				break;
			case 2:
				medicamentos.add(new Medicamentos());
				break;
			case 3:
				perfumarias.add(new Perfumaria());
				break;
			case 4:
				venderMedicamento();
				break;
			case 5:
				venderPerfumaria();
				break;
			case 6:
				if (listaClientes().equals("Dados dos Clientes\n\n"))
					JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado");
				else
					JOptionPane.showMessageDialog(null, listaClientes());
				break;
			case 7:
				if (listaProdutos().equals("Lista dos Produtos\n\n"))
					JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado");
				else
					JOptionPane.showMessageDialog(null, listaProdutos());
				break;
			}
		}while(op!=8);
	}
	
	public static void venderMedicamento(){		
		String customer = JOptionPane.showInputDialog("Digite o cliente que quer comprar");
		boolean confere = false;
		for (Cliente c : clientes) {
			if (customer.equalsIgnoreCase(c.getNome())){
				confere = true;
				String med = JOptionPane.showInputDialog("Digite o medicamento que será vendido");
				if (confereMedicamento(med, c) != true){
					JOptionPane.showMessageDialog(null, "Produto não encontrado");
					break;
				}
			}
		}
		if (confere != true)
			JOptionPane.showMessageDialog(null, "Cliente não encontrado");
	}
	
	public static void venderPerfumaria(){		
		String customer = JOptionPane.showInputDialog("Digite o cliente que quer comprar");
		boolean confere = false;
		for (Cliente c : clientes) {
			if (customer.equalsIgnoreCase(c.getNome())){
				confere = true;
				String perf = JOptionPane.showInputDialog("Digite o perfumaria que será vendida");
				if (conferePerfumaria(perf, c) != true){
					JOptionPane.showMessageDialog(null, "Produto não encontrado");
					break;
				}
			}
		}
		if (confere != true)
			JOptionPane.showMessageDialog(null, "Cliente não encontrado");
			
	}
	
	public static boolean confereMedicamento(String med, Cliente c){
		int qt;
		for (Medicamentos m : medicamentos) {
			if(med.equalsIgnoreCase(m.getNome())){
				qt = Integer.parseInt(JOptionPane.showInputDialog("Quantos "+m.getNome()+" você deseja"));
				if (m.vender(c, qt))
					JOptionPane.showMessageDialog(null, "Produto vendido com sucesso");
				return true;	
			}	
		}
		return false;
	}
	
	public static boolean conferePerfumaria(String perf, Cliente c){
		int qt;
		for (Perfumaria p : perfumarias) {
			if(perf.equalsIgnoreCase(p.getNome())){
				qt = Integer.parseInt(JOptionPane.showInputDialog("Quantos "+p.getNome()+" você deseja"));
				if (p.vender(c, qt))
					JOptionPane.showMessageDialog(null, "Produto vendido com sucesso");
				return true;
				
			}
		}
		return false;
	}
	
	public static String listaClientes(){
		String ret = "Dados dos Clientes\n\n";
		for (Cliente c : clientes) {
			ret+= c.toString();
		}
		return ret;
	}
	
	public static String listaProdutos(){
		String produtos = "Lista dos Produtos\n\nMedicamentos\n";
		for (Medicamentos m : medicamentos) {
			produtos += m.toString();
		}
		produtos += "\nPerfumaria\n";
		for (Perfumaria p : perfumarias) {
			produtos += p.toString();
		}
		return produtos;
	}
	
}



