/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huesandcuesproject;

import GUI.ColorBlock;
import GUI.Board;
import GUI.GameLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucy
 */
public class Runner extends Application {
    
    private JFrame frame;
    public static Player activePlayer;
    public static ArrayList<Player> players = new ArrayList<Player>();
    
    @Override
    public void init(){
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth() / 1.8;
        double height = screenSize.getHeight() / 1.5;
        frame = new JFrame();
        int nOfPlayers;
        do{
            String numberOfPlayers = JOptionPane.showInputDialog(frame, "Enter number of players (3-10): ");
            nOfPlayers = Integer.parseInt(numberOfPlayers);
        }while(nOfPlayers>10 || nOfPlayers<3);
        for(int i = 0; i<nOfPlayers; i++){
            String pName = JOptionPane.showInputDialog(frame, "Enter name: ");
            String pEmail = JOptionPane.showInputDialog(frame, "Enter eMail: ");
            Color color;
            switch(i){
                case 0:
                    color = Color.RED;
                    break;
                case 1:
                    color = Color.BLUE;
                    break;
                case 2:
                    color = Color.GREEN;
                    break;
                case 3:
                    color = Color.ORANGE;
                    break;
                case 4:
                    color = Color.BLUEVIOLET;
                    break;
                case 5:
                    color = Color.BURLYWOOD;
                    break;
                case 6:
                    color = Color.DARKGOLDENROD;
                    break;
                case 7:
                    color = Color.DARKRED;
                    break;
                case 8:
                    color = Color.CORAL;
                    break;
                case 9:
                    color = Color.GREY;
                    break;
                default:
                    color = Color.BLACK;
                    break;
            }
            Player player = new Player(pName, pEmail, color);
            players.add(player);
            activePlayer = players.get(0);
        }
        GameLayout game = new GameLayout(nOfPlayers);
        //ColorBlock btn = new ColorBlock("53251A");
        
        //StackPane root = new StackPane();
        //root.getChildren().add(game);
        
        Scene scene = new Scene(game, width, height);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        //ColorBlock color = new ColorBlock("53251A");
        //MailSender.sendCard("0240599@up.edu.mx", color);
        launch(args);
    }
    
}
