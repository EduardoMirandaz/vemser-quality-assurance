package pages.purchase;

import org.openqa.selenium.By;
import util.BaseTest;



public class ShippingPage extends BaseTest {
    private final By btnConcordarTermosDeEntrega = By.cssSelector("#cgv");
    private final By btnprosseguirParaPagamento = By.cssSelector("#form > p > button");

    public void clicarConcordarTermosDeEntrega(){
        BaseTest.click(btnConcordarTermosDeEntrega);
    }

    public void clicarProsseguirParaPagamento() {
        BaseTest.click(btnprosseguirParaPagamento);
    }
}
