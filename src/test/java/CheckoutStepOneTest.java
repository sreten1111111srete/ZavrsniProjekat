import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutStepOneTest extends BaseTest {

    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutStepOnePage checkoutStepOnePage;

    @BeforeMethod
    public void priprema() {

        driver = otvoriPretrazivac();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        loginPage.ulogujSe("standard_user", "secret_sauce");
        inventoryPage.sortirajPoNajnizojCeni();
        inventoryPage.dodajArtikal1();
        inventoryPage.dodajArtikal2();
        inventoryPage.dodajArtikal3();
        inventoryPage.klikniKorpu();
        cartPage.klikniCheckout();
    }

    @Test
    public void formular() {
        checkoutStepOnePage.popuniFormular("Sreten", "Stankov", "11070");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
        Assert.assertEquals(checkoutStepOnePage.totalnaCena(), "Item total: $33.97");
    }

    @AfterMethod
    public void zatvori() {
        driver.quit();
    }

}
