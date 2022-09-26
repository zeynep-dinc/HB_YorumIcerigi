package base;


import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class TemelIslemler implements ITemelKomutlar {

    public final WebDriver driver = Driver.getDriver();
    private final Logger log = LogManager.getLogger(TemelIslemler.class);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions actions=new Actions(driver);

    @Override
    public void elementToClickable(WebElement element) {
        try {
            wait.until(elementToBeClickable(element));
            element.click();
            System.out.println("The " + element + " is clicked!!");
            log.info("The " + element + " is clicked!!");
        } catch (TimeoutException timeoutException) {
            System.out.println("The " + element + " is timeout for 10 seconds.");
            timeoutException.getMessage();
            log.error("The " + element + " is timeout for 10 seconds.");
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("The " + element + " isn't such element.");
            noSuchElementException.getMessage();
            log.error("The " + element + " isn't such element.");
        } catch (ElementClickInterceptedException elementClickInterceptedException) {
            System.out.println("The " + element + " isn't clickable!");
            elementClickInterceptedException.getMessage();
            log.error("The " + element + " isn't clickable!");
        } catch (Exception exception) {
            exception.getMessage();
            log.error("There is an exception:\n" + exception.getMessage());
        }
    }

    @Override
    public void sendKeys(WebElement sendKeysElement, String message) {
        try {
            elementToBeClickable(sendKeysElement);
            wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
            sendKeysElement.clear();
            sendKeysElement.sendKeys(message);
            System.out.println("The " + sendKeysElement + " is in the value " + message + " wrote!!");
            log.info("The " + sendKeysElement + " is in the value " + message + " wrote!!");
        } catch (TimeoutException timeoutException) {
            System.out.println("The " + sendKeysElement + " is timeout for 10 seconds.");
            timeoutException.getMessage();
            log.error("The " + sendKeysElement + " is timeout for 10 seconds.");
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("The " + sendKeysElement + " isn't such element.");
            noSuchElementException.getMessage();
            log.error("The " + sendKeysElement + " isn't such element.");
        } catch (ElementClickInterceptedException elementClickInterceptedException) {
            System.out.println("The " + sendKeysElement + " isn't clickable!");
            elementClickInterceptedException.getMessage();
            log.error("The " + sendKeysElement + " isn't clickable!");
        } catch (Exception exception) {
            exception.getMessage();
            log.error("There is an exception:\n" + exception.getMessage());
        }
    }

    @Override
    public void pressToKeyboard(Keys keys) {
        actions.sendKeys(keys).build().perform();
    }


    @Override
    public void textElementValueControl(WebElement element, String expectedContext) {
        try {
            Assert.assertEquals(element.getText(),expectedContext);
        } catch (TimeoutException timeoutException) {
            System.out.println("The " + element + " is timeout for 10 seconds.");
            timeoutException.getMessage();
            log.error("The " + element + " is timeout for 10 seconds.");
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("The " + element + " isn't such element.");
            noSuchElementException.getMessage();
            log.error("The " + element + " isn't such element.");
        } catch (ElementClickInterceptedException elementClickInterceptedException) {
            System.out.println("The " + element + " isn't clickable!");
            elementClickInterceptedException.getMessage();
            log.error("The " + element + " isn't clickable!");
        } catch (Exception exception) {
            exception.getMessage();
            log.error("There is an exception:\n" + exception.getMessage());
        }
    }

    @Override
    public void changeToLastTab() {
        try {
            System.out.println(driver.getTitle() + " old page title");
            Thread.sleep(1000);
            Set<String> tab_handles = driver.getWindowHandles();
            int number_of_tabs = tab_handles.size();
            int new_tab_index = number_of_tabs - 1;
            driver.close();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
            driver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());
            Thread.sleep(1000);
            System.out.println(driver.getTitle() + " current page title.");
            log.info("Switch To driver tab!!");
        } catch (TimeoutException timeoutException) {
            System.out.print("The " + driver.getTitle() + " is timeout for 10 seconds.");
            timeoutException.getMessage();
            log.error("The " + driver.getTitle() + " is timeout for 10 seconds.");
        } catch (Exception exception) {
            exception.getMessage();
            log.error("There is an exception:\n" + exception.getMessage());
        }
    }

    @Override
    public void isDisplay(WebElement element) {
        try {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
            if (element.isDisplayed()) {
                log.info("The element(" + element + ") is displayed.");
                System.out.println("The element(" + element + ") is displayed.");
            }
        } catch (Exception exception) {
            exception.getMessage();
            log.error("The element(" + element + ") isn't display!");
            System.out.println("The element(" + element + ") isn't display!");
        }
    }

    @Override
    public void waitFor(long second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void waitForPageLoad(int second) {
        try {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(second));
        }
        catch (Exception exception){
            exception.getMessage();
        }
    }
}
