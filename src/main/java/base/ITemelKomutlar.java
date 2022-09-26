package base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface ITemelKomutlar {

    void elementToClickable(WebElement element);
    void sendKeys(WebElement element,String message);
    void pressToKeyboard(Keys keys);
    void textElementValueControl(WebElement element,String expectedContext);
    void changeToLastTab();
    void isDisplay(WebElement element);
    void waitFor(long second);
    void waitForPageLoad(int second);
}
