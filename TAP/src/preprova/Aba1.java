package preprova;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class Aba1 extends Composite {
	private Text txtNome;
	private Text txtIdade;
	private Text txtFiltro;
	private Table table;
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Button btnMasculino;
	private Button btnFeminino;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Aba1(Composite parent, int style) {
		super(parent, style);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 10, 33, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.setBounds(49, 7, 160, 21);
		
		Label lblIdade = new Label(this, SWT.NONE);
		lblIdade.setBounds(10, 37, 33, 15);
		lblIdade.setText("Idade");
		
		txtIdade = new Text(this, SWT.BORDER);
		txtIdade.setBounds(49, 34, 64, 21);
		
		Group grpSexo = new Group(this, SWT.NONE);
		grpSexo.setText("Sexo");
		grpSexo.setBounds(10, 58, 89, 62);
		
		btnMasculino = new Button(grpSexo, SWT.RADIO);
		btnMasculino.setBounds(10, 21, 90, 16);
		btnMasculino.setText("Masculino");
		
		btnFeminino = new Button(grpSexo, SWT.RADIO);
		btnFeminino.setBounds(10, 43, 90, 16);
		btnFeminino.setText("Feminino");
		
		Label lblFiltro = new Label(this, SWT.NONE);
		lblFiltro.setBounds(10, 126, 33, 15);
		lblFiltro.setText("Filtro");
		
		txtFiltro = new Text(this, SWT.BORDER);
		txtFiltro.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				preencheTabela(txtFiltro.getText());
			}
		});
		txtFiltro.setBounds(49, 123, 155, 21);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 147, 430, 143);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(198);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnIdade = new TableColumn(table, SWT.NONE);
		tblclmnIdade.setWidth(90);
		tblclmnIdade.setText("Idade");
		
		TableColumn tblclmnSexo = new TableColumn(table, SWT.NONE);
		tblclmnSexo.setWidth(137);
		tblclmnSexo.setText("Sexo");
		
		Button btnAdicionar = new Button(this, SWT.NONE);
		btnAdicionar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pessoas.add(new Pessoa(txtNome.getText(), Integer.parseInt(txtIdade.getText()), btnMasculino.getSelection()==true?'M':'F'));
				limpaJanela();
				preencheTabela(null);
			}
		});
		btnAdicionar.setImage(SWTResourceManager.getImage(Aba1.class, "/imgs/add.png"));
		btnAdicionar.setBounds(134, 58, 95, 25);
		btnAdicionar.setText("Adicionar");

	}
	
	private void limpaJanela(){
		txtNome.setText("");
		txtIdade.setText("");
		btnMasculino.setSelection(true);
		btnFeminino.setSelection(false);
	}
	
	private void preencheTabela(String filtro){
		table.setItemCount(0);
		if(filtro==null){
			for (Pessoa p : pessoas) {
				TableItem it= new TableItem(table, SWT.NONE);
				it.setText(p.toArray());
			} 
		}else{
			ArrayList<Pessoa> temp = new ArrayList<Pessoa>();
			for (Pessoa p : pessoas) {
				if(p.getNome().startsWith(filtro))
					temp.add(p);
			}
			for (Pessoa p : temp) {
				TableItem it= new TableItem(table, SWT.NONE);
				it.setText(p.toArray());
			}
		}
	}


	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
