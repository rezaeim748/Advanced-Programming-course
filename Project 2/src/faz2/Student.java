package faz2;

import java.io.Serializable;
import java.util.HashMap;

public class Student implements Serializable {
    private String username ;
    private String password ;
    private HashMap<Class,Integer> classes ;
    private String cardNumber ;
    private String cardPassword ;
    private int cardBalance ;
    private boolean[] reservedDays ;
    private int unitsNumber ;

    public Student (String username, String password){
        this.username = username ;
        this.password = password ;
        classes = new HashMap<>() ;
        cardNumber = "" ;
        cardPassword = "" ;
        cardBalance = 0 ;
        reservedDays = new boolean[7] ;
        unitsNumber = 0 ;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public HashMap<Class, Integer> getClasses() {
        return classes;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardPassword() {
        return cardPassword;
    }

    public int getCardBalance() {
        return cardBalance;
    }

    public boolean[] getReservedDays() {
        return reservedDays;
    }

    public int getUnitsNumber() {
        return unitsNumber;
    }

    public void setUnitsNumber(int unitsNumber) {
        this.unitsNumber = unitsNumber;
    }

    public void setPassword (String password){
        this.password = password ;
    }

    public void addClass (Class class1){
        classes.put(class1, 0) ;
        unitsNumber += class1.getUnitsNumber() ;
    }

    public void setClasses(HashMap<Class, Integer> classes) {
        this.classes = classes;
    }

    public void setScore (Class class1, int score){
        classes.put(class1, score) ;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardPassword(String cardPassword) {
        this.cardPassword = cardPassword;
    }

    public void increaseCardBalance (int amount){
        cardBalance += amount ;
    }

    public void decreaseCardBalance (int amount){
        cardBalance -= amount ;
    }

    public void setReservedDays (boolean[] reservedDays){ this.reservedDays = reservedDays ; }

    public double getAverageScore (){
        double sum = 0 ;
        for (int i : classes.values()){
            sum += i ;
        }
        return (sum / classes.size()) ;
    }

    public void removeClass (Class class1){
        Class class2 = null ;
        for (Class class3 : classes.keySet()){
            if (class3.equals(class1)){
                class2 = class3 ;
            }
        }
        classes.remove(class2) ;
        if (class2 != null) {
            unitsNumber -= class1.getUnitsNumber();
        }
    }


}
