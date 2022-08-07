package steps;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.catalog.Inventory;
import pages.purchase.OrderSummaryPage;
import pages.purchase.YourCartPage;
import pages.user.YourInformationPage;
import util.BaseTest;
import util.Browser;

import static pages.catalog.Inventory.testAllThingsTShirt;

public class DefaultBuy extends Browser {

    LogInSteps logInSteps = new LogInSteps();
    YourCartPage yourCartPage = new YourCartPage();
    Inventory inventory = new Inventory();
    OrderSummaryPage orderSummaryPage = new OrderSummaryPage();
    YourInformationPage yourInformationPage = new YourInformationPage();


    private final String sucessOrderMsg = "THANK YOU FOR YOUR ORDER";

    @Test
    public void buyDefaultDress(){

        logInSteps.logar();

        comprarItem(testAllThingsTShirt);

//         Validação
        String expected = orderSummaryPage.getMsgOrderConfirmation();
        Assert.assertEquals(expected, sucessOrderMsg);
    }

    public void comprarItem(By item){

        BaseTest.click(item);

        inventory.clickBtnNoCarrinho();

        finalizarPagamentoDefault();

    }


    private void finalizarPagamentoDefault() {

        yourCartPage.clicarProsseguirParaPagamento();

        yourInformationPage.preencherFirstName();
        yourInformationPage.preencherLastName();
        yourInformationPage.preencherZipPostalCode();
        yourInformationPage.clicarContinue();

        orderSummaryPage.clickConfirmOrder();

        orderSummaryPage.getMsgOrderConfirmation();

    }

}
