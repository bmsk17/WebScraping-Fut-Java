/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteExemplos;

// Importa as bibliotecas do JUnit, Selenium WebDriver, List etc.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;




/**
 *
 * @author Bernardo
 */
public class TesteUniy {
    public static void main(String[] args){
 
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bernardo\\Downloads\\chromedriver.exe");
 
        WebDriver driver = new ChromeDriver(); 
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
        
        //Close the browser
        //driver.quit();
        
    }    
}


/*
driver.navigate().to("http://softwaretestingbooks.com/"); 
        String appTitle = driver.getTitle(); 
        System.out.println("Application title is : "+appTitle);

*/