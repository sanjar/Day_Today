package testequinoxaspect;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.addView("com.test.sample.plugin.views.SampleView", IPageLayout.TOP, 0.5f, editorArea);
	}
}
