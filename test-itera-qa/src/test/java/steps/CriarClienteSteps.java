package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.CreateCustomerPage;
import pages.DashboardPage;
import pages.LoginPage;
import util.Browser;

import static util.Elements.waitElement;

public class CreateCustomerSteps extends Browser {

    SignUpSteps signUpSteps = new SignUpSteps();
    LoginSteps loginSteps = new LoginSteps();
    DashboardPage dashboardPage = new DashboardPage();
    CreateCustomerPage createCustomerPage = new CreateCustomerPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void criarClienteValido(){

        signUpSteps.cadastrar();
        loginSteps.logar();
        criarCliente();

//         Validação
        Assert.assertEquals(loginPage.retornoLogin(), "Welcome " +"thedraude");

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

}
