package com.virtusa.FieldTechnician.entity;

 


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

 

@Entity
public class FieldTechnician {

 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private int mobileNo;

 


    public FieldTechnician(int id, String name, int age, int mobileNo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobileNo = mobileNo;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getMobileNo() {
        return mobileNo;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

 

    

}