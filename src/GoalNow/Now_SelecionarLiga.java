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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Bernardo
 */
public class Now_SelecionarLiga {
    public static void main(String[] args) throws IOException {        
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF); /* comment out to turn off annoying htmlunit warnings */
        WebClient webClient = new WebClient();
        HtmlPage currentPage = webClient.getPage("http://info.nowgoal.com/en/League/2019-2020/36.html");
        String texto = currentPage.asXml();
    
        Document documento = Jsoup.parse(texto);
        
        Elements tabela = documento.select("[id=div_Table1]");
        
        System.out.println(documento);
        
        /*
        
        Elements tabela = documento.select("[id=allSclassList]");
        Elements paises = tabela.select("[class=divList]");
        Elements ligas = documento.select("[class=floatDiv]").select("[class=ulDiv]:eq(0)").select("li[onmouseover*=showSeason]").select("a[href*=java]:eq(0)");
        
        
        for(Element it:paises){
            System.out.println(it.text());
            String buscar =it.attr("id")+"div";
            Elements liga = documento.select("[id="+buscar+"]").select("[class=ulDiv]:eq(0)").select("li[onmouseover*=showSeason]");
            
            //System.out.println(liga.select("li").select("[onmouseover=showSeason(this,event,0)]"));
            for(Element its:liga){
                String nome  = its.select("a[href*=java]:eq(0)").text();
                Elements temporada = its.select("[class=inner_ul]").select("li");//.select("a[href]:eq(0)");
                System.out.println("  "+nome+"  -  "+its.select("li").attr("onmouseover"))/*+temporada.select("a");
            }  
          
        }   */          
    }  

    
}
