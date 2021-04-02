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
    private int height;
    private int length;
    private String position;
    
    public ColorBlock(String color){
        this.setColor(color);
        this.setSize();
        setStyle("-fx-background-color: #" + color + ";");
    }
    
    private void setColor(String color){
        this.color = color;
    }
    
    public String getColor(){
        return this.color;
    }
    
    private void setSize(){
        //.setMinSize(height, length);
        //.setMaxSize(height, length);
    }
    
    public void setPosition(String letter, String number){
        this.position = letter + number;
    }
    
    public String getPosition(){
        return this.position;
    }
    
}
