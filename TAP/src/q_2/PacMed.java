package q_2;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;

public class PacMed extends Composite {
	private Text text;
	private Table table;
	private Text text_1;
	private Table table_1;
	private Text text_2;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public PacMed(Composite parent, int style) {
		super(parent, style);
		
		Label lblPaciente = new Label(this, SWT.NONE);
		lblPaciente.setBounds(10, 10, 45, 15);
		lblPaciente.setText("Paciente");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(90, 7, 204, 21);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 31, 430, 71);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(167);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnSexo = new TableColumn(table, SWT.NONE);
		tblclmnSexo.setWidth(101);
		tblclmnSexo.setText("Sexo");
		
		TableColumn tblclmnIdade = new TableColumn(table, SWT.NONE);
		tblclmnIdade.setWidth(142);
		tblclmnIdade.setText("Idade");
		
		Label lblMedicamento = new Label(this, SWT.NONE);
		lblMedicamento.setBounds(10, 129, 74, 15);
		lblMedicamento.setText("Medicamento");
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setBounds(90, 126, 204, 21);
		
		table_1 = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(10, 151, 430, 71);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn.setWidth(176);
		tblclmnNewColumn.setText("Nome");
		
		TableColumn tblclmnValor = new TableColumn(table_1, SWT.NONE);
		tblclmnValor.setWidth(133);
		tblclmnValor.setText("Valor");
		
		TableColumn tblclmnQtCaixa = new TableColumn(table_1, SWT.NONE);
		tblclmnQtCaixa.setWidth(110);
		tblclmnQtCaixa.setText("Qt caixa");
		
		Label lblQtDiria = new Label(this, SWT.NONE);
		lblQtDiria.setBounds(10, 241, 55, 15);
		lblQtDiria.setText("Qt di\u00E1ria");
		
		text_2 = new Text(this, SWT.BORDER);
		text_2.setBounds(71, 238, 85, 21);
		
		Button btnGravar = new Button(this, SWT.NONE);
		btnGravar.setBounds(205, 236, 75, 25);
		btnGravar.setText("Gravar");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
