/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteExemplos;

import java.io.IOException;
import model.bean.TimeCantos;
import model.dao.TimeCantosDAO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Bernardo
 */
public class AcademiaApostas {
    public static void main(String[] args) throws IOException {

          String url = "https://www.academiadasapostasbrasil.com/stats/competition/brasil-stats/26";
              
          Document document = Jsoup.connect(url).get();
          Elements tabela = document.select("table[class=competition-rounds competition-half-padding]");
          Elements items = tabela.select("tr");  
                                  
          for(Element element : items){
                try {
                    String TimesA = element.select("td:eq(2)").text();
                    String TimesB = element.select("td:eq(4)").text();
                    String Dia = element.select("td:eq(0)").text();
                    String Data = element.select("td:eq(1)").text();


                    //System.out.println(element);

                    //System.out.println("\n"+selecionados.text());
                    System.out.print("\n"+Dia+" "+Data+": "+TimesA+" vs "+TimesB);
    
                } catch (Exception e) {
                }  
          }                       
    }
}
