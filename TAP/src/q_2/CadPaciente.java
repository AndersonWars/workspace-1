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
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class CadPaciente extends Composite {
	private Text txtNome;
	private Text txtIdade;
	private Table table;
	private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	private Button btnMasculino;
	private Button btnFeminino;
	private Paciente pacSel;
	private Text txtFiltro;
	private Button btnComeaCom;
	private Button btnPossui;
	private Button btnTerminaCom;
	
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
				Paciente p = new Paciente(txtNome.getText(), Integer.parseInt(txtIdade.getText()), (btnMasculino.getSelection()?'M':'F'));
				if(p.cadastra()==1)
					mensagem("Feito", "Cadastro realizado com sucesso");
				else
					mensagem("Erro", "Cadastro não pode ser feito");
				limpaJanela();
				preencheTabela(false,0);
			}
		});
		btnCadastrar.setBounds(403, 10, 75, 25);
		btnCadastrar.setText("Cadastrar");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		
		table.setBounds(10, 178, 468, 182);
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
		
		Button btnAlterar = new Button(this, SWT.NONE);
		btnAlterar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pacSel.setNome(txtNome.getText());
				pacSel.setIdade(Integer.parseInt(txtIdade.getText()));
				pacSel.setSexo(btnMasculino.getSelection()?'M':'F');
				pacSel.altera();
				preencheTabela(false,0);
				limpaJanela();
			}
		});
		btnAlterar.setBounds(403, 41, 75, 25);
		btnAlterar.setText("Alterar");
		
		Button btnExcluir = new Button(this, SWT.NONE);
		btnExcluir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pacSel.exclui();
				preencheTabela(false, 0);
				btnExcluir.setEnabled(false);
				btnAlterar.setEnabled(false);
			}
		});
		btnExcluir.setBounds(403, 72, 75, 25);
		btnExcluir.setText("Excluir");
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				pacSel = pacientes.get(table.getSelectionIndex());
				txtNome.setText(pacSel.getNome());
				txtIdade.setText(pacSel.getIdade()+"");
				if(pacSel.getSexo()=='M'){
					btnMasculino.setSelection(true);
					btnFeminino.setSelection(false);
				}else{
					btnFeminino.setSelection(true);
					btnMasculino.setSelection(false);
				}
				btnAlterar.setEnabled(true);
				btnExcluir.setEnabled(true);
			}
		});
		
		txtFiltro = new Text(this, SWT.BORDER);
		txtFiltro.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				int op;
				if(btnComeaCom.getSelection())
					op=1;
				else if(btnPossui.getSelection())
					op=2;
				else
					op=3;
				preencheTabela(true, op);
			}
		});
		txtFiltro.setBounds(10, 151, 468, 21);
		
		Group grpFiltro = new Group(this, SWT.NONE);
		grpFiltro.setText("Filtro");
		grpFiltro.setBounds(10, 101, 359, 44);
		
		btnComeaCom = new Button(grpFiltro, SWT.RADIO);
		btnComeaCom.setSelection(true);
		btnComeaCom.setBounds(10, 21, 90, 16);
		btnComeaCom.setText("Come\u00E7a com:");
		
		btnPossui = new Button(grpFiltro, SWT.RADIO);
		btnPossui.setBounds(132, 21, 90, 16);
		btnPossui.setText("Possui:");
		
		btnTerminaCom = new Button(grpFiltro, SWT.RADIO);
		btnTerminaCom.setBounds(259, 21, 90, 16);
		btnTerminaCom.setText("Termina com:");
		
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
		preencheTabela(false,0);
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
	
	private void preencheTabela(boolean filtro, int op){
		table.setItemCount(0);
		if(filtro)
			pacientes = Paciente.listaFiltro(txtFiltro.getText(), op);
		else
			pacientes = Paciente.listaTudo();
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
