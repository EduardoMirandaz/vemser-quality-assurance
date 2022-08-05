package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Browser {

    public static WebDriverWait wait;
    public static WebDriver driver;


    @Before
    public void iniciarBrowser(){

        String url = "https://itera-qa.azurewebsites.net/";

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");

        driver = new ChromeDriver(); // Instancia e cria um browser
        wait = new WebDriverWait(driver, 30); // delay
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS); // Definir um tempo para iniciar
        driver.manage().window().maximize(); // Maximizar a janela do navegador


    }

}