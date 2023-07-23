import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    ChromeDriver driver;

    public ChromeDriver otvoriPretrazivac() {

        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        return driver;
    }
}
