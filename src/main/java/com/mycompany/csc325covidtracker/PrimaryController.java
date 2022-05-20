package com.mycompany.csc325covidtracker;

import static com.mycompany.csc325covidtracker.Covid19Api.myApi;
import static com.mycompany.csc325covidtracker.CovidActNow.*;
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
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

    public void initialize() {

        startAnimations();
        //make the animations start before populating the charts

        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                new PieChart.Data("Test", 50)
        );

        pie.setData(pieData);

        JSONObject obj = al();//Alabama data
        JSONObject obj1 = (JSONObject) obj.get("actuals");
        JSONObject obj2 = ak();//Alaska Data
        JSONObject akObj = (JSONObject) obj2.get("actuals");
        JSONObject obj3 = az();//Arizona Data
        JSONObject AZobj = (JSONObject) obj3.get("actuals");
        JSONObject obj4 = ar();//Arkansas Data
        JSONObject ARobj = (JSONObject) obj4.get("actuals");
        JSONObject obj6 = ca();
        JSONObject CAobj = (JSONObject) obj6.get("actuals");
        JSONObject obj7 = co();
        JSONObject COobj = (JSONObject) obj7.get("actuals");
        JSONObject obj8 = ct();
        JSONObject CTobj = (JSONObject) obj8.get("actuals");
        JSONObject obj9 = de();
        JSONObject DEobj = (JSONObject) obj9.get("actuals");
        JSONObject obj10 = dc();
        JSONObject DCobj = (JSONObject) obj10.get("actuals");
        JSONObject obj11 = fl();
        JSONObject FLobj = (JSONObject) obj11.get("actuals");
        JSONObject obj12 = ga();
        JSONObject GAobj = (JSONObject) obj12.get("actuals");
       
        JSONObject obj14 = hi();
        JSONObject HIobj = (JSONObject) obj14.get("actuals");
        JSONObject obj15 = id();
        JSONObject IDobj = (JSONObject) obj15.get("actuals");
        JSONObject obj16 = il();
        JSONObject ILobj = (JSONObject) obj16.get("actuals");
        JSONObject obj17 = in();
        JSONObject INobj = (JSONObject) obj17.get("actuals");
        JSONObject obj18 = ia();
        JSONObject IAobj = (JSONObject) obj18.get("actuals");
        JSONObject obj19 = ks();
        JSONObject KSobj = (JSONObject) obj19.get("actuals");
        JSONObject obj20 = ky();
        JSONObject KYobj = (JSONObject) obj20.get("actuals");
        JSONObject obj21 = la();
        JSONObject LAobj = (JSONObject) obj21.get("actuals");
        JSONObject obj22 = me();
        JSONObject MEobj = (JSONObject) obj22.get("actuals");
        JSONObject obj23 = md();
        JSONObject MDobj = (JSONObject) obj23.get("actuals");
        JSONObject obj24 = ma();
        JSONObject MAobj = (JSONObject) obj24.get("actuals");
        JSONObject obj25 = mi();
        JSONObject MIobj = (JSONObject) obj25.get("actuals");
        JSONObject obj26 = mn();
        JSONObject MNobj = (JSONObject) obj26.get("actuals");
        JSONObject obj27 = ms();
        JSONObject MSobj = (JSONObject) obj27.get("actuals");
        JSONObject obj28 = mo();
        JSONObject MOobj = (JSONObject) obj28.get("actuals");
        JSONObject obj29 = mt();
        JSONObject MTobj = (JSONObject) obj29.get("actuals");
        JSONObject obj30 = ne();
        JSONObject NEobj = (JSONObject) obj30.get("actuals");
        JSONObject obj31 = nv();
        JSONObject NVobj = (JSONObject) obj31.get("actuals");
        JSONObject obj32 = nh();
        JSONObject NHobj = (JSONObject) obj32.get("actuals");
        JSONObject obj33 = nj();
        JSONObject NJobj = (JSONObject) obj33.get("actuals");
        JSONObject obj34 = nm();
        JSONObject NMobj = (JSONObject) obj34.get("actuals");
        JSONObject obj35 = ny();
        JSONObject NYobj = (JSONObject) obj35.get("actuals");
        JSONObject obj36 = nc();
        JSONObject NCobj = (JSONObject) obj36.get("actuals");
        JSONObject obj37 = nd();
        JSONObject NDobj = (JSONObject) obj37.get("actuals");
        
        JSONObject obj39 = oh();
        JSONObject OHobj = (JSONObject) obj39.get("actuals");
        JSONObject obj40 = ok();
        JSONObject OKobj = (JSONObject) obj40.get("actuals");
        JSONObject obj41 = or();
        JSONObject ORobj = (JSONObject) obj41.get("actuals");
        JSONObject obj42 = pa();
        JSONObject PAobj = (JSONObject) obj42.get("actuals");
        JSONObject obj43 = pr();
        JSONObject PRobj = (JSONObject) obj43.get("actuals");
        JSONObject obj44 = ri();
        JSONObject RIobj = (JSONObject) obj44.get("actuals");
        JSONObject obj45 = sc();
        JSONObject SCobj = (JSONObject) obj45.get("actuals");
        JSONObject obj46 = sd();
        JSONObject SDobj = (JSONObject) obj46.get("actuals");
        JSONObject obj47 = tn();
        JSONObject TNobj = (JSONObject) obj47.get("actuals");
        JSONObject obj48 = tx();
        JSONObject TXobj = (JSONObject) obj48.get("actuals");
        JSONObject obj49 = ut();
        JSONObject UTobj = (JSONObject) obj49.get("actuals");
        JSONObject obj50 = vt();
        JSONObject VTobj = (JSONObject) obj50.get("actuals");
        JSONObject obj51 = va();
        JSONObject VAobj = (JSONObject) obj51.get("actuals");
       
        JSONObject obj53 = wa();
        JSONObject WAobj = (JSONObject) obj53.get("actuals");
        JSONObject obj54 = wv();
        JSONObject WVobj = (JSONObject) obj54.get("actuals");
        JSONObject obj55 = wi();
        JSONObject WIobj = (JSONObject) obj55.get("actuals");
        JSONObject obj56 = wy();
        JSONObject WYobj = (JSONObject) obj56.get("actuals");
        

        XYChart.Series s1 = new XYChart.Series();
        s1.getData().add(new XYChart.Data("Alabama", obj1.get("newCases")));
        s1.getData().add(new XYChart.Data("Alaska", akObj.get("newCases")));
        s1.getData().add(new XYChart.Data("Arizona", AZobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Arkansas", ARobj.get("newCases")));
        s1.getData().add(new XYChart.Data("California", CAobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Colorado", COobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Connecticut", CTobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Delaware", DEobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Washington D.C.", DCobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Florida", FLobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Georgia", GAobj.get("newCases")));
        
        s1.getData().add(new XYChart.Data("Hawaii", HIobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Idaho", IDobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Illinois", ILobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Indiana", INobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Iowa", IAobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Kansas", KSobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Kentucky", KYobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Louisiana", LAobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Maine", MEobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Maryland", MDobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Massachusetts", MAobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Michigan", MIobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Mississippi", MSobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Missouri", MOobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Montana", MTobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Nebraska", NEobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Nevada", NVobj.get("newCases")));
        s1.getData().add(new XYChart.Data("New Hampshire", NHobj.get("newCases")));
        s1.getData().add(new XYChart.Data("New Jersey", NJobj.get("newCases")));
        s1.getData().add(new XYChart.Data("New Mexico", NMobj.get("newCases")));
        s1.getData().add(new XYChart.Data("New York", NYobj.get("newCases")));
        s1.getData().add(new XYChart.Data("North Carolina", NCobj.get("newCases")));
        s1.getData().add(new XYChart.Data("North Datokta", NDobj.get("newCases")));
     
        s1.getData().add(new XYChart.Data("Ohio", OHobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Oklahoma", OKobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Oregon", ORobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Pennsylvania", PAobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Puerto Rico", PRobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Rhode Island", RIobj.get("newCases")));
        s1.getData().add(new XYChart.Data("South Carolina", SCobj.get("newCases")));
        s1.getData().add(new XYChart.Data("South Dakota", SDobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Tennessee", TNobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Texas", TXobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Utah", UTobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Vermont", VTobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Virginia", VAobj.get("newCases")));
        
        s1.getData().add(new XYChart.Data("Washington", WAobj.get("newCases")));
        s1.getData().add(new XYChart.Data("West Virgina", WVobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Wisconsin", WIobj.get("newCases")));
        s1.getData().add(new XYChart.Data("Wyoming", WYobj.get("newCases")));
        bar.getData().add(s1);
    }

    /**
     * this method will make all of our charts appear slowly, they SHOULD be
     * filled with data, fadeTransitions are used to make the charts appear and
     * the opacity value is used to make the charts fade in and out
     */
    private void startAnimations() {

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
    private void switchToAge() throws IOException {
        App.setRoot("userage");
    }

    @FXML
    private void switchToLocation() throws IOException {
        App.setRoot("userLocation");
    }

    @FXML
    private void switchToEthnicity() throws IOException {
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
    private void close() {
        System.exit(0);
    }

    /**
     * the showResources method will open a text file that shows the information
     * used in the program, such as the API as well as the link to the github
     * however, showResources is only available in the main screen, not the side
     * functions
     *
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

        if (getState.length() > 2) {
            System.out.println("error, only 2 letters for the state");
            getState = "Null";

            Alert a = new Alert(AlertType.ERROR);
            a.setHeaderText("Error, States should be entered as their respective 2 letter abbreviations");
            a.setTitle("Input Error");
            a.showAndWait();
            //maybe make a method that prints out an error alert
        }

        String vaccineStatus = "";

        if (yesVacc.isSelected()) {
            vaccineStatus = yesVacc.getText();
        } else if (noVacc.isSelected()) {
            vaccineStatus = noVacc.getText();
        } else if (VaxNotSay.isSelected()) {
            vaccineStatus = VaxNotSay.getText();
        }

        String age = "";
        if (uage1.isSelected()) {
            age = uage1.getText();
        } else if (uage2.isSelected()) {
            age = uage2.getText();
        } else if (uage3.isSelected()) {
            age = uage3.getText();
        } else if (uage4.isSelected()) {
            age = uage4.getText();
        } else if (uage5.isSelected()) {
            age = uage5.getText();
        } else if (uageNotSay.isSelected()) {
            age = uageNotSay.getText();
        } else {
            age = "Error";
        }

        String recommendUser = "";

        if (age.equals("Rather Not Say") || getState.equals("") || vaccineStatus.equals("Rather Not Say")) {

            recommendUser = "based on your input, we are unable to generate a completly accurate recommendation, however based on your input, we recommend that...";

        }
    }
}
