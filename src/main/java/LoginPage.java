import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement korisnickoIme;

    @FindBy(id = "password")
    WebElement sifra;

    @FindBy(id = "login-button")
    WebElement loginDugme;

    @FindBy(css = ".error-message-container")
    WebElement greska;

    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ulogujSe(String ime,String lozinka) {

        korisnickoIme.sendKeys(ime);
        sifra.sendKeys(lozinka);
        loginDugme.submit();
    }

    public String porukaGreske() {
        return greska.getText();
    }
}
