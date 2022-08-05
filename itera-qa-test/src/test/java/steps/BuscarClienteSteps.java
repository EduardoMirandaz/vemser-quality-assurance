package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.DashboardPage;
import pages.DeleteCustomerPage;
import pages.LoginPage;
import util.Browser;

public class BuscarClienteSteps extends Browser {

    SignUpSteps signUpSteps = new SignUpSteps();
    LoginSteps loginSteps = new LoginSteps();
    CriarClienteSteps criarClienteSteps = new CriarClienteSteps();
    DashboardPage dashboardPage = new DashboardPage();
    DeleteCustomerPage deleteCustomerPage = new DeleteCustomerPage();
    @Test
    public void buscarClienteValido(){

        signUpSteps.cadastrar();
        loginSteps.logar();
        criarClienteSteps.criarCliente();
        String atributoDaBusca = "eduardo@gmail.com";
        String expected = buscarCliente(atributoDaBusca);

//         Validação
        Assert.assertEquals(expected, atributoDaBusca);

        deletar();

    }

    public String buscarCliente(String atributoCliente){

        dashboardPage.preencherInputSearching(atributoCliente);
        dashboardPage.clicarbtnSearch();
        return dashboardPage.retornoBusca();
    }

    public void deletar(){
        dashboardPage.clicarbtnDelete();
        deleteCustomerPage.clickDeleteCustomer();
    }

}