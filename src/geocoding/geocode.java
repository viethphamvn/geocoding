/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geocoding;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Viet H. Pham
 */
public class geocode {
    
    String endpoint = "https://maps.googleapis.com/maps/api/geocode/json?";
    String API_key = "AIzaSyC4i8VAgGQWY2jgzSQSsoXgshRX0Mtnzz8"; 
    
    public geocode(String address) throws IOException{
 
        try {
            HttpURLConnection connection = null;
            URL url = new URL(endpoint + "address=" +address + "&key=" + API_key);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

        //Send request
            DataOutputStream wr = new DataOutputStream (
            connection.getOutputStream());
            wr.close();

        //Get Response  
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
              response.append(line);
              response.append("\n");
            }
            rd.close();
            int index = response.indexOf("\"location");
            while(true){
                System.out.print(response.charAt(index++));
                if (response.charAt(index) == '}'){
                    System.out.println(response.charAt(index));
                    break;
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(geocode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
