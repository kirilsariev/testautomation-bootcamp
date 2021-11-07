package com.musala.course.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy(className = "btn_action")
    private WebElement loginButton;

    @FindBy(id = "login_button_container")
    private WebElement loginErrorMessage;

    @FindBy(className = "login_logo")
    private WebElement loginLogo;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProductListerPage login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        return new ProductListerPage(driver);
    }

    public String getLoginErrorMessage(){
        return loginErrorMessage.getText();
    }

    public void clearFields() {
        usernameField.clear();
        passwordField.clear();
    }

    public boolean isLoginLogoDisplayed() {
        return loginLogo.isDisplayed();
    }
}
