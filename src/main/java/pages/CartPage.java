package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;
import util.Stash;

import java.util.List;
import org.openqa.selenium.NoSuchElementException;

public class CartPage extends BasePageObject{

    @FindBy(xpath="//span[@class='eCartItem_nameValue']")
    List<WebElement> cartProductList;

    @FindBy(xpath="//div[@class='bIconButton mRemove mGray jsRemoveAll']")
    WebElement clearCart;

    @FindBy(xpath="//div[@class='eCartControls_infoDate']")
    WebElement date;

    @FindBy(xpath="//span[@class='jsInnerContentpage_title']")
    WebElement headerCart;

    public void checkProductList(){
        for (int i = 0; i < cartProductList.size(); i++) {
            String checkName = cartProductList.get(i).getText();
            if (!Stash.stash.contains(checkName)){
                Assert.fail((String.format("Товара %s нет в корзине", checkName)));
            }
        }
    }
    public void clearCart(){
        WebDriver driver = BaseSteps.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(date));

        while (true) {
            try {
                driver.findElement(By.xpath("//div[@class='bIconButton mRemove mGray jsRemoveAll']"));
            } catch (NoSuchElementException e) {
                return;
            }
            try{
                new Actions(BaseSteps.getDriver()).moveToElement(clearCart).click().perform();
            }catch(org.openqa.selenium.StaleElementReferenceException e2){
                return;
            }
        }

    }
    public void checkEmptyCart(String expHeader){
        String actualHeader = headerCart.getText();
        Assert.assertEquals("Коризна не пуста", expHeader, actualHeader);
    }
}
