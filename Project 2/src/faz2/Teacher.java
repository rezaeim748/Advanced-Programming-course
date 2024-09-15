package faz2;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

import static faz2.Main1.addClass;
import static faz2.Main1.removeClass;

public class Teacher implements Serializable {
    private String username ;
    private String password ;
    private ArrayList<Class> classes ;

    public Teacher (String username, String password){
        this.username = username ;
        this.password = password ;
        classes = new ArrayList<>() ;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void setPassword (String password){
        this.password = password ;
    }

    public void addClass (Class class1){
        classes.add(class1) ;
    }

    public void removeClass (Class class1){
        Class class2 = null ;
        for (Class class3 : classes){
            if (class3.equals(class1)){
                class2 = class3 ;
            }
        }
        classes.remove(class2) ;
    }

    public boolean isAddingClassAllowed (Class class1){
        boolean isAllowed = true ;
        ArrayList<Class> AllClasses = Main1.getClasses() ;
        for (Class otherClass : AllClasses) {
            if (otherClass.getTeacher().equals(this) && class1.getTimePeriod() == otherClass.getTimePeriod()) {
                isAllowed = false;
            }
        }

        return isAllowed ;
    }

    public boolean equals (Teacher teacher){
        if (this.username.equals(teacher.getUsername())){
            return true ;
        }
        return false ;
    }




}
