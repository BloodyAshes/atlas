package pageObject.base;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.base.enums.Languages;

import java.lang.reflect.Method;

import static constants.Constant.TimeoutVariables.EXPLICIT_WAIT;


public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css = ".bui-avatar.bui-avatar--small")
    private WebElement languageSelector;

    @FindBy(xpath = "//h1")
    private WebElement titleOfPage;


    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public  String getTitle(){
        return titleOfPage.getText();
    }


    @Step("Method is used for changed language")
    public void changeLanguage(Languages lang){
        languageSelector.click();
        waitElementIsVisible(driver.findElement(By.xpath(".//div[contains(@lang,'" + lang.getLang() + "')]"))).click();
    }
}
