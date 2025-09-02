package ch.tbz;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDo {
    private ArrayList<String> tasks = new ArrayList<>();
    private ArrayList<Boolean> done = new ArrayList<>();
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    listTasks();
                    break;
                case 3:
                    markDone(scanner);
                    break;
                case 0:
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

        } while (choice != 0);
    }

    private void showMenu() {
        System.out.println("1) Add Task");
        System.out.println("2) Show Task");
        System.out.println("3) Mark Task as done");
        System.out.println("0) Stop program");
        System.out.print("Choice: ");
    }

    private void addTask(Scanner scanner) {
        System.out.print("New Task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        done.add(false);
        System.out.println("Task added: !");
    }

    private void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                String status = done.get(i) ? "[x]" : "[ ]";
                System.out.println((i + 1) + ". " + status + " " + tasks.get(i));
            }
        }
        System.out.println("------------------------");
    }

    private void markDone(Scanner scanner) {
        listTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Which task is done? Type the number: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        index -= 1;

        if (index >= 0 && index < tasks.size()) {
            done.set(index, true);
            System.out.println("Task done!");
        } else {
            System.out.println("Invalid number!");
        }
    }
}
