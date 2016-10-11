package arquivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Telinha extends Shell {
	private Text txtTexto;
	private Button btnNegrito;
	private Button btnItlico;
	private Combo combo;
	private Label lblText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Telinha shell = new Telinha(display);
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
	public Telinha(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		CTabFolder tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setBounds(0, 0, 434, 261);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmCadastro = new CTabItem(tabFolder, SWT.NONE);
		tbtmCadastro.setText("Cadastro");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmCadastro.setControl(composite_1);
		
		Label lblTexto = new Label(composite_1, SWT.NONE);
		lblTexto.setBounds(10, 10, 28, 15);
		lblTexto.setText("Texto");
		
		txtTexto = new Text(composite_1, SWT.BORDER);
		txtTexto.setBounds(44, 7, 195, 21);
		
		Label lblCor = new Label(composite_1, SWT.NONE);
		lblCor.setBounds(10, 49, 28, 15);
		lblCor.setText("Cor");
		
		combo = new Combo(composite_1, SWT.NONE);
		combo.setItems(new String[] {"Azul", "Vermelho", "Verde"});
		combo.setBounds(44, 46, 113, 23);
		combo.setText("Selecionar");
		
		btnNegrito = new Button(composite_1, SWT.CHECK);
		btnNegrito.setBounds(26, 105, 93, 16);
		btnNegrito.setText("Negrito");
		
		btnItlico = new Button(composite_1, SWT.CHECK);
		btnItlico.setBounds(125, 105, 93, 16);
		btnItlico.setText("It\u00E1lico");
		
		Button btnGravar = new Button(composite_1, SWT.NONE);
		btnGravar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Properties prop = new Properties();
				prop.setProperty("texto", txtTexto.getText());
				prop.setProperty("cor", combo.getText().equals("Seleciona")?"Preto":combo.getText());
				prop.setProperty("negrito", btnNegrito.getSelection()?"S":"N");
				prop.setProperty("italico", btnItlico.getSelection()?"S":"N");
				try{
					FileWriter fw = new FileWriter("conf.properties");
					prop.store(fw, "Configurações");
					fw.close();
				}catch(Exception err){
					err.printStackTrace();
				}
			}
		});
		btnGravar.setBounds(28, 140, 75, 25);
		btnGravar.setText("Gravar");
		
		CTabItem tabAplicar = new CTabItem(tabFolder, SWT.NONE);
		tabAplicar.setText("Aplicar");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tabAplicar.setControl(composite);
		
		lblText = new Label(composite, SWT.CENTER);
		
		lblText.setFont(SWTResourceManager.getFont("Segoe UI Emoji", 47, SWT.NORMAL));
		lblText.setBounds(50, 45, 333, 97);
		lblText.setText("...");
		
		Button btnAplicar = new Button(composite, SWT.NONE);
		btnAplicar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Properties prop = new Properties();
				try{
					FileReader fr = new FileReader("conf.properties");
					prop.load(fr);
					lblText.setText(prop.getProperty("texto"));
					String cor = prop.getProperty("cor");
					if(cor.equals("Verde"))
						lblText.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
					if(cor.equals("Vermelho"))
						lblText.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					if(cor.equals("Azul"))
						lblText.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
					String n = prop.getProperty("negrito");
					String i = prop.getProperty("italico");
					if(n.equals("S"))
						lblText.setFont(SWTResourceManager.getFont("Segoe UI", 47, SWT.BOLD));
					if(i.equals("S"))
						lblText.setFont(SWTResourceManager.getFont("Segoe UI", 47, SWT.ITALIC));
					if (n.equals("S") && i.equals("S"))
						lblText.setFont(SWTResourceManager.getFont("Segoe UI", 47, SWT.BOLD | SWT.ITALIC));
					
				}catch(Exception err){
					err.printStackTrace();
				}
			}
		});
		btnAplicar.setBounds(178, 160, 75, 25);
		btnAplicar.setText("Aplicar");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Tela");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
