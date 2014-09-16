package testactivities;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.ISourceProviderService;


public class TogglePrintHandler extends AbstractHandler {

	

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		 ISourceProviderService sourceProviderService = (ISourceProviderService) HandlerUtil
			        .getActiveWorkbenchWindow(event).getService(ISourceProviderService.class);
			    // now get my service
		 CustomSourceProvider provider = (CustomSourceProvider) sourceProviderService
			        .getSourceProvider(CustomSourceProvider.TOGGLE_PRINT);
		 provider.toogleEnabled();
		return null;
	}

	

}
