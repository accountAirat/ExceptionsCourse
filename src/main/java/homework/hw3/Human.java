package homework.hw3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Human {
    private String surname;
    private String name;
    private String fatherName;
    private Date birthday;
    private Long phone;

    private Sex sex;
    private final int size = 6;

    public String getSurname() {
        return surname;
    }

    public Boolean setSurname(String surname) {
        if (this.surname == null) {
            this.surname = surname;
            return true;
        } else return false;
    }

    public String getName() {
        return name;
    }

    public Boolean setName(String name) {
        if (this.name == null) {
            this.name = name;
            return true;
        } else return false;
    }

    public String getFatherName() {
        return fatherName;
    }

    public Boolean setFatherName(String fatherName) {
        if (this.fatherName == null) {
            this.fatherName = fatherName;
            return true;
        } else return false;
    }

    public String getBirthday() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(birthday);
    }

    public Boolean setBirthday(String value) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        try {
            this.birthday = dateFormat.parse(value);
            return true;
        } catch (ParseException e) {
            return false;
        }

    }

    public Long getPhone() {
        return phone;
    }

    public Boolean setPhone(String value) {
        try {
            if (value.length() == 11) {
                this.phone = Long.parseLong(value);
                return true;
            }
            return false;
        } catch (Exception e) {// Почему-то не принимает IOException и ParseException.
            return false;
        }

    }

    public Sex getSex() {
        return sex;
    }

    public Boolean setSex(String value) {
        if (value.equals("f")) {
            this.sex = Sex.f;
            return true;
        } else if (value.equals("m")) {
            this.sex = Sex.m;
            return true;
        } else return false;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Human{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", birthday=" + birthday +
                ", phone=" + phone +
                ", sex=" + sex +
                '}';
    }

    public enum Sex {
        f, m
    }
}
