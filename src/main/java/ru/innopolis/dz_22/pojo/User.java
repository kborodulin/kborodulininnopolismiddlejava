package ru.innopolis.dz_22.pojo;


import java.util.Objects;

public class User {
    private int id;
    private String login;
    private String password;
    private String surname;
    private String name;
    private String patronymic;
    private String email;
    private String phone;

    private User(Builder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.password = builder.password;
        this.surname = builder.surname;
        this.name = builder.name;
        this.patronymic = builder.patronymic;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    public static class Builder {
        private int id;
        private String login;
        private String password;
        private String surname;
        private String name;
        private String patronymic;
        private String email;
        private String phone;

        public Builder(String login, String password, String surname, String name, String patronymic) {
            this.login = login;
            this.password = password;
            this.surname = surname;
            this.name = name;
            this.patronymic = patronymic;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(name, user.name) &&
                Objects.equals(patronymic, user.patronymic) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, surname, name, patronymic, email, phone);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}