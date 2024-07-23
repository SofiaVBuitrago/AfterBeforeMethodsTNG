package Locators;

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
    @FindBy(xpath = "//div[contains(text(),'Warning')]")
    private WebElement wrongCredentialsWarning;





    public LoginPage(WebDriver driver) {
        super();
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public void enterEmail (String email){
        input_email.sendKeys(email);
    }

    public void enterPassword (String password){
        input_password.sendKeys(password);
    }

    public void clickLogin (){
        btn_login.click();
    }

    public String wrongCredentialsWarning (){
       String warningCredentials = wrongCredentialsWarning.getText();
       return warningCredentials;
    }



}
