package testequinoxaspect;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

public aspect ViewAspect {

	public ViewAspect() {
		System.out.println("aspect loaded");
	}
	pointcut getViewImage() : within(com.test.sample.plugin.views.SampleView.ViewLabelProvider) && execution(Image getImage(Object));
	
	Image around(): getViewImage(){
		//System.out.println("hhhh");
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
        IPath path = new Path("icons/alt_window_16.gif");
        URL url = FileLocator.find(bundle, path, null);
		Image img=ImageDescriptor.createFromURL(url).createImage();
		if(img!=null){
			return img;
		}
		return proceed();
	}
}
	

