/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac5;

import java.io.Serializable;

/**
 *
 * @author rcoem
 */
public class Student implements Serializable {
    String name;
    int sem,roll_no;
    double cgpa;

    public Student() {
    }

    public Student(String name, int sem, int roll_no, double cgpa) {
        this.name = name;
        this.sem = sem;
        this.roll_no = roll_no;
        this.cgpa = cgpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public int getSem() {
        return sem;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public double getCgpa() {
        return cgpa;
    }
    
}
