import Locators.AccountPage;
import Locators.HomePage;
import Locators.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login extends Base {

    public Login(){
        super();
    }
    WebDriver driver;

    @DataProvider
    public Object [][] readTestDataSucc(){
        Object[][] data= {{"pruebatestingsofia@gmail.com","123456"},
                {"amotooricap1@gmail.com","12345"},
                {"amotooricap3@gmail.com","12345"}};
        return data;
    }
    @DataProvider
    public Object [][] readTestDataUnSucc(){
        Object[][] data= {{"pruebawrong@gmail.com","123456"},
                {"fakewrong1@gmail.com","12345"}};
        return data;
    }



    @BeforeMethod /*aca use el method y no before test porque lo necesito para cada uno de los test*/
    public void setupUntilLogin(){

        driver =  openingThePage();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccountDropDownMenu();
        homePage.clickOnBtn_login();
    }
    @AfterMethod
    public void closeQuit(){
//      System.out.println("acá acaba el test");
        driver.close();
        driver.quit();
    }
    @Test(dataProvider = "readTestDataSucc")
    public void SuccessfulLogin (String email, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        AccountPage accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.EditYourAccInfoDisplayed());

    }


    @Test(dataProvider = "readTestDataUnSucc")
    public void UnSuccessfulLogin (String wrongEmail, String password)  {
        //driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(wrongEmail);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        String Actual = loginPage.wrongCredentialsWarning();
        String Expected = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(Actual,Expected);


    }





}
