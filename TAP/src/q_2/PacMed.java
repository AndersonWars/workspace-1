package q_2;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PacMed extends Composite {
	private Text txtPac;
	private Table tabPac;
	private Text txtMed;
	private Table tabMed;
	private Text txtQtDiaria;
	
	ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
	ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	
	Medicamento mSel = new Medicamento();
	Paciente pSel = new Paciente();
	private Label lblInf;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public PacMed(Composite parent, int style) {
		super(parent, style);
		setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		
		Label lblPaciente = new Label(this, SWT.NONE);
		lblPaciente.setBounds(10, 10, 45, 15);
		lblPaciente.setText("Paciente");
		
		txtPac = new Text(this, SWT.BORDER);
		txtPac.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				preenchePaciente(txtPac.getText());
			}
		});
		txtPac.setBounds(90, 7, 204, 21);
		
		tabPac = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tabPac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				pSel = pacientes.get(tabPac.getSelectionIndex());
			}
		});
		tabPac.setBounds(10, 31, 430, 71);
		tabPac.setHeaderVisible(true);
		tabPac.setLinesVisible(true);
		
		TableColumn tblclmnCodigo = new TableColumn(tabPac, SWT.NONE);
		tblclmnCodigo.setWidth(121);
		tblclmnCodigo.setText("Codigo");
		
		TableColumn tblclmnMed = new TableColumn(tabPac, SWT.NONE);
		tblclmnMed.setWidth(148);
		tblclmnMed.setText("Medicamento");
		
		TableColumn tblclmnQtd = new TableColumn(tabPac, SWT.NONE);
		tblclmnQtd.setWidth(142);
		tblclmnQtd.setText("Quantidade");
		
		Label lblMedicamento = new Label(this, SWT.NONE);
		lblMedicamento.setBounds(10, 129, 74, 15);
		lblMedicamento.setText("Medicamento");
		
		txtMed = new Text(this, SWT.BORDER);
		txtMed.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				preencheMedicamento(txtMed.getText());
			}
		});
		txtMed.setBounds(90, 126, 204, 21);
		
		tabMed = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		tabMed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e){
				mSel = medicamentos.get(tabMed.getSelectionIndex());
				lblInf.setText(pSel.getNome()+" - "+mSel.getNome());
			}
		});
		tabMed.setBounds(10, 151, 430, 71);
		tabMed.setHeaderVisible(true);
		tabMed.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(tabMed, SWT.NONE);
		tblclmnNewColumn.setWidth(128);
		tblclmnNewColumn.setText("Codigo");
		
		TableColumn tblclmnValor = new TableColumn(tabMed, SWT.NONE);
		tblclmnValor.setWidth(150);
		tblclmnValor.setText("Paciente");
		
		TableColumn tblclmnQtCaixa = new TableColumn(tabMed, SWT.NONE);
		tblclmnQtCaixa.setWidth(110);
		tblclmnQtCaixa.setText("Quantidade");
		
		Label lblQtDiria = new Label(this, SWT.NONE);
		lblQtDiria.setBounds(10, 280, 55, 15);
		lblQtDiria.setText("Qt di\u00E1ria");
		
		txtQtDiaria = new Text(this, SWT.BORDER);
		txtQtDiaria.setBounds(71, 277, 85, 21);
		
		Button btnGravar = new Button(this, SWT.NONE);
		btnGravar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Prescricao p = new Prescricao();
				p.setPaciente(pSel);
				p.setMedicameneto(mSel);
				p.setQt(Integer.parseInt(txtQtDiaria.getText()));
				p.cadastra();
			}
		});
		btnGravar.setBounds(205, 275, 75, 25);
		btnGravar.setText("Gravar");
		
		lblInf = new Label(this, SWT.BORDER);
		lblInf.setAlignment(SWT.CENTER);
		lblInf.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblInf.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblInf.setBounds(10, 236, 419, 25);
		lblInf.setText("...");

	}
	
	private void preencheMedicamento(String filtro){
		tabMed.setItemCount(0);
		medicamentos = Medicamento.listaFiltro(filtro);
		for (Medicamento m: medicamentos){
			TableItem it= new TableItem(tabMed, SWT.NONE);
			it.setText(m.toArray());
		}
	}
	
	private void preenchePaciente(String filtro){
		tabPac.setItemCount(0);
		pacientes = Paciente.listaFiltro(filtro, 1);
		for (Paciente p: pacientes){
			TableItem it= new TableItem(tabPac, SWT.NONE);
			it.setText(p.toArray());
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
