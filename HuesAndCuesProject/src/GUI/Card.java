/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.layout.HBox;

/**
 *
 * @author Lucy
 */
public class Card extends HBox{
    private ColorBlock[] colors;
    
    public Card(){
        
    }

    public ColorBlock[] getColors() {
        return colors;
    }

    
    //????????????????????????????????????????????
    public void setColors(ColorBlock[] colors) {
        this.colors = new ColorBlock[4];
    }
    //????????????????????????????????????????????
    
    
    //Overrides normal toString to point out the colors...
    //Should change to show position...
    @Override
    public String toString(){
        String text = "";
        text += colors[0].getPosition() + " ";
        text += colors[1].getPosition() + " ";
        text += colors[2].getPosition() + " ";
        text += colors[3].getPosition() + " ";
        return text;
    }
    
}
