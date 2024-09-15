package faz2;

import com.company.UnexistingProfileException;
import com.company.WrongPasswordException;

import java.io.*;
import java.util.ArrayList;

public class Main1 {
    private static File studentsFile = new File("./../files/students") ;
    private static File teachersFile = new File("./../files/teachers") ;
    private static File classesFile = new File("./../files/classes") ;
    private static File adminFile = new File("./../files/admin") ;
    private static UnexistingProfileException unexistingProfileException = new UnexistingProfileException() ;
    private static WrongPasswordException wrongPasswordException = new WrongPasswordException() ;


    public static ArrayList<Student> getStudents (){
        ArrayList<Student> students = new ArrayList<>() ;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(studentsFile))){
            students = (ArrayList<Student>) in.readObject();
        } catch (IOException | ClassNotFoundException | NullPointerException e){
            e.printStackTrace() ;
        }

        return students ;
    }

    public static ArrayList<Teacher> getTeachers (){
        ArrayList<Teacher> teachers = new ArrayList<>() ;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(teachersFile))){
            teachers = (ArrayList<Teacher>) in.readObject() ;
        } catch (IOException | ClassNotFoundException | NullPointerException e){
            e.printStackTrace() ;
        }

        return teachers ;
    }

    public static ArrayList<Class> getClasses (){
        ArrayList<Class> classes = new ArrayList<>() ;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(classesFile))){
            classes = (ArrayList<Class>) in.readObject() ;
        } catch (IOException | ClassNotFoundException | NullPointerException e){
            e.printStackTrace() ;
        }

        return classes ;
    }

    public static Admin getAdmin (){
        Admin admin = null ;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(adminFile))){
            admin = (Admin) in.readObject();
        } catch (IOException | ClassNotFoundException | NullPointerException e){
            e.printStackTrace() ;
        }

        return admin ;
    }

    public static Student getStudentByUsername (String username) {
        Student student = null ;
        ArrayList<Student> students = getStudents() ;
        if (students != null) {
            for (Student std : students) {
                if (std.getUsername().equals(username)) {
                    student = std;
                }
            }
        }

        return student ;
    }

    public static Student getStudentByInfo (String username, String password) throws UnexistingProfileException, WrongPasswordException{
        Student student = null ;
        boolean doesExist = false ;
        boolean rightPassword = false ;
        ArrayList<Student> students = getStudents() ;
        if (students != null) {
            for (Student std : students) {
                if (std.getUsername().equals(username)) {
                    if (std.getPassword().equals(password)) {
                        student = std;
                        rightPassword = true;
                    }
                    doesExist = true;
                }
            }
        }
        if (!doesExist){
            throw unexistingProfileException ;
        }
        if (doesExist && !rightPassword){
            throw wrongPasswordException ;
        }

        return student ;
    }

    public static Teacher getTeacherByUserName (String username) {
        Teacher teacher = null ;
        ArrayList<Teacher> teachers = getTeachers() ;
        if (teachers != null) {
            for (Teacher thc : teachers) {
                if (thc.getUsername().equals(username)) {
                    teacher = thc;
                }
            }
        }

        return teacher ;
    }

    public static Teacher getTeacherByInfo (String username, String password) throws UnexistingProfileException, WrongPasswordException{
        Teacher teacher = null ;
        boolean doesExist = false ;
        boolean rightPassword = false ;
        ArrayList<Teacher> teachers = getTeachers() ;
        if (teachers != null) {
            for (Teacher thc : teachers) {
                if (thc.getUsername().equals(username)) {
                    if (thc.getPassword().equals(password)) {
                        teacher = thc;
                        rightPassword = true;
                    }
                    doesExist = true;
                }
            }
        }
        if (!doesExist){
            throw unexistingProfileException ;
        }
        if (doesExist && !rightPassword){
            throw wrongPasswordException ;
        }

        return teacher ;
    }

    public static Admin getAdminByInfo (String username, String password) throws UnexistingProfileException, WrongPasswordException{
        Admin admin = null ;
        Admin adm = getAdmin() ;
        boolean doesExist = false ;
        boolean rightPassword = false ;
        if (adm != null) {
            if (adm.getUsername().equals(username)) {
                if (adm.getPassword().equals(password)) {
                    admin = adm;
                    rightPassword = true;
                }
                doesExist = true;
            }
        }
        if (!doesExist){
            throw unexistingProfileException ;
        }
        if (doesExist && !rightPassword){
            throw wrongPasswordException ;
        }

        return admin ;
    }

    public static void addStudent (Student student){
        ArrayList<Student> students = getStudents() ;
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(studentsFile))){
            if (students == null){
                students = new ArrayList<>() ;
            }
            students.add(student) ;
            out.writeObject(students);
        } catch (IOException | NullPointerException e){
            e.printStackTrace() ;
        }
    }

    public static void addTeacher (Teacher teacher){
        ArrayList<Teacher> teachers = getTeachers() ;
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(teachersFile))){
            if (teachers == null){
                teachers = new ArrayList<>() ;
            }
            teachers.add(teacher) ;
            out.writeObject(teachers) ;
        } catch (IOException | NullPointerException e){
            e.printStackTrace() ;
        }
    }

    public static void addClass (Class class1){
        ArrayList<Class> classes = getClasses() ;
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(classesFile))){
            if (classes == null) {
                classes = new ArrayList<>();
            }
            classes.add(class1) ;
            out.writeObject(classes) ;
        } catch (IOException | NullPointerException e){
            e.printStackTrace() ;
        }
    }

    public static void addAdmin (Admin admin){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(adminFile))){
            out.writeObject(admin) ;
        } catch (IOException | NullPointerException e){
            e.printStackTrace() ;
        }
    }

    public static void removeClass (Class class1){
        ArrayList<Class> classes = getClasses() ;
        Class cls = null ;
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(classesFile))){
            if (classes != null) {
                for (Class class2 : classes) {
                    if (class2.equals(class1)) {
                        cls = class2;
                    }
                }
            }
            classes.remove(cls) ;
            out.writeObject(classes) ;
        } catch (IOException | NullPointerException e){
            e.printStackTrace() ;
        }
    }

    public static void removeStudent (Student student){
        ArrayList<Student> students = getStudents() ;
        Student std = null ;
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(studentsFile))){
            if (students != null) {
                for (Student student1 : students) {
                    if (student1.getUsername().equals(student.getUsername())) {
                        std = student1;
                    }
                }
            }
            students.remove(std) ;
            out.writeObject(students) ;
        } catch (IOException | NullPointerException e){
            e.printStackTrace() ;
        }
    }

    public static void removeTeacher (Teacher teacher){
        ArrayList<Teacher> teachers = getTeachers() ;
        Teacher thc = null ;
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(teachersFile))){
            if (teachers != null) {
                for (Teacher teacher1 : teachers) {
                    if (teacher1.getUsername().equals(teacher.getUsername())) {
                        thc = teacher1;
                    }
                }
            }
            teachers.remove(thc) ;
            out.writeObject(teachers);
        } catch (IOException | NullPointerException e){
            e.printStackTrace() ;
        }
    }

    public static void removeAdmin (){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(teachersFile))){
            out.writeObject(null) ;
        } catch (IOException | NullPointerException e){
            e.printStackTrace() ;
        }
    }





    public static void main(String[] args) {

    }
}
