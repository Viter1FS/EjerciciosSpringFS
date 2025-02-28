package com.Vitech.springFS.beans;

public class Person {

    private String DNI;
    private String name;
    private String first_surname;
    private String second_surname;
    private String full_name;
    private String birthdate;
    private String gender_sex;

    public Person(String DNI, String name, String first_surname, String second_surname, String birthdate, String gender_sex) {
        this.DNI = DNI;
        this.name = name;
        this.first_surname = first_surname;
        this.second_surname = second_surname;
        this.full_name = name + " " + first_surname + " " +second_surname;
        this.birthdate = birthdate;
        this.gender_sex = gender_sex;
    }

    /*
    private String name;
    private String first_surname;
    private String second_surname;
    private String full_name = name + " " + first_surname +" " + second_surname;
    private String birthdate;
    private String gender_sex;
    public Person(String name, String first_surname, String second_surname, String birthdate, String gender_sex) {
        this.name = name;
        this.first_surname = first_surname;
        this.second_surname = second_surname;
        this.full_name = name + " " + first_surname + " " +second_surname;
        this.birthdate = birthdate;
        this.gender_sex = gender_sex;
    }
    */

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_surname() {
        return first_surname;
    }

    public void setFirst_surname(String first_surname) {
        this.first_surname = first_surname;
    }

    public String getSecond_surname() {
        return second_surname;
    }

    public void setSecond_surname(String second_surname) {
        this.second_surname = second_surname;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender_sex() {
        return gender_sex;
    }

    public void setGender_sex(String gender_sex) {
        this.gender_sex = gender_sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "DNI='" + DNI + '\'' +
                ", name='" + name + '\'' +
                ", first_surname='" + first_surname + '\'' +
                ", second_surname='" + second_surname + '\'' +
                ", full_name='" + full_name + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", gender_sex='" + gender_sex + '\'' +
                '}';
    }
}
