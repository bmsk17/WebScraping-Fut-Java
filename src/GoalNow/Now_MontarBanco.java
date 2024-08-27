/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoalNow;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import model.bean.LigaNow;
import model.bean.Pais;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import view.Tela_Now;

/**
 *
 * @author Bernardo
 */
public class Now_MontarBanco {
    public static void main(String[] args) throws IOException {
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF); /* comment out to turn off annoying htmlunit warnings */
        WebClient webClient = new WebClient();
        HtmlPage currentPage = webClient.getPage("http://info.nowgoal.com/");
        String texto = currentPage.asXml();
    
        Document documento = Jsoup.parse(texto);
        BuscarPaises(documento);        
        
    }
    
    public static void BuscarPaises(Document documento) throws IOException{
        Elements tabela = documento.select("[id=allSclassList]");
        Elements paises = tabela.select("[class=divList]:lt(10)");
        Elements ligas = documento.select("[class=floatDiv]").select("[class=ulDiv]:eq(0)").select("li[onmouseover*=showSeason]").select("a[href*=java]:eq(0)");      
                
        for(Element it:paises){
            String buscar =it.attr("id")+"div";
            Pais p = new Pais();
            p.setNome(it.text());
            p.setLink(buscar);
            System.out.println(p.getNome());
            BuscarLiga(p.getLink(), documento);
        }            
    }
    
    public static void BuscarLiga(String ligsa,Document documento) throws IOException{
            Elements liga = documento.select("[id="+ligsa+"]").select("[class=ulDiv]:lt(1)").select("li[onmouseover*=showSeason]:lt(1)");
            for(Element its:liga){
                String nome  = its.select("a[href*=java]:eq(0)").text();
                Elements temporada = its.select("[class=inner_ul]").select("li:eq(0)");//.select("a[href]:eq(0)");
                //System.out.println("  "+nome+"  -  "+temporada.text()+"  -  "+temporada.select("a").attr("href"));
                LigaNow l = new LigaNow();
                l.setNome(nome);
                l.setLink(its.select("li").attr("onmouseover"));
                System.out.println("    - "+l.getNome());
                BuscarTemporada(ligsa, documento);
            }     
    }
    
    public static void BuscarTemporada(String ligsa,Document documento) throws IOException{
            Elements liga = documento.select("[id="+ligsa+"]").select("[class=ulDiv]:lt(1)").select("li[onmouseover=showSeason(this,event,0)]");
            Elements temporada = liga.select("[class=inner_ul]").select("li:lt(1)");
            String link = "";
            for(Element its:temporada){
                String nome  = its.text();
                link = its.select("a").attr("href");
                //System.out.println(link);
                LigaNow l = new LigaNow();
                l.setNome(nome);
                System.out.println("        - "+l.getNome());   
                BuscarTabelaLiga(AcharLiga("http://info.nowgoal.com"+link));//link da liga natemporada
            }     
    }
    
    public static void BuscarJogos(String LinkTemporada){       
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF); /* comment out to turn off annoying htmlunit warnings */
        WebClient webClient = new WebClient();
        HtmlPage currentPage;
        try {
            currentPage = webClient.getPage("http://info.nowgoal.com"+LinkTemporada);String Source = currentPage.asXml();
        
            Document doo =Jsoup.parse(Source);
        
            Elements tabela = doo.select("[id=Table3]");
            Elements items = tabela.select("tr:gt(1)");  
            for(Element it: items){
                String data = it.select("td:eq(1)").text();
                String timeA = it.select("td:eq(2)").select("a").text();
                String linkTimeA = it.select("td:eq(9)").select("a").attr("href");
                String timeB = it.select("td:eq(4)").select("a").text();
                System.out.println("                "+ data+" "+ timeA+" x "+timeB+" ---- "+linkTimeA);
            }    
        } catch (IOException ex) {
            Logger.getLogger(Tela_Now.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static String AcharLiga(String linkTabJs) throws IOException{
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF); /* comment out to turn off annoying htmlunit warnings */
        WebClient webClient = new WebClient();
        
        Now_TabelaLiga n = new Now_TabelaLiga();
        HtmlPage currentPage = webClient.getPage(linkTabJs);
        String texto = currentPage.asXml();
        
        Document documento = Jsoup.parse(texto);
        Elements tabela = documento.select("script[src*=/jsData/matchResult]");
        String src = tabela.attr("src");
        System.out.println("http://info.nowgoal.com"+src);
        
        return "http://info.nowgoal.com"+src;
    }
    
    public static void BuscarTabelaLiga(String linkTabJs) throws IOException{
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF); /* comment out to turn off annoying htmlunit warnings */
        WebClient webClient = new WebClient();
        
        Now_TabelaLiga n = new Now_TabelaLiga();
        //"http://info.nowgoal.com/jsData/matchResult/2019/s4_en.js?version=2019080104"
        HtmlPage currentPage = webClient.getPage(linkTabJs);
        String texto = currentPage.asXml();
        
        Document documento = Jsoup.parse(texto);
        Elements tabela = documento.select("script[src*=/jsData/matchResult]");
        String src = tabela.attr("src");
        System.out.println(src);
        
        String regex = "var arrTeam = \\[(\\[.*\\,.*\\,.*\\,.*\\,.*\\,.*\\,.*\\])*\\]";
        String regexLiga = "var arrLeague = \\[.*\\,.*\\,.*\\,.*\\,.*\\,.*\\,.*\\]";   
        
        n.CadastrarLiga(regexLiga, texto);
        n.CadastrarTime(regex, texto);
    }
    
    public void CadastrarLiga(String regex,String texto){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);  
        
        String nomeLiga="";
        ArrayList<String> nLiga = new ArrayList<String>();
        
        while(matcher.find()){
             nomeLiga=matcher.group();
        }
        pattern = Pattern.compile("\\''\\,\\''\\,\\'(\\w+\\s*)+'\\,");
        matcher = pattern.matcher(nomeLiga);
        while(matcher.find()){
             nLiga.add(matcher.group().substring(7, matcher.group().length()-2));
        }
        System.out.println("oi o i ss"+"            - "+nLiga.get(0));  
    }
    
    public void CadastrarTime(String regex,String texto){
        String Times="",tt="",pTime="";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);       
        
        while(matcher.find()){
             Times = matcher.group();             
        }
        Times = Times.substring(15,Times.length()-1);
        //System.out.println(Times);
        
        int finall=0,inicio=0;
        
        for(int i=0;i<Times.length();i++){
            if(Times.substring(i,i+1).equals("[")){
                inicio=i;
                i++;
                while(!Times.substring(i,i+1).equals("]")){
                    i++;
                    finall=i+1;
                }
                pTime=Times.substring(inicio, finall);
                
                pattern = Pattern.compile("\\''\\,\\''\\,\\'(\\w+\\s*)+'\\,");
                matcher = pattern.matcher(pTime);
                while(matcher.find()){
                    pTime = matcher.group().substring(7, matcher.group().length()-2);
                    System.out.println("oi o i "+"            - "+pTime);             
                }
            }
        } 
    
    }
    
}
