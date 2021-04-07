/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Lucy
 */
public class ScoreBoard extends BorderPane{
    
    private final int height = 100;
    private final int length = 900;
    private final int blockHeight = 50;
    private final int blockLength = 20;
    
    public ScoreBoard() throws Exception{
        
        this.setSize();
        
        GridPane scoreGp = new GridPane();
        FileReader fr = new FileReader("colorScoreMatrix.csv");
        BufferedReader br = new BufferedReader(fr);
        String line;
        int j=0;
        while((line = br.readLine()) != null){
            String[] tempArray = line.split(",");
            for(int i=0; i<25; i++){
                ColorBlock tempColorBlock = new ColorBlock(tempArray[i]);
                tempColorBlock.setSize(blockLength, blockHeight);
                scoreGp.add(tempColorBlock, i, j);
            }
            j++;
        }
        
        this.setCenter(scoreGp);   
    }
    
    private void setSize(){
        this.setMinSize(length, height);
        this.setMaxSize(length, height);
    }
}
