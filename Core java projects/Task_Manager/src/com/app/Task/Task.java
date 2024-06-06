package com.app.Task;

import java.time.LocalDate;
import java.util.Objects;

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
d. Display all pending tasks     
e. Display all pending tasks for today           
f.  Display all tasks sorted by taskDate */

public class Task {
	
	private static int idGenerator;
	private int taskId;
	private String taskName;
	private String description;
	private LocalDate taskDate;
	private boolean active;
	private Status status;
	
	
	
	public Task(String taskName, String description, LocalDate taskDate) {
		super();
		this.taskId=++idGenerator;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = taskDate;
		this.active = true;
		this.status = status.PENDING;
	}
	
	
	
	public int getTaskId() {
		return taskId;
	}



	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}



	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	public Task(int taskId) {
		super();
		this.taskId = taskId;
	}



	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", description=" + description + ", taskDate="
				+ taskDate + ", active=" + active + ", status=" + status + "]";
	}



	public Task(String taskName) {
		super();
		this.taskName = taskName;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Task other = (Task) obj;
		return taskId == other.taskId;
	}
	
	
}
