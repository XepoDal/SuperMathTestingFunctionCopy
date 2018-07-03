package ru.SuperMath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class AboutPage extends PageObject{

    By close_button = By.xpath("//*[@id=\"about_us\"]/div/a/img");
    WebDriver driver;


    public AboutPage(WebDriver miandriver)
    {
        this.driver = miandriver;
    }

    public void pageClose() {
        driver.findElement(close_button).click();
    }

    public void pageOpen() {
        driver.get("http://supermath.ru/#about_us");
    }
}
