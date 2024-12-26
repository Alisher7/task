package org.example;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private ArrayList<Task> tasks;
    private int id = 1;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void crud() {
        System.out.println("Вы вошли в систему: выберите дальнейшие действия");
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
}
