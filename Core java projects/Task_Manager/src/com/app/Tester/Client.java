package com.app.Tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static com.app.utility.TaskUtility.*;

import com.app.Task.Task;

public class Client {
	public static void main(String[] args) {
		List<Task> list  = new ArrayList<>(); 
		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				try {
					System.out.println("welcone to the Task Manager/n");
					System.out.println("Enter the Choice");
					System.out.println("0.to populated data \n1.Add Task \n2.Delete \n3.display \n4.Update Status\n5.Display pending \n6.Today Pending"
							+ "\n7.Sorted By Date \n9.close the program");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("taskName, description, taskDate");
						addNewTask(sc.next(), sc.next(),sc.next(), list);
						break;
					case 2:
						System.out.println("Enter the choice to Delete");
						System.out.println("1.By Name /n2.By TaskId");
						switch (sc.nextInt()) {
						case 1:
							System.out.println("enter the name");
							deleteTaskByName(sc.next(), list);
							break;
						case 2:
							System.out.println("enter the id");
							deleteTaskById(sc.nextInt(), list);
							break;
						default:
							break;
						}
						break;
					case 3:
						displayAll(list);
						break;
					case 4:
						System.out.println("enter the id and status");
						System.out.println("PENDING,PROGRESS or COMPLETED");
						UpdateTaskStatus(sc.nextInt(), sc.next(), list);
						break;
					case 5:
						displayPendingTask(list);
						break;
					case 6:
					displayPendingTaskForToday(list);			
					break;
					case 7:
						sortedByDate(list);			
						break;
					case 0:
						list=populatedTask();			
						break;
					case 9:
						return ;			
					default:
						break;
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					sc.nextLine();
				}
			}
		}
	}

}
