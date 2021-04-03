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
import javafx.stage.Stage;

/**
 *
 * @author Lucy
 */
public class Runner extends Application {
    
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
