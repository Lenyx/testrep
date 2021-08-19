package com.a1qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class lkPage {
    public WebDriver driver;

    public lkPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[contains(text(), 'Мой профиль')]")
    private WebElement profileButton;

    public void clickProfileButton() {
        profileButton.click();
    }



}
