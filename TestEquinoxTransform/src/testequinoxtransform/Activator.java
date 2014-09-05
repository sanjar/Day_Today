package testequinoxtransform;

import java.net.URL;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration<?> registration;
	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Hashtable<String, String> properties = new Hashtable<>();
		properties.put("equinox.transformerType", "xslt");
		registration= context.registerService(URL.class.getName(), context.getBundle().getEntry("/transform.csv"), properties);
		System.out.println("done");
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		if (registration != null) {
            registration.unregister();
            registration = null;
        }
	}

}
