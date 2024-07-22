import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;

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
    @Test
    public void SearchWithExistingProduct(){

        driver.findElement(By.name("search")).sendKeys("HP");
        driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
        Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
    }
    @Test
    public void SearchWithNonExistingProduct(){

        driver.findElement(By.name("search")).sendKeys("sofia");
        driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
        String actual = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
        Assert.assertEquals(actual,"There is no product that matches the search criteria.");
    }
    @Test
    public void SearchWithoutType(){

        driver.findElement(By.name("search"));
        driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
        String actual = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
        Assert.assertEquals(actual,"There is no product that matches the search criteria.");
    }
}
