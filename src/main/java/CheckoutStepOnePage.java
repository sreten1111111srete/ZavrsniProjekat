import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage extends BasePage {

    @FindBy(id = "first-name")
    WebElement ime;

    @FindBy(id = "last-name")
    WebElement prezime;

    @FindBy(id = "postal-code")
    WebElement postanskiBroj;

    @FindBy(id = "continue")
    WebElement dugme;

    @FindBy(className = "summary_subtotal_label")
    WebElement cena;

    public CheckoutStepOnePage(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void popuniFormular(String ime1, String prezime1, String broj) {
        ime.sendKeys(ime1);
        prezime.sendKeys(prezime1);
        postanskiBroj.sendKeys(broj);
        dugme.click();
    }

    public String totalnaCena() {
        return cena.getText();
    }
}
