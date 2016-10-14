package q_2;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
//import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
//import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class CadMedicamento extends Composite {
	private Text txtNome;
	private Text txtValor;
	private Text txtQtd;
	private Table table;
	private ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CadMedicamento(Composite parent, int style) {
		super(parent, style);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 10, 33, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.setBounds(10, 26, 190, 21);
		
		Label lblValorCaixa = new Label(this, SWT.NONE);
		lblValorCaixa.setBounds(225, 10, 57, 15);
		lblValorCaixa.setText("Valor Caixa");
		
		txtValor = new Text(this, SWT.BORDER);
		txtValor.setBounds(225, 26, 106, 21);
		
		Label lblQtdadeCaixa = new Label(this, SWT.NONE);
		lblQtdadeCaixa.setBounds(10, 53, 70, 15);
		lblQtdadeCaixa.setText("Qtdade Caixa");
		
		txtQtd = new Text(this, SWT.BORDER);
		txtQtd.setBounds(10, 72, 83, 21);
		
		Button btnCadastrar = new Button(this, SWT.NONE);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Medicamento m = new Medicamento(txtNome.getText(), Integer.parseInt(txtQtd.getText()), Double.parseDouble(txtValor.getText()));
				if(m.cadastra()==1)
					mensagem("OK", "Cadastro feito");
				else
					mensagem("Falha", "Falha");
			}
		});
		btnCadastrar.setBounds(365, 72, 75, 25);
		btnCadastrar.setText("Cadastrar");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				medicamentos.remove(table.getSelectionIndex());
				
			}
		});
		table.setBounds(10, 99, 430, 191);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(140);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnValorCaixa = new TableColumn(table, SWT.NONE);
		tblclmnValorCaixa.setWidth(100);
		tblclmnValorCaixa.setText("Valor Caixa");
		
		TableColumn tblclmnQtdade = new TableColumn(table, SWT.NONE);
		tblclmnQtdade.setWidth(73);
		tblclmnQtdade.setText("Qtdade");
		
		TableColumn tblclmnValorUnidade = new TableColumn(table, SWT.NONE);
		tblclmnValorUnidade.setWidth(112);
		tblclmnValorUnidade.setText("Valor Unidade");

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
