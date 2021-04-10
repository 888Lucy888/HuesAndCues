/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    
    private static Label hint;
    
    //public GameLayout(int nPlayers) throws Exception{
        
        //Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        //double length = screenSize.getWidth() / 10;
        //double height = screenSize.getHeight() / 10;
  
    private final double length = 800;
    private final double height = 620;
    public ScoreBoard scoreBoard;
    public Board board;
    
    public GameLayout(int nPlayers) throws Exception{
        this.setSize();
        
        GridPane mainGp = new GridPane();
        mainGp.setAlignment(Pos.CENTER);
        
        this.setScoreBoard();
        this.setBoard(nPlayers);

        mainGp.add(this.getScoreBoard(), 0, 0);
        mainGp.add(new Label(), 0, 1);
        mainGp.add(this.getBoard(), 0, 2);
        //Board gameBoard = new Board();
        //this.setCenter(gameBoard);
        //ScoreBoard scoreBoard = new ScoreBoard();
        //this.setTop(scoreBoard);
        this.setCenter(mainGp);
        //this.setBottom(LBLHINT);
        //LBLHINT.setVisible(true);
        
        hint.setStyle("-fx-text-fill: green; -fx-font-weight: bold");;
        hint.setVisible(true);
        
        GridPane hintGrid = new GridPane();
        hintGrid.setMinSize(800, 40);
        hintGrid.setMaxSize(800, 40);
        hintGrid.add(hint,0,0);
        hintGrid.setAlignment(Pos.CENTER);
        this.setBottom(hintGrid);
      
        mainGp.setMinSize(660, 500);
        mainGp.setMaxSize(660, 500);
        
        //Adding color;
        mainGp.setStyle("-fx-background-color: black");
        this.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        /*
        VBox numbers = new VBox();
        HBox letters = new HBox();
        for(int i=0; i<25; i++){
            String letterString = this.getCharForNumber(i);
            Label letter = new Label(letterString);
            letter.setStyle("-fx-text-fill: white; -fx-font-weight: bold");
            letters.getChildren().add(letter);
        }
        letters.setSpacing(16);
        letters.setAlignment(Pos.CENTER);
        
        mainGp.add(letters, 0, 1);
        */
    }
    
    private void setSize(){
        this.setMinSize(length, height);
        this.setMaxSize(length, height);
    }
    
    public static void setLBLHINT(Label label){
        hint = label;
    }
    
    public static Label getLBLHINT(){
        return hint;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void setScoreBoard() throws Exception {
        this.scoreBoard = new ScoreBoard();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(int nPlayers) throws Exception {
        this.board = new Board(nPlayers);
    }  
}

