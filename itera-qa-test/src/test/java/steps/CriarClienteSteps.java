package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.CreateCustomerPage;
import pages.DashboardPage;
import pages.DeleteCustomerPage;
import pages.LoginPage;
import util.Browser;

import static util.Elements.waitElement;

public class CriarClienteSteps extends Browser {

    SignUpSteps signUpSteps = new SignUpSteps();
    LoginSteps loginSteps = new LoginSteps();
    DashboardPage dashboardPage = new DashboardPage();
    CreateCustomerPage createCustomerPage = new CreateCustomerPage();
    LoginPage loginPage = new LoginPage();
    DeleteCustomerPage deleteCustomerPage = new DeleteCustomerPage();

    @Test
    public void criarClienteValido(){

        signUpSteps.cadastrar();
        loginSteps.logar();
        criarCliente();
//         Validação
        Assert.assertEquals(loginPage.retornoLogin(), "Welcome " +"thedraude");

        deletar();
    }

    public void criarCliente(){
        // Clicar no botao create user
        dashboardPage.clicarBtnCreateNew();

        // Preencher formulário
        createCustomerPage.preencherName();
        createCustomerPage.preencherCompany();
        createCustomerPage.preencherAddress();
        createCustomerPage.preencherCity();
        createCustomerPage.preencherPhone();
        createCustomerPage.preencherEmail();

        // Clicar no botao create submit
        createCustomerPage.clickSubmitCreate();

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
