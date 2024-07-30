package org.example.service;

import java.util.Scanner;


public class ContactRun {
    private ContactServiceImpl contactService;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу с контактами:");
        String filePath = scanner.nextLine();
        contactService = new ContactServiceImpl(filePath);

        while (true) {
            System.out.println("Выберите действие: (1) Показать все контакты, (2) Добавить контакт, (3) Удалить контакт, (4) Выйти");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    contactService.getAllContacts();
                    break;
                case "2":
                    System.out.println("Введите контакт в формате: Ф. И. О.;номер телефона;адрес электронной почты");
                    String contactInput = scanner.nextLine();
                    String[] parts = contactInput.split(";");
                    if (parts.length == 3) {
                        contactService.addContact(parts[0], parts[1], parts[2]);
                    } else {
                        System.out.println("Некорректный формат ввода");
                    }
                    break;
                case "3":
                    System.out.println("Введите email контакта для удаления:");
                    String email = scanner.nextLine();
                    contactService.removeContactByEmail(email);
                    break;
                case "4":
                    contactService.saveContactsToFile();
                    System.out.println("Контакты сохранены. Выход.");
                    return;
                default:
                    System.out.println("Некорректный выбор");
            }
        }
    }
}



