package tests.loginPageTest;

import common.dataProviders.DataProviders;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.base.BasePage;
import tests.base.BaseTest;

import static common.config.LOGIN_PAGE_URL;
import static common.configPages.ConfigInventoryPage.DEFAULT_SORT;
import static common.configPages.ConfigInventoryPage.SORT_Z_A;
import static common.configPages.ConfigLoginPage.ALL_USERS_PASSWORD;
import static common.configPages.ConfigLoginPage.STANDART_USER_LOGIN;

@Feature("Tests for Inventory page")
public class InventoryPageTest extends BaseTest {

    @Test(priority=1,
    description = "Check Inventory Page Attribute")
    public void checkInventoryPageAttribute(){
        basePage.open(LOGIN_PAGE_URL);
        loginPage.enterLogin(STANDART_USER_LOGIN)
                .enterPassword(ALL_USERS_PASSWORD)
                .pressLoginButton();
        inventoryPage.checkTitlePage()
                .getCountProductPerPage()
                .checkDefaultDropDownValue(DEFAULT_SORT);
    }

    @Test(priority=2,
    description = "Check sorting by Name",
    dataProvider = "sortByName",
    dataProviderClass = DataProviders.class)
    public void checkSortingByName(String methodSort){
        basePage.open(LOGIN_PAGE_URL);
        loginPage.enterLogin(STANDART_USER_LOGIN)
                .enterPassword(ALL_USERS_PASSWORD)
                .pressLoginButton();
        inventoryPage
                .changeSort(methodSort)
                .checkSortingByName(methodSort);
    }

}
