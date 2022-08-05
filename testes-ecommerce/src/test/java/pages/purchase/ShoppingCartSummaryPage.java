package pages.purchase;

import org.openqa.selenium.By;
import util.BaseTest;

public class ShoppingCartSummaryPage extends BaseTest {

    private final By btnprosseguirParaPagamento = By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium");

    public void clicarProsseguirParaPagamento(){
        BaseTest.click(btnprosseguirParaPagamento);
    }
}
