package steps;

import org.openqa.selenium.By;
import util.BaseTest;
import util.Browser;

public class ContactCustomerServiceSteps extends Browser {

    private final By btnContactUs = By.cssSelector("#contact-link > a");

    public void clickContactUs(){
        BaseTest.click(btnContactUs);
    }

}
