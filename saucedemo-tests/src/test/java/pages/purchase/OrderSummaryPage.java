package pages.purchase;

import org.openqa.selenium.By;
import util.BaseTest;

public class OrderSummaryPage {

    private final By btnFinish = By.cssSelector("#finish");
    private final By msgOrderConfirmation = By.cssSelector("#checkout_complete_container > h2");

    public void clickConfirmOrder(){
        BaseTest.click(btnFinish);
    }

    public String getMsgOrderConfirmation(){
        return BaseTest.getText(msgOrderConfirmation);
    }

}
