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

public class JanelaPaciente extends Shell {
	private Text txtNome;
	private Text txtIdade;
	private Table table;
	private Button rdM;
	private Button rdF;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			JanelaPaciente shell = new JanelaPaciente(display);
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
	public JanelaPaciente(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 10, 33, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.setBounds(49, 7, 257, 21);
		
		Label lblIdade = new Label(this, SWT.NONE);
		lblIdade.setBounds(10, 34, 33, 15);
		lblIdade.setText("Idade");
		
		txtIdade = new Text(this, SWT.BORDER);
		txtIdade.setBounds(49, 31, 61, 21);
		
		Group grpSexo = new Group(this, SWT.NONE);
		grpSexo.setText("Sexo");
		grpSexo.setBounds(10, 62, 296, 43);
		
		rdM = new Button(grpSexo, SWT.RADIO);
		rdM.setSelection(true);
		rdM.setBounds(10, 19, 90, 16);
		rdM.setText("Masculino");
		
		rdF = new Button(grpSexo, SWT.RADIO);
		rdF.setBounds(196, 19, 90, 16);
		rdF.setText("Feminino");
		
		Button btnGravar = new Button(this, SWT.NONE);
		btnGravar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String linha = txtNome.getText()+","+
						txtIdade.getText()+","+
						(rdM.getSelection()?"M":"F")+"\n";
				try{
					FileWriter fw = new FileWriter("pacientes.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.append(linha);
					bw.close();
					fw.close();
					limpaJanela();
				}catch(Exception err){
					err.printStackTrace();
				}
				lerArquivo();
			}
		});
		btnGravar.setBounds(316, 34, 61, 25);
		btnGravar.setText("Gravar");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 111, 414, 140);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(225);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnIdade = new TableColumn(table, SWT.NONE);
		tblclmnIdade.setWidth(71);
		tblclmnIdade.setText("Idade");
		
		TableColumn tblclmnSexo = new TableColumn(table, SWT.NONE);
		tblclmnSexo.setWidth(114);
		tblclmnSexo.setText("Sexo");
		createContents();
		
		lerArquivo();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Cadastro Paciente");
		setSize(450, 300);

	}
	
	private void limpaJanela(){
		txtNome.setText("");
		txtIdade.setText("");
		rdM.setSelection(true);
	}
	
	private void lerArquivo(){
		table.setItemCount(0);
		try{
			FileReader fr = new FileReader("pacientes.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while((linha = br.readLine())!=null){
				TableItem item= new TableItem(table, SWT.NONE);
				item.setText(linha.split(","));
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
