package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.user.LoginPage;
import pages.user.MyAccountPage;
import pages.user.SignIn_LoginPage;
import util.Browser;

public class LogInSteps extends Browser {


    HomePage homePage = new HomePage();
    SignIn_LoginPage signIn_loginPage = new SignIn_LoginPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    LoginPage loginPage = new LoginPage();
    SignInSteps signInSteps = new SignInSteps();
    @Test
    public void logarUsuarioValido(){
        signInSteps.cadastrar();
        // Clicar no botao de logout e voltar para a SignIn_LoginPage
        myAccountPage.clicarLogout();
        logar();

        // Validação

        String expected = myAccountPage.myAccountMessage();
        Assert.assertEquals(expected, "MY ACCOUNT");
    }

    void logar() {

        homePage.clickSignIn();
        // preencher dados do login
        loginPage.preencherEmail();
        loginPage.preencherPassword();
        signIn_loginPage.clicarBtnLogin();
    }
}
