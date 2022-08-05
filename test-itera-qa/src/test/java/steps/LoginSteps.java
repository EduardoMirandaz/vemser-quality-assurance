package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.SignUpPage;
import util.Browser;

// passos para chegar até a tela de sign up
public class LoginSteps extends Browser {

    SignUpPage signUpPage = new SignUpPage();
    HomePage homePage = new HomePage();


    @Test
    public void cadastrararUsuarioValido(){
        // Clicar no botao signUp
        homePage.clicarBtnSignUp();

        // Preencher formulário
        signUpPage.preencherFirstName();
        signUpPage.preencherSurName();
        signUpPage.preencherE_post();
        signUpPage.preencherMobile();
        signUpPage.preencherUsername();
        signUpPage.preencherPassword();
        signUpPage.preencherConfirmPassword();

        // Clicar no botao submit
        signUpPage.clicarBtnSubmit();

        // Validação
        Assert.assertEquals(signUpPage.retornoSignUp(), "Registration Sucessful");

    }




}
