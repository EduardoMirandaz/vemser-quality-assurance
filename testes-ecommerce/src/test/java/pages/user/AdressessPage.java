package pages.user;

import org.openqa.selenium.By;
import util.BaseTest;

public class AdressessPage extends BaseTest {

    private final By btnprosseguirParaPagamento = By.cssSelector("#center_column > form > p > button");

    public void clicarProsseguirParaPagamento(){
        BaseTest.click(btnprosseguirParaPagamento);
    }
}
