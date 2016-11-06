package q_2;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class TelaConsulta2 extends Composite {
	private Combo combo;
	private Table table;
	ArrayList<Medicamento> medicamentos = new ArrayList<>();

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TelaConsulta2(Composite parent, int style) {
		super(parent, style);
		
		Label lblMedicamento = new Label(this, SWT.NONE);
		lblMedicamento.setBounds(13, 37, 74, 15);
		lblMedicamento.setText("Medicamento");
		
		combo = new Combo(this, SWT.NONE);
		combo.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent arg0) {
				table.setItemCount(0);
				int index = combo.getSelectionIndex();
				if(index>=0){
					ArrayList<Prescricao> lista = Prescricao.buscaPorMedicamento(medicamentos.get(index));
					for (Prescricao p : lista) {
						TableItem it= new TableItem(table, SWT.NONE);
						it.setText(p.colunasCon2());
					}
				}
			}
		});
		combo.setBounds(93, 34, 190, 23);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 63, 430, 182);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnPaciente = new TableColumn(table, SWT.NONE);
		tblclmnPaciente.setWidth(183);
		tblclmnPaciente.setText("Paciente");
		
		TableColumn tblclmnIdade = new TableColumn(table, SWT.NONE);
		tblclmnIdade.setWidth(57);
		tblclmnIdade.setText("Idade");
		
		TableColumn tblclmnSexo = new TableColumn(table, SWT.NONE);
		tblclmnSexo.setWidth(108);
		tblclmnSexo.setText("Sexo");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(73);
		tblclmnNewColumn.setText("Qt di\u00E1ria");
		
		Label lblPacientesQueConsomem = new Label(this, SWT.NONE);
		lblPacientesQueConsomem.setBounds(13, 10, 291, 15);
		lblPacientesQueConsomem.setText("Pacientes que consomem determinado medicamento");
		
		preencheCombo();

	}
	
	private void preencheCombo(){
		medicamentos = Medicamento.listaTodos();
		for (Medicamento m : medicamentos) {
			combo.add(m.getNome());
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
