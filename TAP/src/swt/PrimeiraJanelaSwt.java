package swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

public class PrimeiraJanelaSwt extends Shell {
	private CTabFolder tabFolder;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			PrimeiraJanelaSwt shell = new PrimeiraJanelaSwt(display);
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
	public PrimeiraJanelaSwt(Display display) {
		super(display, SWT.SHELL_TRIM);
		//setImage(SWTResourceManager.getImage(PrimeiraJanelaSwt.class, "/imgs/info.png"));
		
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("&Arquivo");
		
		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);
		
		MenuItem mntmNewItem = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem tbtmJanela = jaaberto("Janela 1");
				if(tbtmJanela==null){
					tbtmJanela = new CTabItem(tabFolder, SWT.NONE);
					tbtmJanela.setShowClose(true);
					tbtmJanela.setText("Janela 1");
					Composite composite = new Janela1(tabFolder, SWT.NONE);
					tbtmJanela.setControl(composite);
					tabFolder.setSelection(tbtmJanela);
				}else
					tabFolder.setSelection(tbtmJanela);
			}
		});
		mntmNewItem.setText("Op\u00E7\u00E3o &1");
		
		MenuItem mntmNewItem_1 = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem tbtmJanela = jaaberto("Janela 2");
				if (tbtmJanela==null){
					tbtmJanela = new CTabItem(tabFolder, SWT.NONE);
					tbtmJanela.setShowClose(true);
					tbtmJanela.setText("Janela 2");
					Composite composite = new Janela2(tabFolder, SWT.NONE);
					tbtmJanela.setControl(composite);
					tabFolder.setSelection(tbtmJanela);
				}else
					tabFolder.setSelection(tbtmJanela);
			}
		});
		mntmNewItem_1.setText("Op\u00E7\u00E3o &2");
		
		MenuItem mntmNewItem_2 = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem tbtmJanela = jaaberto("Janela 3");
				if(tbtmJanela==null){
					tbtmJanela = new CTabItem(tabFolder, SWT.NONE);
					tbtmJanela.setShowClose(true);
					tbtmJanela.setText("Janela 3");
					Composite composite = new Janela3(tabFolder, SWT.NONE);
					tbtmJanela.setControl(composite);
					tabFolder.setSelection(tbtmJanela);
				}else
					tabFolder.setSelection(tbtmJanela);
			}
		});
		mntmNewItem_2.setText("Opção &3");
		
		MenuItem mntmOpo = new MenuItem(menu_1, SWT.NONE);
		mntmOpo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem tbtmJanela = jaaberto("Janela 4");
				if(tbtmJanela==null){
					tbtmJanela = new CTabItem(tabFolder, SWT.NONE);
					tbtmJanela.setShowClose(true);
					tbtmJanela.setText("Janela 4");
					Composite composite = new Janela4(tabFolder, SWT.NONE);
					tbtmJanela.setControl(composite);
					tabFolder.setSelection(tbtmJanela);
				}else
					tabFolder.setSelection(tbtmJanela);
			}
		});
		mntmOpo.setText("Op\u00E7\u00E3o &4");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmNewItem_3 = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_3.setImage(SWTResourceManager.getImage(PrimeiraJanelaSwt.class, "/imgs/multiply.png"));
		
		mntmNewItem_3.setText("&Sair");
		
		MenuItem mntmNewSubmenu_1 = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu_1.setText("Teste");
		
		Menu menu_2 = new Menu(mntmNewSubmenu_1);
		mntmNewSubmenu_1.setMenu(menu_2);
		
		MenuItem mntmNewSubmenu_2 = new MenuItem(menu_2, SWT.CASCADE);
		mntmNewSubmenu_2.setText("Submenu");
		
		Menu menu_3 = new Menu(mntmNewSubmenu_2);
		mntmNewSubmenu_2.setMenu(menu_3);
		
		MenuItem mntmNewItem_4 = new MenuItem(menu_3, SWT.NONE);
		mntmNewItem_4.setText("Sample1");
		
		MenuItem mntmNewItem_5 = new MenuItem(menu_3, SWT.NONE);
		mntmNewItem_5.setText("Sample2");
		
		new MenuItem(menu_3, SWT.SEPARATOR);
		
		MenuItem mntmNewRadiobutton = new MenuItem(menu_3, SWT.RADIO);
		mntmNewRadiobutton.setText("New RadioButton");
		
		MenuItem mntmNewRadiobutton_1 = new MenuItem(menu_3, SWT.RADIO);
		mntmNewRadiobutton_1.setText("New RadioButton");
		
		new MenuItem(menu_3, SWT.SEPARATOR);
		
		MenuItem mntmNewCheckbox = new MenuItem(menu_3, SWT.CHECK);
		mntmNewCheckbox.setText("New CheckBox");
		
		MenuItem mntmNewCheckbox_1 = new MenuItem(menu_3, SWT.CHECK);
		mntmNewCheckbox_1.setText("New CheckBox");
		
		tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setSimple(false);
		tabFolder.setBounds(10, 10, 626, 344);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		createContents();
		
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Primeira Janela");
		setSize(652, 413);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private CTabItem jaaberto(String nome){
		for (CTabItem it: tabFolder.getItems()){
			if(it.getText().equals(nome))
				return it;
		}
		return null;
	}
}
