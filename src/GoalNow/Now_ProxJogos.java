/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoalNow;

import java.io.IOException;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Bernardo
 */
public class Now_ProxJogos {
    public static void main(String[] args) throws IOException {
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF); /* comment out to turn off annoying htmlunit warnings */
        WebClient webClient = new WebClient();
        HtmlPage currentPage = webClient.getPage("http://info.nowgoal.com/en/League/2019/4.html");
        String Source = currentPage.asXml();
        
        Document doo =Jsoup.parse(Source);
        
        Elements tabela = doo.select("[id=Table3]");
        Elements items = tabela.select("tr:gt(1)");  
        for(Element it: items){
            String data = it.select("td:eq(1)").text();
            String timeA = it.select("td:eq(2)").select("a").text();
            String linkTimeA = it.select("td:eq(9)").select("a").attr("href");
            String timeB = it.select("td:eq(4)").select("a").text();
            System.out.println("\n"+ data+" "+ timeA+" x "+timeB+" ---- "+linkTimeA);
        }     
    }
}

/*
        HtmlTable table = currentPage.getHtmlElementById("Table3");
        System.out.println("Cell (1,2)=" + table.getCellAt(1,2).asText());

        int i =0;
        //Percorrer        Tabela
        for (final HtmlTableRow row : table.getRows()) {
            if (i >1){
                System.out.println("Found row");
                System.out.println("   Data: " +row.getCell(1).asText()+" - Times: " +row.getCell(2).asText()+" x "+row.getCell(4).asText() );   
            }
            i++;
        }*/

/*
int i =0;
        //Percorrer        Tabela
        for (final HtmlTableRow row : table.getRows()) {
            if (i >1){
                System.out.println("Found row");
                for (final HtmlTableCell cell : row.getCells()) {
                    System.out.println("   Data: " +row.getCell(0)+ row.getCell(1) );
                }
            }
            i++;
        }

*/