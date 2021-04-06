/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huesandcuesproject;

import GUI.ColorBlock;
import GUI.Board;
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
    
    JFrame frame;
    Player activePlayer;
    
    @Override
    public void init(){
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        ArrayList<Player> players = new ArrayList<Player>();
        frame = new JFrame();
        int nOfPlayers;
        do{
            String numberOfPlayers = JOptionPane.showInputDialog(frame, "Enter number of players (3-10): ");
            nOfPlayers = Integer.parseInt(numberOfPlayers);
        }while(nOfPlayers>10 || nOfPlayers<3);
        for(int i = 0; i<nOfPlayers; i++){
            String pName = JOptionPane.showInputDialog(frame, "Enter name: ");
            String pEmail = JOptionPane.showInputDialog(frame, "Enter eMail: ");
            Player player = new Player(pName, pEmail, Color.RED);
            players.add(player);
        }
        Board game = new Board();
        ColorBlock btn = new ColorBlock("53251A");
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        //StackPane root = new StackPane();
        //root.getChildren().add(game);
        
        Scene scene = new Scene(game, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        //MailSender.sendTo("crlvlz0215@gmail.com", "Test message by Carlos");
        launch(args);
    }
    
}
