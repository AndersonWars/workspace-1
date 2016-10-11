package arquivos;

import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class JanelaPrinc extends Shell {
	private Text txtPath;
	private Table table;
	private File[] lista;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			JanelaPrinc shell = new JanelaPrinc(display);
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
	public JanelaPrinc(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label lblCaminho = new Label(this, SWT.NONE);
		lblCaminho.setBounds(10, 10, 55, 15);
		lblCaminho.setText("Caminho");
		
		txtPath = new Text(this, SWT.BORDER);
		txtPath.setBounds(10, 31, 324, 21);
		
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dlg = new DirectoryDialog(getShell());
				dlg.setFilterPath("\\");
				setText("Diretório");
				dlg.setMessage("Selecionar caminho");
				String dir = dlg.open();
				if (dir!=null)
					txtPath.setText(dir);
			}
		});
		button.setBounds(349, 29, 29, 25);
		button.setText("...");
		
		Button btnCarregar = new Button(this, SWT.NONE);
		btnCarregar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				carregar();
			}

		});
		btnCarregar.setBounds(10, 58, 75, 25);
		btnCarregar.setText("Carregar");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				int index = table.getSelectionIndex();
				File f = lista[index];
				f.delete();
				carregar();
			}
		});
		table.setBounds(10, 89, 414, 277);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(177);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnTamanho = new TableColumn(table, SWT.NONE);
		tblclmnTamanho.setWidth(100);
		tblclmnTamanho.setText("Tamanho");
		
		TableColumn tblclmnData = new TableColumn(table, SWT.NONE);
		tblclmnData.setWidth(100);
		tblclmnData.setText("Data");
		
		Button btnApagarTodos = new Button(this, SWT.NONE);
		btnApagarTodos.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for (File f : lista) {
					f.delete();
				}
				carregar();
			}
		});
		btnApagarTodos.setBounds(10, 372, 85, 25);
		btnApagarTodos.setText("Apagar Todos");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Arquivos");
		setSize(450, 440);

	}
	
	private void carregar() {
		table.setItemCount(0);
		File d = new File(txtPath.getText());
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		DecimalFormat dc = new DecimalFormat("#0.00");
		if (d.isDirectory()){
			lista = d.listFiles();
		}
		for (File f : lista) {
			String nome = f.getName();
			double tam = (double)f.length()/1024;
			Date data = new Date(f.lastModified());
			TableItem item= new TableItem(table, SWT.NONE);
			item.setText(0, nome);
			item.setText(1, dc.format(tam)+" kb");
			item.setText(2, df.format(data));
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
