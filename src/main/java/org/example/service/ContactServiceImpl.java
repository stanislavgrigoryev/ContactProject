package org.example.service;

import org.example.model.Contact;

import java.io.*;
import java.util.*;

public class ContactServiceImpl implements ContactService {
    private List<Contact> contactList = new ArrayList<>();
    private String path;

    public ContactServiceImpl(String path) {
        this.path = path;
        initContacts();
    }


    public void getAllContacts() {
        contactList.forEach(System.out::println);
    }

    @Override
    public void addContact(String fullName, String phoneNumber, String email) {
        Contact contact = new Contact(fullName, phoneNumber, email);
        contactList.add(contact);
    }

    @Override
    public void removeContactByEmail(String email) {
        Contact contactToRemove = contactList.stream()
                .filter(contact -> contact.getEmail() != null && contact.getEmail().equals(email))
                .findFirst()
                .orElse(null);

        if (contactToRemove != null) {
            contactList.remove(contactToRemove);
            System.out.println("Contact removed: " + email);
        } else {
            System.out.println("Contact not found!");
        }
    }

    @Override
    public void initContacts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    contactList.add(new Contact(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка загурзки контактов: " + e.getMessage());
        }

    }

    @Override
    public void saveContactsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Contact contact : contactList) {
                writer.write(contact.getFullName() + ";" + contact.getPhoneNumber() + ";" + contact.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка сохранения контактов: " + e.getMessage());
        }
    }
}
