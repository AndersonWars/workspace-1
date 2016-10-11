package swt;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;


import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.SWTResourceManager;

public class Janela2 extends Composite {
	private Label lblPato;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Janela2(Composite parent, int style) {
		super(parent, style);
		
		lblPato = new Label(this, SWT.NONE);
		lblPato.setImage(SWTResourceManager.getImage(Janela2.class, "/imgs/duck.png"));

		lblPato.setBounds(10, 10, 293, 267);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(getShell());
				fd.setFilterExtensions(new String[]{"*.jpg","*.png"});
				Image imagem = new Image(null, fd.open());
				lblPato.setImage(imagem);
			}
		});
		btnNewButton.setBounds(342, 25, 98, 34);
		btnNewButton.setText("...");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
