package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.catalog.CatalogPage;
import pages.purchase.OrderSummaryPage;
import pages.purchase.PaymentMethodPage;
import pages.purchase.ShippingPage;
import pages.purchase.ShoppingCartSummaryPage;
import pages.user.AdressessPage;
import pages.user.MyAccountPage;
import util.Browser;

public class BuyDefaultDress extends Browser {

    CatalogPage catalog = new CatalogPage();
    SignInSteps signInSteps = new SignInSteps();
    LogInSteps logInSteps = new LogInSteps();

    ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage();
    MyAccountPage myAccountPage = new MyAccountPage();

    AdressessPage adressessPage = new AdressessPage();

    ShippingPage shippingPage = new ShippingPage();

    PaymentMethodPage paymentMethodPage = new PaymentMethodPage();

    OrderSummaryPage orderSummaryPage = new OrderSummaryPage();

    private final String sucessOrderMsg = "Your order on My Store is complete.";

    @Test
    public void buyDefaultDress(){

        logInSteps.cadastrarDeslogarELogar();

        String nomeDoVestido = "Faded Short Sleeve";
        comprarVestido(nomeDoVestido);

        // Validação
        String expected = orderSummaryPage.getMsgOrderConfirmation();
        Assert.assertEquals(expected, sucessOrderMsg);
    }

    public void comprarVestido(String nomeDoVestido){
        myAccountPage.buscarVestido(nomeDoVestido);
        myAccountPage.clickBtnSearch();

        catalog.clickPrimeiroLista();
        catalog.proceedToCheckout();

        finalizarPagamentoDefault();
    }

    public void comprarVestido(){
        myAccountPage.buscarVestido("Printed");
        myAccountPage.clickBtnSearch();

        catalog.clickPrimeiroLista();
        catalog.proceedToCheckout();

        finalizarPagamentoDefault();
    }

    private void finalizarPagamentoDefault() {
        shoppingCartSummaryPage.clicarProsseguirParaPagamento();

        adressessPage.clicarProsseguirParaPagamento();

        shippingPage.clicarConcordarTermosDeEntrega();
        shippingPage.clicarProsseguirParaPagamento();

        paymentMethodPage.clickPayBankWire();

        orderSummaryPage.clickConfirmOrder();
    }

}
