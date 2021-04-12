/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import huesandcuesproject.Runner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;
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

/**
 *
 * @author Lucy
 */
public class Board extends BorderPane{
    
    public static ColorBlock [][] blocks = new ColorBlock [30] [16];
    private StackPane mainStackPane;
    private GridPane gp;
    private GridPane scoreGp;
    private int iPlayers = 0;
    private final int HEIGHT = 360;
    private final int LENGTH = 640;
    public int iRounds = 0;
    //Used to clear the board
    private boolean isClear = false;
    private int score = 0;
    
    public Board (int nPlayers) throws Exception{
        
        this.setGp();
        this.setScoreGp();
        this.setMainStackPane();
        this.setCenter(this.getMainStackPane());
        this.setSize();
        
        String line;
        
        FileReader boardCSV = new FileReader("colorMatrix.csv");
        BufferedReader br = new BufferedReader(boardCSV);
        int i = 0;
        while((line = br.readLine()) != null){
            String [] seperator = line.split(",");
            for(int j = 0; j < 30; j++){
                //Creates Triangles Players can us to select their answer
                StackPane sp = new StackPane();
                Polygon tri = new Polygon();
                tri.getPoints().addAll(new Double[]{
                   0.0, 0.0,
                   10.0, 20.0,
                   20.0, 0.0
                });
                tri.setFill(Color.BLACK);
                
                //Creates a ColorBlock
                if(j==0 && i==0)
                    seperator[j] = "53251A";
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
                        if(blocks [y] [x].getSelected() && isClear){
                            tri.setVisible(false);
                        }else if(Runner.getActivePlayer().getIsLeader()){
                            
                            //Updates to 0 for next round
                            iRounds = 0;
                            for(int k = 0; k < 16; k++){
                                for(int l = 0; l < 30; l++){
                                    //Does the needed Scoring and shows it to the players
                                    Label points = new Label();
                                    points.setAlignment(Pos.CENTER);
                                    points.setMaxSize(20, 20);
                                    points.setMinSize(20, 20);
                                    points.setStyle("-fx-text-color: black; -fx-font-weight: bold");
                                    score = scoreBlocks(y, x, l, k);
                                    //Checks the players and compares them to the playe whoe selected the block
                                    //If so adds the score to the given player 
                                    for(int iCountPlayers = 0; iCountPlayers < nPlayers; iCountPlayers++){
                                        //Checks if the player selected the block
                                        Runner.activePlayer = Runner.getPlayers().get(iCountPlayers);
                                        if(Runner.activePlayer.getName().equals(blocks [l] [k].getSelectedBy())){
                                            Runner.getPlayers().get(iCountPlayers).setScore(Runner.getPlayers().get(iCountPlayers).getScore() + score);
                                            if(score>1){
                                                Runner.getPlayers().get(Runner.iPlayers).setScore(Runner.getPlayers().get(Runner.iPlayers).getScore() + 1);
                                            }
                                        }
                                    }
                                    String scr = "" + score;
                                    points.setText(scr + " ");
                                    if(score == 0){
                                        points.setVisible(false);
                                    }else{
                                        //Test Runner.activePlayer.setScore(score);
                                    }
                                    
                                    getScoreGp().add(points, l+1, k+1);
                                    //Resets score
                                    score = 0;
                                    
                                }
                            }
                            
                            for(int iCountPlayers = 0; iCountPlayers < nPlayers; iCountPlayers++){
                                System.out.println(Runner.getPlayers().get(iCountPlayers).getScore());
                            }
                            
                            getScoreGp().toFront();
                            
                            
                            //Alerts the player of the change in cue giver
                            int index = Runner.iPlayers + 1;
                            if(index == nPlayers){
                                index = 0;
                            }
                            
                            Runner.userInput.showAlertWindow(Runner.getPlayers().get(index).getName() + " is the cue-giver");
                            
                            //Shows Scoring Board for 10 seconds
                            try{
                                TimeUnit.SECONDS.sleep(10);
                            }catch(InterruptedException ex){
                                Logger.getLogger(Board.class.getName()).log(Level.SEVERE,null, ex);
                            }
                            
                            //Resets ScoringBoard
                            resetScore();
                            
                            clearBlocks();
                            //Changes the hint-giver to the next player
                            Runner.getPlayers().get(Runner.getiPlayers()).setIsLeader(false);
                            Runner.iPlayers++;
                            if(Runner.iPlayers == nPlayers){
                                Runner.iPlayers = 0;
                            }
                            Runner.getPlayers().get(Runner.getiPlayers()).setIsLeader(true);
                            Runner.activePlayer = Runner.getPlayers().get(Runner.getiPlayers());
                            
                            
                            //Asks the hint-giver for their first hint
                            Runner.getGame().changeHint(Runner.askFirstHint());
                            Runner.iPlayers++;
                            if(Runner.iPlayers == nPlayers){
                                Runner.iPlayers = 0;
                            }
                            Runner.activePlayer = Runner.getPlayers().get(Runner.getiPlayers());
                        }
                        //Used to put the pieces of the other players
                        else{
                            setAsSelected(y, x, Runner.getActivePlayer().getName());
                            //Sets a triangle 
                            tri.setFill(Runner.getActivePlayer().getColor());
                            tri.setVisible(true);
                            //Changes the current player
                            Runner.iPlayers++;
                            //Used if the max value of the array is reached
                            if(Runner.iPlayers == nPlayers){
                                Runner.iPlayers = 0;
                            }
                            Runner.activePlayer = Runner.getPlayers().get(Runner.getiPlayers());
                            //If the current player is detected as the hint-giver
                            //Asks for a hint without need of pressing anything
                            if(Runner.getActivePlayer().getIsLeader() && iRounds == 0){
                                //Updates the round pointing that a full round has passed
                                iRounds++;
                                try {
                                    //Asks if they want to give another hint
                                    Runner.getUserInput().askForAnotherHint();
                                } catch (Exception ex) {
                                    Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                //If yes they give another hint and the hint is updated
                                if(Runner.getUserInput().getHintConfirm()){
                                    Runner.getGame().changeHint(Runner.askAnotherHint());
                                    Runner.iPlayers++;
                                    if(Runner.getiPlayers() == nPlayers){
                                        Runner.setiPlayers(0);
                                    }
                                    Runner.activePlayer = Runner.getPlayers().get(Runner.getiPlayers());
                                }
                            }
                            //Else it's ignored and he can select the correct block
                            else if(Runner.activePlayer.getIsLeader() && iRounds != 0)
                                Runner.getUserInput().showAlertWindow(Runner.getActivePlayer().getName() + " choose the correct block");
                        }
                    }
                });
                GridPane.setConstraints(sp, j+1, i+1);
                this.getGp().getChildren().add(sp);
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
        
        
        
        //while(!br.readLine().isEmpty()){
            //String colorCodes[] = br.readLine().split(" ");
        //}    
    }
    
    private void setSize(){
        this.setMinSize(LENGTH, HEIGHT);
        this.setMaxSize(LENGTH, HEIGHT);
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
    
    //Scores blocks based on distance
    private int scoreBlocks(int y, int x, int l, int k){
        int score = 0;
        int maxDistance;
        int distanceX = blocks [y] [x].getPosX() - blocks [l] [k].getPosX();
        int distanceY = blocks [y] [x].getPosY() - blocks [l] [k].getPosY();
        if(distanceX<0) distanceX *= -1;
        if(distanceY<0) distanceY *= -1;
        if(distanceY > distanceX)
            maxDistance = distanceY;
        else
            maxDistance = distanceX;
        switch(maxDistance){
            case 0:
                score = 3;
                break;
            case 1:
                score = 2;
                break;
            case 2:
                score = 1;
                break;
            default:
                score = 0;
                break;
        }
        return score;
    }
    
    //Grabs a ColorBlock and sets it as selected
    private void setAsSelected(int j, int i, String name){
        blocks [j] [i].setAsSelected();
        blocks [j] [i].setSelectedBy(name);
    }
    
    //Grbas a ColorBlock and resets selections
    private void clearSelected(int j, int i){
        blocks [j] [i].clearSelected();
        blocks [j] [i].clearSelectedBy();
    }
    
    private void clearBlocks(){
        //Clears all the blocks
        isClear = true;
        for(int k = 0; k < 16; k++){
            for(int l = 0; l < 30; l++){
                if(blocks [l] [k].getSelected())
                    blocks [l] [k].fire();
                clearSelected(l, k);
            }
        }
        isClear = false;
    }

    public GridPane getGp() {
        return gp;
    }

    private void setGp() {
        this.gp = new GridPane();
    }
    
    public GridPane getScoreGp() {
        return scoreGp;
    }

    private void setScoreGp() {
        this.scoreGp = new GridPane();
        this.setCenter(scoreGp);
        Label space = new Label(".");
        space.setMinSize(20, 20);
        this.scoreGp.add(space, 0, 0);
    }
    
    private void resetScore(){
        this.scoreGp.getChildren().clear();
        this.scoreGp.toBack();
    }

    public StackPane getMainStackPane() {
        return mainStackPane;
    }

    public void setMainStackPane() {
        this.mainStackPane = new StackPane();
        this.mainStackPane.getChildren().add(scoreGp);
        this.mainStackPane.getChildren().add(gp);
    }
    
    
}
