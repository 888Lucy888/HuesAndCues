/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import huesandcuesproject.Player;
import huesandcuesproject.Runner;
import javafx.scene.image.Image;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
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
    private final double BLOCKHEIGHT = 50;
    private final double BLOCKLENGTH = 20;
    
    private GridPane scoreGp;
    private GridPane triangleGp;
    private StackPane scoreBoardStacked;
    
    public ScoreBoard(int numberOfPlayers) throws Exception{
        
        this.setScoreGp();
        this.setTriangleGp();
        this.setSize();
        this.setScoreBoardStacked();
        
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
                tempColorBlock.setSize(BLOCKLENGTH, BLOCKHEIGHT);
                this.getScoreGp().add(tempColorBlock, i, j);
            }
            j++;
            
            //Setting up constrains so the triangles can move specifically within those constraints
            for(int c=0; c<12; c++){
                this.getTriangleGp().getColumnConstraints().add(new ColumnConstraints(BLOCKLENGTH));
            }
        }
        //Setting up starter triangles for each player
        this.getTriangleGp().getRowConstraints().add(new RowConstraints(BLOCKHEIGHT/numberOfPlayers));
        this.getTriangleGp().getColumnConstraints().add(new ColumnConstraints(BLOCKLENGTH));
        for(int k=0; k<numberOfPlayers; k++){
            VBox scoreTri = new VBox();
            Polygon tri = new Polygon();
            tri.getPoints().addAll(new Double[]{
                0.0, 8.0,
                4.0, 0.0,
                8.0, 8.0
            });
            tri.setFill(Runner.getPlayers().get(k).getColor());
            tri.setVisible(true);
            scoreTri.setMaxSize(BLOCKLENGTH,BLOCKHEIGHT);
            scoreTri.setMinSize(BLOCKLENGTH,BLOCKHEIGHT);
            scoreTri.getChildren().add(tri);
            scoreTri.setAlignment(Pos.TOP_LEFT);
            this.getTriangleGp().add(scoreTri, 0, k);
            this.getTriangleGp().getRowConstraints().add(new RowConstraints(BLOCKHEIGHT/numberOfPlayers));
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
        
        //Aligned and adding to BorderPane
        this.getScoreGp().setAlignment(Pos.CENTER);
        this.getTriangleGp().setAlignment(Pos.CENTER);
        this.getScoreBoardStacked().setAlignment(Pos.CENTER);
        
        this.setLeft(this.getScoreBoardStacked());  
        
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
    
    private void setTriangleGp(){
        this.triangleGp = new GridPane();
    }
    
    public GridPane getTriangleGp(){
        return this.triangleGp;
    }

    public StackPane getScoreBoardStacked() {
        return scoreBoardStacked;
    }

    private void setScoreBoardStacked() {
        this.scoreBoardStacked = new StackPane();
        this.scoreBoardStacked.getChildren().add(scoreGp);
        this.scoreBoardStacked.getChildren().add(triangleGp);        
    }
    
    
    
    public void updateScoreBoard(){
        for (int i=0; i<Runner.getPlayers().size(); i++){
           int score = Runner.getPlayers().get(i).getScore();
           if(score != 0){
            GridPane.setColumnIndex((Node) this.getTriangleGp().getChildren().get(i), (score-1));
           }
        }
    }
    
    
}
