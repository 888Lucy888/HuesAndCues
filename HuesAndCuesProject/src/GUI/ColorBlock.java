/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStrokeStyle;

/**
 *
 * @author Lucy
 */
public class ColorBlock extends Button{
    private String color;
    private final int height = 30;
    private final int length = 30;
    private String position;
    
    public ColorBlock(String color) throws Exception{
        this.setColor(color);
        this.setSize();
        this.setStyle("-fx-background-color:#" + this.getColor() + ";-fx-border-color: black");
    }
    
    private void setColor(String color){
        this.color = color;
    }
    
    public String getColor(){
        return this.color;
    }
    
    private void setSize(){
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
