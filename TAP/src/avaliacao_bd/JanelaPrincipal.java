package avaliacao_bd;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class JanelaPrincipal extends Shell {
	private Text txtModelo;
	private Text txtAno;
	private Text txtValor;
	private Text txtOutro;
	private Table table;
	private Text txtTodo;
	public static Connection conn = Conexao.conn();
	private ArrayList<Carro> carros = new ArrayList<Carro>();
	private Button btnArCondicionado;
	private Button btnDireoElrtrica;
	private Button btnPilotoAutomtico;
	private Button btnAbs;
	private Button btnOutro;
	private Combo combo;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			JanelaPrincipal shell = new JanelaPrincipal(display);
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
	public JanelaPrincipal(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label lblMarca = new Label(this, SWT.NONE);
		lblMarca.setBounds(10, 30, 39, 15);
		lblMarca.setText("Marca");
		
		combo = new Combo(this, SWT.NONE);
		combo.setItems(new String[] {"Fiat", "Chevrolet", "Ford", "Honda", "Hyundai", "Mercedes"});
		combo.setBounds(64, 27, 173, 23);
		combo.select(0);
		
		Label lblModelo = new Label(this, SWT.NONE);
		lblModelo.setBounds(10, 59, 48, 15);
		lblModelo.setText("Modelo");
		
		txtModelo = new Text(this, SWT.BORDER);
		txtModelo.setBounds(64, 56, 173, 21);
		
		Label lblAno = new Label(this, SWT.NONE);
		lblAno.setBounds(10, 86, 30, 15);
		lblAno.setText("Ano");
		
		txtAno = new Text(this, SWT.BORDER);
		txtAno.setBounds(64, 83, 173, 21);
		
		Label lblValor = new Label(this, SWT.NONE);
		lblValor.setBounds(10, 113, 39, 15);
		lblValor.setText("Valor");
		
		txtValor = new Text(this, SWT.BORDER);
		txtValor.setBounds(64, 110, 173, 21);
		
		Button btnCadastrar = new Button(this, SWT.NONE);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Carro c=null;
				try{
				c = new Carro(combo.getText(), txtModelo.getText(), Integer.parseInt(txtAno.getText()), Double.parseDouble(txtValor.getText()), 
						(btnArCondicionado.getSelection()?'S':'N'), (btnDireoElrtrica.getSelection()?'S':'N'), (btnPilotoAutomtico.getSelection()?'S':'N'), 
						(btnAbs.getSelection()?'S':'N'));
				c.setOutro(txtOutro.getText());
				if(btnOutro.getSelection()){
					if(txtOutro.getText().isEmpty() ||txtOutro.getText().startsWith(" ")){
						mensagem("Erro", "Campo outro vazio.\nFavor preencher ou desmarcar caixa outro");
					}else{
						int feito = c.cadastra();
						if(feito>0){
							mensagem("OK", "Cadastro concluido");
							preencheTabela();
							limpaJanela();
						}
					}
				}else{
					int feito = c.cadastra();
					if(feito>0){
						mensagem("OK", "Cadastro concluido");
						preencheTabela();
						limpaJanela();
					}
				}
				}catch(Exception err){
					mensagem("Erro", "Confira se todos os campos obrigatórios foram inseridos corretamente");
				}
			}
		});
		btnCadastrar.setBounds(10, 150, 75, 25);
		btnCadastrar.setText("Cadastrar");
		
		Button btnExportarParaArquivo = new Button(this, SWT.NONE);
		btnExportarParaArquivo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DecimalFormat df = new DecimalFormat("##.00");
				try {
					FileWriter fw = new FileWriter("carros.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					for (Carro c : carros) {
						bw.append(c.getId()+","+c.getMarca()+","+c.getModelo()+","+c.getAno()+","+df.format(c.getValor())+","+c.getAr()+","+c.getDirecao()+","+c.getPiloto()+","+c.getAbs()+(c.getOutro().isEmpty()?".":","+c.getOutro()+".")+"\n");
					}
					bw.close();
					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}finally {
					mensagem("Feito", "Conteúdo da tabela foi exportado para 'carros.txt'");
				}
				
			}
		});
		btnExportarParaArquivo.setBounds(102, 150, 135, 25);
		btnExportarParaArquivo.setText("Exportar para arquivo");
		
		Group grpOpicionais = new Group(this, SWT.NONE);
		grpOpicionais.setText("Opicionais");
		grpOpicionais.setBounds(256, 10, 248, 165);
		
		btnArCondicionado = new Button(grpOpicionais, SWT.CHECK);
		btnArCondicionado.setBounds(10, 23, 109, 16);
		btnArCondicionado.setText("Ar condicionado");
		
		btnDireoElrtrica = new Button(grpOpicionais, SWT.CHECK);
		btnDireoElrtrica.setBounds(10, 45, 109, 16);
		btnDireoElrtrica.setText("Dire\u00E7\u00E3o el\u00E9rtrica");
		
		btnPilotoAutomtico = new Button(grpOpicionais, SWT.CHECK);
		btnPilotoAutomtico.setBounds(10, 67, 121, 16);
		btnPilotoAutomtico.setText("Piloto autom\u00E1tico");
		
		btnAbs = new Button(grpOpicionais, SWT.CHECK);
		btnAbs.setBounds(10, 89, 93, 16);
		btnAbs.setText("ABS");
		
		btnOutro = new Button(grpOpicionais, SWT.CHECK);
		btnOutro.setBounds(10, 124, 58, 16);
		btnOutro.setText("Outro");
		
		txtOutro = new Text(grpOpicionais, SWT.BORDER);
		txtOutro.setBounds(68, 122, 170, 21);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 181, 554, 124);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnMarca = new TableColumn(table, SWT.NONE);
		tblclmnMarca.setWidth(75);
		tblclmnMarca.setText("Marca");
		
		TableColumn tblclmnModelo = new TableColumn(table, SWT.NONE);
		tblclmnModelo.setWidth(79);
		tblclmnModelo.setText("Modelo");
		
		TableColumn tblclmnAno = new TableColumn(table, SWT.NONE);
		tblclmnAno.setWidth(53);
		tblclmnAno.setText("Ano");
		
		TableColumn tblclmnValor = new TableColumn(table, SWT.NONE);
		tblclmnValor.setWidth(87);
		tblclmnValor.setText("Valor");
		
		TableColumn tblclmnAr = new TableColumn(table, SWT.NONE);
		tblclmnAr.setWidth(30);
		tblclmnAr.setText("AR");
		
		TableColumn tblclmnDireo = new TableColumn(table, SWT.NONE);
		tblclmnDireo.setWidth(52);
		tblclmnDireo.setText("Dire\u00E7\u00E3o");
		
		TableColumn tblclmnPiloto = new TableColumn(table, SWT.NONE);
		tblclmnPiloto.setWidth(44);
		tblclmnPiloto.setText("Piloto");
		
		TableColumn tblclmnAbs = new TableColumn(table, SWT.NONE);
		tblclmnAbs.setWidth(34);
		tblclmnAbs.setText("ABS");
		
		TableColumn tblclmnOutro = new TableColumn(table, SWT.NONE);
		tblclmnOutro.setWidth(93);
		tblclmnOutro.setText("Outro");
		
		Label lblSomaDosValores = new Label(this, SWT.NONE);
		lblSomaDosValores.setBounds(10, 337, 104, 15);
		lblSomaDosValores.setText("Soma dos valores:");
		
		txtTodo = new Text(this, SWT.BORDER);
		txtTodo.setBounds(120, 334, 117, 21);
		
		preencheTabela();
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(590, 401);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private void preencheTabela(){
		table.setItemCount(0);
		DecimalFormat df = new DecimalFormat("##.00");
		carros = Carro.listaTudo();
		double valor = 0;
		for (Carro c : carros) {
			TableItem item= new TableItem(table, SWT.NONE);
			item.setText(c.toArray());
			valor += c.getValor();
		}
		txtTodo.setText(df.format(valor));
	}
	
	private void limpaJanela(){
		combo.select(0);
		txtModelo.setText("");
		txtAno.setText("");
		txtValor.setText("");
		btnArCondicionado.setSelection(false);
		btnDireoElrtrica.setSelection(false);
		btnPilotoAutomtico.setSelection(false);
		btnAbs.setSelection(false);
		btnOutro.setSelection(false);
		txtOutro.setText("");
	}
	
	private void mensagem(String titulo, String txt){
		MessageBox msg = new MessageBox(getShell());
		msg.setText(titulo);
		msg.setMessage(txt);
		msg.open();
	}
}
