package tests.baseTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import webDriverFactory.Browsers;
import webDriverFactory.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import static constants.Constant.CLEAR_COOKIES_AND_STORAGE;
import static constants.Constant.TimeoutVariables.IMPLICIT_WAIT;
import static constants.Constant.TimeoutVariables.PAGE_LOAD_WAIT;
import static counter.CountMethods.countMethods;

public class BaseTests {

    protected WebDriver driver = null;

    @BeforeSuite
    public void SetUp(){
        driver = WebDriverFactory.initDriver(Browsers.FIREFOX);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    @AfterTest
    public void clearCookiesAndStorage(){
        if (CLEAR_COOKIES_AND_STORAGE){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void closeDriver() throws ClassNotFoundException {
      //  countMethods();
        if (driver != null){
            driver.quit();
        }
    }

    public void open(String url){
        driver.navigate().to(url);
    }
}
