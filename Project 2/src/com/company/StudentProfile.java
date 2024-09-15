package com.company;

import faz2.Class;
import faz2.Main1;
import faz2.Student;
import faz2.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.*;

public class StudentProfile implements Serializable {
    private JFrame studentFrame ;
    private JPanel column ;
    private JPanel personal ;
    private JPanel classes ;
    private JPanel account ;
    private JPanel mealReserve ;
    private JPanel classChoosing ;
    private JPanel centerPanel ;
    private Student student ;


    public StudentProfile (Student student){
        this.student = student ;
        centerPanel = new JPanel() ;
        setStudentProfileInfo() ;

    }

    public Student getStudent() {
        return student;
    }

    public void setVisibility (boolean visibility){
        studentFrame.setVisible(visibility) ;
    }

    public void setStudentProfileInfo (){
        studentFrame = new JFrame() ;
        studentFrame.setTitle("Student profile") ;
        studentFrame.setSize(1000, 600) ;
        studentFrame.setLocation(100, 100) ;
        studentFrame.setLayout(new BorderLayout()) ;
        addStudentFrameComponents() ;
    }
    public void addStudentFrameComponents (){
        column = new JPanel() ;
        classes = new JPanel() ;
        personal = new JPanel() ;
        account = new JPanel() ;
        mealReserve = new JPanel() ;
        classChoosing = new JPanel() ;

        addColumnComponents() ;
        addPersonalComponents() ;
        addClassesComponents() ;
        addAccountComponents() ;
        addMealReserveComponents() ;
        addClassChoosingComponents() ;

        studentFrame.add(column, BorderLayout.EAST) ;
        studentFrame.add(centerPanel, BorderLayout.CENTER) ;
    }

    public void addColumnComponents (){
        column.setLayout(new GridLayout(5, 1)) ;
        JButton btn = new JButton("personal") ;
        addActionListenerToPersonalButton(btn);
        column.add(btn) ;

        btn = new JButton("classes") ;
        addActionListenerToClassesButton(btn);
        column.add(btn) ;

        btn = new JButton("account") ;
        addActionListenerToAccountButton(btn);
        column.add(btn) ;

        btn = new JButton("mealReserve") ;
        addActionListenerToMealReserveButton(btn);
        column.add(btn) ;

        btn = new JButton("classChoosing") ;
        addActionListenerToClassChoosingButton(btn);
        column.add(btn) ;
    }

    public void addPersonalComponents (){
        personal.setLayout(new GridLayout(3, 2)) ;
        JLabel label = new JLabel("Username : ") ;
        personal.add(label) ;

        label = new JLabel(student.getUsername()) ;
        personal.add(label) ;

        label = new JLabel("Password : ") ;
        personal.add(label) ;

        label = new JLabel(student.getPassword()) ;
        personal.add(label) ;

        JButton btn = new JButton("Change password") ;
        personal.add(btn) ;
        addActionListenerToChangePasswordButton(btn) ;
    }

    public void addClassesComponents (){
        classes.setLayout(new GridLayout(20, 2)) ;
        ArrayList<JLabel> labels = new ArrayList<>() ;
        HashMap<Class,Integer> classHashMap = student.getClasses() ;
        Set<Class> classHashSet = classHashMap.keySet() ;
        for (int i = 0; i < classHashMap.size() * 2; i++){
            labels.add(new JLabel()) ;
        }
        int i = 0 ;
        for (Class class1 : classHashSet){
            labels.get(i * 2).setText("Class name : " + class1.getName());
            labels.get(i * 2 + 1).setText("Score : " + classHashMap.get(class1)) ;
            i++ ;
        }
        for (JLabel jLabel : labels){
            classes.add(jLabel) ;
        }
    }

    public void addAccountComponents (){
        account.setLayout(new GridLayout(3, 3)) ;
        JLabel label = new JLabel("Card number : ") ;
        account.add(label) ;

        label = new JLabel(student.getCardNumber()) ;
        account.add(label) ;

        JButton btn = new JButton("Change card number") ;
        account.add(btn) ;
        addActionListenerToChangeCardNumberButton(btn) ;

        label = new JLabel("Password : ") ;
        account.add(label) ;

        label = new JLabel(student.getCardPassword()) ;
        account.add(label) ;

        btn = new JButton("Change password") ;
        account.add(btn) ;
        addActionListenerToChangeCardPasswordButton(btn);

        label = new JLabel("Balance : ") ;
        account.add(label) ;

        label = new JLabel("" + student.getCardBalance()) ;
        account.add(label) ;

        btn = new JButton("Increase balance") ;
        account.add(btn) ;
        addActionListenerToIncreaseBalanceButton(btn) ;
    }

    public void addMealReserveComponents (){
        ArrayList<JLabel> isReserved = new ArrayList<>() ;
        for (int i = 0; i < 5; i++){
            isReserved.add(new JLabel()) ;
            if (student.getReservedDays()[i]){
                isReserved.get(i).setText("Reserved") ;
            }
            else {
                isReserved.get(i).setText("Not reserved") ;
            }
        }

        String[] meals = Main1.getAdmin().getMeals() ;
        mealReserve.setLayout(new GridLayout(5, 5)) ;
        JLabel label = new JLabel("Saturday : ") ;
        mealReserve.add(label) ;

        label = new JLabel(meals[0]) ;
        mealReserve.add(label) ;

        JButton btn = new JButton("Reserve") ;
        mealReserve.add(btn) ;
        addActionListenerToMealReserveReserveButton(btn, 0);

        btn = new JButton("Cancel") ;
        mealReserve.add(btn) ;
        addActionListenerToMealReserveCancelButton(btn, 0);

        mealReserve.add(isReserved.get(0)) ;

        label = new JLabel("Sunday : ") ;
        mealReserve.add(label) ;

        label = new JLabel(meals[1]) ;
        mealReserve.add(label) ;

        btn = new JButton("Reserve") ;
        mealReserve.add(btn) ;
        addActionListenerToMealReserveReserveButton(btn, 1);

        btn = new JButton("Cancel") ;
        mealReserve.add(btn) ;
        addActionListenerToMealReserveCancelButton(btn, 1);

        mealReserve.add(isReserved.get(1)) ;

        label = new JLabel("Monday : ") ;
        mealReserve.add(label) ;

        label = new JLabel(meals[2]) ;
        mealReserve.add(label) ;

        btn = new JButton("Reserve") ;
        mealReserve.add(btn) ;
        addActionListenerToMealReserveReserveButton(btn, 2);

        btn = new JButton("Cancel") ;
        mealReserve.add(btn) ;
        addActionListenerToMealReserveCancelButton(btn, 2);

        mealReserve.add(isReserved.get(2)) ;

        label = new JLabel("Tuesday : ") ;
        mealReserve.add(label) ;

        label = new JLabel(meals[3]) ;
        mealReserve.add(label) ;

        btn = new JButton("Reserve") ;
        mealReserve.add(btn) ;
        addActionListenerToMealReserveReserveButton(btn, 3);

        btn = new JButton("Cancel") ;
        mealReserve.add(btn) ;
        addActionListenerToMealReserveCancelButton(btn, 3);

        mealReserve.add(isReserved.get(3)) ;

        label = new JLabel("wednesday : ") ;
        mealReserve.add(label) ;

        label = new JLabel(meals[4]) ;
        mealReserve.add(label) ;

        btn = new JButton("Reserve") ;
        mealReserve.add(btn) ;
        addActionListenerToMealReserveReserveButton(btn, 4);

        btn = new JButton("Cancel") ;
        mealReserve.add(btn) ;
        addActionListenerToMealReserveCancelButton(btn, 4);

        mealReserve.add(isReserved.get(4)) ;
    }

    public void addClassChoosingComponents (){
        classChoosing.setLayout(new GridLayout(2, 2)) ;
        JLabel label = new JLabel("Units number : ") ;
        classChoosing.add(label) ;

        label = new JLabel("" + student.getUnitsNumber()) ;
        classChoosing.add(label) ;

        JButton btn = new JButton("Your classes") ;
        classChoosing.add(btn) ;
        addActionListenerToYourClassesButton(btn) ;

        btn = new JButton("Choose new class") ;
        classChoosing.add(btn) ;
        addActionListenerToChooseNewClassButton(btn) ;
    }

    public void updateStudentFrame (JPanel panel){
        setVisibility(false) ;
        centerPanel = panel ;
        setStudentProfileInfo();
        setVisibility(true) ;
    }

























    public void addActionListenerToPersonalButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudentFrame(personal) ;
            }
        });
    }
    public void addActionListenerToClassesButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudentFrame(classes) ;
            }
        });
    }
    public void addActionListenerToAccountButton (JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudentFrame(account) ;
            }
        });
    }
    public void addActionListenerToMealReserveButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudentFrame(mealReserve) ;
            }
        });
    }
    public void addActionListenerToClassChoosingButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudentFrame(classChoosing) ;
            }
        });
    }

    public void addActionListenerToChangePasswordButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame passwordFrame = new JFrame() ;
                passwordFrame.setTitle("Change card password") ;
                passwordFrame.setSize(400, 200) ;
                passwordFrame.setLocation(300, 300) ;
                passwordFrame.setLayout(new BorderLayout()) ;
                JPanel panel = new JPanel() ;
                passwordFrame.add(panel, BorderLayout.CENTER) ;
                panel.setLayout(new GridLayout(2, 2)) ;
                JLabel label = new JLabel("New password : ") ;
                panel.add(label) ;
                JTextField txt = new JTextField() ;
                panel.add(txt) ;
                JButton btn = new JButton("Save") ;
                panel.add(btn) ;
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String password = txt.getText() ;
                        if (password.length() < 8){
                            JFrame frame = new JFrame() ;
                            JOptionPane.showMessageDialog(frame, "Password must have at least 8 digits");
                        }
                        else {
                            passwordFrame.setVisible(false) ;
                            Main1.removeStudent(student) ;
                            student.setPassword(password) ;
                            Main1.addStudent(student) ;
                        }
                    }
                });
                passwordFrame.setVisible(true) ;

            }
        });
    }

    public void addActionListenerToChangeCardNumberButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame cardNumberFrame = new JFrame() ;
                cardNumberFrame.setTitle("Change card number") ;
                cardNumberFrame.setSize(400, 200) ;
                cardNumberFrame.setLocation(300, 300) ;
                cardNumberFrame.setLayout(new BorderLayout()) ;
                JPanel panel = new JPanel() ;
                cardNumberFrame.add(panel, BorderLayout.CENTER) ;
                panel.setLayout(new GridLayout(2, 2)) ;
                JLabel label = new JLabel("New card number : ") ;
                panel.add(label) ;
                JTextField txt = new JTextField() ;
                panel.add(txt) ;
                JButton btn = new JButton("Save") ;
                panel.add(btn) ;
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String cardNumber = txt.getText() ;
                        cardNumberFrame.setVisible(false) ;
                        Main1.removeStudent(student) ;
                        student.setCardNumber(cardNumber) ;
                        Main1.addStudent(student) ;

                    }
                });
                cardNumberFrame.setVisible(true) ;
            }
        });
    }

    public void addActionListenerToChangeCardPasswordButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame passwordFrame = new JFrame() ;
                passwordFrame.setTitle("Change card password") ;
                passwordFrame.setSize(400, 200) ;
                passwordFrame.setLocation(300, 300) ;
                passwordFrame.setLayout(new BorderLayout()) ;
                JPanel panel = new JPanel() ;
                passwordFrame.add(panel, BorderLayout.CENTER) ;
                panel.setLayout(new GridLayout(2, 2)) ;
                JLabel label = new JLabel("New card password : ") ;
                panel.add(label) ;
                JTextField txt = new JTextField() ;
                panel.add(txt) ;
                JButton btn = new JButton("Save") ;
                panel.add(btn) ;
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String cardPassword = txt.getText() ;
                        if (cardPassword.length() < 8){
                            JFrame frame = new JFrame() ;
                            JOptionPane.showMessageDialog(frame, "Password must have at least 8 digits");
                        }
                        else {
                            passwordFrame.setVisible(false) ;
                            Main1.removeStudent(student) ;
                            student.setCardPassword(cardPassword);
                            Main1.addStudent(student) ;
                        }
                    }
                });
                passwordFrame.setVisible(true) ;

            }
        });
    }

    public void addActionListenerToIncreaseBalanceButton (JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame increaseBalanceFrame = new JFrame();
                increaseBalanceFrame.setTitle("Increase balance");
                increaseBalanceFrame.setSize(400, 200);
                increaseBalanceFrame.setLocation(300, 300);
                increaseBalanceFrame.setLayout(new BorderLayout());
                JPanel panel = new JPanel();
                increaseBalanceFrame.add(panel, BorderLayout.CENTER);
                panel.setLayout(new GridLayout(2, 2));
                JLabel label = new JLabel("The amount of increasing : ");
                panel.add(label);
                JTextField txt = new JTextField();
                panel.add(txt);
                JButton btn = new JButton("Save");
                panel.add(btn);
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String increasingAmount = txt.getText();
                        increaseBalanceFrame.setVisible(false);
                        Main1.removeStudent(student);
                        student.increaseCardBalance(Main.myParseInt(increasingAmount)) ;
                        Main1.addStudent(student);

                    }
                });
                increaseBalanceFrame.setVisible(true);
            }
        });
    }

    public void addActionListenerToMealReserveReserveButton (JButton btn, int index){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean[] reservedDays = student.getReservedDays() ;
                int cardBalance = student.getCardBalance() ;
                if (!reservedDays[index]){
                    if (cardBalance >= 2000){
                        reservedDays[index] = true ;
                        Main1.removeStudent(student);
                        student.setReservedDays(reservedDays);
                        student.increaseCardBalance(-2000) ;
                        Main1.addStudent(student);
                    }
                    else {
                        JFrame frame = new JFrame() ;
                        JOptionPane.showMessageDialog(frame, "Your card balance isn't enough");
                    }
                }
            }
        });
    }

    public void addActionListenerToMealReserveCancelButton (JButton btn, int index){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean[] reservedDays = student.getReservedDays() ;
                if (reservedDays[index]){
                    reservedDays[index] = false ;
                    Main1.removeStudent(student);
                    student.setReservedDays(reservedDays);
                    student.increaseCardBalance(2000) ;
                    Main1.addStudent(student);
                }
            }
        });
    }

    public void addActionListenerToYourClassesButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame yourClassesFrame = new JFrame();
                yourClassesFrame.setTitle("Your classes");
                yourClassesFrame.setSize(800, 800);
                yourClassesFrame.setLocation(100, 100);
                yourClassesFrame.setLayout(new BorderLayout());
                JPanel panel = new JPanel();
                yourClassesFrame.add(panel, BorderLayout.CENTER);
                panel.setLayout(new GridLayout(20, 2));
                ArrayList<JLabel> labels = new ArrayList<>() ;
                ArrayList<JButton> buttons = new ArrayList<>() ;
                for (int i = 0; i < student.getClasses().size(); i++){
                    labels.add(new JLabel()) ;
                    buttons.add(new JButton()) ;
                }
                Set<Class> classHashSet = student.getClasses().keySet() ;
                int i = 0 ;
                for (Class class1 : classHashSet){
                    labels.get(i).setText("Class name : " + class1.getName()) ;
                    buttons.get(i).setText("Remove class ") ;
                    addActionListenerToRemoveClassButton(buttons.get(i), class1) ;
                    i++ ;
                }
                for (int j = 0; j < student.getClasses().size(); j++){
                    panel.add(labels.get(j)) ;
                    panel.add(buttons.get(j)) ;
                }
                yourClassesFrame.setVisible(true) ;
            }
        });
    }

    public void addActionListenerToRemoveClassButton (JButton btn, Class class1){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main1.removeStudent(student);
                HashMap<Class,Integer> classesHashmap = student.getClasses() ;
                classesHashmap.remove(class1) ;
                student.setClasses(classesHashmap) ;
                student.setUnitsNumber(student.getUnitsNumber() - class1.getUnitsNumber()) ;
                Main1.addStudent(student);
                Main1.removeClass(class1) ;
                class1.removeStudent(student) ;
                Main1.addClass(class1) ;
                Teacher teacher = class1.getTeacher() ;
                Main1.removeTeacher(teacher) ;
                teacher.removeClass(class1) ;
                teacher.addClass(class1) ;
                Main1.addTeacher(teacher) ;
            }
        });
    }

    public void addActionListenerToChooseNewClassButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame chooseNewClassFrame = new JFrame() ;
                chooseNewClassFrame.setTitle("Classes to choose") ;
                chooseNewClassFrame.setSize(800, 800) ;
                chooseNewClassFrame.setLocation(100, 100) ;
                chooseNewClassFrame.setLayout(new BorderLayout()) ;
                JPanel panel = new JPanel() ;
                chooseNewClassFrame.add(panel, BorderLayout.CENTER) ;
                panel.setLayout(new GridLayout(20, 4)) ;
                ArrayList<Class> allClasses = Main1.getClasses() ;
                Set<Class> studentsPresentClasses = student.getClasses().keySet() ;
                ArrayList<Class> classesToChoose = new ArrayList<>() ;
                for (Class class1 : allClasses){
                    boolean isAllowed = true ;
                    for (Class class2 : studentsPresentClasses){
                        if (class1.getTimePeriod() == class2.getTimePeriod()){
                            isAllowed = false ;
                            break ;
                        }
                    }
                    if (isAllowed){
                        classesToChoose.add(class1) ;
                    }
                }

                ArrayList<JLabel> classNameLabels = new ArrayList<>() ;
                ArrayList<JLabel> classTeacherLabels = new ArrayList<>() ;
                ArrayList<JLabel> classTimeLabels = new ArrayList<>() ;
                ArrayList<JButton> addingClassButtons = new ArrayList<>() ;
                for (int i = 0; i < classesToChoose.size(); i++){
                    classNameLabels.add(new JLabel()) ;
                    classTeacherLabels.add(new JLabel()) ;
                    classTimeLabels.add(new JLabel()) ;
                    addingClassButtons.add(new JButton()) ;
                }
                int j = 0 ;
                for (Class class1 : classesToChoose){
                    classNameLabels.get(j).setText("Class name : " + class1.getName()) ;
                    classTeacherLabels.get(j).setText("Teacher : " + class1.getTeacher().getUsername()) ;
                    classTimeLabels.get(j).setText(Main.IntToClassTime(class1.getTimePeriod())) ;
                    addingClassButtons.get(j).setText("Add class") ;
                    addActionListenerToAddClassButton(addingClassButtons.get(j), class1, chooseNewClassFrame) ;
                    j++ ;
                }
                for (int i = 0; i < classesToChoose.size(); i++){
                    panel.add(classNameLabels.get(i)) ;
                    panel.add(classTeacherLabels.get(i)) ;
                    panel.add(classTimeLabels.get(i)) ;
                    panel.add(addingClassButtons.get(i)) ;
                }
                chooseNewClassFrame.setVisible(true) ;
            }
        });
    }

    public void addActionListenerToAddClassButton (JButton btn, Class class1, JFrame chooseNewClassFrame){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame() ;
                if (class1.getCapacity() == class1.getStudents().size()){
                    JOptionPane.showMessageDialog(frame, "Class is full") ;
                }
                else if ((student.getAverageScore() < 17) && (student.getUnitsNumber() + class1.getUnitsNumber() > 20)){
                    JOptionPane.showMessageDialog(frame, "Your average score is less than 17 and you cant have more than 20 units");
                }
                else if ((student.getAverageScore() >= 17) && (student.getUnitsNumber() + class1.getUnitsNumber() > 24)){
                    JOptionPane.showMessageDialog(frame, "You cant have more than 24 units");
                }
                else {
                    Main1.removeClass(class1) ;
                    class1.addStudent(student) ;
                    Main1.addClass(class1) ;
                    Main1.removeStudent(student) ;
                    student.addClass(class1) ;
                    Main1.addStudent(student) ;
                    Teacher teacher = class1.getTeacher() ;
                    Main1.removeTeacher(teacher) ;
                    teacher.removeClass(class1) ;
                    teacher.addClass(class1) ;
                    Main1.addTeacher(teacher) ;
                    chooseNewClassFrame.setVisible(false) ;
                    JOptionPane.showMessageDialog(frame, "Your chosen class was added successfully") ;
                }
            }
        });
    }



}
