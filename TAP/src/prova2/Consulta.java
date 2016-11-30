package prova2;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class Consulta extends Composite {
	private Table table;
	private ArrayList<String[]> lista;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Consulta(Composite parent, int style) {
		super(parent, style);
		
		Label lblConsultaVacinaAtrasadas = new Label(this, SWT.NONE);
		lblConsultaVacinaAtrasadas.setBounds(148, 10, 136, 15);
		lblConsultaVacinaAtrasadas.setText("Consulta vacina atrasadas");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 60, 430, 230);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnVacina = new TableColumn(table, SWT.NONE);
		tblclmnVacina.setWidth(215);
		tblclmnVacina.setText("Vacina");
		
		TableColumn tblclmnPessoa = new TableColumn(table, SWT.NONE);
		tblclmnPessoa.setWidth(195);
		tblclmnPessoa.setText("Pessoa");
		
		preencheTabela();

	}
	
	public void preencheTabela(){
		lista = Vacina.consulta();
		for (String[] s : lista) {
			TableItem tableItem= new TableItem(table, SWT.NONE);
			tableItem.setText(s);
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
