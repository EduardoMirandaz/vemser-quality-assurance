package pages.user;

import org.openqa.selenium.By;
import util.BaseTest;

public class MyAccountPage extends BaseTest {

    public final By btnMyPersonalInformation = By.cssSelector("#center_column > div > div:nth-child(1) > ul > li:nth-child(4) > a");

    public final By fieldSearchDress = By.cssSelector("#search_query_top");

    public final By btnVerCatalogoWomen = By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a");
    public final By btnVerCatalogoDresses = By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a");
    public final By btnVerCatalogoTShirts = By.cssSelector("#block_top_menu > ul > li:nth-child(3) > a");

    public final By btnLogout = By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a");
    public final By btnSearch = By.cssSelector("#searchbox > button");

    private final By myAccountMessage = By.cssSelector("#center_column > h1");

    public void clicarMyPersonalInformation(){
        BaseTest.click(btnMyPersonalInformation);
    }

    public String myAccountMessage() {
        return BaseTest.getText(myAccountMessage);
    }

    public void clicarVerCatalogoWomen(){
        BaseTest.click(btnVerCatalogoWomen);
    }
    public void clicarVerCatalogoDresses(){
        BaseTest.click(btnVerCatalogoDresses);
    }
    public void clicarVerCatalogoTShirts(){
        BaseTest.click(btnVerCatalogoTShirts);
    }


    public void buscarVestido(String nomeDoVestido){
        BaseTest.sendKeys(fieldSearchDress, nomeDoVestido);
    }
    public void clicarLogout(){
        BaseTest.click(btnLogout);
    }


    public void clickBtnSearch() {
        BaseTest.click(btnSearch);
    }
}
