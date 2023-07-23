import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void priprema() {

        driver = otvoriPretrazivac();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void logovanje1() {

        loginPage.ulogujSe("standard_user", "secret_sauce");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void logovanje2() {

        loginPage.ulogujSe("problem_user", "secret_sauce");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void logovanje3() {

        loginPage.ulogujSe("performance_glitch_user", "secret_sauce");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void logovanje4() {

        loginPage.ulogujSe("locked_out_user", "secret_sauce");

        Assert.assertEquals(loginPage.porukaGreske(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void logovanje5() {

        loginPage.ulogujSe("", "secret_sauce");

        Assert.assertEquals(loginPage.porukaGreske(), "Epic sadface: Username is required");
    }

    @AfterMethod
    public void zatvori() {
        driver.quit();
    }

}
