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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 *
 * @author Lucy
 */
public class Board extends BorderPane{
    
    private ColorBlock [][] blocks = new ColorBlock [30] [16];
    private GridPane gp;
    
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
                StackPane sp = new StackPane();
                Polygon tri = new Polygon();
                tri.getPoints().addAll(new Double[]{
                   0.0, 0.0,
                   10.0, 20.0,
                   20.0, 0.0
                });
                tri.setFill(Color.BLACK);
                blocks [j] [i] = new ColorBlock(seperator[j]);
                sp.getChildren().add(blocks [j] [i] );
                sp.getChildren().add(tri);
                tri.setVisible(false);
                blocks [j] [i].setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                        tri.setVisible(true);
                    }
                });
                GridPane.setConstraints(sp, j, i);
                gp.getChildren().add(sp);
            }
            i++;
        }
        
        this.setCenter(gp);
        
        //while(!br.readLine().isEmpty()){
            //String colorCodes[] = br.readLine().split(" ");
        //}
        
    }
    
}
