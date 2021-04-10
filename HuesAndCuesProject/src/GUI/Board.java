/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import huesandcuesproject.Player;
import huesandcuesproject.Runner;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Scale;

/**
 *
 * @author Lucy
 */
public class Board extends BorderPane{
    
    public static ColorBlock [][] blocks = new ColorBlock [30] [16];
    private GridPane gp;
    private final int height = 360;
    private final int length = 640;
    public int iRounds = 0;
    
    public Board (int nPlayers) throws Exception{
        
        this.setSize();
        gp = new GridPane();
        
        String line;
        
        FileReader boardCSV = new FileReader("colorMatrix.csv");
        BufferedReader br = new BufferedReader(boardCSV);
        int i = 0;
        while((line = br.readLine()) != null){
            String [] seperator = line.split(",");
            for(int j = 0; j < 30; j++){
                StackPane sp = new StackPane();
                Polygon tri = new Polygon();
                tri.getPoints().addAll(new Double[]{
                   0.0, 0.0,
                   10.0, 20.0,
                   20.0, 0.0
                });
                tri.setFill(Color.BLACK);
                
                //Creates a ColorBlock
                blocks [j] [i] = new ColorBlock(seperator[j], i, j);
                
                //Adds position to the ColorBlock
                String letter = this.getLetterForNumber(i);
                String number = String.valueOf(j+1);
                blocks[j][i].setPosition(letter, number);
                
                sp.getChildren().add(blocks [j] [i]);
                sp.getChildren().add(tri);
                tri.setVisible(false);
                
                final int y = j;
                final int x = i;
                //Sets action for color block on click
                blocks [j] [i].setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                        //Checks if the player who gave the hint is the current player
                        if(Runner.activePlayer.getIsLeader()){
                            //Updates to 0 for next round
                            iRounds = 0;
                            //TODO add scoring
                            System.out.println("You selected the correct color");
                            //Changes the hint-giver to the next player
                            Runner.players.get(Runner.iPlayers).setIsLeader(false);
                            Runner.iPlayers++;
                            if(Runner.iPlayers == nPlayers){
                                Runner.iPlayers = 0;
                            }
                            Runner.players.get(Runner.iPlayers).setIsLeader(true);
                            Runner.activePlayer = Runner.players.get(Runner.iPlayers);
                            //Asks the hint-giver for their first hint
                            Runner.askFirstHint();
                        }
                        //Used to put the pieces of the other players
                        else{
                            setAsSelected(y, x);
                            //Sets a triangle 
                            tri.setFill(Runner.activePlayer.getColor());
                            tri.setVisible(true);
                            //Changes the current player
                            Runner.iPlayers++;
                            //Used if the max value of the array is reached
                            if(Runner.iPlayers == nPlayers){
                                Runner.iPlayers = 0;
                            }
                            Runner.activePlayer = Runner.players.get(Runner.iPlayers);
                            //If the current player is detected as the hint-giver
                            //Asks for a hint without need of pressing anything
                            if(Runner.activePlayer.getIsLeader() && iRounds == 0){
                                //Updates the round pointing that a full round has passed
                                iRounds++;
                                try {
                                    //Asks if they want to give another hint
                                    Runner.userInput.askForAnotherHint();
                                } catch (Exception ex) {
                                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                //If yes they give another hint and the hint is updated
                                if(Runner.userInput.getHintConfirm()){
                                    Runner.game.changeHint(Runner.askAnotherHint());
                                    Runner.iPlayers++;
                                    if(Runner.iPlayers == nPlayers){
                                        Runner.iPlayers = 0;
                                    }
                                    Runner.activePlayer = Runner.players.get(Runner.iPlayers);
                                }
                                //Else it's ignores and he can seect the correct block
                            }
                        }
                    }
                });
                GridPane.setConstraints(sp, j+1, i+1);
                gp.getChildren().add(sp);
            }
            i++;
        }
        
        //Add letters
        for(int cont=0; cont<16; cont++){
            String letter = this.getLetterForNumber(cont);
            Label tempLetter = new Label(letter);
            tempLetter.setAlignment(Pos.CENTER);
            tempLetter.setMaxSize(20, 20);
            tempLetter.setMinSize(20, 20);
            tempLetter.setStyle("-fx-text-fill: white; -fx-font-weight: bold");            
            GridPane.setConstraints(tempLetter, 0, cont+1);
            gp.getChildren().add(tempLetter);
        }
        for(int cont=0; cont<16; cont++){
            String letter = this.getLetterForNumber(cont);
            Label tempLetter = new Label(letter);
            tempLetter.setAlignment(Pos.CENTER);
            tempLetter.setMaxSize(20, 20);
            tempLetter.setMinSize(20, 20);
            tempLetter.setStyle("-fx-text-fill: white; -fx-font-weight: bold");            
            GridPane.setConstraints(tempLetter, 31, cont+1);
            gp.getChildren().add(tempLetter);
        }
        
        //Add numbers
        for(int cont=1; cont<31; cont++){
            String number = String.valueOf(cont);
            Label tempNumber = new Label(number);
            tempNumber.setAlignment(Pos.CENTER);
            tempNumber.setMaxSize(20, 20);
            tempNumber.setMinSize(20, 20);
            tempNumber.setStyle("-fx-text-fill: white; -fx-font-weight: bold");            
            GridPane.setConstraints(tempNumber, cont, 0);
            gp.getChildren().add(tempNumber);
        }
        for(int cont=1; cont<31; cont++){
            String number = String.valueOf(cont);
            Label tempNumber = new Label(number);
            tempNumber.setAlignment(Pos.CENTER);
            tempNumber.setMaxSize(20, 20);
            tempNumber.setMinSize(20, 20);
            tempNumber.setStyle("-fx-text-fill: white; -fx-font-weight: bold");            
            GridPane.setConstraints(tempNumber, cont, 17);
            gp.getChildren().add(tempNumber);
        }
        
        gp.setStyle("-fx-background-color: black");
        gp.setAlignment(Pos.BOTTOM_CENTER);
        
        this.setCenter(gp);
        
        
        //while(!br.readLine().isEmpty()){
            //String colorCodes[] = br.readLine().split(" ");
        //}    
    }
    
    private void setSize(){
        this.setMinSize(length, height);
        this.setMaxSize(length, height);
    }

    public ColorBlock[][] getBlocks() {
        return blocks;
    }

    private void setBlocks(ColorBlock[][] blocks) {
        this.blocks = blocks;
    }
    
    private String getLetterForNumber(int i) {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        if (i > 25) {
            return null;
        }
        return Character.toString(alphabet[i]);
    }
    
    private int scoreBlocks(ColorBlock correct, ColorBlock guessed){
        int score = 0;
        
        return score;
    }
    
    private void setAsSelected(int j, int i){
        blocks [j] [i].setAsSelected();
        blocks [j] [i].setSelectedBy();
    }
    
    private void clearSelected(int j, int i){
        blocks [j] [i].clearSelected();
        blocks [j] [i].clearSelectedBy();
    }
    
}
