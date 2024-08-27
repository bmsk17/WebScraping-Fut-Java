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
import org.w3c.dom.Attr;

/**
 *
 * @author Bernardo
 */
public class FcTable {
    public static void main(String[] args) throws IOException {
        
          LigaCantos lCantos = new LigaCantos();
          LigaCantosDAO lCantosDAO = new LigaCantosDAO();
          TimeCantosDAO tCantosDAO = new TimeCantosDAO();
              
          

          String url = "https://www.fctables.com/";
              
          Document document = Jsoup.connect(url).get();
          Elements tabela = document.select("[class=alphabet]");
          Elements items = tabela.select("[data-href]");  
          
          //System.out.println(items);
          String liga="/brazil/";
          String ligaTabela="/brazil/serie-a/";
          for(Element element2 : items){
                try {
                    String rLink = element2.attr("data-href").toString();
                    //System.out.println(rLink);    
                    
          String url2=url+rLink;
          Document document2 = Jsoup.connect(url2).get();
          Elements tabelaLigas = document2.select("[class=col-xs-6 col-sm-4 col-lg-3 col-md-3]");
          
          //System.out.println(tabelaLigas);
          
          for(Element element : tabelaLigas){
                try {
                    Elements linkLiga = element.select("[class=logo-image]").select("a[href]");
                    Elements linkLiga1 = element.select("[class=detail truncate]").select("a[href]");
                    String rLinkLiga = linkLiga.attr("href").toString();
                    String nomeLiga1 = linkLiga1.text();
                            
                   // System.out.println(rLinkLiga);
                    
                    lCantos.setNome(nomeLiga1);
                    lCantosDAO.create(lCantos);
                    int cod=lCantosDAO.readNome(lCantos);
                    
                    String url3=url+rLinkLiga+"corners/";
                    Document document3 = Jsoup.connect(url3).get();
                    Elements tabelaTbody = document3.select("tbody");
                    Elements itemsTr = tabelaTbody.select("tr"); 
          
                    for(Element element1 : itemsTr){
                        try {
                            TimeCantos time = new TimeCantos();
                            String Times = element1.select("td:eq(1)").text();
                            Double MCantosFeitos = Double.parseDouble(element1.select("td:eq(6)").text());
                            Double MCantosSofridos = Double.parseDouble(element1.select("td:eq(14)").text());
                            Double MCantosTotais = Double.parseDouble(element1.select("td:eq(2)").text());
                            Double MCantosFeitosHT = Double.parseDouble(element1.select("td:eq(7)").text());
                            Double MCantosSofridosHT = Double.parseDouble(element1.select("td:eq(15)").text());
                    
                            time.setNome(Times);
                            time.setCodlig(cod);
                            time.setmCantosFeitos(MCantosFeitos);
                            time.setmCantosFeitosHT(MCantosFeitosHT);
                            time.setmCantosSofridos(MCantosSofridos);
                            time.setmCantosSofridosHT(MCantosSofridosHT);
                            time.setmCantosTotais(MCantosTotais);
                            tCantosDAO.create(time);
                    
                        } catch (Exception e) {
                        }  
                    }                   
                } catch (Exception e) {
                }  
          }
                } catch (Exception e) {
                }  
          }         
                           
    }
}




/*

public static void main(String[] args) throws IOException {

          String url = "https://www.fctables.com/";
              
          Document document = Jsoup.connect(url).get();
          Elements tabela = document.select("[class=alphabet]");
          Elements items = tabela.select("[data-href]");  
          
          //System.out.println(items);
          String liga="/brazil/";
          String ligaTabela="/brazil/serie-a/";
          for(Element element : items){
                try {
                    String rLink = element.attr("data-href").toString();
                    //System.out.println(rLink);    
                } catch (Exception e) {
                }  
          }
          
          String url2=url+liga;
          Document document2 = Jsoup.connect(url2).get();
          Elements tabelaLigas = document2.select("[class=col-xs-6 col-sm-4 col-lg-3 col-md-3]");
          
          //System.out.println(tabelaLigas);
          
          for(Element element : tabelaLigas){
                try {
                    Elements linkLiga = element.select("a[href]:eq(0)");
                    String rLinkLiga = linkLiga.attr("href").toString();
                    //System.out.println(rLinkLiga);
                    
                    String url3=url+ligaTabela+"corners/";
                    Document document3 = Jsoup.connect(url3).get();
                    Elements tabelaTbody = document3.select("tbody");
                    Elements itemsTr = tabelaTbody.select("tr"); 
          
                    for(Element element1 : itemsTr){
                        try {
                            TimeCantos time = new TimeCantos();
                            String Times = element1.select("td:eq(1)").text();
                            Double MCantosFeitos = Double.parseDouble(element1.select("td:eq(6)").text());
                            Double MCantosSofridos = Double.parseDouble(element1.select("td:eq(14)").text());
                            Double MCantosTotais = Double.parseDouble(element1.select("td:eq(2)").text());
                            Double MCantosFeitosHT = Double.parseDouble(element1.select("td:eq(7)").text());
                            Double MCantosSofridosHT = Double.parseDouble(element1.select("td:eq(15)").text());
                    
                            time.setNome(Times);
                            time.setmCantosFeitos(MCantosFeitos);
                            time.setmCantosFeitosHT(MCantosFeitosHT);
                            time.setmCantosSofridos(MCantosSofridos);
                            time.setmCantosSofridosHT(MCantosSofridosHT);
                            time.setmCantosTotais(MCantosTotais);
                    
                        } catch (Exception e) {
                        }  
                    }                    
                } catch (Exception e) {
                }  
          }                 
    }

*/