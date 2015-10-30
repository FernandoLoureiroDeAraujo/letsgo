package br.com.viewfx;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author fernando
 */
public class StartProgram extends Application {
       
    @Override
    public void start(Stage primaryStage) {
        LoginPane lp = new LoginPane();
        lp.inicia();
    } 
    
            
    public static void main(String[] args) {
        Application.launch(args);
    }
}
