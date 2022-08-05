package pages.user;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import util.BaseTest;
import util.JsonManipulation;

import java.util.Map;

// Mapeamentos

public class SignInPage extends BaseTest {

    private static final By fieldFirstName = By.cssSelector("#customer_firstname");
    private static final By checkboxGender = By.cssSelector("#id_gender1");

    private static final By fieldLastName = By.cssSelector("#customer_lastname");
    private static final By fieldPassword = By.cssSelector("#passwd");

    private static final By selectorDay = By.cssSelector("#days");
    private static final By selectorMonth = By.cssSelector("#months");

    private static final By selectorYear = By.cssSelector("#years");

    private static final By selectorState = By.cssSelector("#id_state");

    private static final By fieldZipPostalCode = By.cssSelector("#postcode");
    private static final By fieldMobile = By.cssSelector("#phone");
    private static final By fieldCity = By.cssSelector("#city");
    private static final By fieldCompany = By.cssSelector("#company");
    private static final By fieldAddress1 = By.cssSelector("#address1");
    private static final By fieldAddress2 = By.cssSelector("#address2");

    private static final By btnSubmit = By.cssSelector("#submitAccount");
    private final By fieldEmail = By.cssSelector("#email_create");
    public final By msgSucessRegistration = By.cssSelector("body > div > form > div > div:nth-child(11) > div > label");
    public final By createAnAccountScreenMessage = By.cssSelector("#noSlide > h1");

    // CLICKS
    public void clicarBtnSubmit(){
        BaseTest.click(btnSubmit);
    }
    public void clicarGender(){
        BaseTest.click(checkboxGender);
    }

    // SEND KEYS
    public String preencherEmail() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        BaseTest.sendKeys(fieldEmail, email);
        return email;
    }

    public void preencherFirstName(){
        BaseTest.sendKeys(fieldFirstName, "Eduardo");
    }
    public void preencherLastName(){
        BaseTest.sendKeys(fieldLastName, "Miranda");
    }
    public void preencherZipPostalCode(){
        BaseTest.sendKeys(fieldZipPostalCode, "12399");
    }
    public void preencherPhoneNumber1(){
        BaseTest.sendKeys(fieldMobile, "28999254213");
    }
    public void preencherAddress1(){
        BaseTest.sendKeys(fieldAddress1, "Rua Joao Ramalho, 3333, Sao Paulo");
    }
    public void preencherAddress2(){
        BaseTest.sendKeys(fieldAddress2, "Sobrado verde");
    }
    public String preencherPassword(){
        String senha = gerarRandomico(8);
        BaseTest.sendKeys(fieldPassword, senha);
        return senha;
    }
    public void preencherCompany(){
        BaseTest.sendKeys(fieldCompany, "DBC Company");
    }

    public String retornoSignUp(){
        return BaseTest.getText(msgSucessRegistration);
    }


    public void preencherDateOfBirth() {
        preencherDia();
        preencherMes();
        preencherAno();
    }

    private void preencherDia(){
        BaseTest.click(selectorDay);
        BaseTest.sendKeys(selectorDay, String.valueOf((int) ((Math.random() * 27) + 1)));
        BaseTest.sendKeys(selectorDay, Keys.ENTER);
    }
    private void preencherMes(){
        BaseTest.click(selectorMonth);
        int month = (int) (Math.random() * 12);
        for (int i = 0; i <= month; i++){
            BaseTest.sendKeys(selectorMonth, Keys.ARROW_DOWN);
        }
        BaseTest.sendKeys(selectorMonth, Keys.ENTER);
    }

    private void preencherAno(){
        BaseTest.click(selectorYear);
        int month = (int) (Math.random() * 80);
        for (int i = 0; i <= month; i++){
            BaseTest.sendKeys(selectorYear, Keys.ARROW_DOWN);
        }
        BaseTest.sendKeys(selectorYear, Keys.ENTER);
    }

    public void preencherCity() {
        BaseTest.sendKeys(fieldCity, "Sao Carlos");
    }

    public void preencherState(){
        BaseTest.click(selectorState);
        BaseTest.sendKeys(selectorState, "New Mexico");
        BaseTest.sendKeys(selectorState, Keys.ENTER);
    }


    public void criarJsonCadastro(Map<String, String> login) {
        JsonManipulation.criarJsonCadastro(login);
    }
}
