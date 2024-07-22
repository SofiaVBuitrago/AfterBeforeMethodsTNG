import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Register extends Base {

    public Register(){
        super();
    }
    WebDriver driver;
    @BeforeMethod
    public void setup (){
//        driver = new ChromeDriver();
//        driver.navigate().to("https://tutorialsninja.com/demo");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver = openingThePage();
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

    }
    @AfterMethod
    public void closing (){
        driver.close();
        driver.quit();

    }


    @Test
       public void registerOnThePage(){

           driver.findElement(By.name("firstname")).sendKeys("Tabot1");
           driver.findElement(By.name("lastname")).sendKeys("Junior");
           driver.findElement(By.name("email")).sendKeys(Util.generateGmail());
           driver.findElement(By.name("telephone")).sendKeys("987654");
           driver.findElement(By.name("password")).sendKeys("123456");
           driver.findElement(By.name("confirm")).sendKeys("123456");
           driver.findElement(By.name("agree")).click();
           driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), "Your Account Has Been Created!");
       }

    @Test
    public void registerOnThePageWithNewsletter(){

        driver.findElement(By.name("firstname")).sendKeys("Tabot1");
        driver.findElement(By.name("lastname")).sendKeys("Junior");
        driver.findElement(By.name("email")).sendKeys(Util.generateGmail());
        driver.findElement(By.name("telephone")).sendKeys("987654");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.name("confirm")).sendKeys("123456");
        driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']/h1")).getText(), "Your Account Has Been Created!");
    }

    @Test
    public void registerWithRegisteredEmail(){

        driver.findElement(By.name("firstname")).sendKeys("Tabot1");
        driver.findElement(By.name("lastname")).sendKeys("Junior");
        driver.findElement(By.name("email")).sendKeys("pruebatestingsofia@gmail.com");
        driver.findElement(By.name("telephone")).sendKeys("987654");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.name("confirm")).sendKeys("123456");
        driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        String actual = driver.findElement(By.xpath("//div[contains(text(),'Warning')]")).getText();
        Assert.assertEquals(actual, "Warning: E-Mail Address is already registered!");
    }

    @Test
    public void registerWithEmptyDetails(){

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        String actual = driver.findElement(By.xpath("//div[contains(text(),'Warning')]")).getText();
        Assert.assertEquals(actual, "Warning: You must agree to the Privacy Policy!");
    }







}
