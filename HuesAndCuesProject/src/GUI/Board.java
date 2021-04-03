/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Lucy
 */
public class Board extends BorderPane{
    
    ColorBlock [][] blocks = new ColorBlock [30] [16];
    GridPane gp;
    
    public Board () throws Exception{
        
        gp = new GridPane();
        
        String line;
        
        FileReader boardCSV = new FileReader("colorMatrix.csv");
        //FileReader fr = new FileReader("css color file route");
        BufferedReader br = new BufferedReader(boardCSV);
        int i = 0;
        while((line = br.readLine()) != null){
            String [] seperator = line.split(",");
            for(int j = 0; j < 30; j++){
                blocks [j] [i] = new ColorBlock(seperator[j]);
                GridPane.setConstraints(blocks [j] [i], j, i);
                gp.getChildren().add(blocks [j] [i]);
            }
            i++;
        }
        
        this.setCenter(gp);
        
        //while(!br.readLine().isEmpty()){
            //String colorCodes[] = br.readLine().split(" ");
        //}
        
    }
    
}
