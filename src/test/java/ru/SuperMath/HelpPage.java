package ru.SuperMath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelpPage extends PageObject {

    WebDriver driver;

    public HelpPage(WebDriver miandriver)
    {
        this.driver = miandriver;
    }

    public void pageClose() {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("close_window_div")));
        driver.findElement(By.className("close_window_div")).findElement(By.tagName("img")).click();
    }

    public void pageOpen() {
        driver.get("http://supermath.ru/#help");
    }

}
