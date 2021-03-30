/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.layout.StackPane;

/**
 *
 * @author Lucy
 */
public class ColorBlock extends StackPane{
    private String color;
    private int height;
    private int length;
    
    public ColorBlock(String color){
        this.setColor(color);
        this.setSize();
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
    
}
