/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.image.Image;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Lucy
 */
public class ScoreBoard extends BorderPane{
    
    private final int height = 100;
    private final int length = 600;
    private final int blockHeight = 50;
    private final int blockLength = 18;
    
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
        
        //Adding numbers on scoreboard
        for(int cont=5; cont<26; cont+=5){
            String number = String.valueOf(cont);
            Label tempNumber = new Label(number);
            tempNumber.setAlignment(Pos.BOTTOM_CENTER);
            tempNumber.setMaxSize(20, 50);
            tempNumber.setMinSize(20, 50);
            tempNumber.setStyle("-fx-text-fill: white; -fx-font-weight: bold");            
            GridPane.setConstraints(tempNumber, cont-1, 0);
            scoreGp.getChildren().add(tempNumber);
        }
        for(int cont=5; cont<26; cont+=5){
            String number = String.valueOf(55-cont);
            Label tempNumber = new Label(number);
            tempNumber.setAlignment(Pos.BOTTOM_CENTER);
            tempNumber.setMaxSize(20, 50);
            tempNumber.setMinSize(20, 50);
            tempNumber.setStyle("-fx-text-fill: white; -fx-font-weight: bold");            
            GridPane.setConstraints(tempNumber, cont-5, 1);
            scoreGp.getChildren().add(tempNumber);
        }

        scoreGp.setAlignment(Pos.CENTER);
        this.setLeft(scoreGp);  
        
        //Adding the Logo
        Image logo = new Image(new FileInputStream("HuesAndCuesLogo.jpg"));
        ImageView imageView = new ImageView(logo);
        imageView.setFitHeight(120); 
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true); 
        GridPane imageLogo = new GridPane();
        imageLogo.setAlignment(Pos.CENTER);
        imageLogo.add(imageView,0,0);
        this.setRight(imageLogo);
    }
    
    private void setSize(){
        this.setMinSize(length, height);
        this.setMaxSize(length, height);
    }
}
