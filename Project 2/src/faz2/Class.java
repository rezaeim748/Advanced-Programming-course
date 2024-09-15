package faz2;

import java.io.Serializable;
import java.util.ArrayList;

public class Class implements Serializable {
    private String name;
    private int unitsNumber ;
    private int timePeriod ;
    private int capacity ;
    private Teacher teacher ;
    private ArrayList<Student> students ;

    public Class (Teacher teacher, String name, int unitsNumber, int timePeriod, int capacity){
        this.teacher = teacher ;
        this.name = name ;
        this.unitsNumber = unitsNumber ;
        this.timePeriod = timePeriod ;
        this.capacity = capacity ;
        students = new ArrayList<>() ;
    }

    public String getName() {
        return name;
    }

    public int getUnitsNumber() {
        return unitsNumber;
    }

    public int getTimePeriod() { return timePeriod; }

    public int getCapacity() {
        return capacity;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void removeStudent (Student student){ students.remove(student); }

    public void addStudent (Student student){ students.add(student); }

    public boolean equals (Class otherClass){
        if ((this.timePeriod == otherClass.timePeriod) && (this.getTeacher().getUsername().equals(otherClass.getTeacher().getUsername())) && (this.name.equals(otherClass.getName()))) {
            return true ;
        }
        return false ;
    }
}
