package elements.previewItem;

import elements.base.BaseElement;
import io.qameta.allure.Step;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreviewItemDescription extends BaseElement {

    @FindBy(xpath = ".//div[@class='inventory_item_desc']")
    WebElement previewItemDescription;

    public PreviewItemDescription(SearchContext searchContext) {
        super(searchContext);
    }

    public void printText(){
        System.out.println(previewItemDescription.getText());
    }

    @Step("Get Description text for preview inventory item")
    public String getText(){
        return previewItemDescription.getText();
    }

}
