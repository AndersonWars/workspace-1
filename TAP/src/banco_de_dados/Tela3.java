package banco_de_dados;

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
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Tela3 extends Shell {
	private Text txtPessoa;
	private Table table;
	private Text text;
	private Table table_1;
	public static Connection conn = Conexao.conn();
	private ArrayList<Pessoa> pessoas = new ArrayList<>();
	private ArrayList<Dispositivo> dispositivos = new ArrayList<>();
	private Pessoa pSel;
	private Dispositivo dSel;
	private Text txtqtd;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Tela3 shell = new Tela3(display);
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
	public Tela3(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label lblPessoa = new Label(this, SWT.NONE);
		lblPessoa.setBounds(10, 10, 36, 15);
		lblPessoa.setText("Pessoa");
		
		txtPessoa = new Text(this, SWT.BORDER);
		txtPessoa.setBounds(52, 10, 314, 21);
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				pSel = pessoas.get(table.getSelectionIndex());
			}
		});
		table.setBounds(10, 40, 464, 113);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(244);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnIdade = new TableColumn(table, SWT.NONE);
		tblclmnIdade.setWidth(100);
		tblclmnIdade.setText("Idade");
		
		TableColumn tblclmnSexo = new TableColumn(table, SWT.NONE);
		tblclmnSexo.setWidth(100);
		tblclmnSexo.setText("Sexo");
		
		Label lblDispositivo = new Label(this, SWT.NONE);
		lblDispositivo.setBounds(10, 162, 58, 15);
		lblDispositivo.setText("Dispositivo");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(74, 159, 292, 21);
		
		table_1 = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				dSel = dispositivos.get(table_1.getSelectionIndex());
			}
		});
		table_1.setBounds(10, 183, 464, 106);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tblclmnDispositivo = new TableColumn(table_1, SWT.NONE);
		tblclmnDispositivo.setWidth(268);
		tblclmnDispositivo.setText("Dispositivo");
		
		TableColumn tblclmnValor = new TableColumn(table_1, SWT.NONE);
		tblclmnValor.setWidth(149);
		tblclmnValor.setText("Valor");
		
		Button btnGravar = new Button(this, SWT.NONE);
		btnGravar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Uso u = new Uso();
				u.setPessoa(pSel);
				u.setDispositivo(dSel);
				u.setQtd(Integer.parseInt(txtqtd.getText()));
				u.cadastra();
			}
		});
		btnGravar.setBounds(354, 301, 75, 25);
		btnGravar.setText("Gravar");
		
		txtqtd = new Text(this, SWT.BORDER);
		txtqtd.setBounds(27, 305, 76, 21);
		
		preencheTabelas();
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(500, 375);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private void preencheTabelas(){
		dispositivos = Dispositivo.listaTudo();
		pessoas = Pessoa.listarTudo();
		for (Dispositivo d : dispositivos) {
			TableItem tableItem= new TableItem(table_1, SWT.NONE);
			tableItem.setText(d.toArray());
		}
		for (Pessoa p : pessoas) {
			TableItem item= new TableItem(table, SWT.NONE);
			item.setText(p.toArray());
		}
	}
}
