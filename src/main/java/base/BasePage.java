package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Set;

public class BasePage {
    public WebDriver driver;
    WebDriverWait wait;

    /** Base Page Class contains all Selenium methods that we need to use in test scenarios
     *  I created this class one time and we will never need create test methods in other pages.
     *  Just create one time and use in everywhere. It saves us code repear and memory
     * **/

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20, 500);
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public String getTitle(By by) {
        return driver.getTitle();
    }

    public String getText(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by)).getText();
    }

    public void clickWithJs(By by) {
        WebElement element = findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void sendKeys(By by, CharSequence text) {
        try {
            WebElement element = findElement(by);
            wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendKeyAndPressEnter(By by, CharSequence text, Keys enter) {
        WebElement element = findElement(by);
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text, Keys.ENTER);
    }


    public Actions getActions(By by) {
        return new Actions(driver);
    }

    public void hoverElement(By by) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            getActions(by).moveToElement(findElement(by)).build().perform();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }


    public void switchToWindow() {
        String currentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            if (!currentWindow.equals(window)) {
                driver.switchTo().window(window);
            }
        }
    }  /** Created this method because of in the future if we redirect user to another window and if we need to
          continue to test we won't want to interrupt the scenario
     **/

    public void getImages(String key) throws IOException {
        List<WebElement> datas = driver.findElements(By.cssSelector(key));
        for (int i = 0; i <= 15; i++) {
            System.out.println("*************______I_____***********" + datas.get(i).getAttribute("src"));


            try {
                URL url = new URL(datas.get(i).getAttribute("src"));
                URLConnection urlConnection = url.openConnection();
                HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                httpURLConnection.setConnectTimeout(4000);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    System.out.println(datas.get(i).getAttribute("src"));
                    System.out.println("!!**!!" + httpURLConnection.getResponseCode() + ">>" + httpURLConnection.getResponseMessage());
                } else {
                    System.out.println(datas.get(i).getAttribute("src"));
                    System.out.println("!!**!!" + httpURLConnection.getResponseCode() + ">>" + httpURLConnection.getResponseMessage());
                    httpURLConnection.disconnect();
                }
            } catch (Exception e) {
                System.err.println(datas.get(i).getAttribute("src"));

            }
        }
    }  /** This method for if we need to get particular images from page we can use this method for it. **/

}



