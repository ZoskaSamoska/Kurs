import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class JobOfferCheck {

    public WebDriver getDriver(){
        WebDriver driver = WebDriverManager.chromedriver().create();

        driver.manage().window().maximize();
        driver.navigate().to("https://alan-systems.com/");
        return driver;
    }

    @Test
    public void RequiredFields() {

        /**otwarcie strony głównej i wybranie opcji dla biznesu*/
        WebDriver driver = getDriver();

        WebElement linkCandidates = driver.findElement(By.xpath("//*[text()='WSKAKUJ NA POKŁAD']"));
        linkCandidates.click();

        /**przejście do zakładki Kariera*/
        WebElement Career = driver.findElement(By.xpath("//*[text()='Kariera']"));
        Career.click();

        /**wyszukaj i otwórz ofertę Test developera*/
        WebElement jobOffer = driver.findElement(By.cssSelector("a[href='https://alan-systems.com/pl/oferta-pracy/test-automation-developer/']"));
        WebElement bodyJO = driver.findElement(By.tagName("body"));
        bodyJO.sendKeys(Keys.PAGE_DOWN);
        bodyJO.sendKeys(Keys.PAGE_DOWN);
        bodyJO.sendKeys(Keys.PAGE_DOWN);
        jobOffer.click();

        /**wyszukaj checkboxy w formularzu aplikacyjnym*/
        WebElement apply = driver.findElement(By.className("forminator-button-submit"));
        WebElement bodyA = driver.findElement(By.tagName("body"));
        bodyA.sendKeys(Keys.PAGE_DOWN);
        bodyA.sendKeys(Keys.PAGE_DOWN);
        bodyA.sendKeys(Keys.PAGE_DOWN);
        apply.click();

        /**sprawdzanie error message dla pola ładowania pliku*/
        WebElement usePdf = driver.findElement(By.xpath("//*[text()='Use PDF or DOCX files']"));

        /**sprawdzanie walidacji pola ładowania pliku*/
        WebElement attachCV = driver.findElement(By.name("upload-1"));
        Assertions.assertTrue(Boolean.parseBoolean(attachCV.getAttribute("aria-invalid")),
                "Checkbox " + attachCV + " powinien mieć atrybut 'aria-invalid'");

        /**sprawdzanie error message dla pola checkbox'ów*/
        WebElement chooseOption = driver.findElement(By.xpath("//*[text()='Zaznacz opcję']"));

        /**sprawdzanie walidacji checkbox'ów*/
        for (int i = 1; i <= 3; i++) {
            String checkboxName = "checkbox-" + i + "[]";

            WebElement checkbox = driver.findElement(By.name(checkboxName));
            Assertions.assertTrue(Boolean.parseBoolean(checkbox.getAttribute("aria-invalid")),
                    "Checkbox " + checkboxName + " powinien mieć atrybut 'aria-invalid'");
        }

        driver.quit();

    }
}
