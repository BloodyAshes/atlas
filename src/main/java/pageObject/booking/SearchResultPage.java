package pageObject.booking;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pageObject.base.BasePage;
import pageObject.base.enums.Months;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#__bui-c598125-1")
    private WebElement placeInput;

    @FindBy(xpath = ".//button[@data-testid='date-display-field-start']")
    private WebElement startTripDate;

    @FindBy(xpath = ".//button[@data-testid='date-display-field-end']")
    private WebElement endTripDate;

    @FindBys({
            @FindBy(xpath = ".//span[@data-testid='address']")})
    private List<WebElement> addressesList;

    @Step("Is used for getting current starts date")
    public String getStartTripDate() {
        return startTripDate.getText();
    }

    @Step("Is used for getting current ends date")
    public String getEndTripDate() {
        return endTripDate.getText();
    }

    @Step("The method is used to verify that the chose and current dates are equally")
    public Boolean checkTripDate(Months months, int day, int year, int period) {
        if (getStartTripDate().toLowerCase().contains(months.getName().toLowerCase()) && getStartTripDate().contains(String.valueOf(day))
                && getStartTripDate().contains(String.valueOf(year))) {
            if (getEndTripDate().contains(String.valueOf(day + period))) {
                return true;
            }
        }
        return false;

    }

    @Step("This method is used to get a list of current addresses on page")
    public ArrayList<String> getAddresses() {
        ArrayList<String> listOfAddresses = new ArrayList<>();
        List<WebElement> listAdr = addressesList;
        if (listAdr.size() > 0) {
            for (WebElement address : listAdr) {
                String addresses = address.getText();
                String lineForRecord = String.format(addresses + "\n");
                listOfAddresses.add(lineForRecord);
            }
        }
        return listOfAddresses;
    }


    @Step("The method is used to verify that all addresses on the page are at the selected location")
    public Boolean verifyThatAllOfRealStatesInNeededPlace(String place) {
        Boolean res = false;
        ArrayList<String> adresses = getAddresses();
        if (adresses.size() <= 0) {
            return false;
        }else {
                for (String address : adresses) {
                    if (address.contains(place)) {
                        res = true;
                    }else {
                        res = false;
                    }
                }
            }
        return res;
        }
    }


