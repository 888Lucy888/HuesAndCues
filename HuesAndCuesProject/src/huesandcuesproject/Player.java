/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huesandcuesproject;

/**
 *
 * @author Lucy
 */
public class Player {
    private String name;
    private int score = 0;
    private String email;
    
    public Player(String name, String email){
        this.setName(name);
        this.setEmail(email);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }
    
}
