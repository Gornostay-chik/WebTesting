package tests.base;

import common.utils.DriverUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.base.BasePage;
import pages.swagLabs.LoginPage;
import pages.swagLabs.InventoryPage;

import static common.configs.CommonConfig.CLEAR_COOKIES_AND_STORAGE;
import static common.configs.CommonConfig.CLOSE_BROWSER;

abstract public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;

    @BeforeClass
    public void setUp(){
        driver = DriverUtils.createDriver();
        BasePage.setDriver(driver);
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
    }

    @AfterTest(enabled = false)
    public void clearCookiesAndLocalStorage(){
        if(CLEAR_COOKIES_AND_STORAGE) {
            System.out.println("Before CLEAR");
            var javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        if (CLOSE_BROWSER) driver.quit();
    }


}
