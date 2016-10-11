package swt;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.SWT;

public class Janela3 extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Janela3(Composite parent, int style) {
		super(parent, style);
		
		DateTime dateTime = new DateTime(this, SWT.BORDER);
		dateTime.setBounds(30, 60, 226, 130);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
