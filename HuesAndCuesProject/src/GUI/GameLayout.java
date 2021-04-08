/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import huesandcuesproject.Player;
import java.awt.Dimension;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author Lucy
 */
public class GameLayout extends BorderPane{
    
    public GameLayout(int nPlayers) throws Exception{
        
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        double length = screenSize.getWidth() / 10;
        double height = screenSize.getHeight() / 10;
    
        
        this.setSize(length, height);
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
    
    private void setSize(double length, double height){
        this.setMinSize(length, height);
        this.setMaxSize(length, height);
    }
}
