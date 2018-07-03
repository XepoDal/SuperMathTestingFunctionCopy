package ru.SuperMath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends PageObject{

    By close_button = By.id("login_close_button");
    By open_reg = By.id("login_registration_button_id");
    By type_mail = By.id("login_user_email");
    By type_pass = By.id("login_user_password");
    WebDriver driver;

    public SignInPage(WebDriver miandriver)
    {
        this.driver = miandriver;
    }

    public void OpenReg()
    {
        driver.findElement(open_reg).click();
    }

    public void typeEmail()
    {
        driver.findElement(type_mail).sendKeys("test@google.com");
    }

    public void typePassword()
    {
        driver.findElement(type_pass).sendKeys("qwerty123");
    }

    public void pageClose() {
        driver.findElement(close_button).click();
    }

    public void pageOpen() {
        driver.get("http://supermath.ru/#login");
    }
}
