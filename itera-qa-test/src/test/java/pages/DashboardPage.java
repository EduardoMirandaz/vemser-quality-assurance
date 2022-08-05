package pages;

import org.openqa.selenium.By;
import util.BaseText;

public class DashboardPage {

    public final By btnCreateNew = By.cssSelector("body > div > div > p:nth-child(4) > a");
    public final By btnSearch = By.cssSelector("body > div > div > form > input.btn.btn-secondary.my-2.my-sm-0");
    public final By btnDelete = By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-danger");
    public final By inputSearching = By.cssSelector("#searching");
    public final By msgEmailAfterSearching = By.cssSelector("body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(6)");


    public void clicarBtnCreateNew(){
        BaseText.click(btnCreateNew);
    }
    public void clicarbtnSearch(){
        BaseText.click(btnSearch);
    }
    public void clicarbtnDelete(){
        BaseText.click(btnDelete);
    }
    public void preencherInputSearching(String atributo){
        BaseText.sendKeys(inputSearching, atributo);
    }


    public String retornoBusca() {
        return BaseText.getText(msgEmailAfterSearching);
    }
}
