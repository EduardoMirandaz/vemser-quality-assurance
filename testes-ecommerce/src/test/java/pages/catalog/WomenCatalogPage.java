package pages.catalog;

import org.openqa.selenium.By;
import util.BaseTest;

public class WomenCatalogPage {
    public final By btnPrintedSummerDress = By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.last-line.first-item-of-tablet-line.first-item-of-mobile-line.last-mobile-line > div > div.left-block > div > a.product_img_link > img");
    public static final By hover = By.cssSelector(".ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line");
    public final By fieldSearchCloth = By.cssSelector("#search_query_top");
    public final By btnSearch = By.cssSelector("#searchbox > button");

    public static final By addToCart = By.cssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line.hovered > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default");
    public static final By proximaPaginaCompra = By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");

    public void clickBtnSearch(){
        BaseTest.click(btnSearch);
    }

    public void buscarVestido(String nomeVestido) {
        BaseTest.sendKeys(fieldSearchCloth, nomeVestido);
    }

}
