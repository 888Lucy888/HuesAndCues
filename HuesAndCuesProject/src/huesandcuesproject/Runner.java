/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huesandcuesproject;

import GUI.CustomDialogs;
import GUI.GameLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/**
 *
 * @author Lucy
 */
public class Runner extends Application {
    
    private final double length = 640;
    private final double height = 620;
    public static int nOfPlayers;
    public static int iPlayers = 0;
    public static Player activePlayer;
    public static ArrayList<Player> players = new ArrayList<Player>();
    
    @Override
    public void init() throws Exception{
        
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        CustomDialogs userInput = new CustomDialogs();
        userInput.getNumberOfUsers();
        for(int i = 0; i<nOfPlayers; i++){
            userInput.createNewPlayer();
            iPlayers++;
            players.add(activePlayer);
        }
        activePlayer = players.get(0);
        
        GameLayout game = new GameLayout(nOfPlayers);
        
        Scene scene = new Scene(game, length, height);
        
        primaryStage.setTitle("Hues And Cues");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Scale scale = new Scale(1, 1);
        scale.setPivotX(0);
        scale.setPivotY(0);
        scene.getRoot().getTransforms().setAll(scale);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        launch(args);
    }
    
}
