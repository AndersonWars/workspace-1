package banco_de_dados;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class Principal2 extends Shell {
	private Text txtNome;
	private Text txtValor;
	private Table table;
	private Text txtFiltro;
	public static Connection conn = Conexao.conn();
	private ArrayList<Dispositivo> dispositivos = new ArrayList<>();
	private Dispositivo dSel;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Principal2 shell = new Principal2(display);
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
	public Principal2(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 28, 33, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.setBounds(49, 25, 165, 21);
		
		Label lblValor = new Label(this, SWT.NONE);
		lblValor.setBounds(10, 55, 33, 15);
		lblValor.setText("Valor");
		
		txtValor = new Text(this, SWT.BORDER);
		txtValor.setBounds(49, 52, 76, 21);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(30, 128, 419, 198);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(270);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnValor = new TableColumn(table, SWT.NONE);
		tblclmnValor.setWidth(100);
		tblclmnValor.setText("Valor");
		
		txtFiltro = new Text(this, SWT.BORDER);
		txtFiltro.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				preencheTabela(true);
			}
		});
		txtFiltro.setBounds(49, 101, 360, 21);
		
		Label lblFiltro = new Label(this, SWT.NONE);
		lblFiltro.setBounds(20, 80, 55, 15);
		lblFiltro.setText("Filtro");
		
		Button btnCadastra = new Button(this, SWT.NONE);
		btnCadastra.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Dispositivo d = new Dispositivo(txtNome.getText(), Double.parseDouble(txtValor.getText()));
				int feito = d.cadastra();
				if(feito>0){
					System.out.println("Feito");
				}
				preencheTabela(false);
			}
		});
		btnCadastra.setBounds(234, 10, 75, 25);
		btnCadastra.setText("Cadastra");
		
		Button btnAltera = new Button(this, SWT.NONE);
		btnAltera.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dSel = dispositivos.get(table.getSelectionIndex());
				dSel.setNome(txtNome.getText());
				dSel.setValor(Double.parseDouble(txtValor.getText()));
				dSel.altera();
				preencheTabela(false);
			}
		});
		btnAltera.setBounds(234, 45, 75, 25);
		btnAltera.setText("Altera");
		
		Button btnExclui = new Button(this, SWT.NONE);
		btnExclui.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dSel = dispositivos.get(table.getSelectionIndex());
				dSel.exclui();
				preencheTabela(false);
			}
		});
		btnExclui.setBounds(234, 70, 75, 25);
		btnExclui.setText("Exclui");
		
		Button btnExptxt = new Button(this, SWT.NONE);
		btnExptxt.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					FileWriter fw = new FileWriter("dispositivos.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					for (Dispositivo d : dispositivos) {
						bw.append(d.getNome()+","+d.getValor()+"\n");
					}
					bw.close();
					fw.close();
				}catch(Exception err){
					err.printStackTrace();
				}finally {
					System.out.println("Exportado");
				}
			}
		});
		btnExptxt.setBounds(339, 18, 75, 25);
		btnExptxt.setText("Exp. .txt");
		
		preencheTabela(false);
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(500, 375);

	}
	
	private void preencheTabela(boolean filtro){
		table.setItemCount(0);
		if(filtro){
			dispositivos = Dispositivo.listaFiltro(txtFiltro.getText());
		}else{
			dispositivos = Dispositivo.listaTudo();
		}
		for (Dispositivo d : dispositivos) {
			TableItem item= new TableItem(table, SWT.NONE);
			item.setText(d.toArray());
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
