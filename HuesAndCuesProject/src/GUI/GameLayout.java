/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;

/**
 *
 * @author Lucy
 */
public class GameLayout extends BorderPane{
    
    private Label hint;
  
    private final double LENGTH = 800;
    private final double HEIGHT = 620;
    public ScoreBoard scoreBoard;
    public Board board;
    
    public GameLayout(int nPlayers) throws Exception{
        this.setSize();
        this.setHint();
        
        GridPane mainGp = new GridPane();
        mainGp.setAlignment(Pos.CENTER);
        
        this.setScoreBoard(nPlayers);
        this.setBoard(nPlayers);

        mainGp.add(this.getScoreBoard(), 0, 0);
        mainGp.add(new Label(), 0, 1);
        mainGp.add(this.getBoard(), 0, 2);
        this.setCenter(mainGp);
        
        hint.setStyle("-fx-text-fill: green; -fx-font-weight: bold");
        hint.setVisible(true);
        
        GridPane hintGrid = new GridPane();
        hintGrid.setMinSize(800, 40);
        hintGrid.setMaxSize(800, 40);
        hintGrid.add(hint,0,0);
        hintGrid.setAlignment(Pos.CENTER);
        this.setBottom(hintGrid);
        
        //Adds main sizes
        mainGp.setMinSize(660, 500);
        mainGp.setMaxSize(660, 500);
        
        //Adding color;
        mainGp.setStyle("-fx-background-color: black");
        this.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
    private void setSize(){
        this.setMinSize(LENGTH, HEIGHT);
        this.setMaxSize(LENGTH, HEIGHT);
    }
    
    private void setHint(){
        this.hint = new Label();
    }
    
    public void changeHint(String hintText){
        this.hint.setText("HINT: "+hintText);
    }
    
    public Label getHint(){
        return this.hint;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    private void setScoreBoard(int nOfPlayers) throws Exception {
        this.scoreBoard = new ScoreBoard(nOfPlayers);
    }

    public Board getBoard() {
        return board;
    }

    private void setBoard(int nPlayers) throws Exception {
        this.board = new Board(nPlayers);
    }  
    
}

