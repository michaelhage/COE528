package ScenePackage;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;

public class BankGUIMain extends Application{
    private Stage window;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        window = primaryStage;
        window.setTitle("Online Banking Software");
        
        //initialize the scene to the main menu
        window.setScene(MainMenu.mainMenuScene(window));
        
        //set resizability to false
        window.setResizable(false);
        
        //display the GUI
        window.show();
    }
    
    //main method launches the GUI startup
    public static void main(String[] args){
        launch(args);
    }
}
