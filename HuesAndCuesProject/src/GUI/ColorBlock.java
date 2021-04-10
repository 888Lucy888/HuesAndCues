/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.Button;

/**
 *
 * @author Lucy
 */
public class ColorBlock extends Button{
    private String color;
    private final int height = 20;
    private final int length = 20;
    private String position;
    
    private ColorBlock(){  
    }
    
    public ColorBlock(String color) throws Exception{
        this.setColor(color);
        this.setSize(length, height);
        this.setStyle("-fx-background-color: #" + this.getColor() + "; -fx-border-color: black");
    }
    
    private void setColor(String color){
        this.color = color;
    }
    
    public String getColor(){
        return this.color;
    }
    
    protected void setSize(int length, int height){
        this.setMinSize(length, height);
        this.setMaxSize(length, height);
    }
    
    public void setPosition(String letter, String number){
        this.position = letter + number;
    }
    
    public String getPosition(){
        return this.position;
    }
    
}
