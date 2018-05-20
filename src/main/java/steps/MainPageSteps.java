package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainPageSteps {

    @Step("выбран пункт меню {name}")
    public void selectPanel(String name) {
        MainPage mainPage = new MainPage();
        mainPage.selectPanel(name);
    }
}
