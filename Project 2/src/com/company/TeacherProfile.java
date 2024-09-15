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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static com.company.Main.IntToClassTime;
import static com.company.Main.classTimeToInt;

public class TeacherProfile implements Serializable {
    private JFrame teacherFrame ;
    private JPanel column ;
    private JPanel personal ;
    private JPanel classes ;
    private JPanel addClass ;
    private JPanel centerPanel ;
    private Teacher teacher ;

    public TeacherProfile (Teacher teacher){
        this.teacher = teacher ;
        centerPanel = new JPanel() ;
        setTeacherProfileInfo() ;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setVisibility (boolean visibility){
        teacherFrame.setVisible(visibility) ;
    }

    public void setTeacherProfileInfo (){
        teacherFrame = new JFrame() ;
        teacherFrame.setTitle("Teacher profile") ;
        teacherFrame.setSize(1000, 600) ;
        teacherFrame.setLocation(100, 100) ;
        teacherFrame.setLayout(new BorderLayout()) ;
        addTeacherFrameComponents() ;
    }

    public void addTeacherFrameComponents (){
        column = new JPanel() ;
        personal = new JPanel() ;
        classes = new JPanel() ;
        addClass = new JPanel() ;

        addColumnComponents() ;
        addPersonalComponents() ;
        addClassesComponents() ;
        addAddClassComponents() ;

        teacherFrame.add(column, BorderLayout.EAST) ;
        teacherFrame.add(centerPanel, BorderLayout.CENTER) ;
    }

    public void addColumnComponents (){
        column.setLayout(new GridLayout(4, 1)) ;
        JButton btn = new JButton("personal") ;
        addActionListenerToPersonalButton(btn) ;
        column.add(btn) ;

        btn = new JButton("classes") ;
        addActionListenerToClassesButton(btn) ;
        column.add(btn) ;

        btn = new JButton("addClass") ;
        addActionListenerToAddClassButton(btn) ;
        column.add(btn) ;

    }

    public void addPersonalComponents (){
        personal.setLayout(new GridLayout(3, 2)) ;
        JLabel label = new JLabel("Username : ") ;
        personal.add(label) ;

        label = new JLabel(teacher.getUsername()) ;
        personal.add(label) ;

        label = new JLabel("Password : ") ;
        personal.add(label) ;

        label = new JLabel(teacher.getPassword()) ;
        personal.add(label) ;

        JButton btn = new JButton("Change password") ;
        personal.add(btn) ;
        addActionListenerToChangePasswordButton(btn) ;
    }

    public void addClassesComponents (){
        classes.setLayout(new GridLayout(20, 3)) ;
        for (Class class1 : teacher.getClasses()){
            JLabel jLabel = new JLabel(class1.getName() + " at " + IntToClassTime(class1.getTimePeriod())) ;
            classes.add(jLabel) ;

            JButton btn = new JButton("Students list") ;
            classes.add(btn) ;
            addActionListenerToStudentsListButton(btn, class1) ;

            btn = new JButton("Remove the class") ;
            classes.add(btn) ;
            addActionListenerToRemoveClassButton(btn, class1) ;
        }
    }

    public void addAddClassComponents (){
        addClass.setLayout(new GridLayout(5, 2)) ;
        JLabel label = new JLabel("Class name : ") ;
        addClass.add(label) ;

        JTextField textField1 = new JTextField() ;
        addClass.add(textField1) ;

        label = new JLabel("Units number : ") ;
        addClass.add(label) ;

        JTextField textField2 = new JTextField() ;
        addClass.add(textField2) ;

        label = new JLabel("Class time period : ") ;
        addClass.add(label) ;

        JComboBox<String> comboBox = new JComboBox<>() ;
        addItemsToComboBox(comboBox) ;
        addClass.add(comboBox) ;

        label = new JLabel("Capacity : ") ;
        addClass.add(label) ;

        JTextField textField4 = new JTextField() ;
        addClass.add(textField4) ;

        JButton btn = new JButton("Add") ;
        addClass.add(btn) ;
        addActionListenerToAddClassAddClassButton(btn, textField1, textField2, comboBox, textField4) ;
    }

    public void updateTeacherFrame (JPanel panel){
        setVisibility(false) ;
        centerPanel = panel ;
        setTeacherProfileInfo() ;
        setVisibility(true) ;
    }

    public void addItemsToComboBox (JComboBox<String> comboBox){
        comboBox.addItem("Saturday 8-10") ;
        comboBox.addItem("Saturday 10-12") ;
        comboBox.addItem("Saturday 14-16") ;
        comboBox.addItem("Sunday 8-10") ;
        comboBox.addItem("Sunday 10-12") ;
        comboBox.addItem("Sunday 14-16") ;
        comboBox.addItem("Monday 8-10") ;
        comboBox.addItem("Monday 10-12") ;
        comboBox.addItem("Monday 14-16") ;
        comboBox.addItem("Tuesday 8-10") ;
        comboBox.addItem("Tuesday 10-12") ;
        comboBox.addItem("Tuesday 14-16") ;
        comboBox.addItem("Wednesday 8-10") ;
        comboBox.addItem("Wednesday 10-12") ;
        comboBox.addItem("Wednesday 14-16") ;
    }

































    public void addActionListenerToPersonalButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTeacherFrame(personal) ;
            }
        });
    }
    public void addActionListenerToClassesButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTeacherFrame(classes) ;
            }
        });
    }
    public void addActionListenerToAddClassButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTeacherFrame(addClass) ;
            }
        });
    }

    public void addActionListenerToRemoveTheClassButton (JButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                            Main1.removeTeacher(teacher) ;
                            teacher.setPassword(password) ;
                            Main1.addTeacher(teacher) ;
                        }
                    }
                });
                passwordFrame.setVisible(true) ;

            }
        });
    }

    public void addActionListenerToStudentsListButton (JButton btn, Class class1){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame studentsListFrame = new JFrame() ;
                studentsListFrame.setTitle("Students list") ;
                studentsListFrame.setSize(800, 800) ;
                studentsListFrame.setLocation(100, 100) ;
                studentsListFrame.setLayout(new BorderLayout()) ;
                JPanel panel = new JPanel() ;
                studentsListFrame.add(panel, BorderLayout.CENTER) ;
                panel.setLayout(new GridLayout(40, 2)) ;
                ArrayList<JLabel> labels = new ArrayList<>() ;
                ArrayList<JTextField> textFields = new ArrayList<>() ;
                ArrayList<JButton> buttons = new ArrayList<>() ;
                for (int i = 0; i < class1.getStudents().size(); i++){
                    labels.add(new JLabel()) ;
                    textFields.add(new JTextField()) ;
                    buttons.add(new JButton()) ;
                }
                ArrayList<Student> students = class1.getStudents() ;
                int i = 0 ;
                for (Student student : students){
                    labels.get(i).setText("Student name : " + student.getUsername()) ;
                    textFields.get(i).setText("Score") ;
                    buttons.get(i).setText("save") ;
                    addActionListenerToSaveScoreButton(buttons.get(i), textFields.get(i), student, class1) ;
                    i++ ;
                }
                for (int j = 0; j < class1.getStudents().size(); j++){
                    panel.add(labels.get(j)) ;
                    panel.add(textFields.get(j)) ;
                    panel.add(buttons.get(j)) ;
                }
                studentsListFrame.setVisible(true) ;
            }
        });
    }

    public void addActionListenerToSaveScoreButton (JButton btn, JTextField txt, Student student, Class class1){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int score = Main.myParseInt(txt.getText()) ;
                Main1.removeStudent(student) ;
                student.setScore(class1, score) ;
                Main1.addStudent(student) ;
            }
        });
    }

    public void addActionListenerToRemoveClassButton (JButton btn, Class class1){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Student student : class1.getStudents()){
                    Main1.removeStudent(student) ;
                    student.removeClass(class1) ;
                    Main1.addStudent(student) ;
                }
                Main1.removeTeacher(teacher) ;
                teacher.removeClass(class1) ;
                Main1.addTeacher(teacher) ;

                Main1.removeClass(class1) ;
            }
        });
    }

    public void addActionListenerToAddClassAddClassButton (JButton btn, JTextField classNametxt, JTextField unitsNumbertxt, JComboBox<String> comboBox, JTextField capacitytxt){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int unitsNumberToInt = Main.myParseInt(unitsNumbertxt.getText()) ;
                int classTimeToInt = classTimeToInt(comboBox.getSelectedItem().toString() + "") ;
                int capacityToInt = Main.myParseInt(capacitytxt.getText()) ;
                Class class1 = new Class(teacher, classNametxt.getText(), unitsNumberToInt, classTimeToInt, capacityToInt) ;
                if (teacher.isAddingClassAllowed(class1)){
                    Main1.removeTeacher(teacher);
                    teacher.addClass(class1);
                    Main1.addTeacher(teacher);
                    Main1.addClass(class1);
                }
                else {
                    JFrame frame = new JFrame() ;
                    JOptionPane.showMessageDialog(frame, "You have another class at this time") ;
                }
            }
        });
    }


}
