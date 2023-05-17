package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.time.Duration;

import static common.config.BROWSER;
import static common.config.IMPLICITLY_WAIT;

public class CommonActions {

    public static WebDriver createDriver(){
        WebDriver driver = null;
        switch(BROWSER){
            case "EDGE":
                System.setProperty("webdriver.edge.driver","src/main/resources/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                Assert.fail("Wrong browser type:" + BROWSER);
                System.out.println("Неверно задан браузер!");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT));
        return driver;
    }

}