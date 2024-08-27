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
public class OddsPedia {
    public static void main(String[] args) throws IOException {

          String url = "https://oddspedia.com/football/inplay/";
          TimeCantos tCantos = new TimeCantos();
          TimeCantosDAO timeCantosDAO = new TimeCantosDAO();
              
          Document document = Jsoup.connect(url).get();
          Elements tabela = document.select("tbody");
          Elements items = tabela.select("[class=headline headline-mobile]"); 
          Elements jogoss1 = tabela.select("[class=match-data]");
          
          
          
          //System.out.println(tabela);
                                  
          for(Element element : items){
                //Elements selecionados = element.select("class=march-data");
                Elements itemsCompeticao = element.select("th")/*.next().select("a[href]")*/;
                String cod="";
                String neww=element.attr("rel");;
                try {
                    if(cod!=neww){
                        cod=neww;
                        String nCompeticao= itemsCompeticao.select("th:eq(0)").text();                   
                        System.out.println("LIGA: "+nCompeticao+" COD: "+neww);
                        Elements jogoss2 = jogoss1.select("[rel="+neww+"]");
                        for(Element j:jogoss2){
                            System.out.println("\n     JOGOS: "+j.text());
                        }                        
                    }                                       
              } catch (Exception e) {
              }
               /* 
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
                }*/
                
                
          }             
              
    }
    
    
}
