package pages.catalog;

import util.BaseTest;
import util.Browser;

import static pages.catalog.WomenCatalogPage.*;

public class CatalogPage extends Browser {


    public void clickPrimeiroLista() {
        BaseTest.hover(hover);
        BaseTest.click(addToCart);
    }

    public void proceedToCheckout(){
        BaseTest.click(proximaPaginaCompra);
    }
}
