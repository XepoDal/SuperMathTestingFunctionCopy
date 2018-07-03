package ru.SuperMath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends PageObject{

    By help_element = By.id("header_help_id");
    By about_element = By.id("header_aboutus_id");
    By sign_in_element = By.id("header_login_id");
    By open_reg = By.id("login_registration_button_id");
    By game1 = By.id("banner_2_img");
    By game2 = By.id("banner_3_img");
    By game3 = By.id("banner_4_img");
    By game4 = By.id("banner_5_img");
    By game5 = By.id("banner_1_img");
    WebDriver driver;
    WebDriverWait driverWait;

    public MainPage(WebDriver driver, WebDriverWait driverWait)
    {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public void pageOpen() {
        driver.get("http://supermath.ru/");
    }

    public void pageClose() {
        if (driver != null)
            driver.quit();
    }

    public PageObject helpClick()
    {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(help_element));
         driver.findElement(help_element).click();

        HelpPage help_page = new HelpPage(driver);
        return help_page;
    }

    public PageObject aboutClick()
    {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(about_element));
        driver.findElement(about_element).click();
        AboutPage about_page = new AboutPage(driver);
        return about_page;
    }

    public PageObject signInClick()
    {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(sign_in_element));
        driver.findElement(sign_in_element).click();
        SignInPage signInObj = new SignInPage(driver);
        return signInObj;
    }

    public void regOpen()
    {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(open_reg));
        driver.findElement(open_reg).click();
    }

    public By getGameElementId(int gameId) {
        By result = By.className("");
        switch (gameId){
            case 1 :
                result = game1;
                break;
            case 2 :
                result = game2;
                break;
            case 3 :
                result = game3;
                break;
            case 4 :
                result = game4;
                break;
            case 5 :
                result = game5;
                break;
            default:
                break;
        }
        return result;
    }

    public GameObjectImpl gameOpen(int gameId) {
        By gameElementId = getGameElementId(gameId);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(gameElementId));
        driver.findElement(gameElementId).click();
        GameObjectImpl GameObj = new GameObjectImpl(driver, driverWait);
        return GameObj;
    }


    public MainPage getMainPage() {
        MainPage mainPage = new MainPage(driver, driverWait);
        return mainPage;
    }
    

}
