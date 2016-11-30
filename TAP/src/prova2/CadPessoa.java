package prova2;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;


import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class CadPessoa extends Composite {
	private Text txtNome;
	private Text txtIdade;
	private Table table;
	private ArrayList<Pessoa> lista;
	private Pessoa pSel;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CadPessoa(Composite parent, int style) {
		super(parent, style);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 10, 38, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.setBounds(54, 7, 257, 21);
		
		Label lblIdadeemMeses = new Label(this, SWT.NONE);
		lblIdadeemMeses.setBounds(10, 38, 99, 15);
		lblIdadeemMeses.setText("Idade (em meses)");
		
		txtIdade = new Text(this, SWT.BORDER);
		txtIdade.setBounds(111, 37, 76, 21);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				pSel = lista.get(table.getSelectionIndex());
				txtNome.setText(pSel.getNome());
				txtIdade.setText(pSel.getIdade()+"");
			}
		});
		table.setBounds(10, 99, 430, 191);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(272);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnIdade = new TableColumn(table, SWT.NONE);
		tblclmnIdade.setWidth(100);
		tblclmnIdade.setText("Idade");
		
		Button btnNovo = new Button(this, SWT.NONE);
		btnNovo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Pessoa p = new Pessoa(txtNome.getText(), Integer.parseInt(txtIdade.getText()));
				p.cadastra();
				preencheTabela();
				limpaJanela();
			}
		});
		btnNovo.setBounds(10, 68, 75, 25);
		btnNovo.setText("Cadastra");
		
		Button btnAltera = new Button(this, SWT.NONE);
		btnAltera.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pSel.setNome(txtNome.getText());
				pSel.setIdade(Integer.parseInt(txtIdade.getText()));
				pSel.altera();
				preencheTabela();
				limpaJanela();
			}
		});
		btnAltera.setBounds(101, 68, 75, 25);
		btnAltera.setText("Altera");
		
		Button btnExclui = new Button(this, SWT.NONE);
		btnExclui.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pSel.exclui();
				preencheTabela();
				limpaJanela();
			}
		});
		btnExclui.setBounds(193, 68, 75, 25);
		btnExclui.setText("Exclui");
		
		preencheTabela();

	}
	
	private void limpaJanela(){
		txtNome.setText("");
		txtIdade.setText("");
	}
	
	private void preencheTabela(){
		table.setItemCount(0);
		lista = Pessoa.listaTudo();
		for (Pessoa p : lista) {
			TableItem item= new TableItem(table, SWT.NONE);
			item.setText(p.toArray());
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
