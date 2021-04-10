/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huesandcuesproject;

import javafx.scene.paint.Color;

/**
 *
 * @author Lucy
 */
public class Player {
    private String name;
    private int score = 0;
    private String email;
    private Color playerColor;
    
    //Indicates if this player will choose a color or hint
    private boolean isLeader;
    
    private Player(){
        
    }
    
    public Player(String name, String email, Color color){
        this.setName(name);
        this.setEmail(email);
        this.setColor(color);
        this.setIsLeader(false);
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
    
    private void setColor(Color newColor){
        this.playerColor = newColor;
    }
    
    public Color getColor(){
        return this.playerColor;
    }
    
    public boolean getIsLeader(){
        return this.isLeader;
    }
    
    public void setIsLeader(boolean leader){
        this.isLeader = leader;
    }
    
}
