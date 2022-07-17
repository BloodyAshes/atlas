package pageObject.booking;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CityPage extends RegionPage{
    public CityPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".bui-f-font-display_two.sr-snippet_header_num_properties")
    private WebElement currentCIty;

    @FindBys({
            @FindBy(xpath = ".//span[@itemprop='addressLocality']")
    })
    private List<WebElement> listOfHotels;

    @Step("The method is used to verify that the selected and current cities are equal")
    public Boolean isCityCorrect(String city){
        Boolean res = false;
        if (currentCIty.getText().contains(city)) {
            res = true;
        }else {
            res = false;
        }
        return res;
    }
}
