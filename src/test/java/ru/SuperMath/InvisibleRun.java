package ru.SuperMath;

import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.WebDriverWait;


//named incorrect
public class InvisibleRun extends TestCase {
    private WebDriver driver; // make privet and create getter
    private MainPage mainPage;
    private WebDriverWait driverWait;

    public WebDriver getDriver() {
        return this.driver;
    }

    public MainPage getMainPage() {
        return this.mainPage;
    }

    public WebDriverWait getDriverWait() {
        return this.driverWait;
    }

    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:/Users/ddzheber/Downloads/chromedriver_win32/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setBinary("C:/Users/ddzheber/Downloads/chromedriver_win32/chromedriver.exe");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, 120);
        mainPage = new MainPage(getDriver(), getDriverWait());
        mainPage.pageOpen();
        assertEquals("SuperMath - Математика, обучение сложению, вычитанию, умножению и делению", getDriver().getTitle());// create method for getter mainPage and test it
    }

    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
