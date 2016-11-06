package q_2;

import java.sql.Connection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class JanelaSwt extends Shell {
	private CTabFolder tabFolder;
	public static Connection conn = Conexao.conn();
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			JanelaSwt shell = new JanelaSwt(display);
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
	public JanelaSwt(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		MenuItem mntmArquivo = new MenuItem(menu, SWT.CASCADE);
		mntmArquivo.setText("Arquivo");
		
		Menu menu_1 = new Menu(mntmArquivo);
		mntmArquivo.setMenu(menu_1);
		
		MenuItem mntmPaciente = new MenuItem(menu_1, SWT.NONE);
		mntmPaciente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem tabItem = jaAberto("Paciente");
				if(tabItem==null){
					tabItem = new CTabItem(tabFolder, SWT.NONE);
					tabItem.setShowClose(true);
					tabItem.setText("Paciente");
					Composite composite = new CadPaciente(tabFolder, SWT.NONE);
					tabItem.setControl(composite);
					tabFolder.setSelection(tabItem);
				}else{
					tabFolder.setSelection(tabItem);
				}
			}
		});
		mntmPaciente.setText("Paciente");
		
		MenuItem mntmMedicamento = new MenuItem(menu_1, SWT.NONE);
		mntmMedicamento.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem tabItem = jaAberto("Medicamento");
				if(tabItem==null){
					tabItem = new CTabItem(tabFolder, SWT.NONE);
					tabItem.setShowClose(true);
					tabItem.setText("Medicamento");
					Composite composite = new CadMedicamento(tabFolder, SWT.NONE);
					tabItem.setControl(composite);
					tabFolder.setSelection(tabItem);
				}else{
					tabFolder.setSelection(tabItem);
				}
			}
		});
		mntmMedicamento.setText("Medicamento");
		
		MenuItem mntmPacientemed = new MenuItem(menu_1, SWT.NONE);
		mntmPacientemed.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem tabItem = jaAberto("Pac_Med");
				if(tabItem==null){
					tabItem = new CTabItem(tabFolder, SWT.NONE);
					tabItem.setShowClose(true);
					tabItem.setText("Pac_Med");
					Composite composite = new PacMed(tabFolder, SWT.NONE);
					tabItem.setControl(composite);
					tabFolder.setSelection(tabItem);
				}else{
					tabFolder.setSelection(tabItem);
				}
			}
		});
		mntmPacientemed.setText("Paciente_Med");
		
		MenuItem mntmConsulta = new MenuItem(menu_1, SWT.NONE);
		mntmConsulta.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem tabItem = jaAberto("Consulta 1");
				if(tabItem==null){
					tabItem = new CTabItem(tabFolder, SWT.NONE);
					tabItem.setShowClose(true);
					tabItem.setText("Consulta 1");
					Composite composite = new TelaMedUtilz(tabFolder, SWT.NONE);
					tabItem.setControl(composite);
					tabFolder.setSelection(tabItem);
				}else{
					tabFolder.setSelection(tabItem);
				}
			}
		});
		mntmConsulta.setText("Consulta 1");
		
		MenuItem mntmConsulta_1 = new MenuItem(menu_1, SWT.NONE);
		mntmConsulta_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem tabItem = jaAberto("Consulta 2");
				if(tabItem==null){
					tabItem = new CTabItem(tabFolder, SWT.NONE);
					tabItem.setShowClose(true);
					tabItem.setText("Consulta 2");
					Composite composite = new TelaConsulta2(tabFolder, SWT.NONE);
					tabItem.setControl(composite);
					tabFolder.setSelection(tabItem);
				}else{
					tabFolder.setSelection(tabItem);
				}
			}
		});
		mntmConsulta_1.setText("Consulta 2");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmSair = new MenuItem(menu_1, SWT.NONE);
		mntmSair.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		mntmSair.setText("Sair");
		
		tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setSimple(false);
		tabFolder.setBounds(0, 0, 563, 397);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	
	private CTabItem jaAberto(String nome){
		for (CTabItem item : tabFolder.getItems()) {
			if(item.getText().equals(nome))
				return item;
		}
		return null;
	}
	
	protected void createContents() {
		setText("Quest\u00E3o 2");
		setSize(574, 456);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
