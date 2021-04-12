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
    private Label lblPoints;
    private String color;
    private final int HEIGHT = 20;
    private final int LENGTH = 20;
    private String position;
    private int posX;
    private int posY;
    private boolean isSelected;
    private int selectedBy;
    
    private ColorBlock(){  
    }
    
    //Constructor called when only color is needed (ScoreBoard)
    public ColorBlock(String color) throws Exception{
        this.setColor(color);
        this.setSize(LENGTH, HEIGHT);
        this.setStyle("-fx-background-color: #" + this.getColor() + "; -fx-border-color: black");
    }
    
    //Constructor used in the board to be able to calculate distance
    public ColorBlock(String color, int posX, int posY) throws Exception{
        this.setColor(color);
        this.setSize(LENGTH, HEIGHT);
        this.setStyle("-fx-background-color: #" + this.getColor() + "; -fx-border-color: black");
        this.setPosX(posX);
        this.setPosY(posY);
        this.clearSelected();
        this.setSelectedBy(-1);
        this.setLabel(new Label());
    }
    
    private void setColor(String color){
        this.color = color;
    }
    
    public String getColor(){
        return this.color;
    }
    
    protected void setSize(double length, double height){
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
    
    public void setSelectedBy(int selected){
        this.selectedBy = selected;
    }
    
    public void clearSelected(){
        this.isSelected = false;
    }
    
    public void clearSelectedBy(){
        this.selectedBy = -1;
    }
    
    public boolean getSelected(){
        return this.isSelected;
    }
    
    public int getSelectedBy(){
        return this.selectedBy;
    }
    
    public void setLabel(Label label){
        this.lblPoints = label;
    }
    
    public Label getLabel(){
        return this.lblPoints;
    }
    
    public void setLabelText(String text){
        this.lblPoints.setText(text);
    }
    
}
