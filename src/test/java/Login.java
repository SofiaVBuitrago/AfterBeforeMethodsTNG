import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login extends Base {

    WebDriver driver;

    @BeforeMethod /*aca use el method y no before test porque lo necesito para cada uno de los test*/
    public void setupUntilLogin(){
//        driver = new ChromeDriver();
//        driver.navigate().to("https://tutorialsninja.com/demo/");
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver =  openingThePage();
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
    }
    @AfterMethod
    public void closeQuit(){
//        System.out.println("acá acaba el test");
        driver.close();
        driver.quit();
    }
    @Test
    public void SuccessfulLogin (){
//        driver = new ChromeDriver();
        driver.findElement(By.name("email")).sendKeys("pruebatestingsofia@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

    }
    @Test
    public void UnSuccessfulLogin (){
        //driver = new ChromeDriver();
        driver.findElement(By.name("email")).sendKeys("pruebatestingsofia@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123456769");
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        String Actual = driver.findElement(By.xpath("//div[contains(text(),'Warning')]")).getText();
        String Expected = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(Actual,Expected);
        System.out.println(Util.generateGmail());


    }





}
