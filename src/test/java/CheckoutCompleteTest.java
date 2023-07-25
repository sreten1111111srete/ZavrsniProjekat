import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutCompleteTest extends BaseTest {

    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutStepOnePage checkoutStepOnePage;
    CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod
    public void priprema() {

        driver = otvoriPretrazivac();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @Test
    public void krajKupovine() {
        loginPage.ulogujSe("standard_user", "secret_sauce");
        inventoryPage.sortirajPoNajnizojCeni();
        inventoryPage.dodajArtikal1();
        inventoryPage.dodajArtikal2();
        inventoryPage.dodajArtikal3();
        inventoryPage.klikniKorpu();
        cartPage.klikniCheckout();
        checkoutStepOnePage.popuniFormular("Sreten", "Stankov", "11070");
        checkoutCompletePage.klikni();

        Assert.assertEquals(checkoutCompletePage.zavrsnaPoruka(), "Thank you for your order!");
    }

    @AfterMethod
    public void zatvori() {
        driver.quit();
    }
}
