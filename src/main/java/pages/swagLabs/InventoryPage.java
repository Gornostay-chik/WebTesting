package pages.swagLabs;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    By title = By.cssSelector(".title");
    By item = By.cssSelector(".inventory_item");


    By bySortList = By.xpath("//select[@data-test='product_sort_container']");//Список сортировки "Name (Z to A)"
    By itemName = By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_name']");//имя item
    By itemPrice = By.cssSelector(".inventory_item_price");

    @Step("Check the title of the page")
    public InventoryPage checkTitlePage() {
        String titleText = driver.findElement(title).getText();
        Assert.assertEquals(titleText, INVENTORY_TITLE);
        return this;
    }

    @Step("Count product item on page. Expected: {common.configPages.ConfigInventoryPage.COUNT_ITEM_PER_PAGE}")
    public InventoryPage getCountProductPerPage() {
        List<WebElement> listitem = driver.findElements(item);
        Assert.assertEquals(listitem.size(), COUNT_ITEM_PER_PAGE);
        return this;
    }

    @Step("Check DropDown list default value. Expected: {defaultSort}")
    public InventoryPage checkDefaultDropDownValue(String defaultSort) {
        WebElement sortDropDown = driver.findElement(bySortList);
        Select selectDropDown = new Select(sortDropDown);
        WebElement firstSelectedOptions = selectDropDown.getFirstSelectedOption();
        Assert.assertEquals(firstSelectedOptions.getText(), defaultSort);
        return this;
    }

    @Step
    public InventoryPage changeSort(String selectSortValue) {
        WebElement sortDropDown = driver.findElement(bySortList);
        Select selectDropDown = new Select(sortDropDown);
        selectDropDown.selectByVisibleText(selectSortValue);
        return this;
    }

    //think how improve this test!!!!
    @Step("Check sorting for: {typeSort}")
    public InventoryPage checkSortingByName(String typeSort) {
        List<WebElement> listItem = new ArrayList<>();
        List<WebElement> sortedListItem = new ArrayList<>();
        //listItem.stream().forEach((i) -> {System.out.println(i.getText());});
        switch (typeSort) {
            case SORT_Z_A:
                listItem = driver.findElements(itemName);
                sortedListItem = listItem
                        .stream()
                        .sorted((WebElement i1, WebElement i2) ->
                                (
                                        i2.getText().compareTo(i1.getText()))
                        )
                        .collect(Collectors.toList());
                break;
            case SORT_PRICE_LOW_HIGH:
                listItem = driver.findElements(itemPrice);
                sortedListItem = listItem.stream()
                        .sorted(
                                (WebElement i1, WebElement i2) ->
                                {
                                    double priceItem1 = Double.valueOf(i1.getText().replace("$", ""));
                                    double priceItem2 = Double.valueOf(i2.getText().replace("$", ""));
                                    return Double.compare(priceItem1, priceItem2);
                                }
                        )
                        .collect(Collectors.toList());
                break;
            case SORT_PRICE_HIGH_LOW:
                listItem = driver.findElements(itemPrice);
                sortedListItem = listItem.stream()
                        .sorted(
                                (WebElement i1, WebElement i2) ->
                                {
                                    double priceItem1 = Double.valueOf(i1.getText().replace("$", ""));
                                    double priceItem2 = Double.valueOf(i2.getText().replace("$", ""));
                                    return Double.compare(priceItem2, priceItem1);
                                }
                        )
                        .collect(Collectors.toList());
                break;
            default:
                listItem = driver.findElements(itemName);
                sortedListItem = listItem
                        .stream()
                        .sorted((WebElement i1, WebElement i2) ->
                                (
                                        i1.getText().compareTo(i2.getText()))
                        )
                        .collect(Collectors.toList());
        }
        /*
        listItem.stream().forEach((i) -> {
            System.out.println(typeSort + " listItem = " + i.getText());
        });
        sortedListItem.stream().forEach((i) -> {
            System.out.println(typeSort + " sortedListItem = " + i.getText());
        });*/
        Assert.assertEquals(sortedListItem, listItem);
        return this;
    }

}
