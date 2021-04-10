/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huesandcuesproject;

import GUI.*;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/**
 *
 * @author Lucy
 */
public class Runner extends Application {
    
    private final double length = 800;
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
        
        //Setting up number of Players and their information
        CustomDialogs userInput = new CustomDialogs();
        userInput.getNumberOfUsers();
        for(int i = 0; i<nOfPlayers; i++){
            userInput.createNewPlayer();
            iPlayers++;
            players.add(activePlayer);
        }
        
        for(int turn = 0; turn<nOfPlayers; turn++){}
        activePlayer = players.get(0);
        
        //userInput.askHint();
        
        GameLayout game = new GameLayout(nOfPlayers);
        
        //Turning ColorBlocks into an Array so we can shuffle it wiith Collections
        ColorBlock[][] shuffleBlocks = game.getBoard().getBlocks();
        List<ColorBlock> shuffledArrayList = new ArrayList<>();
        for (ColorBlock[] colorIndex : shuffleBlocks) {
            for (ColorBlock i : colorIndex) {
                shuffledArrayList.add(i);
            }
        }
        Collections.shuffle(shuffledArrayList);
      
        //Create cards, index increases by 4:
        Card tempCard = new Card(shuffledArrayList);
        //MailSender.sendHTML("chuggaaconroy888@gmail.com", new Card(shuffledArrayList).toHTML());
        //MailSender.sendHTML("crlvlz0215@gmail.com", new Card(shuffledArrayList).toHTML());
        
        userInput.askHint();
        
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
