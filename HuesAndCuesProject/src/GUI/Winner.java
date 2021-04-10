/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import huesandcuesproject.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
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
public class Winner extends BorderPane {
    private final int height = 350;
    private final int length = 450;
    public Winner(Player winner){
        
        //Creating messages
        GridPane winnerMsg = new GridPane();
        Label congrats = new Label("Congratulations!");
        Label name = new Label("The winner is "+winner.getName());
        Label score = new Label("with a score of "+String.valueOf(winner.getScore())+" points");
        
        //Setting styles
        this.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        winnerMsg.setStyle("-fx-background-color: pink");
        congrats.setStyle("-fx-text-fill: black; -fx-font-weight: bold; -fx-font-size: 40");
        name.setStyle("-fx-text-fill: black; -fx-font-weight: bold; -fx-font-size: 28");
        score.setStyle("-fx-text-fill: black; -fx-font-weight: bold; -fx-font-size: 25");
        
        //Node Alignment and Size
        congrats.setAlignment(Pos.CENTER);
        name.setAlignment(Pos.CENTER);
        score.setAlignment(Pos.CENTER);
        winnerMsg.setAlignment(Pos.CENTER);
        winnerMsg.setMaxSize(length, height);
        winnerMsg.setMinSize(length, height);
        
        //Adding messages
        winnerMsg.add(congrats, 0, 0);
        winnerMsg.add(name, 0, 1);
        winnerMsg.add(score, 0, 2);
        this.setCenter(winnerMsg);    
    }
}
