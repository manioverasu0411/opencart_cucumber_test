package org.opencart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // By Locators

    private By emailInputLocator = By.name("email");
    private By passwordInputLocator = By.name("password");
    private By loginButtonLocator = By.xpath("//input[@type='submit']");
    private By forgottenPasswordLinkLocator = By.linkText("Forgotten Password");
    private By logoutLink = By.linkText("Logout");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Methods / Actions

    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public void clickForgottenPaswordLink() {
        WebElement forgottenPassword = driver.findElement(forgottenPasswordLinkLocator);
        forgottenPassword.click();
    }

    public boolean checkForgotPwdLink() {
        return driver.findElement(forgottenPasswordLinkLocator).isDisplayed();
    }

    public boolean checkLogoutLink() {
        return driver.findElement(logoutLink).isDisplayed();
    }

    public void clickLogout() {
        WebElement logout = driver.findElement(logoutLink);
        logout.click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public String getForgotPwdPageUrl() {
        String forgotPwdPageUrl = driver.getCurrentUrl();
        return forgotPwdPageUrl;
    }


}
