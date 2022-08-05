package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.DashboardPage;
import pages.DeleteCustomerPage;
import pages.LoginPage;
import util.Browser;

public class DeletarClienteSteps extends Browser {

    SignUpSteps signUpSteps = new SignUpSteps();
    LoginSteps loginSteps = new LoginSteps();
    CriarClienteSteps criarClienteSteps = new CriarClienteSteps();
    BuscarClienteSteps buscarClienteSteps = new BuscarClienteSteps();
    DeleteCustomerPage deleteCustomerPage = new DeleteCustomerPage();

    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void deletarClienteValido(){

        signUpSteps.cadastrar();
        loginSteps.logar();
        criarClienteSteps.criarCliente();
        // Busco o cliente a ser deletado
        String atributoDaBusca = "eduardo@gmail.com";

//         Validação
        Assert.assertEquals(deletarCliente(atributoDaBusca), atributoDaBusca);

    }

    public String deletarCliente(String atributoDaBusca) {
        String s = buscarClienteSteps.buscarCliente(atributoDaBusca);
        dashboardPage.clicarbtnDelete();
        deleteCustomerPage.clickDeleteCustomer();
        return s;
    }

}