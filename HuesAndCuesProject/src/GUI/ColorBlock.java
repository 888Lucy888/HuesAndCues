/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import huesandcuesproject.Player;
import huesandcuesproject.Runner;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Lucy
 */
public class ColorBlock extends Button{
    private String color;
    private final int HEIGHT = 20;
    private final int LENGTH = 20;
    private String position;
    private int posX;
    private int posY;
    private boolean isSelected;
    private Player selectedBy;
    
    private ColorBlock(){  
    }
    
    //Constructor called when only color is needed
    public ColorBlock(String color) throws Exception{
        this.setColor(color);
        this.setSize(LENGTH, HEIGHT);
        this.setStyle("-fx-background-color: #" + this.getColor() + "; -fx-border-color: black");
    }
    
    //Constructor used in the board to be able to calculate distance
    public ColorBlock(String color, int posX, int posY) throws Exception{
        this.setColor(color);
        this.setSize(length, height);
        this.setStyle("-fx-background-color: #" + this.getColor() + "; -fx-border-color: black");
        this.setPosX(posX);
        this.setPosY(posY);
        this.clearSelected();
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
    
    private void setPosX(int newPos){
        this.posX = newPos;
    }
    
    public int getPosX(){
        return this.posX;
    }
    
    private void setPosY(int newPos){
        this.posY = newPos;
    }
    
    public int getPosY(){
        return this.posY;
    }
    
    public void setAsSelected(){
        this.isSelected = true;
    }
    
    public void setSelectedBy(){
        this.selectedBy = Runner.activePlayer;
    }
    
    public void clearSelected(){
        this.isSelected = false;
    }
    
    public void clearSelectedBy(){
        this.selectedBy = null;
    }
    
    public boolean getSelected(){
        return this.isSelected;
    }
    
    public Player getSelectedBy(){
        return this.selectedBy;
    }
    
}
