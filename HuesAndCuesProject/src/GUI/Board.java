/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Lucy
 */
public class Board extends BorderPane{
    
    public Board () throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("css color file route");
        BufferedReader br = new BufferedReader(fr);
        
        while(!br.readLine().isEmpty()){
            //String colorCodes[] = br.readLine().split(" ");
        }
        
    }
    
}
