/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteExemplos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.bean.ProximoJogo;
import model.dao.ProximoJogoDAO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Bernardo
 */
public class NewClass {
    public static void main(String[] args) throws IOException {
        String url = "https://www.fctables.com/";                   
        String url1 = url+"brazil/serie-a/";
                Document documentoNomeLiga = Jsoup.connect(url1).get();
                Elements TabelaJogos = documentoNomeLiga.select("[class=games-box livescore_body]");
                Elements jogo = TabelaJogos.select("[id*=game]");
                String nomeLiga;
                for(Element e : jogo){
                    String data =e.select("[class*=date_unix]").attr("title");
                    String timeCasa =e.select("[class*=game_hover]").select("[class*=home]").text();
                    String timeVisitante =e.select("[class*=game_hover]").select("[class*=away]").text();
                    System.out.println(timeCasa);
                }
    
    }
}
