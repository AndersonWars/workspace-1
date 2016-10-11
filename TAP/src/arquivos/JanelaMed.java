package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class JanelaMed extends Shell {
	private Text txtNome;
	private Text txtQtd;
	private Text txtValor;
	private Table table;
	private Button rdUn;
	private Button rdMl;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			JanelaMed shell = new JanelaMed(display);
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
	public JanelaMed(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 10, 38, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.setBounds(10, 30, 218, 21);
		
		Label lblQtdCaixa = new Label(this, SWT.NONE);
		lblQtdCaixa.setBounds(245, 10, 55, 15);
		lblQtdCaixa.setText("Qtd Caixa");
		
		txtQtd = new Text(this, SWT.BORDER);
		txtQtd.setBounds(243, 30, 99, 21);
		
		Label lblValorCaixa = new Label(this, SWT.NONE);
		lblValorCaixa.setBounds(10, 57, 57, 15);
		lblValorCaixa.setText("Valor Caixa");
		
		txtValor = new Text(this, SWT.BORDER);
		txtValor.setBounds(10, 75, 76, 21);
		
		Group grpTipo = new Group(this, SWT.NONE);
		grpTipo.setText("Tipo");
		grpTipo.setBounds(138, 57, 204, 42);
		
		rdUn = new Button(grpTipo, SWT.RADIO);
		rdUn.setBounds(10, 23, 56, 16);
		rdUn.setText("Un");
		
		rdMl = new Button(grpTipo, SWT.RADIO);
		rdMl.setBounds(132, 23, 62, 16);
		rdMl.setText("Ml");
		
		Button btnGravar = new Button(this, SWT.NONE);
		btnGravar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					String linha = txtNome.getText()+","+txtValor.getText()+","+txtQtd.getText()+","+(rdUn.getSelection()?"Un":"Ml")+"\n";
					FileWriter fw = new FileWriter("medicamento.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.append(linha);
					bw.close();
					fw.close();
				}catch(Exception err){
					err.printStackTrace();
				}
				leArquivo();
			}
		});
		btnGravar.setBounds(348, 71, 55, 25);
		btnGravar.setText("Gravar");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 102, 414, 149);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(134);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnValorCaixa = new TableColumn(table, SWT.NONE);
		tblclmnValorCaixa.setWidth(86);
		tblclmnValorCaixa.setText("Valor caixa");
		
		TableColumn tblclmnQtdade = new TableColumn(table, SWT.NONE);
		tblclmnQtdade.setWidth(84);
		tblclmnQtdade.setText("Qtdade");
		
		TableColumn tblclmnValorUnidade = new TableColumn(table, SWT.NONE);
		tblclmnValorUnidade.setWidth(100);
		tblclmnValorUnidade.setText("Valor unidade");
		createContents();
		leArquivo();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 300);

	}
	
	private void leArquivo(){
		table.setItemCount(0);
		
		try{
			FileReader fr = new FileReader("medicamento.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			double valorUn = 0;
			while((linha = br.readLine())!=null){
				String[] info = new String[4];
				info = linha.split(",");
				valorUn = Double.parseDouble(info[1])/Double.parseDouble(info[2]);
				info[2]+=" "+info[3];
				info[3] = valorUn+"";
				TableItem item= new TableItem(table, SWT.NONE);
				item.setText(info);
			}
			br.close();
			fr.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
