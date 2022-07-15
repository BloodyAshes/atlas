package tests.searchTests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.base.enums.Languages;
import pageObject.base.enums.Months;
import pageObject.booking.MainPage;
import tests.baseTest.BaseTests;

import static constants.Constant.Urls.BOOKING_PAGE;

public class SearchTest extends BaseTests {

    MainPage mainPage;

    @BeforeMethod
    public void beforeMethod(){
        open(BOOKING_PAGE);
        mainPage = new MainPage(driver);
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
            .chooseDate(Months.DECEMBER, 2022, 01);
    }
}
