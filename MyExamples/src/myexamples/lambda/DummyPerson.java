/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.lambda;

import java.util.Date;

/**
 *
 * @author odzhara-ongom
 */
public class DummyPerson {
    private int id;
    private String name;
    private Date birthday;
    private int weight;
    private double salary;

    public DummyPerson() {
    }

    public DummyPerson(int id, String name, Date birthday, int weight, double salary) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.weight = weight;
        this.salary = salary;
    }
    
    public static String toString(DummyPerson p){
        if(p==null) return "null";
        return "id="+p.id+"; name='"+p.name+"'; birthday="+p.getBirthdayAsString()+
                "; "+p.getWeight()+" mm; "+p.getSalary()+" euro";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBirthdayAsString(){
        if (this.birthday==null) {
            return "null";
        }
        return this.birthday.toString();
    }
}
