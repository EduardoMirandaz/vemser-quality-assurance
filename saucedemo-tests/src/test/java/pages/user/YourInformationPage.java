package pages.user;

import org.openqa.selenium.By;
import util.BaseTest;

public class YourInformationPage extends BaseTest {

    private final By btnContinue = By.cssSelector("#continue");
    private static final By fieldFirstName = By.cssSelector("#first-name");
    private static final By fieldLastName = By.cssSelector("#last-name");
    private static final By fieldZipPostalCode = By.cssSelector("#postal-code");

    public void clicarContinue(){
        BaseTest.click(btnContinue);
    }

    public void preencherFirstName(){
        BaseTest.sendKeys(fieldFirstName, "Eduardo");
    }
    public void preencherLastName(){
        BaseTest.sendKeys(fieldLastName, "Miranda");
    }
    public void preencherZipPostalCode(){
        BaseTest.sendKeys(fieldZipPostalCode, "12399");
    }

}
