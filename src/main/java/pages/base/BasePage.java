package pages.base;

import org.openqa.selenium.WebDriver;
import pages.swagLabs.InventoryPage;
import pages.swagLabs.LoginPage;

abstract public class BasePage {

    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static <T extends BasePage> T page(Class<T> typePage) {
        T newPage;
        String str = typePage.getName();
        //String str = typePage.getTypeName();
        switch (str){
            case "pages.swagLabs.InventoryPage": newPage = (T) new InventoryPage();
            break;
            default: newPage = (T) new LoginPage();
            break;
        }
        return newPage;
    }
    /*public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLY_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }*/


}
