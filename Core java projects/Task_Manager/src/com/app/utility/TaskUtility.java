package com.app.utility;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.app.Task.Status;
import com.app.Task.Task;

import cam.app.TaskExe.TaskException;

import static cam.app.validate.TaskValidate.*;

/*2. Create a menu driven application "TaskManager" to manage your day-to-day tasks. 

You can create a class Task with fields like taskId, taskName, description, taskDate, status, active. 
taskId should be unique and generated automatically.
status should be either PENDING, IN PROGRESS or COMPLETED.
active should be either true or false. Deleted task will have active=false 
Newly added task should have default status as PENDING and active=true

You can use suitable data structure to store data in memory.

Following functionalities are expected -

a. Add New Task                       
b. Delete a task                         
c. Update task status               
d. Display all pen2ding tasks     
e. Display all pending tasks for today           
f.  Display all tasks sorted by taskDate */

public class TaskUtility {

	// to add a new task
	public static void addNewTask(String taskName, String description, String taskDate, List<Task> listTask)
			throws TaskException {
		Task tNew = new Task(taskName, description, LocalDate.parse(taskDate));
		listTask.add(uniqueId(tNew, listTask));
		System.out.println("Task ADDED SUCCESSFULLY");
	}

	// to delete the new task by Name
	public static void deleteTaskByName(String tName, List<Task> listTask) {
		for (Task t : listTask) {
			if (t.getTaskName().equals(tName)) {
				t.setActive(false);
			}
		}

	}

	// to delete the new task by Id
	public static void deleteTaskById(int id, List<Task> listTask) {
		Task t1 = new Task(id);
		int ind = listTask.indexOf(t1);
		if (ind != -1) {
			listTask.get(ind).setActive(false);
			System.out.println("successfully");
			return;
		}
		System.out.println("No Such Element Exicted");

	}

	// to displlay all Task
	public static void displayAll(List<Task> list) {
		list.forEach(s -> System.out.println(s));
	}

	// update the task status
	public static void UpdateTaskStatus(int id, String status, List<Task> listTask) throws TaskException {
		Task t1 = new Task(id);
		int ind = listTask.indexOf(t1);
		Status new_status = validateStatus(status);
		if (ind != -1) {
			listTask.get(ind).setStatus(new_status);
			System.out.println("successfully");
			return;
		}
		System.out.println("No Such Element Exicted");

	}

	// to displlay pending task all Task
	public static void displayPendingTask(List<Task> list) {
		for (Task t1 : list) {
			if (t1.getStatus() == Status.PENDING) {
				System.out.println(t1);
			}
		}

	}

	// to display all pending task of today
	public static void displayPendingTaskForToday(List<Task> list) {
		for (Task t1 : list) {
			if (t1.getTaskDate() == LocalDate.now()) {
				System.out.println(t1);
			}
		}

	}
//	Display all tasks sorted by taskDate
	public static void sortedByDate(List<Task> list) 
	{
		Collections.sort(list,new Comparator<Task>() {
			@Override
			public int compare(Task o1, Task o2) {
				return o1.getTaskDate().compareTo(o2.getTaskDate());
			}
		});
	}
//	populate data
	public static List<Task> populatedTask()
	{
		Task t1,t2,t3,t4,t5;
		t1=new Task("sleeping", "so jao", LocalDate.parse("2012-12-12"));
		t2=new Task("awaking", "uth jao", LocalDate.parse("2013-12-12"));
		t3=new Task("Eating", "KHANA kha loo", LocalDate.parse("2014-12-12"));
		t4=new Task("playing", "Play Pubg", LocalDate.parse("2015-12-12"));
		t5=new Task("Study", "Studying", LocalDate.parse("2020-12-12"));
		
		List<Task> list = new ArrayList(Arrays.asList(t1,t2,t3,t4,t5));
		return list;
		
		
		
	}

}
