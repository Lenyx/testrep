package com.a1qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//input[contains(@name, 'firstname')]")
    private WebElement username;

    @FindBy(xpath = "//a[contains(text(), 'ВЫХОД')]")
    private WebElement logoutBtn;

    public String getUserName() {
        String firstname = username.getAttribute("defaultValue");
        return firstname; }
    public void clicklogoutBtn() {
        logoutBtn.click();
    }

}
