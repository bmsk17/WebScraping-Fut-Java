package webscrape;

import java.io.IOException;
import java.util.Set;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Shane - shanelee.co.uk
*/


public class WebScrape {
    public static void main(String[] args) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bernardo\\Documents\\NetBeansProjects\\1 - Outros\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(); 
        driver.get("http://info.nowgoal.com/en/League/2019/4.html");
        
        
/*
        Cookie cookie = new Cookie("key", "value");
        driver.manage().addCookie(cookie);

        Set<Cookie> allCookies = driver.manage().getCookies();
        for (Cookie loadedCookie : allCookies) {
            System.out.println(String.format("%s -> %s", loadedCookie.getName(), loadedCookie.getValue()));
        }
  */      
    }
    
    
}
