package com.abc.amazon.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Sumedha on 7/9/2016.
 */

public class MainPage implements IPageObject{

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
    WebElement searchbox;

    @FindBy(xpath = "//*[@id='nav-search']/form/div[2]/div/input")
    WebElement searchicon;

    public WebElement getSearchicon() {
        return searchicon;
    }

    public WebElement getSearchbox() {
        return searchbox;
    }
}
