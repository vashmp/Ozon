package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SectionPage extends BasePageObject{

    @FindBy(xpath="//div[@class='bLeftMainMenu no-mobile']//a")
    List<WebElement> section;

    public void selectSection (String subName){
        selectCollectionItem(subName, section);
    }
}
