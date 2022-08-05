package pages;

import org.openqa.selenium.By;
import util.BaseTest;
import util.Browser;

public class HomePage extends Browser {

    private static final By btnSignIn = By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a");
    private final By btnContactUs = By.cssSelector("#contact-link > a");

    public void clickContactUs(){
        BaseTest.click(btnContactUs);
    }
    public void clickSignIn(){
        BaseTest.click(btnSignIn);
    }

}
