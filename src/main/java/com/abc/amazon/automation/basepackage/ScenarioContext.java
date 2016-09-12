package com.abc.amazon.automation.basepackage;

import com.abc.amazon.automation.pageobject.IPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.core.env.Environment;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by Sumedha on 7/9/2016.
 */

public class ScenarioContext {

    public WebDriver driver(Environment env) throws MalformedURLException {
        WebDriver driver = null;
        String browser = env.getProperty("browser");
        String machine = env.getProperty("machine");
        if (machine.equalsIgnoreCase("local")) {
            switch (browser) {
                case BrowserType.CHROME:
                    driver = new ChromeDriver();
                    break;
                case BrowserType.FIREFOX:
                    driver = new FirefoxDriver();
                    break;
                default:
                    driver = new ChromeDriver();
                    break;
            }
        } else {
            driver = new RemoteWebDriver(new URL(env.getProperty("selenium.server.url")), setCapabilities(env));
        }
        return driver;
    }

    public DesiredCapabilities setCapabilities(Environment env) {
        String browser = env.getProperty("browser");
        DesiredCapabilities cap = null;

        switch (browser) {
            case BrowserType.CHROME:
                cap = DesiredCapabilities.chrome();
                break;
            case BrowserType.FIREFOX:
                cap = DesiredCapabilities.firefox();
                break;
            default:
                cap = DesiredCapabilities.chrome();
                break;
        }
        cap.setJavascriptEnabled(true);
        return cap;
    }

    public WebElement getWebElementFromPageObject(String element, String pagename, WebDriver driver) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String className = "com.abc.amazon.automation.pageobject." + pagename.trim();
        String methodName = "get" + element.replaceAll("(^.?)", String.valueOf(element.charAt(0)).toUpperCase());
        IPageObject page =
                (IPageObject) Class.forName(className).getConstructor(WebDriver.class).newInstance(driver);
        Method method = page.getClass().getDeclaredMethod(methodName);
        return (WebElement) method.invoke(page);
    }

    public WebDriverWait getWait(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait;
    }

    public WebElement findElementByXpath(String element, Properties props, WebDriver driver) {
        String e = element.replaceAll("( )", "").toLowerCase();
        return driver.findElement(By.xpath(props.getProperty(e)));

    }

}
