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
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;

/**
 *
 * @author Lucy
 */
public class GameLayout extends BorderPane{
    
    private static Label LBLHINT;
    
    //public GameLayout(int nPlayers) throws Exception{
        
        //Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        //double length = screenSize.getWidth() / 10;
        //double height = screenSize.getHeight() / 10;
  
    private final double length = 100;
    private final double height = 100;
    public ScoreBoard scoreBoard;
    public Board board;
    
    public GameLayout(int nPlayers) throws Exception{
        this.setSize();
        
        GridPane mainGp = new GridPane();
        mainGp.setAlignment(Pos.CENTER);
        
        this.setScoreBoard();
        this.setBoard(nPlayers);

        mainGp.add(this.getScoreBoard(), 0, 0);
        mainGp.add(this.getBoard(), 0, 1);
        //Board gameBoard = new Board();
        //this.setCenter(gameBoard);
        //ScoreBoard scoreBoard = new ScoreBoard();
        //this.setTop(scoreBoard);
        this.setCenter(mainGp);
        this.setBottom(LBLHINT);
        LBLHINT.setVisible(true);
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        
    }
    
    private void setSize(){
        this.setMinSize(length, height);
        this.setMaxSize(length, height);
    }
    
    public static void setLBLHINT(Label label){
        LBLHINT = label;
    }
    
    public static Label getLBLHINT(){
        return LBLHINT;
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

