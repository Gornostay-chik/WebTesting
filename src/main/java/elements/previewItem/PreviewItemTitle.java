package elements.previewItem;

import elements.base.BaseElement;
import io.qameta.allure.Step;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreviewItemTitle extends BaseElement {

    @FindBy(xpath = ".//div[@class='inventory_item_name']")
    WebElement previewItemTitle;

    public PreviewItemTitle(SearchContext searchContext) {
        super(searchContext);
    }

    public void printText(){
        System.out.println(previewItemTitle.getText());
    }

    @Step("Get Title text for preview inventory item")
    public String getText(){
        return previewItemTitle.getText();
    }

}
