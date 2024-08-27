/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bet;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import view.TelaOdds1_2;

/**
 *
 * @author Bernardo
 */
public class Bet_Jogos {
    public static void main(String[] args) throws IOException {
            String url = "https://oddspedia.com/football/inplay/";
            Document document;
            document = Jsoup.connect(url).get();
            
            Elements jogos = document.select("table[class*=oddspedia-table]").select("[class*=match-data]");
            
            //System.out.println(jogos);
            
            for(Element e: jogos){                           
                
                String titulo = e.select("td:eq(0)").select("a").attr("title");
                System.out.println(e);
                //System.out.println(titulo);
                System.out.println("     ");
                
                
            }
        
        
    }
    
}

/*




*/