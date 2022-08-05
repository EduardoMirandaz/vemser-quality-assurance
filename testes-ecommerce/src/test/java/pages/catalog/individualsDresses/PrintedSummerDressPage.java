package pages.catalog.individualsDresses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import util.BaseTest;

public class PrintedSummerDressPage extends BaseTest {

    private final By selectSize = By.cssSelector("#group_1");
    private final By btnCinza = By.cssSelector("#color_11");
    private final By btnLaranja = By.cssSelector("#color_13");
    private final By btnAzul = By.cssSelector("#color_14");
    private final By btnAmarela = By.cssSelector("#color_16");

    private final By btnAdicionarAoCarrinho = By.cssSelector("#add_to_cart > button");

    private final By btnProsseguirParaCheckout = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");

//    private final By btnProsseguirParaCarrinho = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");


    public void changeDressSize(String size){
        BaseTest.click(selectSize);
        BaseTest.sendKeys(selectSize, size);
        BaseTest.sendKeys(selectSize, Keys.ENTER);
    }


    public void changeDressColor(String cor) {
        switch (cor){
            case "amarela" -> BaseTest.click(btnAmarela);
            case "cinza" -> BaseTest.click(btnCinza);
            case "azul" -> BaseTest.click(btnAzul);
            case "laranja" -> BaseTest.click(btnLaranja);
        }
    }

    public void clickAdicionarAoCarrinho(){
        BaseTest.click(btnAdicionarAoCarrinho);
    }

    public void prosseguirParaCheckout() {
        BaseTest.click(btnProsseguirParaCheckout);
    }
}
