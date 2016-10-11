package q_2;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class CadPaciente extends Composite {
	private Text txtNome;
	private Text txtIdade;
	private Table table;
	private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	private Button btnMasculino;
	private Button btnFeminino;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CadPaciente(Composite parent, int style) {
		super(parent, style);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 10, 55, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.setBounds(10, 31, 201, 21);
		
		Label lblIdade = new Label(this, SWT.NONE);
		lblIdade.setBounds(225, 10, 55, 15);
		lblIdade.setText("Idade");
		
		txtIdade = new Text(this, SWT.BORDER);
		txtIdade.setBounds(225, 31, 116, 21);
		
		Group grpSexo = new Group(this, SWT.NONE);
		grpSexo.setText("Sexo");
		grpSexo.setBounds(10, 58, 323, 44);
		
		btnMasculino = new Button(grpSexo, SWT.RADIO);
		btnMasculino.setSelection(true);
		btnMasculino.setBounds(10, 20, 90, 16);
		btnMasculino.setText("Masculino");
		
		btnFeminino = new Button(grpSexo, SWT.RADIO);
		btnFeminino.setBounds(223, 20, 90, 16);
		btnFeminino.setText("Feminino");
		
		Button btnCadastrar = new Button(this, SWT.NONE);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e){
				try{
					pacientes.add(new Paciente(txtNome.getText(), Integer.parseInt(txtIdade.getText()), btnMasculino.getSelection()==true?'M':'F'));
				}catch(NumberFormatException err){
					mensagem("Erro", "Confira sua idade");
				}
				preencheTabela();
				limpaJanela();
			}
		});
		btnCadastrar.setBounds(387, 77, 75, 25);
		btnCadastrar.setText("Cadastrar");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				pacientes.remove(table.getSelectionIndex());
				preencheTabela();
			}
		});
		table.setBounds(10, 108, 452, 182);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(235);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnIdade = new TableColumn(table, SWT.NONE);
		tblclmnIdade.setWidth(63);
		tblclmnIdade.setText("Idade");
		
		TableColumn tblclmnSexo = new TableColumn(table, SWT.NONE);
		tblclmnSexo.setWidth(110);
		tblclmnSexo.setText("Sexo");

	}
	
	private void mensagem(String titulo, String msg){
		MessageBox m = new MessageBox(getShell());
		m.setText(titulo);
		m.setMessage(msg);
		m.open();
	}
	
	private void limpaJanela(){
		txtNome.setText("");
		txtIdade.setText("");
		btnMasculino.setSelection(true);
		btnFeminino.setSelection(false);
	}
	
	private void preencheTabela(){
		table.setItemCount(0);
		for (Paciente p : pacientes) {
			TableItem it= new TableItem(table, SWT.NONE);
			it.setText(p.toArray());
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
