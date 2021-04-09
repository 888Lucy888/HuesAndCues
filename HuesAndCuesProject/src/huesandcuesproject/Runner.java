/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huesandcuesproject;

import GUI.ColorBlock;
import GUI.Board;
import GUI.CustomDialogs;
import GUI.GameLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Lucy
 */
public class Runner extends Application {
    
    private double width;
    private double height;
    public static int nOfPlayers;
    public static int iPlayers = 0;
    public static Player activePlayer;
    public static ArrayList<Player> players = new ArrayList<Player>();
    
    @Override
    public void init() throws Exception{
        
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.getWidth() / 1.8;
        height = screenSize.getHeight() / 1.5;
        CustomDialogs userInput = new CustomDialogs();
        userInput.getNumberOfUsers();
        for(int i = 0; i<nOfPlayers; i++){
            userInput.createNewPlayer();
            iPlayers++;
            players.add(activePlayer);
        }
        activePlayer = players.get(0);
        
        userInput.askHint();
        GameLayout game = new GameLayout(nOfPlayers);
        Scene scene = new Scene(game, width, height);
        
        primaryStage.setTitle("Hues And Cues");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        launch(args);
    }
    
}
