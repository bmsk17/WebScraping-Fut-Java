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
public class TotalCorner {
    public static void main(String[] args) throws IOException {

          String url = "https://www.totalcorner.com/league/corner_stats/129";
          TimeCantos tCantos = new TimeCantos();
          TimeCantosDAO timeCantosDAO = new TimeCantosDAO();
              
          Document document = Jsoup.connect(url).get();
          Elements tabela = document.select("tbody");
          Elements items = tabela.select("tr");  
          
          //System.out.println(tabela);
                                  
          for(Element element : items){
                Elements selecionados = element.select("td");
                
                try {
                    String Times = selecionados.select("td:eq(1)").text();
                    Double MCantosFeitosHT = Double.parseDouble(selecionados.select("td:eq(10)").text());
                    Double MCantosSofridosHT = Double.parseDouble(selecionados.select("td:eq(11)").text());
                    
                    tCantos.setNome(Times);
                    tCantos.setmCantosFeitosHT(MCantosFeitosHT);
                    tCantos.setmCantosSofridosHT(MCantosSofridosHT);
                    timeCantosDAO.updateHT(tCantos);
                
                    //System.out.println("\n"+selecionados.text());
                    System.out.print("\n"+Times+" "+MCantosFeitosHT+" "+MCantosSofridosHT);
                    
                      
                } catch (Exception e) {
                }
                
                
          }             
              
    }
    
}
