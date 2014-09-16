package testactivities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

public class CustomSourceProvider extends AbstractSourceProvider {

	public final static String TOGGLE_PRINT = "isCommadToTogglePrintMenu";
	private final static Map<String, String> stateMap = new HashMap<String,String>();
	 private final static String[] PROVIDED_SOURCE_NAMES = new String[] { TOGGLE_PRINT };
	 public final static String ENABLED = "enabled";
	  public final static String DISENABLED = "disabled";
	  private boolean enabled = true;
	  
	public CustomSourceProvider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map getCurrentState() {
		stateMap.put(TOGGLE_PRINT, "enabled");
		return stateMap;
	}

	@Override
	public String[] getProvidedSourceNames() {
		return PROVIDED_SOURCE_NAMES;
	}
	
	public void toogleEnabled() {
	    enabled = !enabled ;
	    String value = enabled ? ENABLED : DISENABLED;
	    fireSourceChanged(ISources.WORKBENCH, TOGGLE_PRINT, value);
	  }

}
