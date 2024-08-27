/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteExemplos;

import java.io.IOException; 
import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Bernardo
 */
public class Teste1 {
    public static void main(String[] args) throws IOException{
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bernardo\\Documents\\NetBeansProjects\\1 - Outros\\chromedriver.exe");
 
        WebDriver driver = new ChromeDriver(); 
        driver.get("http://info.nowgoal.com/en/League/2019/4.html");
        String html = driver.getPageSource();
      
        String now = ("http://info.nowgoal.com/en/League/2019/4.html");
        
        Document document = Jsoup.connect(now).get();
        
        Elements tabela = document.select("script[src]");
        Elements items = tabela.select("tr");  
        System.out.println(tabela);

   }    
}
