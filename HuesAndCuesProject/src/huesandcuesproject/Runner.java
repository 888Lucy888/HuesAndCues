/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huesandcuesproject;

import GUI.ColorBlock;
import GUI.Board;
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
    Player p1;
    Player p2;
    Player p3;
    Player activePlayer;
    
    @Override
    public void init(){
        frame = new JFrame();
        String p1Name = JOptionPane.showInputDialog(frame, "Enter name: ");
        String p1Email = JOptionPane.showInputDialog(frame, "Enter eMail: ");
        p1 = new Player(p1Name, p1Email, Color.RED);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
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
