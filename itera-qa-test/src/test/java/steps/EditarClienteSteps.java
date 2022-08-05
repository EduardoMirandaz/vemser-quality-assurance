package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.*;
import util.Browser;

import static util.Elements.waitElement;

public class EditarClienteSteps extends Browser {

    SignUpSteps signUpSteps = new SignUpSteps();
    LoginSteps loginSteps = new LoginSteps();
    CriarClienteSteps criarClienteSteps  = new CriarClienteSteps();
    DeletarClienteSteps deletarClienteSteps = new DeletarClienteSteps();

    DashboardPage dashboardPage = new DashboardPage();
    EditCustomerPage editCustomerPage = new EditCustomerPage();
    LoginPage loginPage = new LoginPage();
    DeleteCustomerPage deleteCustomerPage = new DeleteCustomerPage();
    @Test
    public void editarClienteSteps(){

        signUpSteps.cadastrar();
        loginSteps.logar();
        criarClienteSteps.criarCliente();
        editarCliente();

//         Validação
        Assert.assertEquals(loginPage.retornoLogin(), "Welcome " +"thedraude");

        deletar();
    }

    public void editarCliente(){
        // Clicar no botao create user
        dashboardPage.clicarBtnCreateNew();

        // Preencher formulário
        editCustomerPage.preencherName();
        editCustomerPage.preencherCompany();
        editCustomerPage.preencherAddress();
        editCustomerPage.preencherCity();
        editCustomerPage.preencherPhone();
        editCustomerPage.preencherEmail();

        // Clicar no botao create submit
        editCustomerPage.clickSubmitCreate();

        waitElement(dashboardPage.btnCreateNew);
    }

    public void deletar(){
        String atributoDaBusca = "eduardo@gmail.com";
        dashboardPage.preencherInputSearching(atributoDaBusca);
        dashboardPage.clicarbtnSearch();
        dashboardPage.clicarbtnDelete();
        deleteCustomerPage.clickDeleteCustomer();
    }

}
