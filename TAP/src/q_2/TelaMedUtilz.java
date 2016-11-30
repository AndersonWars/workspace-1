package q_2;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TelaMedUtilz extends Composite {
	private Table table;
	private Text text;
	private ArrayList<Paciente> pacientes = new ArrayList<>();
	private Combo combo;
	public static ArrayList<Prescricao> presc;
	private Text txtPar;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TelaMedUtilz(Composite parent, int style) {
		super(parent, style);
		
		Label lblMedicamentosUtilizados = new Label(this, SWT.NONE);
		lblMedicamentosUtilizados.setBounds(10, 10, 150, 15);
		lblMedicamentosUtilizados.setText("Medicamentos Utilizados:");
		
		Label lblPaciente = new Label(this, SWT.NONE);
		lblPaciente.setBounds(10, 34, 55, 15);
		lblPaciente.setText("Paciente");
		
		combo = new Combo(this, SWT.NONE);
		combo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				if(combo.getSelectionIndex()>=0){
					preencheTabela();
				}
			}
		});
		combo.setBounds(71, 31, 168, 23);
		
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 66, 430, 184);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnMedicamento = new TableColumn(table, SWT.NONE);
		tblclmnMedicamento.setWidth(112);
		tblclmnMedicamento.setText("Medicamento");
		
		TableColumn tblclmnValor = new TableColumn(table, SWT.NONE);
		tblclmnValor.setWidth(66);
		tblclmnValor.setText("Valor");
		
		TableColumn tblclmnQtade = new TableColumn(table, SWT.NONE);
		tblclmnQtade.setWidth(85);
		tblclmnQtade.setText("Qtade caixa");
		
		TableColumn tblclmnQtadeUtilz = new TableColumn(table, SWT.NONE);
		tblclmnQtadeUtilz.setWidth(74);
		tblclmnQtadeUtilz.setText("Qtade utilz.");
		
		TableColumn tblclmnValorUn = new TableColumn(table, SWT.NONE);
		tblclmnValorUn.setWidth(88);
		tblclmnValorUn.setText("Valor un.");
		
		Label lblValorTotalGasto = new Label(this, SWT.NONE);
		lblValorTotalGasto.setBounds(10, 256, 125, 35);
		lblValorTotalGasto.setText("Gasto di\u00E1rio com \r\nmedicamentos");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(139, 256, 100, 21);
		
		Button btnReletrio = new Button(this, SWT.NONE);
		btnReletrio.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				JasperPrint impressao;
				try{
					JRDataSource dsComponente = new JRBeanCollectionDataSource(presc);
					impressao = JasperFillManager.fillReport("relatorios/medPac.jasper", null, dsComponente);
					JasperViewer.viewReport(impressao, false);
				}catch(Exception err){
					err.printStackTrace();
				}
			}
		});
		btnReletrio.setBounds(345, 256, 75, 25);
		btnReletrio.setText("Relet\u00F3rio");
		
		txtPar = new Text(this, SWT.BORDER);
		txtPar.setBounds(10, 297, 160, 21);
		
		Button btnGeraRel = new Button(this, SWT.NONE);
		btnGeraRel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				JasperPrint impressao;
				try{
					Map<String, Object> pars = new HashMap<String, Object>();
					pars.put("PAR1", txtPar.getText());
					impressao = JasperFillManager.fillReport("relatorios/testePar.jasper", pars);
					JasperViewer.viewReport(impressao, false);
				}catch(Exception err){
					err.printStackTrace();
				}
			}
		});
		btnGeraRel.setBounds(210, 297, 75, 25);
		btnGeraRel.setText("Gera rel");
		
		preencheCombo();

	}
	
	private void preencheTabela(){
		table.setItemCount(0);
		presc = Prescricao.buscaPorPaciente((pacientes.get(combo.getSelectionIndex())));
		for (Prescricao x : presc) {
			TableItem tableItem= new TableItem(table, SWT.NONE);
			tableItem.setText(x.colunasCon1());
		}
	}
	
	private void preencheCombo(){
		pacientes = Paciente.listaTudo();
		for (Paciente p : pacientes) {
			combo.add(p.getNome());
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
