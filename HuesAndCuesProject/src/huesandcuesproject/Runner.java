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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

/**
 *
 * @author Lucy
 */
public class Runner extends Application {
    
    //Configures GUI size
    private final double LENGTH = 800;
    private final double HEIGHT = 620;
    
    //Used to store the players
    public static int nOfPlayers;
    public static int iPlayers = 0;
    public static Player activePlayer;
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static GameLayout game;
    
    //Used to store the blocks and cards
    private static List<ColorBlock> shuffledArrayList;
    
    //Receives basic user I/O
    public static CustomDialogs userInput;
    
    //The stage
    private static Stage mainStage;
    
    @Override
    public void init() throws Exception{
        
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        mainStage = primaryStage;
        
        //Setting up number of Players and their information
        userInput = new CustomDialogs();
      
        userInput.getNumberOfUsers();
        for(int i = 0; i<nOfPlayers; i++){
            Player tempPlayer = userInput.createNewPlayer();
            if(tempPlayer != null){
                iPlayers++;
                players.add(tempPlayer);
            }else{
                i--;
            }
        }
        //Sets The Active player and resets the turn count
        activePlayer = players.get(0);
        activePlayer.setIsLeader(true);
        iPlayers = 0;
        
        //Setting up Board Game
        game = new GameLayout(nOfPlayers);
        Scene mainScene = new Scene(game, LENGTH, HEIGHT);
        mainStage.setTitle("Hues And Cues");
        mainStage.setScene(mainScene);
        mainStage.show();
        
        //Turning ColorBlocks into an Array so we can shuffle it wiith Collections
        ColorBlock[][] shuffleBlocks = game.getBoard().getBlocks();
        shuffledArrayList = new ArrayList<>();
        for (ColorBlock[] colorIndex : shuffleBlocks) {
            for (ColorBlock i : colorIndex) {
                shuffledArrayList.add(i);
            }
        }
        Collections.shuffle(shuffledArrayList);

        //To begin the game the first player gives a hint
        game.changeHint(askFirstHint());
        iPlayers++;
        activePlayer = players.get(iPlayers);
        
        //Changing Main Game Scene to Winner Scene
//        Winner winner = new Winner(new Player("Lucy","email",Color.BLUEVIOLET));
//        Scene winningScene = new Scene(winner, 500, 400);
//        primaryStage.setScene(winningScene);
        
        //Scale for different display sizes
        Scale scale = new Scale(1, 1);
        scale.setPivotX(0);
        scale.setPivotY(0);
        mainScene.getRoot().getTransforms().setAll(scale);
        
    }
    
    public static String askFirstHint(){
         //This code is used to send the card by email
        MailSender.sendHTML(activePlayer.getEmail(), new Card(shuffledArrayList).toHTML());
        String hint;
        //Asks for an input
        do{
            hint = userInput.askHint();
        }while(hint.isEmpty());
        return hint;
    }
    
    public static String askAnotherHint(){
        String hint;
        do{
            hint = userInput.askHint();
        }while(hint.isEmpty());
        return hint;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        launch(args);
    }

    public static int getnOfPlayers() {
        return nOfPlayers;
    }

    public static int getiPlayers() {
        return iPlayers;
    }

    public static Player getActivePlayer() {
        return activePlayer;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static GameLayout getGame() {
        return game;
    }

    public static CustomDialogs getUserInput() {
        return userInput;
    }

    public static void setiPlayers(int iPlayers) {
        Runner.iPlayers = iPlayers;
    }
    
    public static void limitReached(){
        Player best = null;
        for(int i = 0; i < nOfPlayers; i++){
            if(i==0)
                best = getPlayers().get(i);
            if(getPlayers().get(i).getScore() > best.getScore())
                best = getPlayers().get(i);
        }
        
        Winner win = new Winner(best);
        Scene winnerScene = new Scene(win);
        mainStage.setScene(winnerScene);
    }
    
    public static void winnerReached(Player best){
        Winner win = new Winner(best);
        Scene winnerScene = new Scene(win);
        mainStage.setScene(winnerScene);
    }
    
}
