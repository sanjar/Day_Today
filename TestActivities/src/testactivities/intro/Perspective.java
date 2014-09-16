package testactivities.intro;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.activities.IActivityManager;
import org.eclipse.ui.activities.IWorkbenchActivitySupport;

public class Perspective implements IPerspectiveFactory {

	public Perspective() {
		System.out.println("Perspective");
		
	
	}
	
	
	


	public void createInitialLayout(IPageLayout layout) {
	}
}
