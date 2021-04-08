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
    
    public String toHTML(){
        String html;
        html = "<html>"
                + "<head> <style> "
                + "#grid { display: grid; grid-template-columns: auto auto;"
                + "grid-gap: 15px; background-color: #000000; padding: 15px;}"
                + "#block1 { background-color: #" + colors[0].getColor() + ";}"
                + "#block2 { background-color: #" + colors[1].getColor() + ";}"
                + "#block3 { background-color: #" + colors[2].getColor() + ";}"
                + "#block4 { background-color: #" + colors[3].getColor() + ";}"
                + ".colored {width: 50px; height: 50px;} </style></head>"
                + "<body><div id = 'grid'><div class = 'colored' id = 'block1'>"
                + "<div class = 'colored' id = 'block2'>"
                + "<div class = 'colored' id = 'block3'>"
                + "<div class = 'colored' id = 'block4'>"
                + "</div></div></body></html>";
        return html;
    }
    
}
