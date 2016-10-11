package swt;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class Janela4 extends Composite {
	private Text txtProd;
	private Text txtValor;
	private Text txtQt;
	private Table table;
	private Text txtTotal;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Janela4(Composite parent, int style) {
		super(parent, style);
		
		Label lblProduto = new Label(this, SWT.NONE);
		lblProduto.setBounds(10, 10, 69, 21);
		lblProduto.setText("Produto");
		
		txtProd = new Text(this, SWT.BORDER);
		txtProd.setBounds(85, 10, 210, 21);
		
		Label lblValor = new Label(this, SWT.NONE);
		lblValor.setBounds(10, 37, 38, 21);
		lblValor.setText("Valor");
		
		txtValor = new Text(this, SWT.BORDER);
		txtValor.setBounds(85, 37, 83, 21);
		
		Label lblQuantidade = new Label(this, SWT.NONE);
		lblQuantidade.setBounds(10, 64, 69, 21);
		lblQuantidade.setText("Quantidade");
		
		txtQt = new Text(this, SWT.BORDER);
		txtQt.setBounds(85, 64, 83, 21);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					produtos.add(new Produto(txtProd.getText(), Double.parseDouble(txtValor.getText()), Integer.parseInt(txtQt.getText())));
					limpaJanela();
					preencheTabela();
				}catch(NumberFormatException err){
					mensagem("Dados Inválidos", "Erro na inserção de dados numéricos");
				}catch(Exception err){
					mensagem("Erro desconhecido", "Contate o suporte");
				}
			}
			
		});
		//btnNewButton.setImage(SWTResourceManager.getImage(Janela4.class, "/imgs/add.png"));
		btnNewButton.setBounds(192, 54, 83, 25);
		btnNewButton.setText("Adicionar");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		
		table.setBounds(10, 91, 430, 167);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(120);
		tblclmnNewColumn.setText("Produto");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(64);
		tblclmnNewColumn_1.setText("Qt");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(82);
		tblclmnNewColumn_2.setText("Vl");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("Sub Total");
		
		Label lblTotal = new Label(this, SWT.NONE);
		lblTotal.setBounds(257, 267, 31, 21);
		lblTotal.setText("Total");
		
		txtTotal = new Text(this, SWT.BORDER);
		txtTotal.setText("");
		txtTotal.setBounds(296, 264, 144, 21);
		
		Button btnExcluir = new Button(this, SWT.NONE);
		btnExcluir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					produtos.remove(table.getSelectionIndex());
				}catch(Exception err){
					mensagem("Erro", "Selecione uma linha antes de excluir");
				}
				preencheTabela();
			}
		});
		btnExcluir.setText("Excluir");
		btnExcluir.setBounds(281, 54, 83, 25);

	}
	
	private void limpaJanela(){
		txtProd.setText("");
		txtQt.setText("");
		txtValor.setText("");
	}
	
	private void preencheTabela(){
		table.setItemCount(0);
		double total = 0;
		for (Produto p : produtos) {
			TableItem item= new TableItem(table, SWT.NONE);
			item.setText(p.toArray());
			total += p.getSubTotal();
		}
		txtTotal.setText(total+"");
	}
	
	private void mensagem(String titulo, String msg){
		MessageBox m = new MessageBox(getShell(), SWT.ICON_WARNING | SWT.OK | SWT.CANCEL);
		m.setText(titulo);
		m.setMessage(msg);
		m.open();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
