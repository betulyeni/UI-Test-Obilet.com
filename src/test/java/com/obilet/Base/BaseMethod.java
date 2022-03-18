package com.obilet.Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class BaseMethod {
    public WebDriver driver;
    public Actions builder;
    public WebDriverWait wait;
    public String baseUrl = "https://www.obilet.com/";
    public static int rndm;

    @Before
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        chromeOptions.addArguments("disable-translate");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(driver, 10);
        driver.get(baseUrl);
    }

    public void waitSeconds(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    public void setBy(By by, String text) {
        WebElement element = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated((by)));
        element.click();
        element.clear();
        element.sendKeys(text);
        waitSeconds(4);

    }

    public void clickBy(By by) {
        WebElement element = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable((by)));
        element.click();
    }

    public void clickElementByCss(String css) {
        WebElement click = driver.findElement(By.cssSelector(css));
        click.click();
    }

    public void clickElementByXpath(String xpath) {
        WebElement click = driver.findElement(By.xpath(xpath));
        click.click();
    }

    public void clickElementById(String id) {
        WebElement tikla = driver.findElement(By.id(id));
        tikla.click();
    }

    public void sendValue(String yazi, By name) {
        WebElement yaz = driver.findElement(name);
        yaz.click();
        yaz.sendKeys(yazi);
    }

    public void gidisDonusTarihi(String id) throws InterruptedException {
        waitSeconds(3);
        clickElementById(id);
        waitSeconds(5);
        List<WebElement> links = driver.findElements(By.xpath("//div[@class='calendar-right']//button[@class='week in']"));
        System.out.println(" Size : " + links.size());
        Random calendarSize = new Random();
        int rndmno = calendarSize.nextInt(links.size());
        System.out.println("Random Choose Number:" + rndmno);
        clickElementByXpath("(//div[@class='calendar-right']//button[@class='week in'])[" + rndmno + "]");

    }

    public void scroll() {
        waitSeconds(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50)");
    }


    public void ucakBiletiSec(String css) {
        waitSeconds(5);
        Random biletSecim = new Random();
        rndm = biletSecim.nextInt(2)+1;
        System.out.println(rndm);
        waitSeconds(2);
        clickElementByCss("ul" + css + " > li:nth-child(" + rndm + ")");
        /*if (rndm >= 3) {
            waitSeconds(3);
            scroll();
        } else {
            waitSeconds(5);
        }
        clickElementByCss("ul" + css + " > li:nth-child(" + rndm + ")"); */
    }

    @After
    public void tearDown() throws InterruptedException {
        driver.quit();
    }


}





