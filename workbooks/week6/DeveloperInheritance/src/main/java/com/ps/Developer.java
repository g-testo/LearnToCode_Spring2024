package com.ps;

public class Developer{
    private String name;
    private int age;
    private float salary;

    public Developer(String name, int age, float salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    protected String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
