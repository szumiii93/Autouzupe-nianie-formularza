package ContactForm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void driverSetup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    //Ponieważ w poleceniu jest uzupełnienie formularza danymi i wysłanie go, więc zakomentowałem driver.quit() by nie zamykało chroma tylko był widoczny
    @AfterEach
    public void tearDown(){
        // driver.quit();
    }
}
