package prova2;

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

public class Principal extends Shell {
	
	public static Connection conn = Conexao.conn();
	
	private CTabFolder tabFolder;
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
		
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		MenuItem mntmCadastro = new MenuItem(menu, SWT.CASCADE);
		mntmCadastro.setText("Cadastro");
		
		Menu menu_1 = new Menu(mntmCadastro);
		mntmCadastro.setMenu(menu_1);
		
		MenuItem mntmPessoa = new MenuItem(menu_1, SWT.NONE);
		mntmPessoa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem tabItem = jaAberto("Pessoa");
				if(tabItem==null){
					tabItem = new CTabItem(tabFolder, SWT.NONE);
					tabItem.setShowClose(true);
					tabItem.setText("Pessoa");
					Composite composite = new CadPessoa(tabFolder, SWT.NONE);
					tabItem.setControl(composite);
					tabFolder.setSelection(tabItem);
				}else{
					tabFolder.setSelection(tabItem);
				}
			}
		});
		mntmPessoa.setText("Pessoa");
		
		MenuItem mntmVacina = new MenuItem(menu_1, SWT.NONE);
		mntmVacina.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem tabItem = jaAberto("Vacina");
				if(tabItem==null){
					tabItem = new CTabItem(tabFolder, SWT.NONE);
					tabItem.setShowClose(true);
					tabItem.setText("Vacina");
					Composite composite = new CadVacina(tabFolder, SWT.NONE);
					tabItem.setControl(composite);
					tabFolder.setSelection(tabItem);
				}else{
					tabFolder.setSelection(tabItem);
				}
			}
		});
		mntmVacina.setText("Vacina");
		
		MenuItem mntmConsulta = new MenuItem(menu_1, SWT.NONE);
		mntmConsulta.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem tabItem = jaAberto("Consulta");
				if(tabItem==null){
					tabItem = new CTabItem(tabFolder, SWT.NONE);
					tabItem.setShowClose(true);
					tabItem.setText("Consulta");
					Composite composite = new Consulta(tabFolder, SWT.NONE);
					tabItem.setControl(composite);
					tabFolder.setSelection(tabItem);
				}else{
					tabFolder.setSelection(tabItem);
				}
			}
		});
		mntmConsulta.setText("Consulta");
		
		tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setBounds(0, 0, 508, 303);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(524, 362);

	}
	
	private CTabItem jaAberto(String nome){
		for (CTabItem item : tabFolder.getItems()) {
			if(item.getText().equals(nome))
				return item;
		}
		return null;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
