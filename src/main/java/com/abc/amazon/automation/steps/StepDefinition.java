package com.abc.amazon.automation.steps;

import com.abc.amazon.automation.basepackage.AutomationConfiguration;
import com.abc.amazon.automation.basepackage.ScenarioContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Created by Sumedha on 7/9/2016.
 */
public class StepDefinition {

    @Autowired
    private Environment env;

    private WebDriver driver;
    private WebDriverWait wait;
    private ScenarioContext context;

    @Autowired
    private AutomationConfiguration config;

    @Resource(name = "xpathproperties")
    private Properties props;

    @Given("^open webdriver$")
    public void testrun() throws IOException {
        this.context = new ScenarioContext();
        config.setDriver(context.driver(env));
        this.driver = config.getDriver();
        config.setWait(context.getWait(driver));
        this.wait = config.getWait();
        driver.manage().window().maximize();

    }

    @And("^I navigate to (.*)$")
    public void navigateToUrl(String url) throws IllegalAccessException, ClassNotFoundException, InstantiationException, InvocationTargetException, NoSuchFieldException, NoSuchMethodException {
        driver.get(url);

    }

    @And("^I enter text (.*) on (.*) in (.*)$")
    public void clickOnElement(String text, String element, String pagename) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        WebElement webElement = this.context.getWebElementFromPageObject(element, pagename, driver);
        webElement.sendKeys(text);
    }

    @And("^I click on (.*) in (.*)$")
    public void clickOnElement(String element, String pagename) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException {
        WebElement webElement = this.context.getWebElementFromPageObject(element, pagename, driver);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();

    }

    @And("^I click on (.*) property$")
    public void clickOnElementXpath(String element) {
        WebElement webElement = context.findElementByXpath(element, props, driver);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();

    }
}
