package org.example.service;

public interface ContactService {
    void getAllContacts();
    void addContact(String fullName, String phoneNumber, String email);
    void removeContactByEmail(String email);
    void initContacts();
    void saveContactsToFile();

}
