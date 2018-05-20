package steps;

import io.qameta.allure.Step;
import pages.CatalogPage;

import java.util.List;

public class CatalogSteps {

    @Step("Отмечены бренды {producers}")
    public void selectProducers(List<String> producers) {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.setProducers(producers);
    }

    @Step("Установлена начальная цена {price}")
    public void setStartPrice(String price) {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.setStartPrice(price);
    }

    @Step("Добавляются в корзину нечетные товары")
    public void chooseEveryOdd() {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.chooseEveryOdd();
    }

}
