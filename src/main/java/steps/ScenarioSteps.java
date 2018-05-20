package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

/**
 * Created by m.baykova on 13.09.2017.
 */
public class ScenarioSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    SectionSteps sectionPageSteps = new SectionSteps();
    CatalogSteps catalogPageSteps = new CatalogSteps();
    CartSteps cartPageSteps = new CartSteps();


    @When("^выбран пункт меню \"(.+)\"$")
    public void selectPanel(String name){
        mainPageSteps.selectPanel(name);
    }

    @When("^выбран пункт в секции \"(.+)\"$")
    public void selectSection(String subName){
        sectionPageSteps.selectSection(subName);
    }
    @When("^отмечены чекбоксы \"(.+)\"$")
    public void setProducers(List<String> producers){
        catalogPageSteps.selectProducers(producers);
    }

    @When("^Установлена начальная цена \"(.+)\"$")
    public void setStartPrice(String price){
        catalogPageSteps.setStartPrice(price);
    }
    @Then("^Добавляются нечетные товары$")
    public void chooseEveryOdd(){
        catalogPageSteps.chooseEveryOdd();
    }
    @When("^Корзина проверяется на наличие товаров$")
    public void checkProductList(){
        cartPageSteps.checkProductList();
    }
    @Then("^Корзина очищается$")
    public void clearCart(){
        cartPageSteps.clearCart();
    }
    @When("^Корзина проверяется \"(.+)\"$")
    public void checkEmptyCart(String expHeader){
        cartPageSteps.checkEmptyCart(expHeader);
    }
}
