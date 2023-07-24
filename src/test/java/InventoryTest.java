import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest{

    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeMethod
    public void priprema() {

        driver = otvoriPretrazivac();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.ulogujSe("standard_user", "secret_sauce");
    }

    @Test
    public void testiranjeKorpe() {
        inventoryPage.sortirajPoNajnizojCeni();
        inventoryPage.dodajArtikal1();
        inventoryPage.dodajArtikal2();
        inventoryPage.dodajArtikal3();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(inventoryPage.proveraKorpe(), "3");
    }

    @AfterMethod
    public void zatvori() {
        driver.quit();
    }

}
