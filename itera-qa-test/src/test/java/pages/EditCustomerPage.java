package pages;

import org.openqa.selenium.By;
import util.BaseText;
import util.Browser;

public class EditCustomerPage extends Browser {

    private static final By fieldName = By.cssSelector("#Name");
    private static final By fieldCompany = By.cssSelector("#Company");
    private static final By fieldAddress = By.cssSelector("#Address");
    private static final By fieldCity = By.cssSelector("#City");
    private static final By fieldPhone = By.cssSelector("#Phone");
    private static final By fieldEmail = By.cssSelector("#Email");

    private static final By btnSubmitEdit = By.cssSelector("body > div > form > div > div:nth-child(9) > div > input");

    public void preencherName(){
        BaseText.sendKeys(fieldName, "Jonas");
    }
    public void preencherCompany(){
        BaseText.sendKeys(fieldCompany, "Brother");
    }
    public void preencherAddress(){
        BaseText.sendKeys(fieldAddress, "Rua Jonas Brother");
    }
    public void preencherCity(){
        BaseText.sendKeys(fieldCity, "São Brother");
    }
    public void preencherPhone(){
        BaseText.sendKeys(fieldPhone, "22998756312");
    }
    public void preencherEmail(){
        BaseText.sendKeys(fieldEmail, "jonas@jonasmail.com");
    }

    public void clickSubmitCreate(){
        BaseText.click(btnSubmitEdit);
    }

}
