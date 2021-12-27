package com.company;

public abstract class Person implements Cloneable, Comparable<Person> {
    private String id;
    private String name;
    private String departement;
    private String address;
    private String phone;
    private String age;
    private String gender;

    public Person() {

    }

    public Person(String id, String name, String departement, String address, String phone, String age, String gender) {
        this.id = id;
        this.name = name;
        this.departement = departement;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartement() {
        return this.departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(Integer.parseInt(this.id), Integer.parseInt(o.getId()));

    }
}
