package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;
import util.Stash;

import java.util.List;

public class CatalogPage extends BasePageObject {

    @FindBy(xpath = "//div[@class='eFilterList_Content']")
    WebElement contentList;

    @FindBy(xpath = "//input[@class='eFromToInput_InputField mFrom']")
    WebElement startPrice;

    @FindBy(xpath = "//span[@class='eFiltersHor_PriceLabel bRub']/ancestor::div[@class='bFacetFilter  mPrice']//div[@class='bFlatButton mMicro mWhite']")
    WebElement acceptPrice;

    @FindBy(xpath = "//div[@itemprop='itemListElement' and contains(@class, 'mRuble')]")
    List<WebElement> productList;

    @FindBy(xpath = "//h1")
    WebElement productHeader;

    @FindBy(xpath = "//div[@class='bSaleBlockButton jsButton']")
    WebElement addButton;

    @FindBy(xpath = "//a[@class='bSaleBlockButton mTwoLines mActive']")
    WebElement addButtonClicked;

    @FindBy(xpath ="//div[@class='eMyOzon_Item_Bottom']")
    WebElement cart;

    public void setProducers(List<String> producers) {
        WebElement[] checkBoxList = new WebElement[producers.size()];
        for (int i = 0; i < producers.size(); i++) {
            checkBoxList[i] = contentList.findElement(By.xpath(".//*[contains(text(), '" + producers.get(i) + "')]"));
            checkBoxList[i].click();
        }
    }
    public void setStartPrice(String price) {
        startPrice.clear();
        startPrice.sendKeys(price);
        startPrice.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 3);
        wait.until(ExpectedConditions.elementToBeClickable(acceptPrice));
        acceptPrice.click();

    }

    public void chooseEveryOdd() {
        for (int i = 0; i <= productList.size(); i += 2) {
            productList.get(i).click();
            String name = productHeader.getText();
            Stash.add(name);
            addButton.click();
            WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 3);
            wait.until(ExpectedConditions.visibilityOf(addButtonClicked));
            BaseSteps.getDriver().navigate().back();
        }
        cart.click();
    }
}
