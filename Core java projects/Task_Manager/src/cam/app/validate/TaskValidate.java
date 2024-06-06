package cam.app.validate;

import java.util.List;

import com.app.Task.Status;
import com.app.Task.Task;

import cam.app.TaskExe.TaskException;

public class TaskValidate {
	public static  Status validateStatus(String status) throws TaskException
	{
		for(Status a : Status.values() ) {
			if(a.name().equalsIgnoreCase(status))
				return Status.valueOf(status.toUpperCase());
		}
		 throw new TaskException("Status mismatched");
	}
	public static Task uniqueId(Task t1,List<Task> list) throws TaskException 
	{
		for(Task t : list) 
		{
			if(t.getTaskName().equals(t1.getTaskName())) 
			{
				throw new TaskException("Already Existed");
			}
		}
		return t1;
	}
	
}
