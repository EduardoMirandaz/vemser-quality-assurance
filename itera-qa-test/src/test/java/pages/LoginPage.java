package pages;

import org.openqa.selenium.By;
import util.BaseText;

public class LoginPage extends BaseText {

    public static final By fieldUsername = By.cssSelector("#Username");
    public static final By fieldPassword = By.cssSelector("#Password");
    public static final By btnLogin = By.cssSelector("body > div > div:nth-child(4) > form > table > tbody > tr:nth-child(7) > td:nth-child(2) > input.btn.btn-primary");
    public static final By msgSucessLogin = By.cssSelector("body > div > div > h3");

    public void preencherUsername(){
        BaseText.sendKeys(fieldUsername, "thedraude");
    }
    public void preencherPassword(){
        BaseText.sendKeys(fieldPassword, "senh@A$");
    }

    public void clicarBtnLogin(){
        BaseText.click(btnLogin);
    }

    public String retornoLogin(){
        return BaseText.getText(msgSucessLogin);
    }


}
