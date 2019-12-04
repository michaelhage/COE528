package ScenePackage;

import bankPackage.AccountInformation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserMainMenu {
    
    private static AccountInformation account;
    
    public static Scene userMainMenuScene(Stage window, String username) throws FileNotFoundException{
        
        account = new AccountInformation(username);
        
        //GUI Banner File
        File bannerFile = new File("ProjectItems/GUI_images/banner.png");
        
        //making the Scene non resizable
        BorderPane bp = new BorderPane();
        
        //Top Pane
        
        //Creating an image 
        Image image = new Image(new FileInputStream(bannerFile));  
        //Setting the image view 
        ImageView imageView = new ImageView(image);
        
        //Setting the preserve ratio of the image view 
        imageView.setPreserveRatio(true);
        bp.setTop(imageView);
        
        
        //Bottom Pane
        
        //Create the Horizontal Box
        HBox bottomBox = new HBox();
        bottomBox.setPadding(new Insets(20,50,20,20));
        
        //Log Out button
        Button logOutButton = new Button("Log Out");
        logOutButton.setPrefSize(100, 20);
        
        //Log Out Button Action
        logOutButton.setOnAction(e -> {
            try {
                //Confirmation to log out
                if(ConfirmationBox.display("Confirmation", "Are You Sure You"
                        + " Want To Log Out")){
                    
                    account.saveAccountInformation();
                
                    //return to main menu
                    window.setScene(MainMenu.mainMenuScene(window));
                }
            } catch (Exception ex) {
                Logger.getLogger(UserMainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        bottomBox.getChildren().addAll(logOutButton);
        bottomBox.setAlignment(Pos.CENTER_RIGHT);
        bottomBox.setStyle("-fx-background-color: #3F669A;");
        bp.setBottom(bottomBox);
        
        //Right Pane
        
        //Create a Vertical Box Alignemnt
        VBox rightBox = new VBox();
        rightBox.setPadding(new Insets(50));
        rightBox.setSpacing(8);
        rightBox.setStyle("-fx-background-color: #D0D3D4;");
        
        Text accountTitle = new Text("Account Information");
        accountTitle.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        Label accountName = new Label("Account Name: "+ 
                account.getUserFirstName() + " "+ account.getUserLastName());
        Label accountBalance = new Label("Account Balance: "+ 
                account.getAccountBalance());
        Label accountState = new Label("Account Membership "+ 
                account.getAccountState().toString());
        
        rightBox.getChildren().addAll(accountTitle, accountName, 
                accountBalance, accountState);
        
        bp.setRight(rightBox);
        
        //Center Pane
        VBox centerBox = new VBox();
        centerBox.setPadding(new Insets(10, 10, 0, 10));
        centerBox.setSpacing(10);
        
        //Add the deposit Button
        Button depositButton = new Button("Deposit");
        depositButton.setPrefSize(300, 60);
        
        //Add the withdrawl button
        Button withdrawlButton = new Button("Withdrawl");
        withdrawlButton.setPrefSize(300, 60);
        
        //Add the transactions
        Button transactionButton = new Button("Transaction");
        transactionButton.setPrefSize(300, 60);
        
        //Deposit Button Action
        depositButton.setOnAction(e -> {
            String text = textInputScreen("Deposit", "Please input the "
                    + "amount of money you would like to deposit");
            if(isValidDouble(text)){
                double savings = Math.round(Double.parseDouble(text) * 100.0) / 100.0;
                account.addAccountBalance(savings);
                
                accountBalance.setText("Account Balance: "+ 
                        account.getAccountBalance());
                accountState.setText("Account Membership "+ 
                account.getAccountState().toString());
            }
        });
        
        //Withdraw Button Action
        withdrawlButton.setOnAction(e -> {
            String text = textInputScreen("Withdrawl", "Please input the "
                    + "amount of money you would like to withdraw");
            if(isValidDouble(text) && isValidValue(Double.parseDouble(text))){
                double savings = Math.round(Double.parseDouble(text) * 100.0) / 100.0;
                account.addAccountBalance(-savings);
                
                accountBalance.setText("Account Balance: "+ 
                        account.getAccountBalance());
                accountState.setText("Account Membership "+ 
                account.getAccountState().toString());
            }
        });
        
        //Withdraw Button Action
        transactionButton.setOnAction(e -> {
            String text = textInputScreen("Transaction", "Please input the "
                    + "amount of money the object(s) cost");
            if(isValidDouble(text) && 
                isValidValue(Double.parseDouble(text) + 
                        account.getAccountState().getFee()) ){
                
                double savings = Math.round(Double.parseDouble(text) * 100.0) / 100.0;
                System.out.println(savings);
                account.addAccountBalance(- savings - 
                        account.getAccountState().getFee());
                
                accountBalance.setText("Account Balance: "+ 
                    account.getAccountBalance());
                accountState.setText("Account Membership "+ 
                    account.getAccountState().toString());
            }
        });
        
        centerBox.getChildren().addAll(depositButton, withdrawlButton,
                transactionButton);
        
        
        centerBox.setStyle("-fx-background-color: #7799C8;");
        
        bp.setCenter(centerBox);
        
        //Closing the program and calling the close program method
        window.setOnCloseRequest(e -> {
            
            //consume the close event, to not force a close
            e.consume();   
            closeProgram();
        });
        
        
        //Create the scene
        Scene scene = new Scene(bp, 1050, 500);
        
        return scene;
    }
    
    public static String textInputScreen(String title, String message){
        return TextInputBox.display(title, message);
    }
    public static boolean isValidDouble(String str){
         try{   
            double savings = Double.parseDouble(str);
            
            if(savings <= 0){
                AlertBox.display("Error","Invalid Input");
                return false;
            }
            
            return true;
            }
         catch(NumberFormatException ex){
            AlertBox.display("Error","Invalid Input");
            return false;
            }
    }
    
    public static boolean isValidValue(double amount){
            if(amount < account.getAccountBalance() && (amount - account.getAccountState().getFee() ) > 50){
                return true;
            }
            else{
                AlertBox.display("Error","Invalid Input");
                return false;
            }
        }
    //Close the program safely
    private static void closeProgram(){
        boolean answer = ConfirmationBox.display("Title",
                "Are you sure you want to exit");
        
        //closes the application properly
        if(answer){
            
            try {
                account.saveAccountInformation();
            } catch (IOException ex) {
                AlertBox.display("Error", "File Not Found");
            }
            
            Platform.exit();
        }
        
    }
}
