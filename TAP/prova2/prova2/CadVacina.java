package prova2;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class CadVacina extends Composite {
	private Text txtNome;
	private Text txtIdadeN;
	private Text txtIdadeA;
	private Table table;
	protected ArrayList<Pessoa> pessoas;
	private Combo combo;
	private ArrayList<Vacina> vacinas;
	private Vacina vSel;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CadVacina(Composite parent, int style) {
		super(parent, style);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 10, 33, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.setBounds(49, 10, 255, 21);
		
		Label lblIdade = new Label(this, SWT.NONE);
		lblIdade.setBounds(7, 40, 70, 15);
		lblIdade.setText("Idade normal\r\n");
		
		txtIdadeN = new Text(this, SWT.BORDER);
		txtIdadeN.setBounds(86, 37, 76, 21);
		
		Label lblIdadeAplicada = new Label(this, SWT.NONE);
		lblIdadeAplicada.setBounds(7, 67, 83, 15);
		lblIdadeAplicada.setText("Idade Aplicada");
		
		txtIdadeA = new Text(this, SWT.BORDER);
		txtIdadeA.setBounds(96, 64, 70, 21);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				vSel = vacinas.get(table.getSelectionIndex());
				txtNome.setText(vSel.getNome());
				txtIdadeN.setText(vSel.getIdadeNormal()+"");
				txtIdadeA.setText(vSel.getIdadeApl()+"");
			}
		});
		table.setBounds(10, 132, 430, 158);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNomeVacina = new TableColumn(table, SWT.NONE);
		tblclmnNomeVacina.setWidth(89);
		tblclmnNomeVacina.setText("Nome Vacina");
		
		TableColumn tblclmnPessoa = new TableColumn(table, SWT.NONE);
		tblclmnPessoa.setWidth(100);
		tblclmnPessoa.setText("Pessoa");
		
		TableColumn tblclmnIdNormal = new TableColumn(table, SWT.NONE);
		tblclmnIdNormal.setWidth(69);
		tblclmnIdNormal.setText("Id Normal");
		
		TableColumn tblclmnIdApl = new TableColumn(table, SWT.NONE);
		tblclmnIdApl.setWidth(94);
		tblclmnIdApl.setText("Id Apl");
		
		Button btnCadastra = new Button(this, SWT.NONE);
		btnCadastra.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Vacina v = new Vacina(txtNome.getText(), Integer.parseInt(txtIdadeN.getText()), Integer.parseInt(txtIdadeA.getText()));
				v.setIdPaciente(pessoas.get(combo.getSelectionIndex()).getId());
				v.cadastra();
				preencheTabela();
				preencheCombo();
			}
		});
		btnCadastra.setBounds(2, 101, 75, 25);
		btnCadastra.setText("Cadastra");
		
		Button btnAltera = new Button(this, SWT.NONE);
		btnAltera.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				vSel.setNome(txtNome.getText());
				vSel.setIdadeNormal(Integer.parseInt(txtIdadeN.getText()));
				vSel.setIdadeApl(Integer.parseInt(txtIdadeA.getText()));
				vSel.setIdPaciente(pessoas.get(combo.getSelectionIndex()).getId());
				preencheTabela();
				preencheCombo();
			}
		});
		btnAltera.setBounds(87, 101, 75, 25);
		btnAltera.setText("Altera");
		
		Button btnExclui = new Button(this, SWT.NONE);
		btnExclui.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				vSel.exclui();
				preencheTabela();
				preencheCombo();
			}
		});
		btnExclui.setBounds(178, 101, 75, 25);
		btnExclui.setText("Exclui");
		
		Label lblPessoa = new Label(this, SWT.NONE);
		lblPessoa.setBounds(196, 40, 41, 15);
		lblPessoa.setText("Pessoa");
		
		combo = new Combo(this, SWT.NONE);
		combo.setBounds(243, 37, 170, 23);
		
		preencheCombo();
		preencheTabela();

	}
	
	private void preencheCombo(){
		pessoas = Pessoa.listaTudo();
		for (Pessoa p : pessoas) {
			combo.add(p.getNome());
		}
	}
	
	private void preencheTabela(){
		table.setItemCount(0);
		vacinas = Vacina.listaTudo();
		for (Vacina v : vacinas) {
			TableItem item= new TableItem(table, SWT.NONE);
			item.setText(v.toArray());
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
