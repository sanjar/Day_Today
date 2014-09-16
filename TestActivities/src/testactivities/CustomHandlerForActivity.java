package testactivities;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.activities.IActivity;
import org.eclipse.ui.activities.IActivityManager;
import org.eclipse.ui.activities.IWorkbenchActivitySupport;


public class CustomHandlerForActivity extends AbstractHandler {

	

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		disableRun();
		return null;
	}

	
	
	private void disableRun() {
		IWorkbench iWorkbench = PlatformUI.getWorkbench();
		IWorkbenchActivitySupport activitySupport = iWorkbench.getActivitySupport();
		IActivityManager activityManager = activitySupport.getActivityManager();
		Set<String> enabledActivityIds = new HashSet<String>(activityManager.getEnabledActivityIds());
		 Set<String> definedActivityIds = activityManager.getDefinedActivityIds();
		 System.out.println(definedActivityIds);
		 System.out.println(enabledActivityIds);
		 Iterator<String> iterator = enabledActivityIds.iterator();
		 boolean activityEnabled=false;
		 
		 IActivity activity = activityManager.getActivity("TestActivities.customActivity");
		 if(activity.isEnabled()){
			 enabledActivityIds.remove("TestActivities.customActivity");
		 }
		 else{
			 enabledActivityIds.add("TestActivities.customActivity");
		 }
		 /*while(iterator.hasNext()){
			 
			 String id = iterator.next();
			 if("TestActivities.customActivity".equals(id)){
				 iterator.remove();
				 activityEnabled=true;
			 }
		 }
		 if(!activityEnabled){
			 enabledActivityIds.add("TestActivities.customActivity");
		 }*/
		 activitySupport.setEnabledActivityIds(enabledActivityIds);
	}

}
