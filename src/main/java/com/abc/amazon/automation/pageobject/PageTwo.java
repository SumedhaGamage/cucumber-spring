package com.abc.amazon.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Sumedha on 7/9/2016.
 */
public class PageTwo implements IPageObject{

    WebDriver driver;

    public PageTwo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id='sort']")
    WebElement sort;

    public WebElement getSort() {
        return sort;
    }
}
