package pageObject.booking;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pageObject.base.BasePage;
import pageObject.base.enums.Months;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static constants.Constant.TimeoutVariables.IMPLICIT_WAIT;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#ss")
    private WebElement searchField;

    @FindBy(css = ".sb-date-field__icon")
    private WebElement calendar;

    @FindBy(css = ".bui-calendar__control--next")
    private WebElement nextMonth;

    @FindBy(css = ".bui-calendar__month")
    private WebElement currentMonthAndYear;

    @FindBy(css = ".sb-searchbox__button")
    private WebElement searchButton;

    @FindBys({
        @FindBy(css = ".bui-calendar__date--selected")
    })
    private List<WebElement> selectedDate;

    @FindBys({
    @FindBy(css = ".ia_link")
    })
    private List<WebElement> loverRegions;

    @FindBy(css = ".bui-tab.bui-tab--rounded.bui-spacer--large")
    private WebElement regionBlock;




    @Step("Method is used for choosing place")
    public MainPage enterPlace(String place){
        searchField.sendKeys(place);
        return this;
    }


    @Description(value = "Beta version!!!")
    @Step("Method is used for choosing date")
    public MainPage chooseDate(Months months, int year, String day, int period){
        waitElementIsVisible(calendar).click();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        while (!currentMonthAndYear.getText().contains(String.valueOf(year))) {
            waitElementIsVisible(nextMonth).click();
        }
        while (!currentMonthAndYear.getText().toLowerCase().contains(months.getName().toLowerCase())) {
                waitElementIsVisible(nextMonth).click();
            }
                driver.findElement(By.xpath(".//td[contains(@data-date, '" + year + "-" + months.getMonth() + "-" + day + "')]")).click();
                driver.findElement(By.xpath(".//td[contains(@data-date, '" + year + "-" + months.getMonth() + "-" + (Integer.parseInt(day) + period) + "')]")).click();
        return this;
    }

    @Step("Method is used to click on the search button and navigate to search result page")
    public SearchResultPage clickOnSearchButton(){
        searchButton.click();
        return new  SearchResultPage(this.driver);
    }

    @Step("The method is used for navigate to city page")
    public RegionPage navigateToRegionPage(String region){
        for (WebElement item : loverRegions){
            if (!item.getText().contains(region)){
              continue;
            }else {
                item.click();
                return new RegionPage(driver);
            }
        }
        return null;
    }
}
