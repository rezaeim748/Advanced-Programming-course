package com.company;

import faz2.*;
import faz2.Class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyBoundsAdapter;
import java.io.Serializable;
import java.util.ArrayList;

public class AdminProfile implements Serializable {
    private JFrame adminFrame ;
    private JPanel column ;
    private JPanel personal ;
    private JPanel mealSchedule ;
    private JPanel lists ;
    private JPanel addMember ;
    private JPanel centerPanel ;
    private Admin admin ;


    public AdminProfile (Admin admin){
        this.admin = admin ;
        centerPanel = new JPanel() ;
        setAdminProfileInfo() ;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setVisibility (boolean visibility){
        adminFrame.setVisible(visibility) ;
    }


    public void setAdminProfileInfo (){
        adminFrame = new JFrame() ;
        adminFrame.setTitle("Admin profile") ;
        adminFrame.setSize(1000, 600) ;
        adminFrame.setLocation(100, 100) ;
        adminFrame.setLayout(new BorderLayout()) ;
        addAdminFrameComponents() ;
    }
    public void addAdminFrameComponents (){
        column = new JPanel() ;
        personal = new JPanel() ;
        mealSchedule = new JPanel() ;
        lists = new JPanel() ;
        addMember = new JPanel() ;

        addColumnComponents() ;
        addPersonalComponents() ;
        addMealScheduleComponents() ;
        addListsComponents() ;
        addAddMemberComponents() ;

        adminFrame.add(column, BorderLayout.EAST) ;
        adminFrame.add(centerPanel, BorderLayout.CENTER) ;
    }

    public void addColumnComponents (){
        column.setLayout(new GridLayout(4, 1)) ;
        JButton btn = new JButton("personal") ;
        addActionListenerToPersonalButton(btn) ;
        column.add(btn) ;

        btn = new JButton("mealSchedule") ;
        addActionListenerToMealScheduleButton(btn) ;
        column.add(btn) ;

        btn = new JButton("lists") ;
        addActionListenerToListsButton(btn) ;
        column.add(btn) ;

        btn = new JButton("addMember") ;
        addActionListenerToAddMemberButton(btn) ;
        column.add(btn) ;
    }

    public void addPersonalComponents (){
        personal.setLayout(new GridLayout(3, 2)) ;
        JLabel label = new JLabel("Username : ") ;
        personal.add(label) ;

        label = new JLabel(admin.getUsername()) ;
        personal.add(label) ;

        label = new JLabel("Password : ") ;
        personal.add(label) ;

        label = new JLabel(admin.getPassword()) ;
        personal.add(label) ;

        JButton btn = new JButton("Change password") ;
        personal.add(btn) ;
        addActionListenerToChangePasswordButton(btn) ;
    }

    public void addMealScheduleComponents (){
        mealSchedule.setLayout(new GridLayout(5, 3)) ;
        JLabel label = new JLabel("Saturday : ") ;
        mealSchedule.add(label) ;

        JTextField textField = new JTextField() ;
        mealSchedule.add(textField) ;

        JButton btn = new JButton("Save") ;
        mealSchedule.add(btn) ;
        addActionListenerToSaveMealButton(btn, textField, 0) ;

        label = new JLabel("Sunday : ") ;
        mealSchedule.add(label) ;

        textField = new JTextField() ;
        mealSchedule.add(textField) ;

        btn = new JButton("Save") ;
        mealSchedule.add(btn) ;
        addActionListenerToSaveMealButton(btn, textField, 1) ;

        label = new JLabel("Monday : ") ;
        mealSchedule.add(label) ;

        textField = new JTextField() ;
        mealSchedule.add(textField) ;

        btn = new JButton("Save") ;
        mealSchedule.add(btn) ;
        addActionListenerToSaveMealButton(btn, textField, 2) ;

        label = new JLabel("Tuesday : ") ;
        mealSchedule.add(label) ;

        textField = new JTextField() ;
        mealSchedule.add(textField) ;

        btn = new JButton("Save") ;
        mealSchedule.add(btn) ;
        addActionListenerToSaveMealButton(btn, textField, 3) ;

        label = new JLabel("wednesday : ") ;
        mealSchedule.add(label) ;

        textField = new JTextField() ;
        mealSchedule.add(textField) ;

        btn = new JButton("Save") ;
        mealSchedule.add(btn) ;
        addActionListenerToSaveMealButton(btn, textField, 4) ;
    }

    public void addListsComponents (){
        lists.setLayout(new GridLayout(1, 3)) ;
        JButton btn = new JButton("Students") ;
        lists.add(btn) ;
        addActionListenerToStudentsListButton(btn) ;

        btn = new JButton("Teachers") ;
        lists.add(btn) ;
        addActionListenerToTeachersListButton(btn) ;

        btn = new JButton("Classes") ;
        lists.add(btn) ;
        addActionListenerToClassesListButton(btn) ;
    }

    public void addAddMemberComponents (){
        addMember.setLayout(new GridLayout(2, 1)) ;
        JButton btn = new JButton("Student") ;
        addMember.add(btn) ;
        addActionListenerToAddStudentButton(btn) ;

        btn = new JButton("Teacher") ;
        addMember.add(btn) ;
        addActionListenerToAddTeacherButton(btn) ;
    }

    public void updateAdminFrame (JPanel panel){
        setVisibility(false) ;
        centerPanel = panel ;
        setAdminProfileInfo();
        setVisibility(true) ;
    }























    public void addActionListenerToPersonalButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAdminFrame(personal);
            }
        });
    }
    public void addActionListenerToMealScheduleButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAdminFrame(mealSchedule) ;
            }
        });
    }
    public void addActionListenerToListsButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAdminFrame(lists) ;
            }
        });
    }
    public void addActionListenerToAddMemberButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAdminFrame(addMember) ;
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
                            Main1.removeAdmin();
                            admin.setPassword(password) ;
                            Main1.addAdmin(admin) ;
                        }
                    }
                });
                passwordFrame.setVisible(true) ;

            }
        });
    }

    public void addActionListenerToSaveMealButton (JButton btn, JTextField textField, int index){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin admin = Main1.getAdmin() ;
                Main1.removeAdmin() ;
                admin.getMeals()[index] = textField.getText() ;
                Main1.addAdmin(admin) ;
            }
        });
    }

    public void addActionListenerToStudentsListButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame studentsListFrame = new JFrame();
                studentsListFrame.setTitle("Students list");
                studentsListFrame.setSize(800, 800);
                studentsListFrame.setLocation(100, 100);
                studentsListFrame.setLayout(new BorderLayout());
                JPanel panel = new JPanel();
                studentsListFrame.add(panel, BorderLayout.CENTER);
                panel.setLayout(new GridLayout(20, 2));
                ArrayList<JLabel> studentsNameLabels = new ArrayList<>() ;
                ArrayList<JButton> removeStudentButtons = new ArrayList<>() ;
                int size = 0 ;
                if (Main1.getStudents() != null){
                    size = Main1.getStudents().size() ;
                }
                for (int i = 0; i < size; i++){
                    studentsNameLabels.add(new JLabel()) ;
                    removeStudentButtons.add(new JButton()) ;
                }
                int j = 0 ;
                for (Student student : Main1.getStudents()){
                    studentsNameLabels.get(j).setText(student.getUsername()) ;
                    removeStudentButtons.get(j).setText("Remove student") ;
                    addActionListenerToRemoveStudentButton(removeStudentButtons.get(j), student) ;
                    j++ ;
                }
                for (int i = 0; i < size; i++){
                    panel.add(studentsNameLabels.get(i)) ;
                    panel.add(removeStudentButtons.get(i)) ;
                }
                studentsListFrame.setVisible(true) ;
            }
        });
    }

    public void addActionListenerToRemoveStudentButton (JButton btn, Student student){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Class class1 : student.getClasses().keySet()){
                    Main1.removeClass(class1) ;
                    class1.removeStudent(student) ;
                    Main1.addClass(class1) ;
                    Teacher teacher = class1.getTeacher() ;
                    Main1.removeTeacher(teacher) ;
                    teacher.removeClass(class1) ;
                    teacher.addClass(class1) ;
                    Main1.addTeacher(teacher) ;
                }
                Main1.removeStudent(student) ;
            }
        });
    }

    public void addActionListenerToTeachersListButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame teachersListFrame = new JFrame();
                teachersListFrame.setTitle("Teachers list");
                teachersListFrame.setSize(800, 800);
                teachersListFrame.setLocation(100, 100);
                teachersListFrame.setLayout(new BorderLayout());
                JPanel panel = new JPanel();
                teachersListFrame.add(panel, BorderLayout.CENTER);
                panel.setLayout(new GridLayout(20, 2));
                ArrayList<JLabel> teachersNameLabels = new ArrayList<>() ;
                ArrayList<JButton> removeTeacherButtons = new ArrayList<>() ;
                int size = 0 ;
                if (Main1.getTeachers() != null){
                    size = Main1.getTeachers().size() ;
                }
                for (int i = 0; i < size; i++) {
                    teachersNameLabels.add(new JLabel());
                    removeTeacherButtons.add(new JButton());
                }
                int j = 0 ;
                for (Teacher teacher : Main1.getTeachers()){
                    teachersNameLabels.get(j).setText(teacher.getUsername()) ;
                    removeTeacherButtons.get(j).setText("Remove teacher") ;
                    addActionListenerToRemoveTeacherButton(removeTeacherButtons.get(j), teacher) ;
                    j++ ;
                }
                for (int i = 0; i < size; i++){
                    panel.add(teachersNameLabels.get(i)) ;
                    panel.add(removeTeacherButtons.get(i)) ;
                }
                teachersListFrame.setVisible(true) ;
            }
        });
    }

    public void addActionListenerToRemoveTeacherButton (JButton btn, Teacher teacher){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Class class1 : teacher.getClasses()){
                    for (Student student : class1.getStudents()){
                        Main1.removeStudent(student) ;
                        student.removeClass(class1) ;
                        Main1.addStudent(student) ;
                    }
                    Main1.removeClass(class1) ;
                }
                Main1.removeTeacher(teacher) ;
            }
        });
    }

    public void addActionListenerToClassesListButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame classesListFrame = new JFrame();
                classesListFrame.setTitle("Classes list");
                classesListFrame.setSize(800, 800);
                classesListFrame.setLocation(100, 100);
                classesListFrame.setLayout(new BorderLayout());
                JPanel panel = new JPanel();
                classesListFrame.add(panel, BorderLayout.CENTER);
                panel.setLayout(new GridLayout(20, 2));
                ArrayList<JLabel> classesInfoLabels = new ArrayList<>() ;
                ArrayList<JButton> removeClassButtons = new ArrayList<>() ;
                for (int i = 0; i < Main1.getClasses().size(); i++){
                    classesInfoLabels.add(new JLabel()) ;
                    removeClassButtons.add(new JButton()) ;
                }
                int j = 0 ;
                for (Class class1 : Main1.getClasses()){
                    classesInfoLabels.get(j).setText(class1.getName() + "  " + class1.getTeacher().getUsername() + "  " + Main.IntToClassTime(class1.getTimePeriod())) ;
                    removeClassButtons.get(j).setText("Remove class") ;
                    addActionListenerToRemoveClassButton(removeClassButtons.get(j), class1) ;
                    j++ ;
                }
                for (int i = 0; i < Main1.getClasses().size(); i++){
                    panel.add(classesInfoLabels.get(i)) ;
                    panel.add(removeClassButtons.get(i)) ;
                }
                classesListFrame.setVisible(true) ;
            }
        });
    }

    public void addActionListenerToRemoveClassButton (JButton btn, Class class1){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Student student : class1.getStudents()){
                    System.out.println(student.getUnitsNumber()) ;
                    Main1.removeStudent(student) ;
                    student.removeClass(class1) ;
                    Main1.addStudent(student) ;
                    System.out.println(student.getUnitsNumber()) ;
                }
                Teacher teacher = class1.getTeacher() ;
                Main1.removeTeacher(teacher) ;
                teacher.removeClass(class1) ;
                Main1.addTeacher(teacher) ;
                Main1.removeClass(class1) ;
            }
        });
    }

    public void addActionListenerToAddStudentButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.gui.getStudentSignOutFrame().setVisible(true) ;
            }
        });
    }

    public void addActionListenerToAddTeacherButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.gui.getTeacherSignOutFrame().setVisible(true) ;
            }
        });
    }



}
