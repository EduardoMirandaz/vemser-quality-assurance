package pages;

import org.openqa.selenium.By;
import util.BaseText;
import util.Browser;

public class CreateCustomerPage extends Browser {

    private static final By fieldName = By.cssSelector("#Name");
    private static final By fieldCompany = By.cssSelector("#Company");
    private static final By fieldAddress = By.cssSelector("#Address");
    private static final By fieldCity = By.cssSelector("#City");
    private static final By fieldPhone = By.cssSelector("#Phone");
    private static final By fieldEmail = By.cssSelector("#Email");

    private static final By btnSubmitCreate = By.cssSelector("body > div > form > div > div:nth-child(9) > div > input");

    public void preencherName(){
        BaseText.sendKeys(fieldName, "Eduardo");
    }
    public void preencherCompany(){
        BaseText.sendKeys(fieldCompany, "Mirandas");
    }
    public void preencherAddress(){
        BaseText.sendKeys(fieldAddress, "Rua Joao Ramalho");
    }
    public void preencherCity(){
        BaseText.sendKeys(fieldCity, "São Carlos");
    }
    public void preencherPhone(){
        BaseText.sendKeys(fieldPhone, "28999185451");
    }
    public void preencherEmail(){
        BaseText.sendKeys(fieldEmail, "eduardo@gmail.com");
    }

    public void clickSubmitCreate(){
        BaseText.click(btnSubmitCreate);
    }

}
