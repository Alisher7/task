package org.example;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void sortArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        int[] arr = {9, 5, 6, 8, 1, 2, 7, 4, 3};
        //Сортировка
        sortArray(arr);
//        System.out.println(Arrays.toString(arr));
        Task task = new Task("test1", "ddd", "IN_PROCESS");
        Task task1 = new Task("test2", "ddd3", "in_process");
        Task task2 = new Task("test3", "ddd", "IN_PROCESS");


        //Вверхни и нижний регистр
        String upperCase = task.getStatus().toUpperCase();
        String lowerCase = task.getStatus().toLowerCase();

//        taskManager.addTask(task);
//        taskManager.addTask(task1);
//        taskManager.addTask(task2);

//        taskManager.changeStatus(task,"Active");

        //Удаление задачи
//        taskManager.removeTask(3);

        LocalDate date = LocalDate.now();
        WorkTask workTask = new WorkTask("Работа 1", "Улучить текущий код", "in_process", date);
//        taskManager.addTask(workTask);

        PersonalTask personalTask = new PersonalTask("Задача ОДИН", "Описание ДВА", "IN_PROCESS", null);
//        taskManager.addTask(personalTask);

//        System.out.println(taskManager.readTasks());

        Book book = new Book("Война и мир", "Лев Толстой", 1867);
        Book book1 = new Book("Темная башня", "Стивен Кинг", 2012);
        Book book3 = new Book("Темная башня", "Баратрум", 1234);
        Book book2 = new Book("Властелин колец: Братство кольца", "Толкин, Джон Рональд Руэл", 1954);
        Book book4 = new Book("Властелин колец: Две крепости", "Толкин, Джон Рональд Руэл", 1954);
        Book book5 = new Book("Властелин колец: Возвращение короля", "Толкин, Джон Рональд Руэл", 1955);

        BookManager allBook = new BookManager();

        allBook.addBook(book);
        allBook.addBook(book1);
        allBook.addBook(book2);
        allBook.addBook(book3);
        allBook.addBook(book4);
        allBook.addBook(book5);

        //Удаление книги по наименованию
        allBook.removeBookByTitle(book5.getTitle());
        //Поиск книги по автору
//        allBook.findBookByAuthor(book2.getAuthor());
//        System.out.println(allBook.getBooks());


        TaskManager taskManager = new TaskManager();
        List<User> userList = UserManager.getUsers();

//        User admin = new User("admin", "admin");
//        User user = new User("user", "user");

//        userManager.addUser(admin);
//        userManager.addUser(user);
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String login = scan.nextLine();
        System.out.println("Введите пароль: ");
        String password = scan.nextLine();
        List<User> userList2 = userList.stream()
                .filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password))
                .toList();
        for (int i = 0; i < userList2.size(); i++) {
            while (true) {
                taskManager.crud();
                int command = scan.nextInt();
                if (command == 1) {
                    scan.nextLine();
                    System.out.println("Введите наименование задачи:");
                    String title = scan.nextLine();
                    System.out.println("Введите описание задачи:");
                    String description = scan.nextLine();
                    Task newTask = new Task(title, description, "new_Task");
                    taskManager.addTask(newTask);
                } else if (command == 2) {
                    System.out.println(taskManager.readTasks());
                } else if (command == 3) {
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
                } else if (command == 4) {
                    System.out.println("Укажите ID задачу которую хотите удалить: ");
                    int id = scan.nextInt();
                    taskManager.removeTask(id);
                } else if (command == 5) {
                    System.exit(0);
                }
            }
        }
        //end
    }
}