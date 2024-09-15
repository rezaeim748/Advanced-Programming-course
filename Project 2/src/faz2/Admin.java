package faz2;

import java.io.Serializable;

public class Admin implements Serializable {
    private String username ;
    private String password ;
    private String[] meals ;

    public Admin (String username, String password){
        this.username = username ;
        this.password = password ;
        this.meals = new String[5] ;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String[] getMeals() {
        return meals;
    }

    public void setPassword (String password){
        this.password = password ;
    }

    public void setMeals (String[] meals){
        this.meals = meals ;
    }

}
