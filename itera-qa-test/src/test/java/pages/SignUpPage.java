package pages;

import org.openqa.selenium.By;
import util.BaseText;

// Mapeamentos

public class SignUpPage extends BaseText {

    public static final By fieldFirstName = By.cssSelector("#FirstName");
    public static final By fieldSurname = By.cssSelector("#Surname");
    public static final By fieldE_post = By.cssSelector("#E_post");
    public static final By fieldMobile = By.cssSelector("#Mobile");
    public static final By fieldUsername = By.cssSelector("#Username");
    public static final By fieldPassword = By.cssSelector("#Password");
    public static final By fieldConfirmPassword = By.cssSelector("#ConfirmPassword");
    public static final By btnSubmit = By.cssSelector("#submit");
    public final By msgSucessRegistration = By.cssSelector("body > div > form > div > div:nth-child(11) > div > label");


    public void clicarBtnSubmit(){
        BaseText.click(btnSubmit);
    }

    public void preencherFirstName(){
        BaseText.sendKeys(fieldFirstName, "Eduardo");
    }
    public void preencherSurName(){
        BaseText.sendKeys(fieldSurname, "Miranda");
    }
    public void preencherE_post(){
        BaseText.sendKeys(fieldE_post, "54655465");
    }
    public void preencherMobile(){
        BaseText.sendKeys(fieldMobile, "28999254213");
    }
    public void preencherUsername(){
        BaseText.sendKeys(fieldUsername, "thedraude");
    }
    public void preencherPassword(){
        BaseText.sendKeys(fieldPassword, "senh@A$");
    }
    public void preencherConfirmPassword(){
        BaseText.sendKeys(fieldConfirmPassword, "senh@A$");
    }

    public String retornoSignUp(){
        return BaseText.getText(msgSucessRegistration);
    }
}
