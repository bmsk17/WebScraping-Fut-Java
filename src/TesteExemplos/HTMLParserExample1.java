/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteExemplos;

import com.sun.jmx.snmp.BerDecoder;
import java.io.File;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jsoup.helper.Validate;

/**
 *
 * @author Bernardo
 */
public class HTMLParserExample1 {
    
    public static void main(String[] args) throws IOException {

          String url = "https://www.betfair.com/sport/football";
          

            Document document = Jsoup.connect(url).get();
            Elements lala = document.select("[class=section]:eq(2)");
            Elements elements = lala.select("[class=event-list]");
            Elements itemsTimes = elements.select("[class*=com-coupon-line-new-layout]");//jogo selecionado     
            System.out.println(document);
            
            for(Element element : itemsTimes){
                String share = element.select("[class*=team-name]:eq(0)").text();
                String share1 = element.select("[class*=team-name]:eq(1)").text();
                
                Elements probabilidades1x2 = element.select("[class=details-market market-3-runners]");
                String horario = element.select("[class=ui-no-score]").text();
                
                Elements links = element.select("[class=ui-nav event-team-container ui-top event-link ui-gtm-click]:eq(0)");
                String linkHrefs = links.attr("href");  
                System.out.print(linkHrefs);
                
                
                //odds casa
                Elements oddsCasa = probabilidades1x2.select("[class*=selection sel-0]");
                double oddsCasa1 = Double.parseDouble(oddsCasa.select("[class*=ui-runner-price]").text());
                
                Elements oddsEmpate = probabilidades1x2.select("[class*=selection sel-1]");
                double oddsEmpate1 = Double.parseDouble(oddsEmpate.select("[class*=ui-runner-price]").text());
                //String oddsEmpate1 = oddsEmpate.select("[class*=ui-runner-price]").text();
            
                Elements oddsVisitante = probabilidades1x2.select("[class*=selection sel-2]");
                double oddsVisitante1 = Double.parseDouble(oddsVisitante.select("[class*=ui-runner-price]").text());
                //String oddsVisitante1 = oddsVisitante.select("[class*=ui-runner-price]").text();
                
                //if(oddsCasa1<=1.2 || oddsVisitante1<=1.2){
                    System.out.print("\n"+share+" X "+share1+" ----- "+horario+""+oddsCasa1+"/"+oddsEmpate1+"/"+oddsVisitante1+"\n"+linkHrefs);                
               // }

                
            }
            
            
           /* 
            
          */  
          //  System.out.print(itemsTimes.text()+"\n");
         //   System.out.print(oddsEmpate1.text()+"\n");
           // System.out.print(oddsVisitante1.text()+"\n");
      
                       
    }
}
    


/*
public static void main(String[] args) throws IOException {

          String url = "https://www.betfair.com/sport/football";
          

            Document document = Jsoup.connect(url).get();
            Elements elements = document.getElementsByClass("event-list");
            Elements itemsTimes = elements.select("[class*=com-coupon-line-new-layout]");
            Elements probabilidades1x2 = itemsTimes.select("[class=details-market market-3-runners]");
            
            Elements times1 = elements.select("[class*=teams-container]:eq(0)");
            Elements times2 = times1.select("[class*=team-name]:eq(0)");
            Elements times3 = times1.select("[class*=team-name]:eq(1)");
            
            //odds casa
            Elements oddsCasa = probabilidades1x2.select("[class*=selection sel-0]");
            Elements oddsCasa1 = oddsCasa.select("[class*=ui-runner-price]");
            
            Elements oddsEmpate = probabilidades1x2.select("[class*=selection sel-1]");
            Elements oddsEmpate1 = oddsEmpate.select("[class*=ui-runner-price]");
            
            Elements oddsVisitante = probabilidades1x2.select("[class*=selection sel-2]");
            Elements oddsVisitante1 = oddsVisitante.select("[class*=ui-runner-price]");
            
            System.out.print(oddsCasa1.text()+"\n");
            System.out.print(oddsEmpate1.text()+"\n");
            System.out.print(oddsVisitante1.text()+"\n");
           // System.out.print(oddsVisitante1.text()+"\n");
            //System.out.print(times2+"\n");        
                       
    }

*/

/*
public static void main(String[] args) throws IOException {

          String url = "https://www.betfair.com/sport/football/caf-african-nations-cup/nig%C3%A9ria-x-%C3%A1frica-do-sul/29355979";

            Document document = Jsoup.connect(url).get();
            Elements elements = document.getElementsByClass("ui-expandable ui-expandable-selected com-expandable-header-anchor");
            Elements ss= elements.select("[data-target*=CORRECT_SCORE]");
            
            System.out.print(ss);
            
            for(Element element : ss){
                String share = element.getElementsByClass("title").text();
                System.out.print("\n"+share);
            }

    }

*/