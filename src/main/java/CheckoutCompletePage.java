import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BasePage{

    @FindBy(id = "finish")
    WebElement kraj;

    @FindBy(className = "complete-header")
    WebElement poruka;

    public CheckoutCompletePage(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void klikni() {
        kraj.click();
    }

    public String zavrsnaPoruka() {
        return poruka.getText();
    }

}
