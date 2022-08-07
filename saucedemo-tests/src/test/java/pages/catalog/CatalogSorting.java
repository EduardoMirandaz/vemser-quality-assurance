package pages.catalog;

import Enums.MetodoDeOrdenacao;
import org.openqa.selenium.By;
import util.BaseTest;

import java.util.ArrayList;
import java.util.Collections;

public class CatalogSorting {

    private final String blockItem = "#inventory_container > div > div:nth-child(";
    public static final String label = ") > div.inventory_item_description > div.inventory_item_label";
    public static final String priceBar = ") > div.inventory_item_description > div.pricebar > div";


    public String getNameItem(Integer indexItem){
        return BaseTest.getText(By.cssSelector(blockItem + indexItem + label));
    }

    public String getPriceItem(Integer indexItem){
        return BaseTest.getText(By.cssSelector(blockItem + indexItem + priceBar));
    }


    public Boolean verifyCatalogOrder(MetodoDeOrdenacao metodoDeOrdenacao) {

        // Se é por nome, ou seja, de A a Z ou de Z a A, faço uma lista de Strings para verificar.
        if(metodoDeOrdenacao == MetodoDeOrdenacao.A_TO_Z || metodoDeOrdenacao == MetodoDeOrdenacao.Z_TO_A)
        {
            ArrayList<String> names = getStrings();
            ArrayList<String> sortedNames = new ArrayList<>(names);

            // Coloco inicialmente em ordem crecente, do menor até o maior, de a até Z;
            Collections.sort(sortedNames);

            // Se o método de ordenação for crescente de fato, retorno se o catálogo está de fato ordenado dessa forma.
            if(metodoDeOrdenacao == MetodoDeOrdenacao.A_TO_Z){
                System.out.println(names);
                return names.equals(sortedNames);
            }

            // Se não, faço um reverse do vetor, e verifico se ele está ordenado de forma decrescente.
            Collections.reverse(sortedNames);

            System.out.println(names);

            return names.equals(sortedNames);

        }
        else if(metodoDeOrdenacao == MetodoDeOrdenacao.PRECO_CRESCENTE || metodoDeOrdenacao == MetodoDeOrdenacao.PRECO_DECRESCENTE)
        {
            ArrayList<Double> precos = getPrices();
            ArrayList<Double> sortedNames = new ArrayList<>(precos);

            // Coloco inicialmente em ordem crecente, do menor até o maior;
            Collections.sort(sortedNames);

            // Se o método de ordenação for crescente de fato, retorno se o catálogo está de fato ordenado dessa forma.
            if(metodoDeOrdenacao == MetodoDeOrdenacao.PRECO_CRESCENTE){
                return precos.equals(sortedNames);
            }

            // Se não, faço um reverse do vetor, e verifico se ele está ordenado de forma decrescente.
            Collections.reverse(sortedNames);
            return precos.equals(sortedNames);
        }
        return false;
    }

    public Boolean verifyCatalogOrderInvalid(MetodoDeOrdenacao metodoDeOrdenacao){
        return !verifyCatalogOrder(metodoDeOrdenacao);
    }


        private ArrayList<Double> getPrices() {
        ArrayList<Double> precos = new ArrayList<>();
        for(int i = 1; i <= 6; i++)
        {
            String strPreco = getPriceItem(i).substring(1, (getPriceItem(i).length() - 1));

            precos.add(Double.parseDouble(strPreco));

        }
        return precos;

    }


    private ArrayList<String> getStrings() {
        ArrayList<String> names = new ArrayList<>();
        for(int i = 1; i <= 6; i++)
        {
            names.add(getNameItem(i));
        }
        return names;
    }
}
