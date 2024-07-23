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
    @FindBy (linkText = "Register")
    private WebElement btn_register;
    @FindBy (name = "search")
    private WebElement input_search;

    @FindBy (xpath = "//div[@id='search']/descendant::button")
    private WebElement btn_search;

    @FindBy (linkText = "HP LP3065")
    private WebElement search_verify;

    @FindBy (xpath = "//div[@id='content']/h2/following-sibling::p")
    private WebElement noMatchSearchCriteria;
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

    public void clickOnBtn_register(){
        btn_register.click();
    }

    public void searchType (String computer){
        input_search.sendKeys(computer);
    }
    public void clickOnSearchBtn (){
        btn_search.click();
    }

    public boolean verifySearch(){
        boolean displayStatus= search_verify.isDisplayed();
        return displayStatus;
    }

    public String noMatchSearch(){
        return noMatchSearchCriteria.getText();
    }
}


