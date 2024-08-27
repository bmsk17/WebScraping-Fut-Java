/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteExemplos;

import java.io.IOException;
import javax.swing.JOptionPane;
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
public class CadastrarCantos {
    public static void main(String[] args) throws IOException {

          String url = "https://www.windrawwin.com/statistics/corners/brazil-serie-a/";
          
          LigaCantos lCantos = new LigaCantos();
          LigaCantosDAO lCantosDAO = new LigaCantosDAO();
              
              lCantos.setNome("Premier League");
              lCantosDAO.create(lCantos);
              int cod=lCantosDAO.readNome(lCantos);
              
              
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
                    
                    tCantos.setCodlig(cod);
                    tCantos.setNome(Times);
                    tCantos.setmCantosFeitos(MCantosFeitos);
                    tCantos.setmCantosSofridos(MCantosSofridos);
                    tCantos.setmCantosTotais(MCantosTotais);
                    timeCantosDAO.create(tCantos);
                
                    //System.out.println("\n"+selecionados.text());
                    System.out.print("\n"+Times+" "+MCantosFeitos+" "+MCantosSofridos+" "+MCantosTotais);
                      
                } catch (Exception e) {
                }
                
                
                
              }
              
    }
    
}

/*

String url = "https://www.windrawwin.com/statistics/corners/brazil-serie-a/";
          String Mls ="https://www.windrawwin.com/statistics/corners/";
          int i=1;
          
          Document pCantos = Jsoup.connect(Mls).get();
          Elements ligas = pCantos.select("select[id=leaguenav]");
          Elements itemsLigas = ligas.select("option").not("option:eq(0)").not("option:eq(1)");
          
          for(Element cLigas:itemsLigas){
              String linkLiga = cLigas.attr("value");
              String nomeliga = cLigas.text();
              System.out.println("\n"+nomeliga);
              
              LigaCantos lCantos = new LigaCantos();
              LigaCantosDAO lCantosDAO = new LigaCantosDAO();
              
              lCantos.setNome(nomeliga);
              //lCantosDAO.create(lCantos);
              
              TimeCantos tCantos = new TimeCantos();
              TimeCantosDAO timeCantosDAO = new TimeCantosDAO();
              
              Document document = Jsoup.connect(linkLiga).get();
              Elements tabela = document.select("[class=wdwtable w90p]");
              Elements items = tabela.select("tr").not("[class=darkrow]").not("[class=lightdarkrow]").not("[class=talc grn]");           
                                  
              for(Element element : items){
                Elements selecionados = element.select("td");
                
                Double MCantosFeitos = Double.parseDouble(selecionados.select("td:eq(2)").not("[class=talc grn]").text());
                System.out.println(MCantosFeitos);
                if(MCantosFeitos>0){
                    String Times = selecionados.select("td:eq(1)").not("[class=talc grn]").text();

                    String MCantosSofridos = selecionados.select("td:eq(3)").not("[class=talc grn]").text();
                    String MCantosTotais = selecionados.select("td:eq(4)").not("[class=talc grn]").text();
                    String TimesLinks = selecionados.select("a[class=blklnk]").not("[class=talc grn]").attr("href");
                    
                    
                    System.out.print("\n"+Times+" "+MCantosFeitos+" "+MCantosSofridos+" "+MCantosTotais+" ---- "+TimesLinks);
                }
                
              }
          }


*/