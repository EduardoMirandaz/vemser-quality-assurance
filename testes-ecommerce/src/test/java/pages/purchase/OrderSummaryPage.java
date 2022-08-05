package pages.purchase;

import org.openqa.selenium.By;
import util.BaseTest;

public class OrderSummaryPage {

    private final By btnConfirmOrder = By.cssSelector("#cart_navigation > button");
    private final By msgOrderConfirmation = By.cssSelector("#center_column > div > p > strong");

    public void clickConfirmOrder(){
        BaseTest.click(btnConfirmOrder);
    }

    public String getMsgOrderConfirmation(){
        return BaseTest.getText(msgOrderConfirmation);
    }

}
