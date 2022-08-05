package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.DashboardPage;
import pages.LoginPage;
import util.Browser;

public class DeletarClienteSteps extends Browser {

    SignUpSteps signUpSteps = new SignUpSteps();
    LoginSteps loginSteps = new LoginSteps();
    CreateCustomerSteps createCustomerSteps = new CreateCustomerSteps();
    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void criarClienteValido(){

        signUpSteps.cadastrar();
        loginSteps.logar();
        createCustomerSteps.criarCliente();
        String atributoDaBusca = "eduardo@gmail.com";
        String expected = buscarCliente(atributoDaBusca);

//         Validação
        Assert.assertEquals(expected, atributoDaBusca);

    }

    public String buscarCliente(String atributoCliente){

        dashboardPage.preencherInputSearching(atributoCliente);
        dashboardPage.clicarbtnSearch();
        return dashboardPage.retornoBusca();
    }
}