/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscrape;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import java.io.IOException;
import java.util.List;
import org.junit.Assert;
/**
 *
 * @author Bernardo
 */
public class HtmlUnit {
    public static void main(String[] args) throws IOException {
        
        String baseUrl = "https://google.com/" ;
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try{    
            HtmlPage page = client.getPage(baseUrl);
            System.out.println(page.asXml());
        }catch(Exception e){
            e.printStackTrace();
        }
        
        String baaseUrl = "https://news.ycombinator.com/" ;
        WebClient clients = new WebClient();
        
        clients.getOptions().setCssEnabled(false);
        clients.getOptions().setJavaScriptEnabled(false);
        try{
            HtmlPage page = client.getPage(baaseUrl);
            System.out.println(page.asXml());
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        HtmlPage page = client.getPage(baseUrl);
        List<HtmlElement> itemList = (List<HtmlElement>) page.getByXPath("//tr[@class='athing']");
        if(itemList.isEmpty()){
            System.out.println("No item found");
        }else{
            for(HtmlElement htmlItem : itemList){
                
                int position = Integer.parseInt(((HtmlElement)htmlItem.getFirstByXPath("./td/span")).asText().replace(".", ""));
                
                int id =
                Integer.parseInt(htmlItem.getAttribute("id"));
                String title = ((HtmlElement) htmlItem.getFirstByXPath("./td[not(@valign='top')][@class='title']")).asText();
                String url = ((HtmlAnchor) htmlItem.getFirstByXPath("./td[not(@valign='top')][@class='title']/a")).getHrefAttribute();
                String author = ((HtmlElement) htmlItem.getFirstByXPath("./followingsibling::tr/td[@class='subtext']/a[@class='hnuser']")).asText();
                
}
        }
    }
}
