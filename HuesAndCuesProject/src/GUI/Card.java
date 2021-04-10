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
    private ArrayList<String> positions;
    
    public Card(List<ColorBlock> shuffledColors){
        this.setColors();
        this.setPositions();
        for(int i=0;i<4;i++){
            String tempColor = shuffledColors.get(index).getColor();
            String tempPos = shuffledColors.get(index).getPosition();
            colors.add(tempColor);
            positions.add(tempPos);
            if(index==99){
                index=0;
            }else{
                index++;
            }
        }
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
        html = ""
            + "<html>"
                + "<head> <style> "
                + "#grid {"
                    + "background-color: black;"
                    + "width: 200px;"
                    + "height: 200px;"
                    + "padding: 15px;"
                + "}"
                +".tableRow{" +
                    "width: 200px;" +
                    "height: 100px;" +
                "}" +
                ".tableData{\n" +
                    "height: 100px;\n" +
                    "width: 100px;\n" +
                "}"
                + "#block1 { background-color: #" + colors.get(0) + ";}"
                + "#block2 { background-color: #" + colors.get(1) + ";}"
                + "#block3 { background-color: #" + colors.get(2) + ";}"
                + "#block4 { background-color: #" + colors.get(3) + ";}"
                + ".colored {width: 50px; height: 50px;}"
                + ".data { color: white; font-weight: bold; text-align: center;}  </style></head>"
                + "<body>"
                    + "<table id = \"grid\">"
                        + "<tr class = \"tableRow\">"
                            + "<td class = \"tableData\"><div class = \"colored\" id = \"block1\"></div></td>"
                            + "<td class = \"tableData\"><div class = \"colored\" id = \"block2\"></div></td>"
                        + "</tr>"
                        + "<tr class = \"Position\">"
                            + "<td class = \"data\"><p>" + positions.get(0) + "</p></td>"
                            + "<td class = \"data\"><p>" + positions.get(1) + "</p></td>"
                        + "</tr>"
                        + "<tr class = \"tableRow\">"
                            + "<td class = \"tableData\"><div class = \"colored\" id = \"block3\"></div></td>"
                            + "<td class = \"tableData\"><div class = \"colored\" id = \"block4\"></div></td>"
                        + "</tr>"
                        + "<tr class = \"Position\">"
                            + "<td class = \"data\"><p>" + positions.get(2) + "</p></td>"
                            + "<td class = \"data\"><p>" + positions.get(3) + "</p></td>"
                        + "</tr>"
                    +"</table>"
                + "</body>"
            + "</html>";
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
    
    private void setPositions(){
        this.positions = new ArrayList();
    }
    
    
    
    
    
}
