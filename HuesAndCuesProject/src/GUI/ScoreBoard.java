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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 *
 * @author Lucy
 */
public class ScoreBoard extends BorderPane{
    
    private final int HEIGHT = 100;
    private final int LENGTH = 600;
    private final int BLOCKHEIGHT = 50;
    private final int BLOCKLENGTH = 20;
    
    private GridPane scoreGp;
    
    public ScoreBoard(int numberOfPlayers) throws Exception{
        
        this.setSize();
        this.setScoreGp();
        
        //Reads colors to make ColorBlocks
        FileReader fr = new FileReader("colorScoreMatrix.csv");
        BufferedReader br = new BufferedReader(fr);
        String line;
        int j=0;
        //Creates colorblocks and resizes them
        while((line = br.readLine()) != null){
            String[] tempArray = line.split(",");
            for(int i=0; i<25; i++){
                ColorBlock tempColorBlock = new ColorBlock(tempArray[i]);
                VBox scoreTri = new VBox();
                //Creates player's scoring triangles
                for(int k=0; k<numberOfPlayers; k++){
                    Polygon tri = new Polygon();
                    tri.getPoints().addAll(new Double[]{
                        0.0, 10.0,
                        5.0, 0.0,
                        10.0, 10.0
                    });
                    tri.setFill(Color.BLACK);
                    tri.setVisible(false);
                    scoreTri.setMaxSize(BLOCKLENGTH,BLOCKHEIGHT);
                    scoreTri.setMinSize(BLOCKLENGTH,BLOCKHEIGHT);
                    scoreTri.getChildren().add(tri);
                    scoreTri.setAlignment(Pos.CENTER);
                }
                tempColorBlock.setSize(BLOCKLENGTH, BLOCKHEIGHT);
                this.getScoreGp().add(tempColorBlock, i, j);
                this.getScoreGp().add(scoreTri, i, j);
            }
            j++;
        }
        
        //Adds numbers on scoreboard
        for(int cont=5; cont<26; cont+=5){
            String number = String.valueOf(cont);
            Label tempNumber = new Label(number);
            tempNumber.setAlignment(Pos.BOTTOM_CENTER);
            tempNumber.setMaxSize(20, 50);
            tempNumber.setMinSize(20, 50);
            tempNumber.setStyle("-fx-text-fill: white; -fx-font-weight: bold");            
            GridPane.setConstraints(tempNumber, cont-1, 0);
            this.getScoreGp().getChildren().add(tempNumber);
        }
        for(int cont=5; cont<26; cont+=5){
            String number = String.valueOf(55-cont);
            Label tempNumber = new Label(number);
            tempNumber.setAlignment(Pos.BOTTOM_CENTER);
            tempNumber.setMaxSize(20, 50);
            tempNumber.setMinSize(20, 50);
            tempNumber.setStyle("-fx-text-fill: white; -fx-font-weight: bold");            
            GridPane.setConstraints(tempNumber, cont-5, 1);
            this.getScoreGp().getChildren().add(tempNumber);
        }

        this.getScoreGp().setAlignment(Pos.CENTER);
        this.setLeft(this.getScoreGp());  
        
        //Adds the Logo
        Image logo = new Image(new FileInputStream("HuesAndCuesLogo.jpg"));
        ImageView imageView = new ImageView(logo);
        imageView.setFitHeight(120); 
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true); 
        GridPane imageLogo = new GridPane();
        imageLogo.setAlignment(Pos.TOP_RIGHT);
        imageLogo.add(imageView, 0, 0);
        this.setRight(imageLogo);
    }
    
    private void setSize(){
        this.setMinSize(LENGTH, HEIGHT);
        this.setMaxSize(LENGTH, HEIGHT);
    }

    public GridPane getScoreGp() {
        return scoreGp;
    }

    private void setScoreGp() {
        this.scoreGp = new GridPane();
    }
    
    
    
    
}
