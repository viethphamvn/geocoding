/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geocoding;
import java.util.*;
import java.io.IOException;

/**
 *
 * @author Viet H. Pham
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String input = "1208 Frankford Ave, Philadelphia, PA 19125";
        System.out.println("Showing Long & Lat of 1208 Frankford Ave, Philadelphia, PA 19125...");
        
        Scanner s = new Scanner(System.in);
       
        String[] word = input.split(" ");
        
        String fin_str = "";
        fin_str = fin_str + word[0];
        
        for (String w : word){
            fin_str += "+";
            fin_str += w;
        }
        
        geocode geo = new geocode(fin_str);
  }
    
}
