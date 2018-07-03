package ru.SuperMath;

import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


//named incorrect
public class VisibleRun extends TestCase {
    private WebDriver driver; // make privet and create getter
    private WebDriverWait driverWait; // make privet and create getter
    private MainPage mainPage;

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebDriverWait getDriverWait() {
        return this.driverWait;
    }

    public MainPage getMainPage() {
        return this.mainPage;
    }

    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:/Users/ddzheber/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, 120);
        mainPage = new MainPage(getDriver(), getDriverWait());
        mainPage.pageOpen();
        String mainTitle = "SuperMath - Математика, обучение сложению, вычитанию, умножению и делению";
        assertEquals(mainTitle, getDriver().getTitle());// create method for getter mainPage and test it


    }

    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}