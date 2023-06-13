package elements.previewItem;

import elements.base.BaseElement;
import io.qameta.allure.Step;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreviewItemPrice extends BaseElement {

    @FindBy(xpath = ".//div[@class='inventory_item_price']")
    WebElement previewItemPrice;

    public PreviewItemPrice(SearchContext searchContext) {
        super(searchContext);
    }

    public void printText(){
        System.out.println(previewItemPrice.getText());
    }

    @Step
    public Double getText(){

        return Double.valueOf(previewItemPrice.getText().replace("$",""));
    }

}
