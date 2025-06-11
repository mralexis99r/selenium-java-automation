package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

import pages.LoginPage;
import utils.JsonReader;

import java.io.InputStream;

public class SauceLoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("LoginData.json");
        return JsonReader.getLoginData(inputStream);
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {
        loginPage.loginAs(username, password);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"), "El login no redirigió correctamente");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
