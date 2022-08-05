package steps;

import org.junit.Test;
import pages.ContactCustomerServicePage;
import pages.HomePage;

import util.Browser;

public class ContactCustomerServiceSteps extends Browser {

    HomePage homePage = new HomePage();
    BuyDefaultDress buyDefaultDress = new BuyDefaultDress();
    LogInSteps logInSteps = new LogInSteps();
    ContactCustomerServicePage contactCustomerServicePage = new ContactCustomerServicePage();
    @Test
    public void contatarServicosDoCliente(){
        logInSteps.cadastrarDeslogarELogar();
        buyDefaultDress.comprarVestido();
        homePage.clickContactUs();

        contatarServicosSAC();

        // Validação

    }

    private void contatarServicosSAC() {
        contactCustomerServicePage.selectSubject();
        contactCustomerServicePage.selectOrderSubject();
    }


}
