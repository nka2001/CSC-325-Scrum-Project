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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
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
    private Button update;
    @FXML
    private Button update2;
    @FXML
    private BarChart<?, ?> bar;
    private PieChart pie;
    private StackedAreaChart<?, ?> stack2;
    private BubbleChart<?, ?> bubble;
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
    private Button submitUserInfo;
    @FXML
    private TextField enterState;
    @FXML
    private Label rcd;
    @FXML
    private Label rcd2;
    @FXML
    private Label rcd3;
    @FXML
    private Label recomendation;

    //the following array is full of state abbriviations for input validation
    private String[] stateList = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "PR", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY", "NULL"};

    public void initialize() {

        startAnimations();
        //make the animations start before populating the charts

        JSONObject obj = al();//Alabama data
        JSONObject obj1 = (JSONObject) obj.get("actuals");
        JSONObject obj2 = ak();//Alaska Data
        JSONObject akObj = (JSONObject) obj2.get("actuals");
        JSONObject obj3 = az();//Arizona Data
        JSONObject AZobj = (JSONObject) obj3.get("actuals");
        JSONObject obj4 = ar();//Arkansas Data
        JSONObject ARobj = (JSONObject) obj4.get("actuals");
        JSONObject obj6 = ca();//california Data
        JSONObject CAobj = (JSONObject) obj6.get("actuals");
        JSONObject obj7 = co();//Colorado Data
        JSONObject COobj = (JSONObject) obj7.get("actuals");
        JSONObject obj8 = ct();//Conneticuit Data
        JSONObject CTobj = (JSONObject) obj8.get("actuals");
        JSONObject obj9 = de();//Deleware Data
        JSONObject DEobj = (JSONObject) obj9.get("actuals");
        JSONObject obj10 = dc();//Washington D.C. Data
        JSONObject DCobj = (JSONObject) obj10.get("actuals");
        JSONObject obj11 = fl();//Florida Data
        JSONObject FLobj = (JSONObject) obj11.get("actuals");
        JSONObject obj12 = ga();//Georgia Data
        JSONObject GAobj = (JSONObject) obj12.get("actuals");

        JSONObject obj14 = hi();//Hawaii Data
        JSONObject HIobj = (JSONObject) obj14.get("actuals");
        JSONObject obj15 = id();//Idaho Data
        JSONObject IDobj = (JSONObject) obj15.get("actuals");
        JSONObject obj16 = il();//Illinois Data
        JSONObject ILobj = (JSONObject) obj16.get("actuals");
        JSONObject obj17 = in();//Indiana Data
        JSONObject INobj = (JSONObject) obj17.get("actuals");
        JSONObject obj18 = ia();//Iowa Data
        JSONObject IAobj = (JSONObject) obj18.get("actuals");
        JSONObject obj19 = ks();//Kansas Data
        JSONObject KSobj = (JSONObject) obj19.get("actuals");
        JSONObject obj20 = ky();//Kentucky Data
        JSONObject KYobj = (JSONObject) obj20.get("actuals");
        JSONObject obj21 = la();//Louisiana Data
        JSONObject LAobj = (JSONObject) obj21.get("actuals");
        JSONObject obj22 = me();//Maine Data
        JSONObject MEobj = (JSONObject) obj22.get("actuals");
        JSONObject obj23 = md();//Maryland Data
        JSONObject MDobj = (JSONObject) obj23.get("actuals");
        JSONObject obj24 = ma();//Massachusetts Data
        JSONObject MAobj = (JSONObject) obj24.get("actuals");
        JSONObject obj25 = mi();//michigan Data
        JSONObject MIobj = (JSONObject) obj25.get("actuals");
        JSONObject obj26 = mn();//Minnesota data
        JSONObject MNobj = (JSONObject) obj26.get("actuals");
        JSONObject obj27 = ms();//mississippi data
        JSONObject MSobj = (JSONObject) obj27.get("actuals");
        JSONObject obj28 = mo();//missouri data
        JSONObject MOobj = (JSONObject) obj28.get("actuals");
        JSONObject obj29 = mt();//montana data
        JSONObject MTobj = (JSONObject) obj29.get("actuals");
        JSONObject obj30 = ne();//nebraska data
        JSONObject NEobj = (JSONObject) obj30.get("actuals");
        JSONObject obj31 = nv();//nevada data
        JSONObject NVobj = (JSONObject) obj31.get("actuals");
        JSONObject obj32 = nh();//hew hampshire data
        JSONObject NHobj = (JSONObject) obj32.get("actuals");
        JSONObject obj33 = nj();//new jersey data
        JSONObject NJobj = (JSONObject) obj33.get("actuals");
        JSONObject obj34 = nm();//new mexico data
        JSONObject NMobj = (JSONObject) obj34.get("actuals");
        JSONObject obj35 = ny();//new york data
        JSONObject NYobj = (JSONObject) obj35.get("actuals");
        JSONObject obj36 = nc();//north carolina data
        JSONObject NCobj = (JSONObject) obj36.get("actuals");
        JSONObject obj37 = nd();//north dakota data
        JSONObject NDobj = (JSONObject) obj37.get("actuals");

        System.out.println(NYobj);

        JSONObject obj39 = oh();//ohio data
        JSONObject OHobj = (JSONObject) obj39.get("actuals");
        JSONObject obj40 = ok();//oklahoma data
        JSONObject OKobj = (JSONObject) obj40.get("actuals");
        JSONObject obj41 = or();//oregon data
        JSONObject ORobj = (JSONObject) obj41.get("actuals");
        JSONObject obj42 = pa();//pennsylvania data
        JSONObject PAobj = (JSONObject) obj42.get("actuals");
        JSONObject obj43 = pr();//
        JSONObject PRobj = (JSONObject) obj43.get("actuals");
        JSONObject obj44 = ri();//rhode island data
        JSONObject RIobj = (JSONObject) obj44.get("actuals");
        JSONObject obj45 = sc();//south carolina data
        JSONObject SCobj = (JSONObject) obj45.get("actuals");
        JSONObject obj46 = sd();//south dakota data
        JSONObject SDobj = (JSONObject) obj46.get("actuals");
        JSONObject obj47 = tn();//tennessee data
        JSONObject TNobj = (JSONObject) obj47.get("actuals");
        JSONObject obj48 = tx();//texas data
        JSONObject TXobj = (JSONObject) obj48.get("actuals");
        JSONObject obj49 = ut();//utah data
        JSONObject UTobj = (JSONObject) obj49.get("actuals");
        JSONObject obj50 = vt();//vermont data
        JSONObject VTobj = (JSONObject) obj50.get("actuals");
        JSONObject obj51 = va();//virginia data
        JSONObject VAobj = (JSONObject) obj51.get("actuals");

        JSONObject obj53 = wa();//washington data
        JSONObject WAobj = (JSONObject) obj53.get("actuals");
        JSONObject obj54 = wv();//west virginia data
        JSONObject WVobj = (JSONObject) obj54.get("actuals");
        JSONObject obj55 = wi();//wisconsion data
        JSONObject WIobj = (JSONObject) obj55.get("actuals");
        JSONObject obj56 = wy();//wyoming data
        JSONObject WYobj = (JSONObject) obj56.get("actuals");

        XYChart.Series s1 = new XYChart.Series();
        s1.getData().add(new XYChart.Data("Alabama", obj1.get("newCases")));//add alabama data to bar chart
        s1.getData().add(new XYChart.Data("Alaska", akObj.get("newCases")));//add alaska data to bar chart
        s1.getData().add(new XYChart.Data("Arizona", AZobj.get("newCases")));//add arizona data to bar chart
        s1.getData().add(new XYChart.Data("Arkansas", ARobj.get("newCases")));//add arkansas data to bar chart 
        s1.getData().add(new XYChart.Data("California", CAobj.get("newCases")));//add california data to bar chart 
        s1.getData().add(new XYChart.Data("Colorado", COobj.get("newCases")));//add colorado data to bar chart
        s1.getData().add(new XYChart.Data("Connecticut", CTobj.get("newCases")));//add conneticut data to bar chart
        s1.getData().add(new XYChart.Data("Delaware", DEobj.get("newCases")));//add delaware data to bar chart
        s1.getData().add(new XYChart.Data("Washington D.C.", DCobj.get("newCases")));//add washington dc data to bar chart
        s1.getData().add(new XYChart.Data("Florida", FLobj.get("newCases")));//add florida data to bar chart
        s1.getData().add(new XYChart.Data("Georgia", GAobj.get("newCases")));//add geogria data to bar chart

        s1.getData().add(new XYChart.Data("Hawaii", HIobj.get("newCases")));//add hawaii data to bar chart
        s1.getData().add(new XYChart.Data("Idaho", IDobj.get("newCases")));//add idaho data to bar chart
        s1.getData().add(new XYChart.Data("Illinois", ILobj.get("newCases")));//add illinois data to bar chart
        s1.getData().add(new XYChart.Data("Indiana", INobj.get("newCases")));//add indiana data to bar chart
        s1.getData().add(new XYChart.Data("Iowa", IAobj.get("newCases")));//add iowa data to bar chart
        s1.getData().add(new XYChart.Data("Kansas", KSobj.get("newCases")));//add kansas data to bar chart
        s1.getData().add(new XYChart.Data("Kentucky", KYobj.get("newCases")));//add kentucky data to bar chart
        s1.getData().add(new XYChart.Data("Louisiana", LAobj.get("newCases")));//add louisiana data to bar chart
        s1.getData().add(new XYChart.Data("Maine", MEobj.get("newCases")));//add maine data to bar chart
        s1.getData().add(new XYChart.Data("Maryland", MDobj.get("newCases")));//add maryland data to bar chart
        s1.getData().add(new XYChart.Data("Massachusetts", MAobj.get("newCases")));//add massachusetts data to bar chart
        s1.getData().add(new XYChart.Data("Michigan", MIobj.get("newCases")));//add michigan data to bar chart
        s1.getData().add(new XYChart.Data("Minnesota", MNobj.get("newCases")));//add minnesota data to bar chart
        s1.getData().add(new XYChart.Data("Mississippi", MSobj.get("newCases")));//add mississippi data to bar chart
        s1.getData().add(new XYChart.Data("Missouri", MOobj.get("newCases")));//add missouri data to bar chart
        s1.getData().add(new XYChart.Data("Montana", MTobj.get("newCases")));//add montana data to bar chart
        s1.getData().add(new XYChart.Data("Nebraska", NEobj.get("newCases")));//add nebraska data to bar chart
        s1.getData().add(new XYChart.Data("Nevada", NVobj.get("newCases")));//add nevada data to bar chart
        s1.getData().add(new XYChart.Data("New Hampshire", NHobj.get("newCases")));//add new hampshire data to bar chart
        s1.getData().add(new XYChart.Data("New Jersey", NJobj.get("newCases")));//add new jersey data to bar chart
        s1.getData().add(new XYChart.Data("New Mexico", NMobj.get("newCases")));//add new mexico data to bar chart
        s1.getData().add(new XYChart.Data("New York", NYobj.get("newCases")));//add new york data to bar chart
        s1.getData().add(new XYChart.Data("North Carolina", NCobj.get("newCases")));//add north carolina data to bar chart
        s1.getData().add(new XYChart.Data("North Datokta", NDobj.get("newCases")));//add north dakota data to bar chart

        s1.getData().add(new XYChart.Data("Ohio", OHobj.get("newCases")));//add ohio data to bar chart
        s1.getData().add(new XYChart.Data("Oklahoma", OKobj.get("newCases")));//add oklahoma data to bar chart
        s1.getData().add(new XYChart.Data("Oregon", ORobj.get("newCases")));//add oregon data to bar chart
        s1.getData().add(new XYChart.Data("Pennsylvania", PAobj.get("newCases")));//add pennsylvania data to bar chart
        s1.getData().add(new XYChart.Data("Puerto Rico", PRobj.get("newCases")));//add puerto rico data to bar chart
        s1.getData().add(new XYChart.Data("Rhode Island", RIobj.get("newCases")));//add rhode island data to bar chart
        s1.getData().add(new XYChart.Data("South Carolina", SCobj.get("newCases")));//south carolina data to bar chart
        s1.getData().add(new XYChart.Data("South Dakota", SDobj.get("newCases")));//add south dakota data to bar chart
        s1.getData().add(new XYChart.Data("Tennessee", TNobj.get("newCases")));//add tennessee data to bar chart
        s1.getData().add(new XYChart.Data("Texas", TXobj.get("newCases")));//add texas data to bar chart
        s1.getData().add(new XYChart.Data("Utah", UTobj.get("newCases")));//add utah data to bar chart
        s1.getData().add(new XYChart.Data("Vermont", VTobj.get("newCases")));//add vermont data to bar chart 
        s1.getData().add(new XYChart.Data("Virginia", VAobj.get("newCases")));//add virginia data to bar chart

        s1.getData().add(new XYChart.Data("Washington", WAobj.get("newCases")));//add washington data to bar chart
        s1.getData().add(new XYChart.Data("West Virgina", WVobj.get("newCases")));//add west virgina data to bar chart
        s1.getData().add(new XYChart.Data("Wisconsin", WIobj.get("newCases")));//add wisconsion data to bar chart 
        s1.getData().add(new XYChart.Data("Wyoming", WYobj.get("newCases")));//add wyoming data to bar chart
        bar.getData().add(s1);

        rcd.setText("United States Covid Data Breakdown" + " (If you want to check data for specific state please enter State Abbreviation in the text field on the right)");
        JSONObject us = us();
        us = (JSONObject) us.get("actuals");

            recomendation.setText("New Cases: " + us.get("newCases")
                    +"\nAll time cases: " + us.get("cases") 
                    + "\nPositive Tests: " + us.get("positiveTests") 
                    + "\nVaccines Distributed: " + us.get("vaccinesDistributed") 
                    + "\nVaccines Administered: " + us.get("vaccinesAdministered"));
//            
            rcd2.setText("New Deaths: " + us.get("newDeaths") + "\nAll time Deaths: " + us.get("deaths") 
                    + "\nNegative Tests: " + us.get("negativeTests")+ "\nVaccines Initiated: " + us.get("vaccinationsInitiated")
                    + "\nAvailaible ICU Beds: " + ((JSONObject)us.get("icuBeds")).get("capacity"));
//      
            us = us();
            us = (JSONObject) us.get("metrics");
            rcd3.setText("Positivity Ratio: " + us.get("testPositivityRatio") + "\nCase Density: " + us.get("caseDensity") 
                    + "\nWeekly New Cases Per 100k: " + us.get("weeklyNewCasesPer100k")+ "\nInfection Rate: " + us.get("infectionRate")
                    +"\nVaccines Completed Ratio: " + us.get("vaccinationsCompletedRatio"));
    }

    /**
     * this method will make all of our charts appear slowly, they SHOULD be
     * filled with data, fadeTransitions are used to make the charts appear and
     * the opacity value is used to make the charts fade in and out
     */
    private void startAnimations() {

        FadeTransition ft2 = new FadeTransition(Duration.seconds(5), bar);
        ft2.setFromValue(0.);
        ft2.setToValue(1.);

        SequentialTransition st = new SequentialTransition(ft2);
        st.play();

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

    /**
     * this method is not yet implemented, this will update the bar chart based
     * on including or excluding ethnicity data
     *
     * @param event
     */
    @FXML
    private void updateChartsEthnicites(ActionEvent event) {

        Alert a = new Alert(AlertType.INFORMATION);//create an alert that will show this feature is not implemented yet
        a.setHeaderText("This Function has not been implemented yet and will be implemented in a future release");
        a.setContentText("we are sorry for the inconvience");
        a.setTitle("Error");
        a.showAndWait();//error message will wait until the user closes the alert

    }

    /**
     * this method is not yet implemented, it will update the bar chart to show
     * data base on including or excluding data based on age demographic
     *
     * @param event
     */
    @FXML
    private void updateChartsAges(ActionEvent event) {

        Alert a = new Alert(AlertType.INFORMATION);//create an alert that will show this feature is not implemented yet
        a.setHeaderText("This Function has not been implemented yet and will be implemented in a future release");
        a.setContentText("we are sorry for the inconvience");
        a.setTitle("Error");
        a.showAndWait();//error message will wait until the user closes the alert

    }

    /**
     * method that takes user information and produces a recommendation based on
     * that data
     *
     * @param event
     */
    @FXML
    private void updateSubmit(ActionEvent event) {

        String getState = enterState.getText();//gets text from the textfield 

        if (getState.length() > 2) {//if the length of the string is greater than 2, its no good
            System.out.println("error, only 2 letters for the state");//print out an error state 
            getState = "Null";

            Alert a = new Alert(AlertType.ERROR);//create an error alert
            a.setHeaderText("Error, States should be entered as their respective 2 letter abbreviations");
            a.setTitle("Input Error");
            a.showAndWait();//keep the alert showing until the user removes it 

        }
        String finalState = "";
        String toUpperCase = getState.toUpperCase();
        JSONObject data = null;
        //the following if/else-if/else statements check for valid state abbreviations, if there is no valid abbreviation then finalState is set to null
        if (toUpperCase.equals("AL")) {
            finalState = "AL";
            data = al();
        } else if (toUpperCase.equals("AK")) {
            finalState = "AK";
            data = ak();
        } else if (toUpperCase.equals("AZ")) {
            finalState = "AZ";
            data = az();
        } else if (toUpperCase.equals("AR")) {
            finalState = "AR";
            data = ar();
        } else if (toUpperCase.equals("CA")) {
            finalState = "CA";
            data = ca();
        } else if (toUpperCase.equals("CO")) {
            finalState = "CO";
            data = co();
        } else if (toUpperCase.equals("CT")) {
            finalState = "CT";
            data = ct();
        } else if (toUpperCase.equals("DE")) {
            finalState = "DE";
            data = de();
        } else if (toUpperCase.equals("DC")) {
            finalState = "DC";
            data = dc();
        } else if (toUpperCase.equals("FL")) {
            finalState = "FL";
            data = fl();
        } else if (toUpperCase.equals("GA")) {
            finalState = "GA";
            data = ga();
        } else if (toUpperCase.equals("HI")) {
            finalState = "HI";
            data = hi();
        } else if (toUpperCase.equals("ID")) {
            finalState = "ID";
            data = id();
        } else if (toUpperCase.equals("IL")) {
            finalState = "IL";
            data = il();
        } else if (toUpperCase.equals("IN")) {
            finalState = "IN";
            data = in();
        } else if (toUpperCase.equals("IA")) {
            finalState = "IA";
            data = ia();
        } else if (toUpperCase.equals("KS")) {
            finalState = "KS";
            data = ks();
        } else if (toUpperCase.equals("KY")) {
            finalState = "KY";
            data = ky();
        } else if (toUpperCase.equals("LA")) {
            finalState = "LA";
            data = la();
        } else if (toUpperCase.equals("ME")) {
            finalState = "ME";
            data = me();
        } else if (toUpperCase.equals("MD")) {
            finalState = "MD";
            data = md();
        } else if (toUpperCase.equals("MA")) {
            finalState = "MA";
            data = ma();
        } else if (toUpperCase.equals("MI")) {
            finalState = "MI";
            data = mi();
        } else if (toUpperCase.equals("MN")) {
            finalState = "MN";
            data = mn();
        } else if (toUpperCase.equals("MS")) {
            finalState = "MS";
            data = ms();
        } else if (toUpperCase.equals("MO")) {
            finalState = "MO";
            data = mo();
        } else if (toUpperCase.equals("MT")) {
            finalState = "MT";
            data = mt();
        } else if (toUpperCase.equals("NE")) {
            finalState = "NE";
            data = ne();
        } else if (toUpperCase.equals("NV")) {
            finalState = "NV";
            data = nv();
        } else if (toUpperCase.equals("NH")) {
            finalState = "NH";
            data = nh();
        } else if (toUpperCase.equals("NJ")) {
            finalState = "NJ";
            data = nj();
        } else if (toUpperCase.equals("NM")) {
            finalState = "NM";
            data = nm();
        } else if (toUpperCase.equals("NY")) {
            finalState = "NY";
            data = ny();
        } else if (toUpperCase.equals("NC")) {
            finalState = "NC";
            data = nc();
        } else if (toUpperCase.equals("ND")) {
            finalState = "ND";
            data = nd();
        } else if (toUpperCase.equals("OH")) {
            finalState = "OH";
            data = oh();
        } else if (toUpperCase.equals("OK")) {
            finalState = "OK";
            data = ok();
        } else if (toUpperCase.equals("OR")) {
            finalState = "OR";
            data = or();
        } else if (toUpperCase.equals("PA")) {
            finalState = "PA";
            data = pa();
        } else if (toUpperCase.equals("PR")) {
            finalState = "PR";
            data = pr();
        } else if (toUpperCase.equals("RI")) {
            finalState = "RI";
            data = ri();
        } else if (toUpperCase.equals("SC")) {
            finalState = "SC";
            data = sc();
        } else if (toUpperCase.equals("SD")) {
            finalState = "SD";
            data = sd();
        } else if (toUpperCase.equals("TN")) {
            finalState = "TN";
            data = tn();
        } else if (toUpperCase.equals("TX")) {
            finalState = "TX";
            data = tx();
        } else if (toUpperCase.equals("UT")) {
            finalState = "UT";
            data = ut();
        } else if (toUpperCase.equals("VT")) {
            finalState = "VT";
            data = vt();
        } else if (toUpperCase.equals("VA")) {
            finalState = "VA";
            data = va();
        } else if (toUpperCase.equals("WA")) {
            finalState = "WA";
            data = wa();
        } else if (toUpperCase.equals("WV")) {
            finalState = "WV";
            data = wv();
        } else if (toUpperCase.equals("WI")) {
            finalState = "WI";
            data = wi();
        } else if (toUpperCase.equals("WY")) {
            finalState = "WY";
            data = wy();
        } else if (toUpperCase.equals("US")) {
            finalState = "US";
            data = us();
        } else {
            finalState = "Null";
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

        if (finalState.equals("Null")) {

            recommendUser = "based on your input, we are unable to generate a completly accurate recommendation, however based on your input, we recommend that...";
            recomendation.setText(recommendUser);
        } else {
            rcd.setText(finalState + " Covid Data Breakdown" + " (If you want to check data for specific state please enter State Abbreviation in the text field on the right)");
            JSONObject deeperData = data;
            data = (JSONObject) data.get("actuals");
            
             recomendation.setText("New Cases: " + data.get("newCases")
                    +"\nAll time cases: " + data.get("cases") 
                    + "\nPositive Tests: " + data.get("positiveTests") 
                    + "\nVaccines Distributed: " + data.get("vaccinesDistributed") 
                    + "\nVaccines Administered: " + data.get("vaccinesAdministered"));
//            
            rcd2.setText("New Deaths: " + data.get("newDeaths") + "\nAll time Deaths: " + data.get("deaths") 
                    + "\nNegative Tests: " + data.get("negativeTests")+ "\nVaccines Initiated: " + data.get("vaccinationsInitiated")
                    + "\nAvailaible ICU Beds: " + ((JSONObject)data.get("icuBeds")).get("capacity"));
//      
            
            deeperData = (JSONObject) deeperData.get("metrics");
            rcd3.setText("Positivity Ratio: " + deeperData.get("testPositivityRatio") + "\nCase Density: " + deeperData.get("caseDensity") 
                    + "\nWeekly New Cases Per 100k: " + deeperData.get("weeklyNewCasesPer100k")+ "\nInfection Rate: " + deeperData.get("infectionRate")
                    +"\nVaccines Completed Ratio: " + deeperData.get("vaccinationsCompletedRatio"));
        }

    }
}
