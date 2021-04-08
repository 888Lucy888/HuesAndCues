/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import huesandcuesproject.Player;
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
    private final int height = 800;
    private final int length = 1050;
    
    public GameLayout(int nPlayers) throws Exception{
        this.setSize();
        GridPane mainGp = new GridPane();
        mainGp.setAlignment(Pos.CENTER);
        mainGp.add(new Board(nPlayers), 0, 3);
        mainGp.add(new ScoreBoard(), 0, 0);
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
