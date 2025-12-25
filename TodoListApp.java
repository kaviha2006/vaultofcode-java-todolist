import java.util.ArrayList;
import java.util.Scanner;

// Task class to store task details
class Task{
    String name;
    boolean completed;

    // Constructor to initialize task
    Task(String name){
        this.name=name;
        this.completed=false;
    }
}

public class TodoListApp{

    // List to store tasks
    static ArrayList<Task> tasks=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);

    // Add a new task
    public static void addTask(){
        System.out.print("Enter task name: ");
        String name=sc.nextLine();
        tasks.add(new Task(name));
        System.out.println("Task added successfully.");
    }

    // Display all tasks
    public static void displayTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("\n--- To-Do List ---");
        for(int i=0;i<tasks.size();i++){
            Task t=tasks.get(i);
            String status=t.completed?"[Completed]":"[Pending]";
            System.out.println((i+1)+". "+t.name+" "+status);
        }
    }

    // Delete a task
    public static void deleteTask(){
        displayTasks();
        if(tasks.isEmpty())return;

        System.out.print("Enter task number to delete: ");
        int index=sc.nextInt();
        sc.nextLine();

        if(index<1||index>tasks.size()){
            System.out.println("Invalid task number.");
            return;
        }
        tasks.remove(index-1);
        System.out.println("Task deleted successfully.");
    }

    // Mark a task as completed
    public static void markTaskCompleted(){
        displayTasks();
        if(tasks.isEmpty())return;

        System.out.print("Enter task number to mark complete: ");
        int index=sc.nextInt();
        sc.nextLine();

        if(index<1||index>tasks.size()){
            System.out.println("Invalid task number.");
            return;
        }
        tasks.get(index-1).completed=true;
        System.out.println("Task marked as completed.");
    }

    // Main menu
    public static void main(String[] args){
        int choice;
        do{
            System.out.println("\n===== TO-DO LIST MENU =====");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice=sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:addTask();break;
                case 2:deleteTask();break;
                case 3:displayTasks();break;
                case 4:markTaskCompleted();break;
                case 5:System.out.println("Exiting application...");break;
                default:System.out.println("Invalid choice. Try again.");
            }
        }while(choice!=5);
    }
}
