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
import javafx.application.Platform;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

/**
 *
 * @author Guest
 */
public class CustomDialogs{
    
    private int nPlayers;
    private Player player;
    
    public void getNumberOfUsers() throws Exception{
        final String [] values = { "3", "4", "5", "6", "7", "8", "9", "10" };
//        List<String> dialogValues;
//        dialogValues = Arrays.asList(values);
//        ChoiceDialog<String> chooseNumberOfUsers;
                List<String> dialogValues;
                dialogValues = Arrays.asList(values);
                ChoiceDialog<String> chooseNumberOfUsers;
                chooseNumberOfUsers = new ChoiceDialog<String>(dialogValues.get(0), dialogValues);
                chooseNumberOfUsers.setHeaderText("Select number of players");
                Optional <String> result = chooseNumberOfUsers.showAndWait();
                if(result.isPresent())
                    Runner.nOfPlayers = Integer.parseInt(result.get());
    }
    
    public void createNewPlayer() throws Exception{
                Label lblName = new Label("Name");
                Label lblEmail = new Label("Email");
                TextField txtName = new TextField();
                TextField txtEmail = new TextField();

                GridPane gpUserDialog = new GridPane();
                gpUserDialog.add(lblName, 0, 0);
                gpUserDialog.add(lblEmail, 0, 1);
                gpUserDialog.add(txtName, 1, 0);
                gpUserDialog.add(txtEmail, 1, 1);

                Dialog<Player> dialog = new Dialog<>();
                dialog.getDialogPane().setContent(gpUserDialog);

                ButtonType buttonTypeOk = new ButtonType("Listo", ButtonData.OK_DONE);
                dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

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

                Optional <Player> result = dialog.showAndWait();

                if(result.isPresent()){
                    Runner.activePlayer = result.get();
                }
    }
    
}
