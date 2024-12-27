package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<Task> tasks;
    private int id = 1;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void crud() {
        System.out.println("Выберите дальнейшие действия");
        System.out.println("1. Добавить задачу ");
        System.out.println("2. Показать задачи ");
        System.out.println("3. Изменить задачу ");
        System.out.println("4. Удалить задачу ");
        System.out.println("5. Выйти из системы ");
    }

    public void addTask(Task task) {
        task.setId(id++);
        tasks.add(task);
    }

    public void changeStatus(Task task, String status) {
        task.setStatus(status);
    }

    public void removeTask(int id) {
        tasks.remove(id-1);
    }

    public ArrayList<Task> readTasks() {
        return tasks;
    }

    public void updateTask(int id, String title, String description, String status) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setTitle(title);
                task.setDescription(description);
                task.setStatus(status);
            }
        }
    }

    public void optionCreateTask(Scanner scan, TaskManager taskManager) {
        System.out.println("Введите наименование задачи:");
        String title = scan.nextLine();
        System.out.println("Введите описание задачи:");
        String description = scan.nextLine();
        System.out.println("Введите статус задачи:");
        String status = scan.nextLine();
        Task newTask = new Task(title, description, status);
        taskManager.addTask(newTask);
    }

    public void optionalReadTask(Scanner scan, TaskManager taskManager) {
        System.out.println(taskManager.readTasks());
    }

    public void optionalUpdateTask(Scanner scan, TaskManager taskManager) {
        System.out.println("Укажите ID задачи которую хотите изменить: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("Изменить наименование задачи: ");
        String title = scan.nextLine();
        System.out.println("Изменить описание задачи: ");
        String description = scan.nextLine();
        System.out.println("Изменить статус задачи: ");
        String status = scan.nextLine();
        taskManager.updateTask(id, title, description, status);
    }

    public void optionalDeleteTask(Scanner scan, TaskManager taskManager) {
        System.out.println("Укажите ID задачу которую хотите удалить: ");
        int id = scan.nextInt();
        taskManager.removeTask(id);
    }
}
