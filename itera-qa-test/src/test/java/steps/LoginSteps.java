package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;
import util.Browser;

import static util.Elements.waitElement;

// passos para chegar até a tela de sign up
public class LoginSteps extends Browser {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    DashboardPage dashboardPage = new DashboardPage();

    SignUpSteps signUpSteps = new SignUpSteps();

    @Test
    public void logarUsuarioValido(){

        signUpSteps.cadastrar();
        logar();
//         Validação
        Assert.assertEquals(loginPage.retornoLogin(), "Welcome " +"thedraude");

    }

    public void logar() {

        // Clicar no botao login
        homePage.clicarBtnLogin();

        // Preencher formulário
        loginPage.preencherUsername();
        loginPage.preencherPassword();

        // Clicar no botao login
        loginPage.clicarBtnLogin();

        waitElement(dashboardPage.btnCreateNew);

    }


}
