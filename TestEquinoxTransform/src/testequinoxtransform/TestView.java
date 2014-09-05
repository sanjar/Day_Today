package testequinoxtransform;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class TestView extends ViewPart {

	public TestView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		Button b = new Button(parent, SWT.PUSH);
		b.setText("Click Me");

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
