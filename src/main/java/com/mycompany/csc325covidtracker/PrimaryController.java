package com.mycompany.csc325covidtracker;


import static com.mycompany.csc325covidtracker.Covid19Api.myApi;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import org.json.simple.JSONObject;

public class PrimaryController {

    @FXML
    private VBox eth1;
    @FXML
    private CheckBox eth2;
    @FXML
    private CheckBox eth3;
    @FXML
    private CheckBox eth4;
    @FXML
    private CheckBox eth5;
    @FXML
    private Button update;
    @FXML
    private CheckBox age1;
    @FXML
    private CheckBox age2;
    @FXML
    private CheckBox age3;
    @FXML
    private CheckBox age4;
    @FXML
    private CheckBox age5;
    @FXML
    private Button update2;
    @FXML
    private BarChart<?, ?> bar;
    @FXML
    private PieChart pie;
    @FXML
    private StackedAreaChart<?, ?> stack2;
    @FXML
    private BubbleChart<?, ?> bubble;
    @FXML
    private BubbleChart<?, ?> bubble1;
    @FXML
    private RadioButton uage1;
    @FXML
    private ToggleGroup ageDemo;
    @FXML
    private RadioButton uage2;
    @FXML
    private RadioButton uage3;
    @FXML
    private RadioButton uage4;
    @FXML
    private RadioButton uage5;
    @FXML
    private RadioButton uageNotSay;
    @FXML
    private RadioButton ueth1;
    @FXML
    private ToggleGroup ethn;
    @FXML
    private RadioButton ueth2;
    @FXML
    private RadioButton ueth3;
    @FXML
    private RadioButton ueth4;
    @FXML
    private RadioButton uethNotSay;
    @FXML
    private RadioButton yesVacc;
    @FXML
    private RadioButton noVacc;
    @FXML
    private ToggleGroup VaccStatus;
    @FXML
    private RadioButton VaxNotSay;
    @FXML
    private ToggleGroup VaccStatus1;
    @FXML
    private Button submitUserInfo;
    @FXML 
    private TextField enterState;
  
    
    
   public void initialize(){
       
        startAnimations();
        //make the animations start before populating the charts
        
          
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                new PieChart.Data("Test", 50)
        
        );
        
        pie.setData(pieData);
        /*
        xAxis.setLabel("Age Demographics");
        yAxis.setLabel("Cases");
        
        bar = new BarChart<String, Number>(xAxis, yAxis);
        
        XYChart.Series s1 = new XYChart.Series();
        s1.getData().add(new XYChart.Data("18+", 100));
        
        
       bar.getData().add(s1);
        */
    }
    /**
     * this method will make all of our charts appear slowly, they SHOULD be filled with data, fadeTransitions are used to make the charts appear
     * and the opacity value is used to make the charts fade in and out 
     */
    private void startAnimations(){
        
        FadeTransition ft1 = new FadeTransition(Duration.seconds(5), pie);
        ft1.setFromValue(0.);
        ft1.setToValue(1.);
        
        FadeTransition ft2 = new FadeTransition(Duration.seconds(5), bar);
        ft2.setFromValue(0.);
        ft2.setToValue(1.);

        FadeTransition ft3 = new FadeTransition(Duration.seconds(5), stack2);
        ft3.setFromValue(0.);
        ft3.setToValue(1.);
        
        FadeTransition ft4 = new FadeTransition(Duration.seconds(5), bubble);
        ft4.setFromValue(0.);
        ft4.setToValue(1.);
        
        SequentialTransition st = new SequentialTransition(ft1, ft2, ft3, ft4);
        st.play();
        
        
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

    @FXML
    private void updateChartsEthnicites(ActionEvent event) {
    }

    @FXML
    private void updateChartsAges(ActionEvent event) {
    }

    @FXML
    private void updateSubmit(ActionEvent event) {
        
        String getState = enterState.getText();
        
        if(getState.length() > 2){
            System.out.println("error, only 2 letters for the state");
            //maybe make a method that prints out an error alert
        }
        
        String vaccineStatus = "";
        
        if(yesVacc.isSelected()){
            vaccineStatus = yesVacc.getText();
        } else if(noVacc.isSelected()){
            vaccineStatus = noVacc.getText();
        } else if(VaxNotSay.isSelected()) {
            vaccineStatus = VaxNotSay.getText();
        }

        String age = "";
        if(uage1.isSelected()){
            age = uage1.getText();
        } else if(uage2.isSelected()){
            age = uage2.getText();
        } else if(uage3.isSelected()){
            age = uage3.getText();
        } else if(uage4.isSelected()){
            age = uage4.getText();
        } else if(uage5.isSelected()){
            age = uage5.getText();
        } else {
            age = "Error";
        }
    }
}
