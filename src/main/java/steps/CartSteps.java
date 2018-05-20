package steps;

import io.qameta.allure.Step;
import pages.CartPage;

public class CartSteps {
    @Step("Корзина проверяется на наличие товаров")
    public void checkProductList() {
        CartPage catalogPage = new CartPage();
        catalogPage.checkProductList();
    }
    @Step("Корзина очищается")
    public void clearCart() {
        CartPage catalogPage = new CartPage();
        catalogPage.clearCart();
    }
    @Step("Корзина проверяется {expHeader}")
    public void checkEmptyCart(String expHeader) {
        CartPage catalogPage = new CartPage();
        catalogPage.checkEmptyCart(expHeader);
    }
}
