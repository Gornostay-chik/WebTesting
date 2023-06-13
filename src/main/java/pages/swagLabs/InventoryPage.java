package pages.swagLabs;

import common.objectValue.PreviewItemCard;
import elements.previewItem.PreviewItemDescription;
import elements.previewItem.PreviewItemPrice;
import elements.previewItem.PreviewItemTitle;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static common.configs.CommonConfig.InventoryPageConfigs.INVENTORY_TITLE;
import static common.configs.InventoryPageConfig.*;

public class InventoryPage extends BasePage {
    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".title")
    WebElement title;
    @FindBy(css = ".inventory_item")
    List<WebElement> listItem;
    @FindBy(xpath = "//select[@data-test='product_sort_container']")
    WebElement sortDropDown;
    @FindBy(xpath = "//div[@class='inventory_item']//div[@class='inventory_item_name']")
    List<WebElement> listItemName;
    @FindBy(css = ".inventory_item_price")
    List<WebElement> listItemPrice;


    By titlePrev = By.xpath(".//div[@class='inventory_item_name']");
    By descriptionPrev = By.xpath(".//div[@class='inventory_item_desc']");
    By pricePrev = By.xpath(".//div[@class='inventory_item_price']");

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
        Assert.assertEquals(listItemPrice, sortedListItem);
        return this;
    }

    @Step("Check previews of the products (find elements by relative locators)")
    public InventoryPage checkListPreviewItem(){
        List<PreviewItemCard> actualPreviewItemCard = new ArrayList<>();
        for (var previewItem : listItem){
            var previewItemTitle = previewItem.findElement(titlePrev);
            var previewItemDescription = previewItem.findElement(descriptionPrev);
            var previewItemPrice = previewItem.findElement(pricePrev);
            //создали превью карточки актуального товара
            var actualPreviewItem = PreviewItemCard.builder()
                    .itemName(previewItemTitle.getText())
                    .itemDescription(previewItemDescription.getText())
                    .itemPrice(Double.valueOf(previewItemPrice.getText().replace("$","")))
                    .build();
            actualPreviewItemCard.add(actualPreviewItem);
        }
        //printActualAndExpectedLists(actualPreviewItemCard, expectedPreviewItemCard);
        Assert.assertEquals(actualPreviewItemCard, expectedPreviewItemCard);
        return this;
    }

    @Step("Check previews of the products (find elements with @FindBy relatively SearchContext)")
    public InventoryPage checkListPreviewItemByElements(){
        List<PreviewItemCard> actualPreviewItemCard = new ArrayList<>();
        List<PreviewItemTitle> listPreviewTitle = new ArrayList<PreviewItemTitle>();
        for(var item : listItem){
            var actualPreviewItem = PreviewItemCard.builder()
                    .itemName(new PreviewItemTitle(item).getText())
                    .itemDescription(new PreviewItemDescription(item).getText())
                    .itemPrice(new PreviewItemPrice(item).getText())
                    .build();

            actualPreviewItemCard.add(actualPreviewItem);
        }
        Assert.assertEquals(actualPreviewItemCard, expectedPreviewItemCard);
        return this;
    }

}
