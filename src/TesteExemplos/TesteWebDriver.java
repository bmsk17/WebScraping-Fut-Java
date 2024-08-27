/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteExemplos;

import java.util.List;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Bernardo
 */
public class TesteWebDriver {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bernardo\\Documents\\NetBeansProjects\\1 - Outros\\chromedriver.exe");
 
        WebDriver driver = new ChromeDriver(); 
        driver.get("https://www.google.com/");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();

    }
}
