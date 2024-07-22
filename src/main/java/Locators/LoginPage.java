package Locators;

import config.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(name="email")
    private WebElement input_email;

    @FindBy(name="password")
    private WebElement input_password;

    @FindBy(xpath="//input[@class='btn btn-primary']")
    private WebElement btn_login;

    @FindBy (linkText = "Edit your account information")
    private WebElement successfull_login;

    public LoginPage(WebDriver driver) {
        super();
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public void enterEmail (){
        input_email.sendKeys(properties.getProperty("validEmail"));
    }



}
