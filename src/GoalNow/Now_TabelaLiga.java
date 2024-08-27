/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoalNow;

import TesteExemplos.CadastrarCantos;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.bytebuddy.asm.Advice;

/**
 *
 * @author Bernardo
 */
public class Now_TabelaLiga {  
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
    
    public static void main(String[] args) throws IOException {        
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF); /* comment out to turn off annoying htmlunit warnings */
        WebClient webClient = new WebClient();
        HtmlPage currentPage = webClient.getPage("http://info.nowgoal.com/jsData/matchResult/2019/s4_en.js?version=2019080104");
        String texto = currentPage.asXml();
    
        String regex = "var arrTeam = \\[(\\[.*\\,.*\\,.*\\,.*\\,.*\\,.*\\,.*\\])*\\]";
        String regexLiga = "var arrLeague = \\[.*\\,.*\\,.*\\,.*\\,.*\\,.*\\,.*\\]";   
        
        Now_TabelaLiga n = new Now_TabelaLiga();
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
        System.out.println(nLiga.get(0));  
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
                    System.out.println(pTime);             
                }
            }
        } 
    
    }
    
    
}
/*
// \d - todos os digitos
        // \D tudo o que não for digito
        // \s espaços em branco \t \n \f \r
        // \S caractere que não é branco
        // \w caracteres de palavras a-z A-Z, digitos e _
        // \W tudo o que não for caractere de palavra
        // []
        // ? zero ou uma
        // * zero ou mais
        // + uma ou mais
        // {n,m} de n ate m
        // ( )
        // |
        // $
        // . coringa 1.3 = 123,133,1A3,1#3, 1 3
        // ^ [^abc]
        int hex = 0x1;

//        String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";
//        String texto = "12 0x 0X 0x01FFABC 0x10G 0x1";
//        String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+"; //([\\w\\.])+@([a-zA-Z])+(\.([a-zA-Z])+)+
//        String texto = "fulano@hotmail.com, 102Abc@gmail.com, #@!abrao@mail.br, teste@gmail.com.br, teste@mail";
//        String regex = "\\d{2}/\\d{2}/\\d{2,4}";
//        String texto = "05/10/2010 05/05/2015 1/1/01 01/05/95"; // dd/MM/yyyy

        String regex = "proj([^,])*";
        String texto = "proj1.bkp, proj1.java, proj1.class, proj1final.java, proj2.bkp, proj3.java, diagrama, texto, foto"; // dd/MM/yyyy

//        System.out.println("Email valido? "+ "#@!abrao@mail.br".matches(regex));
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto:  "+texto);
        System.out.println("indice: 012345678901234567");
        System.out.println("expressao: "+matcher.pattern());
        System.out.println("posicoes encontradas");
        while(matcher.find()){
            System.out.println(matcher.start() +" "+ matcher.group());
        }



*/