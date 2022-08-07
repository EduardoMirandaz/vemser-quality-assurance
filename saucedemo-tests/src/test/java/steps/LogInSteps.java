package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.catalog.Inventory;
import pages.user.LoginPage;
import util.Browser;

public class LogInSteps extends Browser {

    Inventory inventory = new Inventory();
    LoginPage loginPage = new LoginPage();


    @Test
    public void logarUsuarioValido(){

        logar();

        // Validação

        String expected = inventory.myAccountMessage();
        Assert.assertEquals(expected, "PRODUCTS");
    }

    void logar() {

        // preencher dados do login
        loginPage.preencherUsername();
        loginPage.preencherPassword();
        loginPage.clicarBtnLogin();
    }



}
