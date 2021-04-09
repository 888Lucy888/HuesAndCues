/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    
    private final double length = 100;
    private final double height = 100;
    
    public GameLayout(int nPlayers) throws Exception{
        this.setSize();
        
        GridPane mainGp = new GridPane();
        mainGp.setAlignment(Pos.CENTER);
        mainGp.add(new ScoreBoard(), 0, 0);
        mainGp.add(new Board(nPlayers), 0, 1);
        //Board gameBoard = new Board();
        //this.setCenter(gameBoard);
        //ScoreBoard scoreBoard = new ScoreBoard();
        //this.setTop(scoreBoard);
        this.setCenter(mainGp);
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        
    }
    
    private void setSize(){
        this.setMinSize(length, height);
        this.setMaxSize(length, height);
    }
}
