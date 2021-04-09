/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.HBox;

/**
 *
 * @author Lucy
 */
public class Card extends HBox{
    
    private static int index = 0;
    private static int indexj = 0;
    private ArrayList<String> colors;
    
    public Card(List<List<ColorBlock>> shuffledColors){
        this.setColors();
        for(int i=0;i<4;i++){
            String tempColor = shuffledColors.get(indexj).get(index).getColor();
            colors.add(tempColor);
            if(index==30){
                indexj++;
                index = 0;
            }else{
                index++;
            }
        }

        this.toHTML();
    }

    
    //Overrides normal toString to point out the colors...
    //Should change to show position...
    /*@Override
    public String toString(){
        String text = "";
        text += colors[0].getPosition() + " ";
        text += colors[1].getPosition() + " ";
        text += colors[2].getPosition() + " ";
        text += colors[3].getPosition() + " ";
        return text;
    }
    */
    
    public String toHTML(){
        String html;
        html = "<html>"
                + "<head> <style> "
                + "#grid { display: grid; grid-template-columns: auto auto;"
                + "grid-gap: 15px; background-color: #000000; padding: 15px;}"
                + "#block1 { background-color: #" + colors.get(0) + ";}"
                + "#block2 { background-color: #" + colors.get(1) + ";}"
                + "#block3 { background-color: #" + colors.get(2) + ";}"
                + "#block4 { background-color: #" + colors.get(3) + ";}"
                + ".colored {width: 50px; height: 50px;} </style></head>"
                + "<body><div id = 'grid'><div class = 'colored' id = 'block1'>"
                + "<div class = 'colored' id = 'block2'>"
                + "<div class = 'colored' id = 'block3'>"
                + "<div class = 'colored' id = 'block4'>"
                + "</div></div></body></html>";
        return html;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        Card.index = index;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    private void setColors() {
        this.colors = new ArrayList();
    }
    
    
    
    
    
}
