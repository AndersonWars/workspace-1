package preprova;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class JanelaPreProva extends Shell {
	private CTabFolder tabFolder;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			JanelaPreProva shell = new JanelaPreProva(display);
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
	public JanelaPreProva(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		MenuItem mntmAbas = new MenuItem(menu, SWT.CASCADE);
		mntmAbas.setText("Abas");
		
		Menu menu_1 = new Menu(mntmAbas);
		mntmAbas.setMenu(menu_1);
		
		MenuItem mntmNewItem = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem tabItem = jaAberto("Aba 1");
				if(tabItem==null){
					tabItem = new CTabItem(tabFolder, SWT.NONE);
					tabItem.setText("Aba 1");
					tabItem.setShowClose(true);
					Composite composite = new Aba1(tabFolder, SWT.NONE);
					tabItem.setControl(composite);
					tabFolder.setSelection(tabItem);
				}else{
					tabFolder.setSelection(tabItem);
				}
			}
		});
		mntmNewItem.setSelection(true);
		mntmNewItem.setText("Aba 1");
		
		MenuItem mntmAba = new MenuItem(menu_1, SWT.NONE);
		mntmAba.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem tabItem = jaAberto("Aba 2");
				if(tabItem==null){
					tabItem = new CTabItem(tabFolder, SWT.NONE);
					tabItem.setText("Aba 2");
					tabItem.setShowClose(true);
					Composite composite = new Aba2(tabFolder, SWT.NONE);
					tabItem.setControl(composite);
					tabFolder.setSelection(tabItem);
				}else{
					tabFolder.setSelection(tabItem);
				}
			}
		});
		mntmAba.setText("Aba 2");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmSair = new MenuItem(menu_1, SWT.NONE);
		mntmSair.setImage(SWTResourceManager.getImage(JanelaPreProva.class, "/imgs/multiply.png"));
		mntmSair.setText("Sair");
		
		tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setBounds(0, 0, 684, 341);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(700, 400);

	}
	
	private CTabItem jaAberto(String aba){
		for (CTabItem it : tabFolder.getItems()) {
			if(it.getText().equals(aba))
				return it;
		}
		return null;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
