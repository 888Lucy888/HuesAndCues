/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import huesandcuesproject.Player;
import huesandcuesproject.Runner;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 *
 * @author Guest
 */
public class CustomDialogs{
    
    private int nPlayers;
    private Player player;
    //Boolean that stores if they want another hint
    private boolean confirm;
    
    public void getNumberOfUsers() throws Exception{
        final String [] values = { "3", "4", "5", "6", "7", "8", "9", "10" };
        List<String> dialogValues;
        dialogValues = Arrays.asList(values);
        ChoiceDialog<String> chooseNumberOfUsers;
        chooseNumberOfUsers = new ChoiceDialog<String>(dialogValues.get(0), dialogValues);
        chooseNumberOfUsers.setHeaderText("Select number of players");
        chooseNumberOfUsers.initStyle(StageStyle.UNDECORATED);
        Optional <String> result = chooseNumberOfUsers.showAndWait();
        if(result.isPresent())
              Runner.nOfPlayers = Integer.parseInt(result.get());
    }
    
    //Creates a window that asks for name and email
    public Player createNewPlayer() throws Exception{
        
        //Window Elements
        Label lblName = new Label("Name");
        Label lblEmail = new Label("Email");
        TextField txtName = new TextField();
        TextField txtEmail = new TextField();

        //Basic format
        GridPane gpUserDialog = new GridPane();
        gpUserDialog.add(lblName, 0, 0);
        gpUserDialog.add(lblEmail, 0, 1);
        gpUserDialog.add(txtName, 1, 0);
        gpUserDialog.add(txtEmail, 1, 1);
        
        //Window that will support all the previous nodes
        Dialog<Player> dialog = new Dialog<>();
        dialog.getDialogPane().setContent(gpUserDialog);

        //Adds a button to finish the window
        ButtonType buttonTypeOk = new ButtonType("Done", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        dialog.initStyle(StageStyle.UNDECORATED);
        
        //Converts the fields into a Player object
        dialog.setResultConverter(new Callback <ButtonType, Player>(){
            @Override
            public Player call(ButtonType b){
                if(b == buttonTypeOk){
                    Color color;
                    switch(Runner.iPlayers){
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
                    return new Player(txtName.getText(), txtEmail.getText(), color);
                }
                return null;
            }
        });

        //Stores the player
        Optional <Player> result = dialog.showAndWait();

        //Checks if there's a player, and checks if the fields are valid
        if(result.isPresent()){
            if(txtName.getText().isEmpty() || txtEmail.getText().isEmpty()){
                return null;
            }else{
                return result.get();
            }
        }

        return null;
    }
    
    public String askHint(){
        //Window that recieves user input in text
        TextInputDialog dialog = new TextInputDialog();
        
        dialog.initStyle(StageStyle.UNDECORATED);
        
        dialog.setTitle("Hint");
        dialog.setHeaderText("CHECK YOUR EMAIL FOR YOUR CARD... After you have chosen a color, enter a one word hint:");
        
        Optional <String> result = dialog.showAndWait();
        
        //Converts the result into String and returns them
        if(result.isPresent()){
            return(result.get());
        }else{
            return ("");
        }
        
    }
    
    public void askForAnotherHint() throws Exception{
        //Creates a Yes/No window
        Label lblHint = new Label("Want to give another hint?");
        
        Dialog<String> dialog = new Dialog<>();
        
        dialog.getDialogPane().setContent(lblHint);
        dialog.initStyle(StageStyle.UNDECORATED);
        
        ButtonType buttonTypeOk = new ButtonType("Yes", ButtonData.YES);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        
        ButtonType buttonTypeNo = new ButtonType("No", ButtonData.NO);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeNo);
        
        dialog.setResultConverter(new Callback <ButtonType, String>(){
            @Override
            public String call(ButtonType b){
                if(b == buttonTypeOk){
                    return "YES";
                }
                return "NO";
            }
        });
        
        Optional <String> result = dialog.showAndWait();
        
        if(result.isPresent()){
            if(result.get().equals("YES"))
                confirm = true;
            else
                confirm = false;
        }
        
    }
    
    //Returns the global variable confirm, that was obtained in method
    //askForAnotherHint
    public boolean getHintConfirm(){
        return confirm;
    }
    
}
