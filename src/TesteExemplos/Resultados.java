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
public class Resultados {
    public static void main(String[] args) throws IOException {

          String url = "http://info.nowgoal.com/en/League/2019/4.html";
              
          Document document = Jsoup.connect(url).get();
          Elements tabela = document.select("[id=Table3]");
          Elements items = tabela.select("tr:eq(2)");  
                     
          System.out.println(items);
          
          for(int second = 0;; second++){
              if(second>=60)break;
              try {
                  //if(selen("tr:eq(2)")) break;
              } catch (Exception e) {
              }
          }
          
          
                    
    }
}
