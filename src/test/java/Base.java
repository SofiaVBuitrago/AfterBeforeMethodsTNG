import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    WebDriver driver;
    public Properties properties;


    public Base(){
        properties = new Properties();
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        }catch(Throwable e) {
            e.printStackTrace();
        }

    }
    public WebDriver openingThePage(){
        driver = new ChromeDriver();
        driver.navigate().to(properties.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return driver;
    }
}
