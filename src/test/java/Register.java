import Locators.HomePage;
import Locators.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Register extends Base {

    public Register(){
        super();
    }
    WebDriver driver;

    @DataProvider
    public Object [][] dataToRegister(){
        Object[][] data= {{"Tabot1","Junior",Util.generateGmail(), "987654","123456","123456"}};
        return data;
    }
    @DataProvider
    public Object [][] dataToRegisterNoEmail(){
        Object[][] data= {{"Tabot1","Junior", "987654","123456","123456"}};
        return data;
    }

    @BeforeMethod
    public void setup (){

        driver = openingThePage();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccountDropDownMenu();
        homePage.clickOnBtn_register();

    }
    @AfterMethod
    public void closing (){
        driver.close();
        driver.quit();

    }


    @Test(dataProvider = "dataToRegister")
       public void registerOnThePage(String firstname, String lastname, String email, String telephone, String password, String confirm){

            RegisterPage registerPage = new RegisterPage( driver);
            registerPage.enterFirstName(firstname);
            registerPage.enterLastName(lastname);
            registerPage.enterEmail(email);
            registerPage.enterTelephone(telephone);
            registerPage.enterPassword(password);
            registerPage.enterPasswordConfirmation(confirm);
            registerPage.clickAgree();
            registerPage.clickContinue();
            Assert.assertEquals(registerPage.accountCreated(), "Your Account Has Been Created!");
       }

    @Test(dataProvider = "dataToRegister")
    public void registerOnThePageWithNewsletter(String firstname, String lastname, String email, String telephone, String password, String confirm){

        RegisterPage registerPage = new RegisterPage( driver);
        registerPage.enterFirstName(firstname);
        registerPage.enterLastName(lastname);
        registerPage.enterEmail(email);
        registerPage.enterTelephone(telephone);
        registerPage.enterPassword(password);
        registerPage.enterPasswordConfirmation(confirm);
        registerPage.check_newsletter();
        registerPage.clickAgree();
        registerPage.clickContinue();
        Assert.assertEquals(registerPage.accountCreated(), "Your Account Has Been Created!");
    }

    @Test(dataProvider = "dataToRegisterNoEmail")
    public void registerWithRegisteredEmail(String firstname, String lastname, String telephone, String password, String confirm){

        RegisterPage registerPage = new RegisterPage( driver);
        registerPage.enterFirstName(firstname);
        registerPage.enterLastName(lastname);
        registerPage.enterEmail("pruebatestingsofia@gmail.com");
        registerPage.enterTelephone(telephone);
        registerPage.enterPassword(password);
        registerPage.enterPasswordConfirmation(confirm);
        registerPage.check_newsletter();
        registerPage.clickAgree();
        registerPage.clickContinue();
        Assert.assertEquals(registerPage.emailRegisteredWarning(), "Warning: E-Mail Address is already registered!");
    }

    @Test
    public void registerWithEmptyDetails(){

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickContinue();
        Assert.assertEquals(registerPage.agreeWarning(), "Warning: You must agree to the Privacy Policy!");
    }







}
