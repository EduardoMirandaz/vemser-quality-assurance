package frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class comandosIniciais {

    public static WebDriver driver;


    public static WebDriverWait driverWait;

    // comandos selenium


    public void comandosSelenium(){

        // Acessar os sites

        driver.get("https://itera-qa.azurewebsites.net/");


        // Pegar elementos específicos

        driver.findElement(By.cssSelector(""));
        driver.findElement(By.xpath(""));
        driver.findElement(By.id(""));
        driver.findElement(By.name(""));
        driver.findElement(By.className(""));

        // Algumas ações possíveis

        driver.findElement(By.cssSelector("")).click();
        driver.findElement(By.cssSelector("")).sendKeys("TEXTO");
        driver.findElement(By.cssSelector("")).clear();
        driver.findElement(By.cssSelector("")).getText();

        // Controlar o tempo

        driverWait
                .until(
                        ExpectedConditions
                        .presenceOfAllElementsLocatedBy(
                                By.cssSelector("")));


        // fixos
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);


    }

}
