package com.a1qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.io.IOException;


public class LoginTest {
    public static LoginPage loginPage;
    public static ChromeDriver driver;
    public static lkPage lkPage;
    public static ProfilePage profilePage;
    public static WebDriverWait wait;

    @DataProvider(name = "dp")
    public static Object[][] LoginPasswdData() {
        return new Object[][] {
                {"scorpio0", "rjkbgcj98"},
                {"357494059vk", "rTkcNAh6"}
        };
    }


    @BeforeClass
    public static void setup() throws IOException {
        //System.setProperty("webdriver.chrome.driver", "/home/vlad/Tools/chromedriver");

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=es");
        driver = new ChromeDriver(chromeOptions);
        loginPage = new LoginPage(driver);
        lkPage = new lkPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().window().maximize();

        driver.get(ConfProperties.getProperty("loginpage"));
        System.in.read();
    }

    @Test(dataProvider = "dp")
    public void loginTest(String login, String passwd) {
//        loginPage.inputLogin(ConfProperties.getProperty("login"));
//        loginPage.inputPasswd(ConfProperties.getProperty("passwd"));
        loginPage.inputLogin(login);
        loginPage.inputPasswd(passwd);
        loginPage.clickLoginBtn();
        lkPage.clickProfileButton();
        String user = profilePage.getUserName();
        profilePage.clicklogoutBtn();
        System.out.println(user);
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit(); }
}
