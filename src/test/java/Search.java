import Locators.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Search extends Base {
    public Search(){
        super();
    }
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = openingThePage();
    }
    @AfterMethod
    public void close(){
        driver.close();
        driver.quit();
    }
    @DataProvider
    public Object [][] TestData(){
        Object[][] data= {{"HP"}};
        return data;
    }
    @Test(dataProvider = "TestData")
    public void SearchWithExistingProduct(String computer){

        HomePage homePage = new HomePage(driver);
        homePage.searchType(computer);
        homePage.clickOnSearchBtn();
        Assert.assertTrue(homePage.verifySearch());
    }
    @Test
    public void SearchWithNonExistingProduct(){
        HomePage homePage = new HomePage(driver);
        homePage.searchType("Sofia");
        homePage.clickOnSearchBtn();
        Assert.assertEquals(homePage.noMatchSearch(),"There is no product that matches the search criteria.");
    }
    @Test
    public void SearchWithoutType(){
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSearchBtn();
        Assert.assertEquals(homePage.noMatchSearch(),"There is no product that matches the search criteria.");
    }
}
