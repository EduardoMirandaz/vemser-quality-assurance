package pages.purchase;

import org.openqa.selenium.By;
import util.BaseTest;

public class YourCartPage extends BaseTest {

    private final By btnprosseguirParaPagamento = By.cssSelector("#checkout");

    public void clicarProsseguirParaPagamento(){
        BaseTest.click(btnprosseguirParaPagamento);
    }
}
