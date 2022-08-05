package pages.user;

import org.openqa.selenium.By;
import util.BaseTest;
import util.JsonManipulation;

public class LoginPage extends BaseTest {

    public static final By fieldEmail = By.cssSelector("#email");
    public static final By fieldPassword = By.cssSelector("#passwd");
    public static final By msgSucessLogin = By.cssSelector("body > div > div > h3");

    public void preencherEmail(){
        BaseTest.sendKeys(fieldEmail, JsonManipulation.recuperarCadastro().get("email"));
    }
    public void preencherPassword(){
        BaseTest.sendKeys(fieldPassword, JsonManipulation.recuperarCadastro().get("password"));
    }

    public String retornoLogin(){
        return BaseTest.getText(msgSucessLogin);
    }


}
