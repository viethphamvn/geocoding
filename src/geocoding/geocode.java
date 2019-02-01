/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geocoding;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;



/**
 *
 * @author Viet H. Pham
 */
public class geocode {
    
    String endpoint = "https://maps.googleapis.com/maps/api/geocode/json?";
    String API_key = "AIzaSyC4i8VAgGQWY2jgzSQSsoXgshRX0Mtnzz8"; 
    
    public geocode(String address) throws IOException{
        String json = "";
        
        try {
            HttpURLConnection connection = null;
            URL url = new URL(endpoint + "address=" +address + "&key=" + API_key);

            connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("GET");
            connection.connect();
            
            int responsecode = connection.getResponseCode();
            
            Scanner sc = new Scanner(url.openStream());
            while (sc.hasNext()){
                json += sc.nextLine();
            }
            sc.close();
            
            JSONObject obj = new JSONObject(json);
            JSONObject res = obj.getJSONArray("results").getJSONObject(0);
            JSONObject loc = res.getJSONObject("geometry").getJSONObject("location");
            
            System.out.println("lat: " + loc.getDouble("lat") + ", lng: " + loc.getDouble("lng"));
            System.out.println("Head \\u003cb\\u003ewest\\u003c/b\\u003e toward \\u003cb\\u003eN Carlisle St\\u003c/b\\u003e");
        } catch (MalformedURLException ex) {
            Logger.getLogger(geocode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
