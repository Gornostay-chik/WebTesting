package elements.base;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;

abstract public class BaseElement {
    public BaseElement(SearchContext searchContext){
        PageFactory.initElements(searchContext, this);
    }
}
