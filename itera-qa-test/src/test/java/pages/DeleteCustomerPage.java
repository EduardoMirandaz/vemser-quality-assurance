package pages;

import org.openqa.selenium.By;
import util.BaseText;
import util.Browser;

public class DeleteCustomerPage extends Browser {

    private static final By btnDeleteCustomer = By.cssSelector("body > div > div > form > div > input");

    public void clickDeleteCustomer(){
        BaseText.click(btnDeleteCustomer);
    }

}
