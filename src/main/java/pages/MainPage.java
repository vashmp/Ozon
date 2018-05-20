package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePageObject{

    @FindBy(xpath = "//div[@class='bHeaderCategoryLinks ']/a")
    List<WebElement> panel;


    public void selectPanel(String name){
        selectCollectionItem(name, panel);
    }
}
