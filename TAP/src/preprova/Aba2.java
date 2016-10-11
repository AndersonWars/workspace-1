package preprova;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Aba2 extends Composite {
	private Text txtProduto;
	private Text txtQt;
	private Text txtPreco;
	private Table table;
	private Text txtTotal;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Aba2(Composite parent, int style) {
		super(parent, style);
		
		Label lblProduto = new Label(this, SWT.NONE);
		lblProduto.setBounds(10, 10, 43, 15);
		lblProduto.setText("Produto");
		
		txtProduto = new Text(this, SWT.BORDER);
		txtProduto.setBounds(59, 7, 150, 21);
		
		Label lblQuantd = new Label(this, SWT.NONE);
		lblQuantd.setBounds(10, 34, 43, 15);
		lblQuantd.setText("Quantd");
		
		txtQt = new Text(this, SWT.BORDER);
		txtQt.setBounds(59, 31, 76, 21);
		
		Label lblPreo = new Label(this, SWT.NONE);
		lblPreo.setBounds(10, 58, 43, 15);
		lblPreo.setText("Pre\u00E7o");
		
		txtPreco = new Text(this, SWT.BORDER);
		txtPreco.setBounds(59, 55, 76, 21);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 87, 430, 179);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnProduto = new TableColumn(table, SWT.NONE);
		tblclmnProduto.setWidth(125);
		tblclmnProduto.setText("Produto");
		
		TableColumn tblclmnQuantd = new TableColumn(table, SWT.NONE);
		tblclmnQuantd.setWidth(100);
		tblclmnQuantd.setText("Quantd");
		
		TableColumn tblclmnPreo = new TableColumn(table, SWT.NONE);
		tblclmnPreo.setWidth(100);
		tblclmnPreo.setText("Pre\u00E7o");
		
		TableColumn tblclmnSubtotal = new TableColumn(table, SWT.NONE);
		tblclmnSubtotal.setWidth(100);
		tblclmnSubtotal.setText("Subtotal");
		
		Label lblTotal = new Label(this, SWT.NONE);
		lblTotal.setBounds(276, 275, 26, 15);
		lblTotal.setText("Total");
		
		txtTotal = new Text(this, SWT.BORDER);
		txtTotal.setEditable(false);
		txtTotal.setBounds(313, 272, 76, 21);
		
		Button btnAdicionar = new Button(this, SWT.NONE);
		btnAdicionar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					produtos.add(new Produto(txtProduto.getText(), Integer.parseInt(txtQt.getText()), Double.parseDouble(txtPreco.getText())));
				}catch(NumberFormatException err){
					mensagem("Erro", "Confira dados numéricos");
				}catch(Exception err){
					mensagem("Erro desconhecido", "Contate o suporte");
				}
				limpaJanela();
				preencheTabela();
			}
		});
		btnAdicionar.setBounds(302, 24, 75, 25);
		btnAdicionar.setText("Adicionar");
		
		Button btnExcluir = new Button(this, SWT.NONE);
		btnExcluir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					produtos.remove(table.getSelectionIndex());
					preencheTabela();
				}catch(Exception err){
					mensagem("Erro", "Selecione um produto na tabela antes de excluir");
				}
			}
		});
		btnExcluir.setText("Excluir");
		btnExcluir.setBounds(302, 51, 75, 25);

	}
	
	private void limpaJanela(){
		txtProduto.setText("");
		txtQt.setText("");
		txtPreco.setText("");
	}
	
	private void preencheTabela(){
		table.setItemCount(0);
		double total = 0;
		for (Produto p : produtos) {
			TableItem it= new TableItem(table, SWT.NONE);
			it.setText(p.toArray());
			total += p.getSubtotal();
		}
		txtTotal.setText(total+"");
	}
	
	private void mensagem(String titulo, String msg){
		MessageBox m = new MessageBox(getShell());
		m.setText(titulo);
		m.setMessage(msg);
		m.open();
	}
	

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
