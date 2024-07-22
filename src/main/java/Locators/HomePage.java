package Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    /*objects*/
    @FindBy(xpath="//span[text()='My Account']")
    private WebElement myAccountDropDownMenu;

    @FindBy(linkText="Login")
    private WebElement btn_login;
    /*Constructor*/
    public HomePage (WebDriver driver){
        this.driver = driver;
        /*para inicializaar todos los WebElements*/
        PageFactory.initElements(driver,this);
    }

    /*Methods*/
    public void clickOnMyAccountDropDownMenu (){
        myAccountDropDownMenu.click();
    }

    public void clickOnBtn_login(){
        btn_login.click();
    }
}
