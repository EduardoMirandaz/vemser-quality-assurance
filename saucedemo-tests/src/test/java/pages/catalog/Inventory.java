package pages.catalog;

import Enums.MetodoDeOrdenacao;
import org.openqa.selenium.By;
import util.BaseTest;

public class Inventory extends BaseTest {

    public final By btnMyPersonalInformation = By.cssSelector("#center_column > div > div:nth-child(1) > ul > li:nth-child(4) > a");

    public final By btnLogout = By.cssSelector("#header > div.nav > div > div > nav > div:nth-child(2) > a");

    public static final By testAllThingsTShirt = By.cssSelector("#add-to-cart-test\\.allthethings\\(\\)-t-shirt-\\(red\\)");

    public static final By clicarNoCarrinho = By.cssSelector("#shopping_cart_container > a");
    private final By myAccountMessage = By.cssSelector("#header_container > div.header_secondary_container > span");

    private final By selectorA_TO_ZOrder = By.cssSelector("#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(1)");
    private final By selectorZ_TO_AOrder = By.cssSelector("#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(2)");
    private final By selectorLowToHigh = By.cssSelector("#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(3)");
    private final By selectorHighToLow = By.cssSelector("#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(4)");
    public String myAccountMessage() {
        return BaseTest.getText(myAccountMessage);
    }


    public void clickBtnNoCarrinho(){
        BaseTest.click(clicarNoCarrinho);
    }


    public void orderBy(MetodoDeOrdenacao metodo) {
        switch (metodo){
            case A_TO_Z -> BaseTest.click(selectorA_TO_ZOrder);
            case Z_TO_A -> BaseTest.click(selectorZ_TO_AOrder);
            case PRECO_CRESCENTE -> BaseTest.click(selectorLowToHigh);
            case PRECO_DECRESCENTE -> BaseTest.click(selectorHighToLow);
        }
    }
}
