/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteExemplos;

import java.io.IOException;
import model.bean.LigaCantos;
import model.bean.Pais;
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
public class ProximoJogFCT {
    public static void main(String[] args) throws IOException {
        String url1 = "https://www.fctables.com/brazil/serie-a/";
                Document documentoNomeLiga = Jsoup.connect(url1).get();
                Elements TabelaJogos = documentoNomeLiga.select("[class=games-box livescore_body]");
                Elements jogo = TabelaJogos.select("[id*=game]");
                String nomeLiga;
                for(Element e : jogo){
                    String data =e.select("[class*=date_unix]").attr("title");
                    String times =e.select("[class*=game_hover]").text();                 
                    System.out.println(data+"  "+times);
                }
                //System.out.println(jogo);
   }
}
