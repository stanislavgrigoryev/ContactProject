package org.example.model;


import java.util.Objects;

public class Contact {
    private String fullName;
    private String phoneNumber;
    private String email;

    public Contact(String fullName, String phoneNumber, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Contact(String fullName, String phoneNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact contact)) return false;
        return Objects.equals(fullName, contact.fullName) && Objects.equals(phoneNumber, contact.phoneNumber) && Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, phoneNumber, email);
    }

    @Override
    public String toString() {
        return fullName + '|' + email + '|' + phoneNumber;
    }
}
