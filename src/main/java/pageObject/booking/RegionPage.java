package pageObject.booking;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;




public class RegionPage extends MainPage {
    public RegionPage(WebDriver driver) {
        super(driver);
    }

    @FindBys({
            @FindBy(xpath = ".//a/div/h3")
    })
    private List<WebElement> cities;

    @FindBy(xpath = "//h2")
    private WebElement titleOfCities;

    @Step("The method is used for navigate to city page")
    public CityPage navigateToCityPage(String city){
        for (WebElement item : cities){
            if (!item.getText().contains(city)){
                continue;
            }else {
                waitElementIsVisible(item).click();
                return new CityPage(driver);
            }
        }
        return null;
    }
}
