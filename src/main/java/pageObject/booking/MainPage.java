package pageObject.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.base.BasePage;
import pageObject.base.enums.Months;

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


    public MainPage enterPlace(String place){
        searchField.sendKeys(place);
        return this;
    }

    public MainPage chooseDate(Months months, int year, int day){
        waitElementIsVisible(calendar).click();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        while (!currentMonthAndYear.getText().contains(String.valueOf(year))) {
            waitElementIsVisible(nextMonth).click();
        }
        while (!currentMonthAndYear.getText().toLowerCase().contains(months.getName().toLowerCase())) {
                waitElementIsVisible(nextMonth).click();
            }
                driver.findElement(By.xpath(".//td[contains(@data-date, '" + year + "-" + months.getMonth() + "-" + day + "')]")).click();
                driver.findElement(By.xpath(".//td[contains(@data-date, '" + year + "-" + months.getMonth() + "-" + (day + 29) + "')]")).click();
        return this;
    }
}
