/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoalNow;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.bean.LigaNow;
import model.bean.ProximoJogo;
import model.bean.TimeNow;
import model.dao.LigaNowDAO;
import model.dao.TimeNowDAO;
import net.bytebuddy.asm.Advice;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * INSERT INTO `timenow`(`nome`, `codlig`) VALUES ("",10)
 * @author Bernardo
 */
public class Now_BancoCantos {
    public static ArrayList<ProximoJogo> listaProximosJogos; 
    
    
    public static void main(String[] args) throws IOException {
        
        //PrevisaoTimes("http://www.nowgoal.com/analysis/1676919.html");
        
        String Alemanha ="http://info.nowgoal.com/en/League/2019-2020/8.html";
        String espanha ="http://info.nowgoal.com/en/League/2019-2020/31.html";
        String inglaterra  ="http://info.nowgoal.com/en/League/2019-2020/36.html";        
        String franca ="http://info.nowgoal.com/en/League/2019-2020/11.html";        
        String portugal ="http://info.nowgoal.com/en/SubLeague/2019-2020/23.html";
        String italia = "http://info.nowgoal.com/en/League/2019-2020/34.html";
        String Brasil = "http://info.nowgoal.com/en/League/2019/4.html";
        
        //BuscarTabelaLiga(AcharLiga(Brasil)); // CAdastrar liga
        ProximosJogos(Brasil); // Proximos jogos
      
      
        for(ProximoJogo p:listaProximosJogos){
            System.out.println(p.getCasa()+" - "+p.getVisitante()
            +" - "+p.getmCasaCantosTotal()
            +" - "+p.getmVisitanteCantosTotal());
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
        
        Now_BancoCantos n = new Now_BancoCantos();
        //"http://info.nowgoal.com/jsData/matchResult/2019/s4_en.js?version=2019080104"
        HtmlPage currentPage = webClient.getPage(linkTabJs);
        String texto = currentPage.asXml();
        
        Document documento = Jsoup.parse(texto);
        Elements tabela = documento.select("script[src*=/jsData/matchResult]");
        String src = tabela.attr("src");
        System.out.println(src);
        
        String regex = "var arrTeam = \\[(\\[.*\\,.*\\,.*\\,.*\\,.*\\,.*\\,.*\\])*\\]";
        String regexLiga = "var arrLeague = \\[.*\\,.*\\,.*\\,.*\\,";   
        
        
        int codLiga = n.CadastrarLiga(regexLiga, texto);
        n.CadastrarTime(regex, texto,codLiga);
    }
    
    public int CadastrarLiga(String regex,String texto){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);  
        
        
        String nomeLiga="";
        ArrayList<String> nLiga = new ArrayList<String>();
        
        while(matcher.find()){
            System.out.println(matcher.group());
             nomeLiga=matcher.group();
        }
        pattern = Pattern.compile("\\''\\,\\''\\,\\'(\\w+\\s*)+'\\,");
        matcher = pattern.matcher(nomeLiga);
        while(matcher.find()){
             nLiga.add(matcher.group().substring(7, matcher.group().length()-2));
        }
        System.out.println(nLiga);
        System.out.println("- "+nLiga.get(0));
        LigaNow lig = new LigaNow();
        LigaNowDAO ligdao = new LigaNowDAO();
        
        lig.setNome(nLiga.get(0));
        ligdao.create(lig);
        int codigo=ligdao.readNome(lig);
        
        return codigo;
    }
    
    public void CadastrarTime(String regex,String texto,int codliga){
        String Times="",tt="",pTime="";
        System.out.println("This cod :"+codliga);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);       
        
        while(matcher.find()){
             Times = matcher.group();             
        }
        Times = Times.substring(15,Times.length()-1);
        
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
                    System.out.println("- "+pTime);
                    
                    TimeNow t = new TimeNow();
                    TimeNowDAO tdao = new TimeNowDAO();
                    
                    t.setCodlig(codliga);
                    t.setNome(pTime);
                    tdao.create(t);
                }
            }
        } 
    
    }
    
    public static void ProximosJogos(String Linkliga) throws IOException{
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF); /* comment out to turn off annoying htmlunit warnings */
        WebClient webClient = new WebClient();
        HtmlPage currentPage = webClient.getPage(Linkliga);
        String Source = currentPage.asXml();
        
        Document doo =Jsoup.parse(Source);
        
        ProximoJogo p = new ProximoJogo();
        
        Elements tabela = doo.select("[id=Table3]");
        Elements items = tabela.select("tr:gt(1)");  
        for(Element it: items){
            String data = it.select("td:eq(1)").text();
            String timeA = it.select("td:eq(2)").select("a").text();
            String linkTimeA = it.select("td:eq(9)").select("a").attr("href");
            String timeB = it.select("td:eq(4)").select("a").text();
            
            p.setCasa(timeA);
            p.setVisitante(timeB);
            p.setData(data);
            
            TimeNow tim = new TimeNow();
            TimeNow tim2 = new TimeNow();
            TimeNowDAO timdao = new TimeNowDAO();
            
            System.out.println(data+"   -   "+timeA+"   -   "+timeB+"   -   "+linkTimeA);
            
            
            tim.setNome(timeA);
            tim2.setNome(timeB);
            System.out.println("o -- "+timdao.readNome(tim)+"    -- "+timdao.readNome(tim2));
            
            try {
                PrevisaoTimes(linkTimeA,timeA,timeB,p);
            } catch (Exception e) {
            }
            
        }
    
    }
    
    
    public static void PrevisaoTimes(String link,String timeCasa,String timeVisitante, ProximoJogo p) throws IOException{
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF); /* comment out to turn off annoying htmlunit warnings */
        WebClient webClient = new WebClient();
        HtmlPage currentPage = webClient.getPage(link);
        String Source = currentPage.asXml();
        
        Document doo =Jsoup.parse(Source);
        
        Elements nomeA = doo.select("[class=sclassName]");
        ArrayList<String> noo = new ArrayList<>();
        for(Element item:nomeA){
            noo.add(item.text());
        }

        DecimalFormat formatador = new DecimalFormat("0.00");
        
        //Tabela 11
        Elements tabela = doo.select("[id=table_v1]");
        Elements items = tabela.select("tr:gt(2)").select("[id*=tr]");  
        
        Double mCasaFeitos=0.0;
        Double mCasaSofridos=0.0;
        int cont=0;
        for(Element it: items){
            String data = it.select("td:eq(1)").text();
            String timeA = it.select("td:eq(2)").select("a").text();
            String timeB = it.select("td:eq(6)").select("a").text();
            String cantos = it.select("td:eq(5)").text();           
            int traco=0;
            
            
            if(cantos.length()>2){
                for(int i=0;i<cantos.length();i++){
                    if(cantos.substring(i,i+1).equals("-")){ 
                        traco=i;
                    }
                }
                Double nCantosCasa = Double.parseDouble(cantos.substring(0,traco));
                Double nCantosVisitante = Double.parseDouble(cantos.substring(traco+1,cantos.length()));
                
                cont++;
                //System.out.println(" --- CASA :"+nCantosCasa+"   Visitante: "+nCantosVisitante);
                
                if(timeA.equals(timeCasa)){
                    mCasaFeitos=mCasaFeitos+nCantosCasa;
                    mCasaSofridos=mCasaSofridos+nCantosVisitante;
                    //System.out.println("Total CASA :"+mCasaFeitos+"   n jogo: "+nCantosCasa);
                }else{
                    mCasaFeitos=mCasaFeitos+nCantosVisitante;
                    mCasaSofridos=mCasaSofridos+nCantosCasa;
                    //System.out.println("Total Visitantes :"+mCasaFeitos+"   n jogo: "+nCantosVisitante);
                }
                //System.out.println("");
                
                if(cont>4){
                    break;
                }
            }            
        }
                   
        mCasaFeitos=mCasaFeitos/cont;
        mCasaSofridos=mCasaSofridos/cont;
        System.out.println("    Casa Feitos: "+formatador.format(mCasaFeitos)+"    -Casa Contra:"+formatador.format(mCasaSofridos)+"    -Casa Total:"+formatador.format(mCasaSofridos+mCasaFeitos));
        
        ProximoJogo pj = new ProximoJogo();
        
        
        //Tabela 11
        Elements tabela2 = doo.select("[id=table_v2]");
        Elements items2 = tabela2.select("tr:gt(2)").select("[id*=tr]");  
        
        Double mCasaFeitos2=0.0;
        Double mCasaSofridos2=0.0;
        int cont2=0;
        for(Element it: items2){
            String data = it.select("td:eq(1)").text();
            String timeA = it.select("td:eq(2)").select("a").text();
            String timeB = it.select("td:eq(6)").select("a").text();
            String cantos = it.select("td:eq(5)").text();           
            int traco=0;
            
            if(cantos.length()>2){
                for(int i=0;i<cantos.length();i++){
                    if(cantos.substring(i,i+1).equals("-")){ 
                        traco=i;
                    }
                }
                Double nCantosCasa2 = Double.parseDouble(cantos.substring(0,traco));
                Double nCantosVisitante2 = Double.parseDouble(cantos.substring(traco+1,cantos.length()));
                cont2++;
            
                if(timeA.equals(timeVisitante)){
                    mCasaFeitos2=mCasaFeitos2+nCantosCasa2;
                    mCasaSofridos2=mCasaSofridos2+nCantosVisitante2;      
                }else{
                    mCasaFeitos2=mCasaFeitos2+nCantosVisitante2;
                    mCasaSofridos2=mCasaSofridos2+nCantosCasa2;  
                }
                
                if(cont2>4){
                    break;
                }
            }
              
        }        
        mCasaFeitos2=mCasaFeitos2/cont2;
        mCasaSofridos2=mCasaSofridos2/cont2;
                
        System.out.println("    Visitante Feitos: "+formatador.format(mCasaFeitos2)+"    -Visitante Contra:"+formatador.format(mCasaSofridos2)+"    -Visitante Total:"+formatador.format(mCasaSofridos2+mCasaFeitos2));
        System.out.println("    Total: "+formatador.format((mCasaFeitos2+mCasaSofridos2+mCasaSofridos+mCasaFeitos)/2));
        
        
       // Double af = Double.parseDouble(CasaTotalFT.toString());
       // Double co = Double.parseDouble(CasaTotalFT1.toString());
       // Double total = (af+co)/2;
        
       // CasaTotal1T2.setText(total.toString());
        
        p.setCasa(timeCasa);
        p.setVisitante(timeVisitante);
        p.setStatus("EM ANDAMENTO");
        
        p.setmCasaCantosFeitos(mCasaFeitos);
        p.setmCasaCantosSofridos(mCasaSofridos);
        p.setmCasaCantosTotal(mCasaSofridos+mCasaFeitos);
        
        p.setmVisitanteCantosFeitos(mCasaFeitos2);
        p.setmVisitanteCantosSofridos(mCasaSofridos2);
        p.setmVisitanteCantosTotal(mCasaFeitos2+mCasaSofridos2);
        
        System.out.println(p.getCasa()+" - "+p.getVisitante()
        +" - "+p.getmCasaCantosTotal()
        +" - "+p.getmVisitanteCantosTotal());
        
        listaProximosJogos.add(p);
        
    }
}
