package testequinoxtransform;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		layout.setFixed(true);
		String editorArea = layout.getEditorArea();
		//layout.addStandaloneView("TestEquinoxTransform.view", false, IPageLayout.TOP, 0.5f, editorArea);
		//layout.addStandaloneView("com.test.sample.plugin.views.SampleView",  false, IPageLayout.TOP, 0.5f, editorArea);
	}

}
