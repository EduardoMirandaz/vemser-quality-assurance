package pages.user;

import org.openqa.selenium.By;
import util.BaseTest;

public class SignIn_LoginPage {
    public static final By createAnAccount = By.cssSelector("#SubmitCreate > span");
    public static final By btnLogin = By.cssSelector("#SubmitLogin");
    public void clickCreateAnAccount(){
        BaseTest.click(createAnAccount);
    }
    public void clicarBtnLogin(){
        BaseTest.click(btnLogin);
    }


}
