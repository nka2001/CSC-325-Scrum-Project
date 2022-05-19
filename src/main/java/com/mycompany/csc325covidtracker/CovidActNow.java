/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.csc325covidtracker;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author maazh
 */
public class CovidActNow {
    
    
    public static JSONObject myApi2() {

        try {

        URL url = new URL("https://api.covidactnow.org/v2/state/NY.json?apiKey=99d2141317ed40e79b91dd0b4d006a06");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                String inline = "";
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    inline += sc.nextLine() + "\n";
                }
            System.out.println("\nJSON data in string format");
           System.out.println(inline);
            sc.close();

                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);
                return data_obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
        
        
       
    }
}
