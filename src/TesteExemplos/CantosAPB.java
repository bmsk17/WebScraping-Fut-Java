/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteExemplos;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Bernardo
 */
public class CantosAPB {
    
    public static void main(String[] args) throws IOException {

          String url = "https://www.academiadasapostasbrasil.com/stats/competition/brasil-stats/26";
          

            Document document = Jsoup.connect(url).get();
            Elements jogos = document.select("[class=competition-rounds competition-half-padding]").select("tr");
            
            for(Element jogo : jogos){
                String data = jogo.select("td:eq(0)").text()+jogo.select("td:eq(1)").text();
                String casa = jogo.select("td:eq(2)").text();
                String visitante = jogo.select("td:eq(4)").text();
                String linkCasa = jogo.select("td:eq(2)").select("a[href]").attr("href").toString();
                String linkVisitante = jogo.select("td:eq(4)").select("a[href]").attr("href").toString();
                System.out.println(data+" --- "+casa+" x "+visitante+"\n"+linkCasa+"\n"+linkVisitante);
            }

                
    }     
                      
} 
