package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class OnlineUsersTracker {
    static Map<String,Boolean> usersNameAndOnlineStatus = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в меню трекинга пользователей");
        while (true){
            showMenu();
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                        addUsers();
                        break;
                case "2":
                    deleteUser();
                    break;
                case "3":
                    changeUsersStatus();
                    break;
                case "4":
                    showUsersList();
                    break;
                case "0":
                    System.out.println("Выхожу из программы..... До свидания!");
                    return;
                default:
                    System.out.println("Неверный ввод! Попробуйте снова!");
            }
        }

    }
    public static void addUsers (){
        while (true){
            System.out.println("Введите имя пользователя (для выхода введите stop): ");
            String userName = scanner.nextLine();
            if (Objects.equals(userName, "stop")){
                break;
            }
            if (usersNameAndOnlineStatus.containsKey(userName)){
                System.out.println("Такой пользователь уже существует!");
            }
            else {
                usersNameAndOnlineStatus.put(userName,true);
            }
        }
    }
    public static void deleteUser (){
        while (true){
            System.out.println("Хотите удалить пользователя? Введите его имя (для выхода stop): ");
            String userName = scanner.nextLine();
            if (Objects.equals(userName, "stop")){
                break;
            }
            if (usersNameAndOnlineStatus.remove(userName) != null) {
                System.out.println("Пользователь удалён.");
            } else {
                System.out.println("Такой пользователь не найден.");
            }

        }

    }
    public static void changeUsersStatus (){
        while (true){
            System.out.println("Хотите изменить статус пользователя? Введите его имя (для выхода stop): ");
            String chooseUserToChangeStatus = scanner.nextLine();
            if (Objects.equals(chooseUserToChangeStatus,"stop")){
                break;
            } else if (usersNameAndOnlineStatus.containsKey(chooseUserToChangeStatus)) {
                System.out.println("Введите новый статус пользователя (true/false): ");
                Boolean changeUsersStatus = scanner.nextBoolean();
                scanner.nextLine();
                usersNameAndOnlineStatus.put(chooseUserToChangeStatus, changeUsersStatus);
            }
        }
    }
    public static void showUsersList(){
        System.out.println("\n==================");
        usersNameAndOnlineStatus.forEach((key,value) -> {
                if (value) {
                    System.out.println("User: " + key + " status: online");
                }
                else{
                    System.out.println("User: " + key + " status: offline");
                }
        });
        System.out.println("==================");
    }
    public static void showMenu() {
        System.out.println("\n========= МЕНЮ =========");
        System.out.println("1. Добавить пользователя");
        System.out.println("2. Удалить пользователя");
        System.out.println("3. Изменить статус пользователя");
        System.out.println("4. Показать всех пользователей");
        System.out.println("0. Выйти");
        System.out.print("Ваш выбор: ");
    }
}

