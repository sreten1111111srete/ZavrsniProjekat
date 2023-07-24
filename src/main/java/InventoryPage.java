import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BasePage{

    @FindBy(className = "product_sort_container")
    WebElement sortiranje;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")
    WebElement najnizaCena;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement artikal1;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement artikal2;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement artikal3;

    @FindBy(className = "shopping_cart_link")
    WebElement korpa;

    public InventoryPage(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sortirajPoNajnizojCeni() {
        sortiranje.click();
        najnizaCena.click();
    }

    public void dodajArtikal1() {
        artikal1.click();
    }

    public void dodajArtikal2() {
        artikal2.click();
    }

    public void dodajArtikal3() {
        artikal3.click();
    }

    public String proveraKorpe() {
        return korpa.getText();
    }
}
