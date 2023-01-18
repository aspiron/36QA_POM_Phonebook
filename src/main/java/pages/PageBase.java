package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PageBase {
    WebDriver dr;
    public static Logger logger = LoggerFactory.getLogger(PageBase.class);

    public PageBase(WebDriver dr) {
        this.dr = dr;
        PageFactory.initElements(dr, this);
    }

    public void click(WebElement element){
        element.click();
    }

    public void type(WebElement element, String text){
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }


    public void clickWithJSExecutor(WebElement element, int x, int y){
        JavascriptExecutor js= (JavascriptExecutor) dr;
        js.executeScript("window.scrollBy("+x+","+y+")");
        click(element);
    }

    public void typeWithJSExecutor(WebElement element, String text, int x, int y){
        if (text != null) {
            clickWithJSExecutor(element, x, y);
            element.clear();
            element.sendKeys(text);
        }
    }



}
