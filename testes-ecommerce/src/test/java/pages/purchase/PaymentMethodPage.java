package pages.purchase;

import org.openqa.selenium.By;
import util.BaseTest;

public class PaymentMethodPage extends BaseTest {

    private final By btnPayBankWire = By.cssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a");

    public void clickPayBankWire(){
        BaseTest.click(btnPayBankWire);
    }
}
