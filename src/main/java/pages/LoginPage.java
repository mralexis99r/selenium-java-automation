package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Selectores (mismos que usarías en Playwright)
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Acciones
    public void loginAs(String username, String password) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
