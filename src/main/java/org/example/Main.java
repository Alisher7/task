package org.example;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "1111";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

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
        Task task = new Task("test1","ddd","IN_PROCESS");
        Task task1 = new Task("test2","ddd3","in_process");
        Task task2 = new Task("test3","ddd","IN_PROCESS");

        TaskManager taskManager = new TaskManager();

        //Вверхни и нижний регистр
        String upperCase = task.getStatus().toUpperCase();
        String lowerCase = task.getStatus().toLowerCase();

        taskManager.addTask(task);
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        taskManager.changeStatus(task,"Active");

        //Удаление задачи
        taskManager.removeTask(3);

        LocalDate date = LocalDate.now();
        WorkTask workTask = new WorkTask("Работа 1", "Улучить текущий код", "in_process", date);
        taskManager.addTask(workTask);

        PersonalTask personalTask = new PersonalTask("Задача ОДИН", "Описание ДВА", "IN_PROCESS", null);
        taskManager.addTask(personalTask);

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





        UserManager userList = new UserManager();
        TaskManager createTask = new TaskManager();

        User admin = new User("admin", "admin");
        User user = new User("user", "user");

        userList.addUser(admin);
        userList.addUser(user);

//        for (User user1 : Arrays.asList(admin, user)) {
//            userList.addUser(user1);
//        }
        Scanner scan = new Scanner(System.in);
//        ArrayList<UserList> list = new ArrayList<>();
//        list.add(userList);

        System.out.println("Введите логин: ");
        String login = scan.nextLine();
        User foundUser = null;
        for (User user1 : userList.getUsers()) {
            if (user1.getLogin().equals(login)) {
                foundUser = user1;
            }
        }
//        while (!foundUser.getLogin().equals(login)) {
//            System.out.println("Такого пользователя нет, введите логин: ");
//            login = scan.nextLine();
//        }
//
//        System.out.println("Введите пароль: ");
//        String password = scan.nextLine();
//        while (!foundUser.getPassword().equals(password)) {
//            System.out.println("Пароль не верный, введите пароль: ");
//            password = scan.nextLine();
//        }


        while (true) {
            taskManager.crud();
            Scanner scan2 = new Scanner(System.in);
            int command = scan2.nextInt();
            if (command == 1) {
                scan2.nextLine();
                System.out.println("Введите наименование задачи:");
                String title = scan2.nextLine();
                System.out.println("Введите описание задачи:");
                String description = scan2.nextLine();
                Task newTask = new Task(title, description, "new_Task");
                createTask.addTask(newTask);
            } else if (command == 2) {
                System.out.println(createTask.readTasks());
            } else if (command == 3) {

            } else if (command == 4) {

            } else if (command == 5) {
                System.exit(0);
            }
        }










//        Scanner scanner = new Scanner(System.in);
//        Connection connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
//        while (true) {
//            System.out.println("Пожалуйста выберите команду");
//            System.out.println("1. Добавление задачи");
//            System.out.println("2. Показать список задач");
//            System.out.println("3. Изменить задачу");
//            System.out.println("4. Удалить задачу" + "\n");
//
//            int command = scanner.nextInt();
//
//            if (command == 1) {
//                Scanner scan = new Scanner(System.in);
//                String sql = "insert into task (title, description, status) values (?, ?, ?)";
//                PreparedStatement preparedStatement = connection.prepareStatement(sql);
//                System.out.println("Введите название задачи: ");
//                String taskName = scan.nextLine();
//                preparedStatement.setString(1, taskName);
//                System.out.println("Введите описание задачи: ");
//                String taskDescription = scan.nextLine();
//                preparedStatement.setString(2, taskDescription);
//                System.out.println("Введите статус задачи: ");
//                String taskStatus = scan.nextLine();
//                preparedStatement.setString(3, taskStatus);
//                preparedStatement.executeUpdate();
//            } else if (command == 2) {
//                Statement statement = connection.createStatement();
//                System.out.println("Список задач");
//                String sql = "select * from task order by id ASC ";
//                ResultSet result = statement.executeQuery(sql);
//                while (result.next()) {
//                    System.out.println(result.getInt("id") + " " +
//                            result.getString("title") + " " +
//                            result.getString("status"));
//                }
//                System.out.println("\n");
//            } else if (command == 3) {
//                System.out.println("Выберите ID задачи которую хотите изменить");
//                PreparedStatement prepared = connection.prepareStatement("select * from task order by id = ?");
//                Scanner scanID = new Scanner(System.in);
//                int id = scanID.nextInt();
//                prepared.setInt(1, id);
//                if (prepared.executeQuery().next()) {
//                    System.out.println("Выберите что хотите изменить");
//                    System.out.println("1. Название");
//                    System.out.println("2. Описание");
//                    System.out.println("3. Статус");
//                    Scanner scan = new Scanner(System.in);
//                    int com = scan.nextInt();
//                    if (com == 1) {
//                        System.out.println("Введите новое название задачи");
//                        PreparedStatement preparedStatement = connection.prepareStatement("update task set title = ?");
//                        Scanner scanTitle = new Scanner(System.in);
//                        String strTitle = scanTitle.nextLine();
//                        preparedStatement.setString(1, strTitle);
//                        preparedStatement.executeUpdate();
//                    } else if (com == 2) {
//                        System.out.println("Введите новое описание задачи");
//                        PreparedStatement preparedStatement = connection.prepareStatement("update task set description = ?");
//                        Scanner scanDescription = new Scanner(System.in);
//                        String strDescription = scanDescription.nextLine();
//                        preparedStatement.setString(1, strDescription);
//                        preparedStatement.executeUpdate();
//                    } else if (com == 3) {
//                        System.out.println("Введите новое статус задачи");
//                        PreparedStatement preparedStatement = connection.prepareStatement("update task set status = ?");
//                        Scanner scanStatus = new Scanner(System.in);
//                        String strStatus = scanStatus.nextLine();
//                        preparedStatement.setString(1, strStatus);
//                        preparedStatement.executeUpdate();
//                    } else {
//                        System.err.println("Команда не расспознана!");
//                    }
//                }
//            } else if (command == 4) {
//                System.out.println("Пожалуйста введите ID которое нужно удалить");
//                PreparedStatement preparedStatement = connection.prepareStatement("delete from task where id = ?");
//                preparedStatement.setInt(1, scanner.nextInt());
//                preparedStatement.executeUpdate();
//            } else if (command == 5) {
//                System.exit(0);
//            } else {
//                System.err.println("Команда не расспознана!");
//            }
//        }
    }
}