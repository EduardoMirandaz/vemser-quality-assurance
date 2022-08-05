package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.user.MyAccountPage;
import pages.user.SignIn_LoginPage;
import pages.user.SignInPage;
import util.Browser;

import java.util.HashMap;
import java.util.Map;

import static util.Elements.waitElement;

// passos para chegar até a tela de sign up
public class SignInSteps extends Browser {

    SignInPage signInPage = new SignInPage();
    HomePage homePage = new HomePage();

    SignIn_LoginPage signIn_loginPage = new SignIn_LoginPage();

    MyAccountPage myAccountPage = new MyAccountPage();
    @Test
    public void cadastrarUsuarioValido(){

        cadastrar();

        // Validação

        String expected = myAccountPage.myAccountMessage();
        Assert.assertEquals(expected, "MY ACCOUNT");
    }

    public void cadastrar(){
        // Clicar no botao signUp
        homePage.clickSignIn();

        // Preencher formulário

        // preencher email na tela intermediária
        String email = signInPage.preencherEmail();
        signIn_loginPage.clickCreateAnAccount();
        waitElement(signInPage.createAnAccountScreenMessage);

        // preencher formulário de cadasto
        signInPage.clicarGender();
        signInPage.preencherFirstName();
        signInPage.preencherLastName();
        String password = signInPage.preencherPassword();
        signInPage.preencherDateOfBirth();
        signInPage.preencherCompany();
        signInPage.preencherAddress1();
        signInPage.preencherAddress2();
        signInPage.preencherCity();
        signInPage.preencherState();
        signInPage.preencherZipPostalCode();
        signInPage.preencherPhoneNumber1();

        Map<String, String> login = new HashMap<>();
        login.put("email", email);
        login.put("password", password);
        signInPage.criarJsonCadastro(login);

//         Clicar no botao submit
        signInPage.clicarBtnSubmit();

    }


}
