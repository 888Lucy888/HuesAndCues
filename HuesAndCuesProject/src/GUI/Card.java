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
    private ArrayList<String> colors;
    private ArrayList<String> positions;
    
    public Card(List<ColorBlock> shuffledColors){
        //Returns 4 colorblocks from the already shuffled list
        this.setColors();
        this.setPositions();
        for(int i=0;i<4;i++){
            String tempColor = shuffledColors.get(index).getColor();
            String tempPos = shuffledColors.get(index).getPosition();
            colors.add(tempColor);
            positions.add(tempPos);
            if(index==99){
                this.setIndex(0);
            }else{
                index++;
            }
        }
    }

    
    public String toHTML(){
        //Converts the colors and posiitions from the 4 colorblocks into HTML so the card may be sent via mail
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
                + "#block1 { background-color: #" + this.getColors().get(0) + ";}"
                + "#block2 { background-color: #" + this.getColors().get(1) + ";}"
                + "#block3 { background-color: #" + this.getColors().get(2) + ";}"
                + "#block4 { background-color: #" + this.getColors().get(3) + ";}"
                + ".colored {width: 50px; height: 50px;}"
                + ".data { color: white; font-weight: bold; text-align: center;}  </style></head>"
                + "<body>"
                    + "<table id = \"grid\">"
                        + "<tr class = \"tableRow\">"
                            + "<td class = \"tableData\"><div class = \"colored\" id = \"block1\"></div></td>"
                            + "<td class = \"tableData\"><div class = \"colored\" id = \"block2\"></div></td>"
                        + "</tr>"
                        + "<tr class = \"Position\">"
                            + "<td class = \"data\"><p>" + this.getPositions().get(0) + "</p></td>"
                            + "<td class = \"data\"><p>" + this.getPositions().get(1) + "</p></td>"
                        + "</tr>"
                        + "<tr class = \"tableRow\">"
                            + "<td class = \"tableData\"><div class = \"colored\" id = \"block3\"></div></td>"
                            + "<td class = \"tableData\"><div class = \"colored\" id = \"block4\"></div></td>"
                        + "</tr>"
                        + "<tr class = \"Position\">"
                            + "<td class = \"data\"><p>" + this.getPositions().get(2) + "</p></td>"
                            + "<td class = \"data\"><p>" + this.getPositions().get(3) + "</p></td>"
                        + "</tr>"
                    +"</table>"
                + "</body>"
            + "</html>";
        return html;
    }

    public static int getIndex() {
        return index;
    }

    private static void setIndex(int index) {
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
    
    public ArrayList<String> getPositions(){
        return this.positions;
    }
    
    
    
    
}
