package pages;

import org.openqa.selenium.By;
import util.BaseTest;
import util.Browser;

public class HomePage extends Browser {

    private static final By btnSignIn = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");

    public void clickSignIn(){
        BaseTest.click(btnSignIn);
    }

}
