package steps;

import io.qameta.allure.Step;
import pages.SectionPage;

public class SectionSteps {

    @Step("выбран пункт меню {subName}")
    public void selectSection(String subName) {
        SectionPage sectionPage = new SectionPage();
        sectionPage.selectSection(subName);
    }
}
