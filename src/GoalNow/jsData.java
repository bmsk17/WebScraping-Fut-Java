/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoalNow;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Bernardo
 */
public class jsData {
    public static void main(String[] args) throws IOException {
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF); /* comment out to turn off annoying htmlunit warnings */
        WebClient webClient = new WebClient();
        HtmlPage currentPage = webClient.getPage("http://info.nowgoal.com/jsData/leftData/leftData.js");
        String Source = currentPage.asXml();
        
        Document doo =Jsoup.parse(Source);
        
        
        int traco=0,linha=0,finall=0,inicio=0;
            for(int i=0;i<Source.length();i++){
                
                if(Source.substring(i,i+1).equals("[")){ 
                    inicio=i;
                    i++;
                    while(!Source.substring(i,i+1).equals("]")){
                        finall=i+2;
                        i++;
                    }
                    System.out.println(Source.substring(inicio, finall));
                }
            }

        
        System.out.println(doo);
    }
    
}
