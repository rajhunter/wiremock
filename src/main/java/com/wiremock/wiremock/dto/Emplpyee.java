package com.wiremock.wiremock.dto;

public class Emplpyee {
    private String name;
    private String city;
    private int age;

    public Emplpyee(String name, String city, int age, int sal, String gender, int rank) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.sal = sal;
        this.gender = gender;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Emplpyee{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", sal=" + sal +
                ", gender='" + gender + '\'' +
                ", rank=" + rank +
                '}';
    }

    private int sal;
    private String gender;

    public int age() {
        return age;
    }

    public int sal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public String gender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String city() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private int rank;

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int rank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


}
