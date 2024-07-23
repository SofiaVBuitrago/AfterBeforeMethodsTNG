package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RegisterPage {

    WebDriver driver;

    @FindBy (name = "firstname")
    private  WebElement input_firstName;

    @FindBy (name = "lastname")
    private  WebElement input_lastName;

    @FindBy (name = "email")
    private  WebElement input_email;

    @FindBy (name = "telephone")
    private  WebElement input_telephone;

    @FindBy (name = "password")
    private  WebElement input_password;

    @FindBy (name = "confirm")
    private  WebElement input_confirmPassword;

    @FindBy (name = "agree")
    private  WebElement check_agree;

    @FindBy (xpath = "//input[@value='Continue']")
    private  WebElement btn_continue;

    @FindBy (xpath = "(//input[@name='newsletter'])[1]")
    private   WebElement check_newsletter;

    @FindBy (xpath = "//div[@id='content']/h1")
    private  WebElement txt_accountCreated;

    @FindBy (xpath = "//div[contains(text(),'Warning')]")
    private  WebElement emailRegistered_warning;
    @FindBy (xpath = "//div[contains(text(),'Warning')]")
    private WebElement agree_Warning;

    public RegisterPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public  void enterFirstName(String firstname){
        input_firstName.sendKeys(firstname);
    }

    public  void enterLastName (String lastname){
        input_lastName.sendKeys(lastname);
    }

    public  void enterEmail(String email){
        input_email.sendKeys(email);
    }

    public  void enterTelephone(String telephone){
        input_telephone.sendKeys(telephone);
    }

    public  void enterPassword(String password){
        input_password.sendKeys(password);
    }

    public  void enterPasswordConfirmation(String passwordConfirmation){
        input_confirmPassword.sendKeys(passwordConfirmation);
    }

    public  void clickAgree(){
        check_agree.click();
    }

    public  void clickContinue(){
        btn_continue.click();
    }

    public  String accountCreated (){
        String accountCreated =  txt_accountCreated.getText();
        return accountCreated;
    }
    public  String emailRegisteredWarning (){
        String emailRegistered =  emailRegistered_warning.getText();
        return emailRegistered;
    }

    public  String agreeWarning (){
        String agreeWarning = agree_Warning.getText();
        return agreeWarning;
    }
    public  void check_newsletter (){
        check_newsletter.click();
    }



}
