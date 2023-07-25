import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;

    @BeforeMethod
    public void priprema() {

        driver = otvoriPretrazivac();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void testCheckout() {

        loginPage.ulogujSe("standard_user", "secret_sauce");
        inventoryPage.sortirajPoNajnizojCeni();
        inventoryPage.dodajArtikal1();
        inventoryPage.dodajArtikal2();
        inventoryPage.dodajArtikal3();
        inventoryPage.klikniKorpu();
        cartPage.klikniCheckout();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
    }

    @AfterMethod
    public void zatvori() {
        driver.quit();
    }
}
