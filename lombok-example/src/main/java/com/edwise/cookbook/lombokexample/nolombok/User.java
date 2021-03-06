package com.edwise.cookbook.lombokexample.nolombok;

import java.time.LocalDate;

public class User {

    private long id;
    private String name;
    private String surname;
    private String phone;
    private LocalDate birthday;
    private int type;

    public User() {
    }

    public User(long id, String name, String surname, String phone, LocalDate birthday, int type) {
        validateName(name);
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.birthday = birthday;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        validateName(name);
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public User setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public int getType() {
        return type;
    }

    public User setType(int type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User userLombok = (User) o;

        return id == userLombok.id && type == userLombok.type &&
                !(birthday != null ? !birthday.equals(userLombok.birthday) : userLombok.birthday != null) &&
                !(name != null ? !name.equals(userLombok.name) : userLombok.name != null) &&
                !(phone != null ? !phone.equals(userLombok.phone) : userLombok.phone != null) &&
                !(surname != null ? !surname.equals(userLombok.surname) : userLombok.surname != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + type;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", type=" + type +
                '}';
    }

    private void validateName(String name) {
        if (name == null) {
            throw new NullPointerException("The name is null!");
        }
    }
}
