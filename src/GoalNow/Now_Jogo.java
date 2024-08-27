/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoalNow;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Bernardo
 */
public class Now_Jogo {
    public static void main(String[] args) throws IOException {
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF); /* comment out to turn off annoying htmlunit warnings */
        WebClient webClient = new WebClient();
        HtmlPage currentPage = webClient.getPage("http://www.nowgoal.com/analysis/1676889.html");
        String Source = currentPage.asXml();
        
        Document doo =Jsoup.parse(Source);
        
        
        Elements nomeA = doo.select("[class=sclassName]");
        ArrayList<String> noo = new ArrayList<>();
        for(Element item:nomeA){
            noo.add(item.text());
        }
        System.out.println(noo.get(0)+" * "+noo.get(1));
        
        Elements tabela = doo.select("[id=table_v1]");
        Elements items = tabela.select("tr:gt(2)").select("[id*=tr]");  
        
        Double mCasaFeitos=0.0;
        Double mCasaSofridos=0.0;
        int cont=0;
        for(Element it: items){
            String data = it.select("td:eq(1)").text();
            String timeA = it.select("td:eq(2)").select("a").text();
            String timeB = it.select("td:eq(6)").select("a").text();
            String cantos = it.select("td:eq(5)").text();           
            int traco=0;
            for(int i=0;i<cantos.length();i++){
                if(cantos.substring(i,i+1).equals("-")){ 
                    traco=i;
                }
            }
            Double nCantosCasa = Double.parseDouble(cantos.substring(0,traco));
            Double nCantosVisitante = Double.parseDouble(cantos.substring(traco+1,cantos.length()));
            cont++;
            
            mCasaFeitos=mCasaFeitos+nCantosCasa;
            mCasaSofridos=mCasaSofridos+nCantosVisitante;
            System.out.println("\n"+ data+" "+ timeA+" x "+timeB+" - "+cantos+" + "+nCantosCasa+"_"+nCantosVisitante);
        }   
        System.out.println("Media feiros : "+mCasaFeitos/cont+"   -  Media Sofridos"+mCasaSofridos/cont);
    }
    
}
