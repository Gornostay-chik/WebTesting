package pages.swagLabs;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static common.config.InventoryPageConfigs.INVENTORY_TITLE;
import static common.configPages.ConfigInventoryPage.*;

public class InventoryPage extends BasePage {
    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".title")
    WebElement title;
    //By title = By.cssSelector(".title");
    @FindBy(css = ".inventory_item")
    List<WebElement> listItem;
    //By item = By.cssSelector(".inventory_item");
    @FindBy(xpath = "//select[@data-test='product_sort_container']")
    WebElement sortDropDown;
    //By bySortList = By.xpath("//select[@data-test='product_sort_container']");//Список сортировки "Name (Z to A)"
    @FindBy(xpath = "//div[@class='inventory_item']//div[@class='inventory_item_name']")
    List<WebElement> listItemName;
    //By itemName = By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_name']");//имя item
    @FindBy(css = ".inventory_item_price")
    List<WebElement> listItemPrice;
    //By itemPrice = By.cssSelector(".inventory_item_price");

    @Step("Check the title of the page")
    public InventoryPage checkTitlePage() {
        String titleText = title.getText();
        Assert.assertEquals(titleText, INVENTORY_TITLE);
        return this;
    }

    @Step("Count product item on page. Expected: {common.configPages.ConfigInventoryPage.COUNT_ITEM_PER_PAGE}")
    public InventoryPage getCountProductPerPage() {
        Assert.assertEquals(listItem.size(), COUNT_ITEM_PER_PAGE);
        return this;
    }

    @Step("Check DropDown list default value. Expected: {defaultSort}")
    public InventoryPage checkDefaultDropDownValue(String defaultSort) {
        Select selectDropDown = new Select(sortDropDown);
        WebElement firstSelectedOptions = selectDropDown.getFirstSelectedOption();
        Assert.assertEquals(firstSelectedOptions.getText(), defaultSort);
        return this;
    }

    @Step("Change sort order to: {selectSortValue}")
    public InventoryPage changeSort(String selectSortValue) {
        Select selectDropDown = new Select(sortDropDown);
        selectDropDown.selectByVisibleText(selectSortValue);
        return this;
    }

    @Step("Check sorting for: default (A to Z)")
    public InventoryPage checkSortingByDefault() {
        List<WebElement> sortedListItem = listItemName.stream()
                .sorted((WebElement i1, WebElement i2) ->
                        (
                                i1.getText().compareTo(i2.getText()))
                )
                .collect(Collectors.toList());
        /*
        listItemName.stream().forEach((i) -> {
            System.out.println("listItemName = " + i.getText());
        });
        sortedListItem.stream().forEach((i) -> {
            System.out.println("sortedListItem = " + i.getText());
        });
        */
        Assert.assertEquals(listItemName, sortedListItem);
        return this;
    }

    @Step("Check sorting by: Name (Z to A)")
    public InventoryPage checkSortingByNameZtoA() {
        List<WebElement> sortedListItem = listItemName.stream()
                .sorted((WebElement i1, WebElement i2) ->
                        (
                                i2.getText().compareTo(i1.getText()))
                )
                .collect(Collectors.toList());
        /*
        listItemName.stream().forEach((i) -> {
            System.out.println("listItemName = " + i.getText());
        });
        sortedListItem.stream().forEach((i) -> {
            System.out.println("sortedListItem = " + i.getText());
        });
        */
        Assert.assertEquals(listItemName, sortedListItem);
        return this;
    }

    @Step("Check sorting by: Price (Low to High)")
    public InventoryPage checkSortingByPriceLowToHigh() {
        List<WebElement> sortedListItem = listItemPrice.stream()
                .sorted(
                        (WebElement i1, WebElement i2) ->
                        {
                            double priceItem1 = Double.valueOf(i1.getText().replace("$", ""));
                            double priceItem2 = Double.valueOf(i2.getText().replace("$", ""));
                            return Double.compare(priceItem1, priceItem2);
                        }
                )
                .collect(Collectors.toList());
        /*
        listItemPrice.stream().forEach((i) -> {
            System.out.println("listItemName = " + i.getText());
        });
        sortedListItem.stream().forEach((i) -> {
            System.out.println("sortedListItem = " + i.getText());
        });
        */
        Assert.assertEquals(listItemPrice, sortedListItem);
        return this;
    }

    @Step("Check sorting by: Price (High to Low)")
    public InventoryPage checkSortingByPriceHighToLow() {
        List<WebElement> sortedListItem = listItemPrice.stream()
                .sorted(
                        (WebElement i1, WebElement i2) ->
                        {
                            double priceItem1 = Double.valueOf(i1.getText().replace("$", ""));
                            double priceItem2 = Double.valueOf(i2.getText().replace("$", ""));
                            return Double.compare(priceItem2, priceItem1);
                        }
                )
                .collect(Collectors.toList());
        /*
        listItemPrice.stream().forEach((i) -> {
            System.out.println("listItemName = " + i.getText());
        });
        sortedListItem.stream().forEach((i) -> {
            System.out.println("sortedListItem = " + i.getText());
        });
        */
        Assert.assertEquals(listItemPrice, sortedListItem);
        return this;
    }

}
