package tests.loginPageTest;

import common.dataProviders.DataProviders;
import common.dataProviders.FailLoginData;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.swagLabs.LoginPage;
import tests.base.BaseTest;

import static common.config.LOGIN_PAGE_URL;
import static common.configPages.ConfigLoginPage.*;
import static common.configPages.ConfigLoginPage.LoginButton.LOGIN_BUTTON_COLOR;
import static common.configPages.ConfigLoginPage.LoginButton.LOGIN_BUTTON_TEXT;

@Feature("Tests for Login page")
public class LoginPageTest extends BaseTest {

    @Test(description = "Check LoginPage attributes: UserName")
    @Severity(SeverityLevel.MINOR)
    public void checkLoginPageAttributesUsername() {
        loginPage.open(LOGIN_PAGE_URL)
                .checkInputUserNamePlaceholder(USERNAME_PLACEHOLDER);

    }

    @Test(description = "Check LoginPage attributes: Password",
    enabled = false)
    @Severity(SeverityLevel.MINOR)
    public void checkLoginPageAttributesPassword() {
        loginPage.open(LOGIN_PAGE_URL)
                .checkInputPasswordPlaceholder(PASSWORD_PLACEHOLDER);

    }

    @Test(description = "Check LoginPage attributes: Login Button",
    enabled = false)
    @Severity(SeverityLevel.MINOR)
    public void checkLoginPageAttributesLoginButton() {
        loginPage.open(LOGIN_PAGE_URL)
                .checkLoginButtonText(LOGIN_BUTTON_TEXT)
                .checkLoginButtonColor(LOGIN_BUTTON_COLOR);

    }
    @Test(description = "1.1 Succes login in SwagLabs: standart_user")
    public void successEnterStandartUser() {
        loginPage.open(LOGIN_PAGE_URL)
                .enterLogin(STANDART_USER_LOGIN)
                .enterPassword(ALL_USERS_PASSWORD)
                .pressLoginButtonSuccess()
                .checkTitlePage();
    }
    @Test(description = "1.2 Login with empty password",
            dataProvider = "FailLoginData",
            dataProviderClass = DataProviders.class,
            enabled = true)
    @Description("Check error message for login with empty login by different kind of the users.")
    public void failEnterEmptyLogin(FailLoginData failLoginData) {
        loginPage.open(LOGIN_PAGE_URL)
                .enterLogin(failLoginData.getLogin())
                .enterPassword(failLoginData.getPassword())
                .pressLoginButtonFail()
                .checkErrorLabelVisibility(true)
                .checkErrorLabelColor(ERROR_LABEL_COLOR)
                .checkErrorMessage(failLoginData.getError_message());
    }

}
