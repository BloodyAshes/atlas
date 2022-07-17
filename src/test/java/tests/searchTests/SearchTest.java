package tests.searchTests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObject.base.enums.Languages;
import pageObject.base.enums.Months;
import pageObject.booking.CityPage;
import pageObject.booking.MainPage;
import pageObject.booking.RegionPage;
import pageObject.booking.SearchResultPage;
import tests.baseTest.BaseTests;

import static constants.Constant.Urls.BOOKING_PAGE;
import static counter.CountMethods.countMethods;


public class SearchTest extends BaseTests {

    MainPage mainPage;
    SearchResultPage searchResultPage;
    RegionPage regionPage;
    CityPage cityPage;

    @BeforeMethod
    public void beforeMethod(){
        open(BOOKING_PAGE);
        mainPage = new MainPage(driver);
        searchResultPage = new SearchResultPage(driver);
        regionPage = new RegionPage(driver);
        cityPage = new CityPage(driver);
    }

    @AfterTest
    public void afterMethod() throws ClassNotFoundException {
        countMethods(this.getClass().getName());
    }


    @DataProvider(name = "place")
    public Object[][] place(){
        return new Object[][]{
                {"New York"}
        };
    }

    @Owner(value = "Vladyslav Matsenko")
    @Description(value = "Verify that user can search by place and date")
    @Test(dataProvider = "place")
    public void searchByCityAndDateTest(String place){
        mainPage.changeLanguage(Languages.EN_US);
    mainPage.enterPlace(place)
            .chooseDate(Months.DECEMBER, 2022, "01", 29)
            .clickOnSearchButton();
        Assert.assertTrue(searchResultPage.getTitle().contains(place));
        Assert.assertTrue(searchResultPage.checkTripDate(Months.DECEMBER, 1, 2022, 29));
        Assert.assertTrue(searchResultPage.verifyThatAllOfRealStatesInNeededPlace(place));
    }


    @DataProvider(name = "region")
    public Object[][] region(){
        return new Object[][]{
                {"England", "London"},
                {"England", "Manchester"},
                {"Bali", "Ubud"}
        };
    }

    @Owner(value = "Vladyslav Matsenko")
    @Description(value = "Verify that user should be able to find all hotels for region and city")
    @Test(dataProvider = "region")
    public void searchAllHotelByRegionAndCIty(String region, String city) {
        mainPage.changeLanguage(Languages.EN_US);
        mainPage.navigateToRegionPage(region)
                .navigateToCityPage(city);
        Assert.assertTrue(cityPage.isCityCorrect(city));
    }
}
