/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteExemplos;

import java.io.IOException;
import model.bean.LigaCantos;
import model.bean.TimeCantos;
import model.dao.LigaCantosDAO;
import model.dao.TimeCantosDAO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Bernardo
 */
public class AtualizarCantos {
    public static void main(String[] args) throws IOException {

          String url = "https://www.windrawwin.com/statistics/corners/brazil-serie-a/";
          TimeCantos tCantos = new TimeCantos();
              TimeCantosDAO timeCantosDAO = new TimeCantosDAO();
              
              Document document = Jsoup.connect(url).get();
              Elements tabela = document.select("[class=wdwtable w90p]");
              Elements items = tabela.select("tr").not("[class=darkrow]").not("[class=lightdarkrow]").not("[class=talc grn]");           
                                  
              for(Element element : items){
                Elements selecionados = element.select("td");
                
                try {
                    String Times = selecionados.select("td:eq(1)").text();
                    Double MCantosFeitos = Double.parseDouble(selecionados.select("td:eq(2)").text());
                    Double MCantosSofridos = Double.parseDouble(selecionados.select("td:eq(3)").text());
                    Double MCantosTotais = Double.parseDouble(selecionados.select("td:eq(4)").text());
                    String TimesLinks = selecionados.select("a[class=blklnk]").attr("href");
                    
                    tCantos.setNome(Times);
                    tCantos.setmCantosFeitos(MCantosFeitos);
                    tCantos.setmCantosSofridos(MCantosSofridos);
                    tCantos.setmCantosTotais(MCantosTotais);
                    timeCantosDAO.update(tCantos);
                
                    //System.out.println("\n"+selecionados.text());
                    System.out.print("\n"+Times+" "+MCantosFeitos+" "+MCantosSofridos+" "+MCantosTotais);
                      
                } catch (Exception e) {
                }             
                
  
              }
              
              
    }
    
}
