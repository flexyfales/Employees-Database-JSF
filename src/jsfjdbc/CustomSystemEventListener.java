package jsfjdbc;

import javax.faces.application.Application;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PostConstructApplicationEvent;
import javax.faces.event.PreDestroyApplicationEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

public class CustomSystemEventListener implements SystemEventListener{

	@Override
	public boolean isListenerForSource(Object value) {
		// TODO Auto-generated method stub
		return (value instanceof Application);
	}

	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException {
		if(event instanceof PostConstructApplicationEvent) {
			System.out.println("Application Started,PostConstructApplicationEvent occured");
			EmployeesBO employeesBO = new EmployeesBO();
		}
		if(event instanceof PreDestroyApplicationEvent) {
			System.out.println("Application Stopping,PreDestroyApplicationEvent occured");
		}
		
	}

	
	
	
}
