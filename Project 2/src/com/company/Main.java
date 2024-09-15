package com.company;
import faz2.* ;
import faz2.Class;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static GUI gui ;

    public static int classTimeToInt (String str){
        String[] temp = str.split(" ", 2) ;
        int i = 0 ;
        switch (temp[0]){
            case "Saturday" :
                i = 1 ;
                break ;
            case "Sunday" :
                i = 2 ;
                break ;
            case "Monday" :
                i = 3 ;
                break ;
            case "Tuesday" :
                i = 4 ;
                break ;
            case "Wednesday" :
                i = 5 ;
                break ;
            default :
                break ;
        }
        int j = 0 ;
        switch (temp[1]){
            case "8-10" :
                j = 1 ;
                break ;
            case "10-12" :
                j = 2 ;
                break ;
            case "14-16" :
                j = 3 ;
                break ;
            default :
                break ;
        }
        return (i * 10 + j) ;
    }

    public static String IntToClassTime (int number){
        String[] days = new String[5] ;
        days[0] = "Saturday" ;
        days[1] = "Sunday" ;
        days[2] = "Monday" ;
        days[3] = "Tuesday" ;
        days[4] = "Wednesday" ;
        String[] hours = new String[3] ;
        hours[0] = "8-10" ;
        hours[1] = "10-12" ;
        hours[2] = "14-16" ;

        String str = "" ;
        str += days[(number / 10) - 1] ;
        str += " " ;
        str += hours[(number % 10) - 1] ;

        return str ;
    }

    public static int myParseInt (String s){
        int number = 0 ;
        try {
            number = Integer.parseInt(s) ;
        } catch (NumberFormatException e){
            number = 0 ;
        }
        return number ;
    }


    public static void main(String[] args) {
        Main1.addAdmin(new Admin("ali", "12345678"));
        Class class1 = new Class(new Teacher("0", "0"), "0", 0, 0, 0) ;
        Main1.addClass(class1) ;
        Main1.removeClass(class1) ;


        if (Main1.getStudents() != null) {
            for (Student student : Main1.getStudents()) {
                System.out.println(student.getUsername());
            }
        }
        if (Main1.getTeachers() != null) {
            for (Teacher teacher : Main1.getTeachers()) {
                System.out.println(teacher.getUsername());
            }
        }
        if (Main1.getClasses() != null) {
            for (Class class2 : Main1.getClasses()) {
                System.out.println(class2.getName());
            }
        }


        gui = new GUI() ;




    }

}
