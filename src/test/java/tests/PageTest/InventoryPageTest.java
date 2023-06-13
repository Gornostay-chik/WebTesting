package tests.PageTest;

import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.swagLabs.InventoryPage;
import tests.base.BaseTest;

import static common.configs.CommonConfig.LOGIN_PAGE_URL;
import static common.configs.InventoryPageConfig.*;
import static common.configs.LoginPageConfig.ALL_USERS_PASSWORD;
import static common.configs.LoginPageConfig.STANDART_USER_LOGIN;

@Feature("Tests for Inventory page")
public class InventoryPageTest extends BaseTest {

    @Test(priority = 1,
            description = "Check Inventory Page Attribute")
    public void checkInventoryPageAttribute(){
        loginPage.open(LOGIN_PAGE_URL)
                .enterLogin(STANDART_USER_LOGIN)
                .enterPassword(ALL_USERS_PASSWORD)
                .pressLoginButton(InventoryPage.class)
                .checkTitlePage()
                .getCountProductPerPage()
                .checkDefaultDropDownValue(DEFAULT_SORT);
    }

    @Test(priority = 2,
            description = "Check sorting by DEFAULT (A to Z)")
    public void checkSortingByDefault(){
        loginPage.open(LOGIN_PAGE_URL)
                .enterLogin(STANDART_USER_LOGIN)
                .enterPassword(ALL_USERS_PASSWORD)
                .pressLoginButton(InventoryPage.class)
                .changeSort(DEFAULT_SORT)
                .checkSortingByDefault();
    }

    @Test(priority = 3,
            description = "Check sorting by Name (Z to A)")
    public void checkSortingByNameZtoA(){
        loginPage.open(LOGIN_PAGE_URL)
                .enterLogin(STANDART_USER_LOGIN)
                .enterPassword(ALL_USERS_PASSWORD)
                .pressLoginButton(InventoryPage.class)
                .changeSort(SORT_Z_A)
                .checkSortingByNameZtoA();
    }

    @Test(priority = 4,
            description = "Check sorting by Price (Low to High)")
    public void checkSortingByPriceLowToHigh(){
        loginPage.open(LOGIN_PAGE_URL)
                .enterLogin(STANDART_USER_LOGIN)
                .enterPassword(ALL_USERS_PASSWORD)
                .pressLoginButton(InventoryPage.class)
                .changeSort(SORT_PRICE_LOW_HIGH)
                .checkSortingByPriceLowToHigh();
    }

    @Test(priority = 5,
            description = "Check sorting by Price (Low to High)")
    public void checkSortingByPriceHighToLow(){
        loginPage.open(LOGIN_PAGE_URL)
                .enterLogin(STANDART_USER_LOGIN)
                .enterPassword(ALL_USERS_PASSWORD)
                .pressLoginButton(InventoryPage.class)
                .changeSort(SORT_PRICE_HIGH_LOW)
                .checkSortingByPriceHighToLow();
    }

    @Test(description = "Check previews of the products")
    public void checkPreviewItemCard(){
        loginPage.open(LOGIN_PAGE_URL)
                .enterLogin(STANDART_USER_LOGIN)
                .enterPassword(ALL_USERS_PASSWORD)
                .pressLoginButton(InventoryPage.class)
                .checkListPreviewItem();
    }


}
