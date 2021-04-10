/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import huesandcuesproject.Runner;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Scale;

/**
 *
 * @author Lucy
 */
public class Board extends BorderPane{
    
    private ColorBlock [][] blocks = new ColorBlock [30] [16];
    private GridPane gp;
    private int iPlayers = 0;
    private final int height = 380;
    private final int length = 600;
    
    public Board (int nPlayers) throws Exception{
        
        this.setSize();
        gp = new GridPane();
        
        String line;
        
        FileReader boardCSV = new FileReader("colorMatrix.csv");
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
                
                //Creates a ColorBlock
                blocks [j] [i] = new ColorBlock(seperator[j]);
                
                //Adds position to the ColorBlock
                String letter = this.getCharForNumber(i);
                String number = String.valueOf(j+1);
                blocks[j][i].setPosition(letter, number);
                
                sp.getChildren().add(blocks [j] [i] );
                sp.getChildren().add(tri);
                tri.setVisible(false);
                blocks [j] [i].setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                        tri.setFill(Runner.activePlayer.getColor());
                        tri.setVisible(true);
                        iPlayers++;
                        if(iPlayers == nPlayers)
                            iPlayers = 0;
                        Runner.activePlayer = Runner.players.get(iPlayers);
                    }
                });
                GridPane.setConstraints(sp, j, i);
                gp.getChildren().add(sp);
            }
            i++;
        }

        
        gp.setAlignment(Pos.BOTTOM_CENTER);
        this.setBottom(gp);
        
        
        //while(!br.readLine().isEmpty()){
            //String colorCodes[] = br.readLine().split(" ");
        //}    
    }
    
    private void setSize(){
        this.setMinSize(length, height);
        this.setMaxSize(length, height);
    }

    public ColorBlock[][] getBlocks() {
        return blocks;
    }

    private void setBlocks(ColorBlock[][] blocks) {
        this.blocks = blocks;
    }
    
    private String getCharForNumber(int i) {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        if (i > 25) {
            return null;
        }
        return Character.toString(alphabet[i]);
    }
    
    
}
