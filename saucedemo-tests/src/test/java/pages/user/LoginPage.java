package pages.user;

import org.openqa.selenium.By;
import util.BaseTest;
import util.JsonManipulation;

public class LoginPage extends BaseTest {

    public static final By fieldUsername = By.cssSelector("#user-name");
    public static final By fieldPassword = By.cssSelector("#password");

    public static final By btnLogin = By.cssSelector("#login-button");

    public void preencherUsername(){
        BaseTest.sendKeys(fieldUsername, JsonManipulation.recuperarCadastro().get("username"));
    }
    public void preencherPassword(){
        BaseTest.sendKeys(fieldPassword, JsonManipulation.recuperarCadastro().get("password"));
    }

    public void clicarBtnLogin(){
        BaseTest.click(btnLogin);
    }


}
