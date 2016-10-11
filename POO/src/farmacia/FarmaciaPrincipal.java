package farmacia;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FarmaciaPrincipal {
	public static ArrayList<Produto> Produtos = new ArrayList<Produto>();
	public static ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
	
	public static int menu(){
		String menu = "1 - Cadastrar Cliente\n"
				+"2 - Cadastrar Medicamentos\n"
				+"3 - Cadastrar Perfumaria\n"
				+"4 - Cadastrar Equipamentos Hospitalares\n"
				+"5 - Vender produto\n"
				+"6 - Relatório de Produtos\n"
				+"7 - Relatório de Clientes\n"
				+"8 - Sair\n";
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return op;
	}
	
	public static void main(String[] args) {
		int op = 0;
		do{
			op = menu();
			switch (op){
			case 1:
				Clientes.add(new Cliente());
				break;
			case 2:
				Produtos.add(new Medicametos());
				break;
			case 3:
				Produtos.add(new Perfumaria());
				break;
			case 4:
				Produtos.add(new Hospitalares());
				break;
			case 5:
				vender();
				break;
			case 6:
				relataProdutos();;
				break;
			case 7:
				relataClientes();
				break;
			
			}
		}while (op != 8);
	}
	
	public static Cliente selecionaCliente(){
		int op = 1;
		String comprador = "Selecione o cliente\n\n";
		for (Cliente c : Clientes) {
			comprador += op+" - "+c+"\n";
			op++;
		}
		return Clientes.get(Integer.parseInt(JOptionPane.showInputDialog(comprador))-1);
	}
	
	public static void vender(){
		Cliente c = selecionaCliente();
		String prod = JOptionPane.showInputDialog("Que produto será vendido"), resp = "";
		for (Produto p : Produtos) {
			if (prod.equalsIgnoreCase(p.getNome())){
				if (p.venda(Integer.parseInt(JOptionPane.showInputDialog("Quantas unidades de "+p.getNome()+" será vendido")), c))
					resp = "Venda realizada com sucesso";
				else 
					resp = "Não foi possível realizar a venda";
				break;
			}
		}
		if (resp.equals(""))
			resp = "Produto não encontrado";
		JOptionPane.showMessageDialog(null, resp);
	}
	
	public static void relataClientes(){
		String lista = "Relatório de Clientes\n\n";
		for (Cliente c : Clientes) 
			lista += c+"\n";
		JOptionPane.showMessageDialog(null, lista);
	}
	
	public static void relataProdutos(){
		String listaPrinc = "Relatório de Produtos\n\n", listaM = "", listaP = "", listaH = "";
		for (Produto p : Produtos){
			if (p instanceof Medicametos)
				listaM += p+"\n";
			else if (p instanceof Perfumaria)
				listaP += p+"\n";
			else
				listaH += p+"\n";
		}
		listaPrinc += "Medicamentos\n\n"+listaM+"\nPerfumaria\n\n"+listaP+"\nEquipamentos Hospitalares\n\n"+listaH;
		JOptionPane.showMessageDialog(null, listaPrinc);
	}
}