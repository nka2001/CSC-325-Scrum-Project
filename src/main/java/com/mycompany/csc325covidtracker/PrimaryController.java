package com.mycompany.csc325covidtracker;


import static com.mycompany.csc325covidtracker.Covid19Api.myApi;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import org.json.simple.JSONObject;

public class PrimaryController {

    @FXML
    private ListView<String> ListView;
    
  
    
    
    private void initalize(){
        JSONObject obj = myApi();
        
        JSONObject obj1 = (JSONObject) obj.get("Global");
        System.out.println("\tNew Confrimed: " + obj1.get("NewConfirmed"));
        System.out.println("\tTotal Confirmed: " + obj1.get("TotalConfirmed"));
        System.out.println("\tNew Deaths: " + obj1.get("NewDeaths"));
        System.out.println("\tTotal Deaths: " + obj1.get("TotalDeaths"));
        System.out.println("\tNew Recovered: " + obj1.get("NewRecovered"));
        System.out.println("\tTotal Recovered: " + obj1.get("TotalRecovered"));
        
        
    }
    
    
    @FXML
    private void switchToUserInfo() throws IOException {
        
      
        App.setRoot("userinfo");
    }
    
    
    @FXML
    private void switchToAge() throws IOException{
        App.setRoot("userage");
    }
    
    @FXML
    private void switchToLocation() throws IOException{
        App.setRoot("userLocation");
    }
    
    @FXML
    private void switchToEthnicity() throws IOException{
        App.setRoot("userEthicity");
    }
    /**
     * the help method will open a text file that explains the functions within
     * the program, there is only one help file, so if a user clicks on help in
     * another page, they will be directed to this help file
     *
     * @throws IOException
     */
    @FXML
    private void Help() throws IOException {
        File helpFile = new File("Help.txt");//specify the file, in this case help
        Desktop d = Desktop.getDesktop();//use the desktop function to launch the file
        d.open(helpFile);//open and display the file

    }
    @FXML
    private void close(){
        System.exit(0);
    }

    /**
     * the showResources method will open a text file that shows the information used in the program, such as the API as well as the link to the 
     * github however, showResources is only available in the main screen, not the side functions
     * @param event
     * @throws IOException 
     */
    @FXML
    private void showResources(ActionEvent event) throws IOException {
        File resourceFile = new File("Resources.txt");//specify the file, in this case resources 
        Desktop d = Desktop.getDesktop();//use the desktop function to launch the file 
        d.open(resourceFile);//open and display the file
        
    }
}
