package banco_de_dados;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Principal extends Shell {
	private Text txtNome;
	private Text txtIdade;
	private Table table;
	public static Connection conn = Conexao.conn();
	private Button btnFeminino;
	private Button btnMasculino;
	private ArrayList<Pessoa> pessoas = new ArrayList<>();
	private Pessoa pSel;
	private Text txtFiltro;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Principal shell = new Principal(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Principal(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 40, 33, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.setBounds(49, 37, 190, 21);
		
		Label lblIdade = new Label(this, SWT.NONE);
		lblIdade.setBounds(10, 67, 33, 15);
		lblIdade.setText("Idade");
		
		txtIdade = new Text(this, SWT.BORDER);
		txtIdade.setBounds(49, 64, 76, 21);
		
		Group grpSexo = new Group(this, SWT.NONE);
		grpSexo.setText("Sexo");
		grpSexo.setBounds(10, 88, 229, 48);
		
		btnMasculino = new Button(grpSexo, SWT.RADIO);
		btnMasculino.setBounds(10, 22, 90, 16);
		btnMasculino.setText("Masculino");
		
		btnFeminino = new Button(grpSexo, SWT.RADIO);
		btnFeminino.setText("Feminino");
		btnFeminino.setBounds(129, 22, 90, 16);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				try{
					pSel = pessoas.get(table.getSelectionIndex());
					txtNome.setText(pSel.getNome());
					txtIdade.setText(pSel.getIdade()+"");
					if(pSel.getSexo()=='M'){
						btnMasculino.setSelection(true);
						btnFeminino.setSelection(false);
					}else{
						btnMasculino.setSelection(false);
						btnFeminino.setSelection(true);
					}
				}catch(Exception err){
					MessageBox msg = new MessageBox(getShell());
					msg.setText("Erro");
					msg.setText("Seleção inválida");
					msg.open();
				}
			}
		});
		table.setBounds(0, 174, 484, 187);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(249);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnIdade = new TableColumn(table, SWT.NONE);
		tblclmnIdade.setWidth(100);
		tblclmnIdade.setText("Idade");
		
		TableColumn tblclmnSexo = new TableColumn(table, SWT.NONE);
		tblclmnSexo.setWidth(78);
		tblclmnSexo.setText("Sexo");
		
		Button btnCadastrar = new Button(this, SWT.NONE);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int feito=0;
				try{
					Pessoa p = new Pessoa(txtNome.getText(), Integer.parseInt(txtIdade.getText()), btnMasculino.getSelection()?'M':'F');
					feito = p.cadastra();
				}catch(NumberFormatException err){
					MessageBox m = new MessageBox(getShell());
					m.setText("Erro");
					m.setMessage("Confira a idade inserida");
					m.open();
				}catch(NullPointerException err){
					MessageBox m = new MessageBox(getShell());
					m.setText("Erro");
					m.setMessage("Confira o nome inserido");
					m.open();
				}catch(Exception err){
					MessageBox m = new MessageBox(getShell());
					m.setText("Erro");
					m.setMessage("Erro desconhecido");
					m.open();
				}
				if(feito>0){
					MessageBox m = new MessageBox(getShell());
					m.setText("OK");
					m.setMessage("Cadastro realizado com sucesso");
					m.open();
				}
				preencheTabela(false);
				limpaJanela();
			}
		});
		btnCadastrar.setBounds(281, 30, 75, 25);
		btnCadastrar.setText("Cadastrar");
		
		Button btnAlterar = new Button(this, SWT.NONE);
		btnAlterar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pSel.setNome(txtNome.getText());
				pSel.setIdade(Integer.parseInt(txtIdade.getText()));
				pSel.setSexo(btnMasculino.getSelection()?'M':'F');
				pSel.altera();
				preencheTabela(false);
				limpaJanela();
			}
		});
		btnAlterar.setBounds(281, 57, 75, 25);
		btnAlterar.setText("Alterar");
		
		Button btnExcluir = new Button(this, SWT.NONE);
		btnExcluir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pSel.deleta();
				preencheTabela(false);
			}
		});
		btnExcluir.setBounds(281, 84, 75, 25);
		btnExcluir.setText("Excluir");
		
		txtFiltro = new Text(this, SWT.BORDER);
		txtFiltro.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				//if (txtFiltro.getText()!=null)
					preencheTabela(true);
			}
		});
		txtFiltro.setBounds(10, 142, 286, 21);
		
		Button btnExptxt = new Button(this, SWT.NONE);
		btnExptxt.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String linha;
				try{
					FileWriter fw = new FileWriter("pessoas.txt", false);
					BufferedWriter bw = new BufferedWriter(fw);
					for (Pessoa p : pessoas) {
						linha = p.getNome()+","+p.getIdade()+","+p.getSexo()+"\n";
						bw.append(linha);
					}
					bw.close();
					fw.close();
				}catch(IOException err){
					err.printStackTrace();
				}finally {
					MessageBox msg = new MessageBox(getShell());
					msg.setText("OK");
					msg.setMessage("Exportado com sucesso");
					msg.open();
				}
			}
		});
		btnExptxt.setBounds(379, 30, 75, 25);
		btnExptxt.setText("Exp. .txt");
		
		preencheTabela(false);
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(500, 400);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private void limpaJanela(){
		txtNome.setText("");
		txtIdade.setText("");
		btnMasculino.setSelection(false);
		btnFeminino.setSelection(false);
	}
	
	private void preencheTabela(boolean filtro){
		table.setItemCount(0);
		if(filtro){
			pessoas = Pessoa.listaFiltro(txtFiltro.getText());	
		}else{
			pessoas = Pessoa.listarTudo();
		}
		for (Pessoa p : pessoas) {
			TableItem item= new TableItem(table, SWT.NONE);
			item.setText(p.toArray());
			}
		}
	}
