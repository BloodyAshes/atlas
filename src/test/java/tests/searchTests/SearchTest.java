package tests.searchTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.base.enums.Languages;
import pageObject.base.enums.Months;
import pageObject.booking.MainPage;
import pageObject.booking.SearchResultPage;
import tests.baseTest.BaseTests;

import static constants.Constant.Urls.BOOKING_PAGE;

public class SearchTest extends BaseTests {

    MainPage mainPage;
    SearchResultPage searchResultPage;

    @BeforeMethod
    public void beforeMethod(){
        open(BOOKING_PAGE);
        mainPage = new MainPage(driver);
        searchResultPage = new SearchResultPage(driver);
    }


    @DataProvider(name = "place")
    public Object[][] place(){
        return new Object[][]{
                {"New York"}
        };
    }

    @Description(value = "Verify that user can search by place and date")
    @Test(dataProvider = "place")
    public void searchByCityAndDateTest(String place){
    mainPage.changeLanguage(Languages.EN_US);
    mainPage.enterPlace(place)
            .chooseDate(Months.DECEMBER, 2022, 01, 29)
            .clickOnSearchButton();
        Assert.assertTrue(searchResultPage.getTitle().contains(place));
        Assert.assertTrue(searchResultPage.checkTripDate(Months.DECEMBER, 1, 2022, 29));
        Assert.assertTrue(searchResultPage.verifyThatAllOfRealStatesInNeededPlace(place));
    }
}
