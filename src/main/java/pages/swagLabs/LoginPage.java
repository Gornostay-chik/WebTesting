package pages.swagLabs;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.base.BasePage;

import static common.config.LOGIN_PAGE_URL;

public class LoginPage extends BasePage {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    By userName = By.id("user-name");//input Username
    @FindBy(id = "user-name")
    WebElement inputUsername;
    By password = By.xpath("//input[@name='password']");//input Password
    By loginButton = By.cssSelector(".submit-button");//Login button
    By errorTextMessage = By.xpath("//h3[@data-test='error']");//error messege
    By errorContainer = By.cssSelector(".error-message-container");//red label for error

    public LoginPage open(String url){
        driver.get(url);
        return this;
    }
    @Step("Enter login: {0}")
    public LoginPage enterLogin(String login){
        inputUsername.sendKeys(login);
        return this;
    }
    @Step("Enter password: {0}")
    public LoginPage enterPassword(String passw){
        driver.findElement(password).sendKeys(passw);
        return this;
    }
    @Step("Press button 'Login' for success login")
    public InventoryPage pressLoginButtonSuccess(){
        driver.findElement(loginButton).click();
        return new InventoryPage();
    }

    @Step("Press button 'Login' for fail login")
    public LoginPage pressLoginButtonFail(){
        driver.findElement(loginButton).click();
        return this;
    }
    @Step("Check error message. Expected text error: {errorStringExpected}")
    public LoginPage checkErrorMessage(String errorStringExpected){
        var error = driver.findElement(errorTextMessage);
        Assert.assertEquals(error.getText(), errorStringExpected);
        return this;
    }

    @Step("Check visibility of the error label. Expected: {isVisible}")
    public LoginPage checkErrorLabelVisibility(Boolean isVisible){
        var errorLabel = driver.findElement(errorTextMessage);
        Assert.assertTrue(errorLabel.isDisplayed());
        return this;
    }
    @Step("Check color of the error label. Expected: red")
    public LoginPage checkErrorLabelColor(String errorLabelColor){
        var errorLabel = driver.findElement(errorContainer);
        Assert.assertEquals(errorLabel.getCssValue("background-color"), "rgba(226, 35, 26, 1)");
        return this;
    }

    @Step("Check color of Login button. Expected: green")
    public LoginPage checkLoginButtonColor(String loginButtonColor){
        var color = driver.findElement(loginButton).getCssValue("background-color");
        Assert.assertEquals(color, loginButtonColor);
        return this;
    }

    @Step("Check text of Login button. Expected: {loginButtonText}")
    public LoginPage checkLoginButtonText(String loginButtonText){
        var color = driver.findElement(loginButton).getAttribute("value");
        Assert.assertEquals(color, loginButtonText);
        return this;
    }

    @Step("Check placeholder for Username. Expected: {loginPlaceholder}")
    public LoginPage checkInputUserNamePlaceholder(String usernamePlaceholderExpected){
        var usernamePlaceholder = inputUsername.getAttribute("placeholder");
        Assert.assertEquals(usernamePlaceholder, usernamePlaceholderExpected);
        return this;
    }

    @Step("Check placeholder for Password. Expected: {passwordPlaceholder}")
    public LoginPage checkInputPasswordPlaceholder(String passwordPlaceholderExpected){
        var passwordPlaceholder = driver.findElement(password).getAttribute("placeholder");
        Assert.assertEquals(passwordPlaceholder, passwordPlaceholderExpected);
        return this;
    }

}
