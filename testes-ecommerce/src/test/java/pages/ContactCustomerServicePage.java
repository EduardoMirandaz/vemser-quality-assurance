package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import util.BaseTest;
import util.Browser;

public class ContactCustomerServicePage extends Browser {

    private final By selectorSubject = By.cssSelector("#id_contact");
    private final By selectorOrderReference = By.cssSelector("#center_column > form > fieldset > div.clearfix > div.col-xs-12.col-md-3 > div:nth-child(6) > div > select");
    private final By selectorFileUpload = By.cssSelector("#fileUpload");

    public void selectSubject(){
        BaseTest.click(selectorSubject);
        BaseTest.sendKeys(selectorSubject, Keys.ARROW_DOWN);
    }

    public void selectOrderSubject(){
        BaseTest.click(selectorSubject);
        BaseTest.sendKeys(selectorSubject, Keys.ARROW_DOWN);
    }


}
