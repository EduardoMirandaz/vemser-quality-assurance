package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.SignUpPage;
import util.BaseText;
import util.Browser;

import static util.Elements.waitElement;

// passos para chegar até a tela de sign up
public class SignUpSteps  extends Browser {

    SignUpPage signUpPage = new SignUpPage();
    HomePage homePage = new HomePage();

    @Test
    public void cadastrarUsuarioValido(){

        cadastrar();

        // Validação
        waitElement(signUpPage.msgSucessRegistration);


        String expected = signUpPage.retornoSignUp();
        Assert.assertEquals(expected, "Registration Sucessful");
    }

    public void cadastrar(){
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
    }



}
