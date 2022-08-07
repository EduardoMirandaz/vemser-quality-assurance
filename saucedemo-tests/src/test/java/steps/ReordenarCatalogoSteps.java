package steps;

import Enums.MetodoDeOrdenacao;
import org.junit.Assert;
import org.junit.Test;
import pages.catalog.CatalogSorting;
import pages.catalog.Inventory;
import pages.purchase.OrderSummaryPage;
import pages.purchase.YourCartPage;
import util.Browser;

import static Enums.MetodoDeOrdenacao.A_TO_Z;
import static Enums.MetodoDeOrdenacao.PRECO_DECRESCENTE;

public class ReordenarCatalogoSteps extends Browser {

    LogInSteps logInSteps = new LogInSteps();
    YourCartPage yourCartPage = new YourCartPage();
    Inventory inventory = new Inventory();
    OrderSummaryPage orderSummaryPage = new OrderSummaryPage();
    CatalogSorting catalogSorting = new CatalogSorting();

    @Test
    public void reordenarCatalogoValido(){

        logInSteps.logar();

        MetodoDeOrdenacao metodoDeOrdenacao = PRECO_DECRESCENTE;

        reordenarCatalogo(metodoDeOrdenacao);

//         Validação

        Boolean expected = catalogSorting.verifyCatalogOrder(metodoDeOrdenacao);
        Assert.assertTrue(expected);

    }

    @Test
    public void reordenarCatalogoInvalido(){

        logInSteps.logar();

        MetodoDeOrdenacao metodoDeOrdenacao = A_TO_Z;

        reordenarCatalogo(metodoDeOrdenacao);

//         Validação

        Boolean expected = catalogSorting.verifyCatalogOrderInvalid(metodoDeOrdenacao);
        Assert.assertFalse(expected);

    }

    public void reordenarCatalogo(MetodoDeOrdenacao metodo){

        inventory.orderBy(metodo);

    }

}
