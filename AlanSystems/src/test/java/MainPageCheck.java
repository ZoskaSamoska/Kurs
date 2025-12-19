import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPageCheck {

    public WebDriver getDriver(){
        WebDriver driver = WebDriverManager.chromedriver().create();

        driver.manage().window().maximize();
        driver.navigate().to("https://alan-systems.com/");
        return driver;
    }

    @Test
    public void Bussines() {

        /**otwarcie strony głównej i wybranie opcji dla biznesu*/
        WebDriver driver = getDriver();

        WebElement linkBusiness = driver.findElement(By.xpath("//*[text()='Dowiedz się więcej']"));
        linkBusiness.click();

        /**sprawdzanie topBar i wyświetlania elementów na pasku*/
        WebElement navBarBussines = driver.findElement(By.id("main-menu-business"));

        WebElement forBusiness = driver.findElement(By.xpath("//*[text()='Dla biznesu']"));
        Assertions.assertEquals("Dla biznesu", forBusiness.getAttribute("text"));

        WebElement aboutUs = driver.findElement(By.xpath("//*[text()='O nas']"));
        Assertions.assertEquals("O nas", aboutUs.getAttribute("text"));

        WebElement offer = driver.findElement(By.xpath("//*[text()='Oferta']"));
        Assertions.assertEquals("Oferta", offer.getAttribute("text"));

        WebElement contact = driver.findElement(By.xpath("//*[text()='Kontakt']"));
        Assertions.assertEquals("Kontakt", contact.getAttribute("text"));

        WebElement career = driver.findElement(By.xpath("//*[text()='Kariera w ALAN SYSTEMS']"));
        Assertions.assertEquals("Kariera w ALAN SYSTEMS", career.getAttribute("text"));

        /**przesunięcie na koniec strony i sprawdzanie danych kontaktowych*/
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.END);

        WebElement address = driver.findElement(By.cssSelector(".icon-address"));
        Assertions.assertEquals("ul. Obwiednia Południowa 22\n" + "44-200 Rybnik", address.getText());

        WebElement phone = driver.findElement(By.cssSelector(".icon-phone"));
        Assertions.assertEquals("+48 32 733 86 00", phone.getText());

        WebElement email = driver.findElement(By.cssSelector(".icon-email"));
        Assertions.assertEquals("info@alan-systems.com", email.getText());

        driver.quit();
    }

        @Test
        public void Candidates(){
        /**otwarcie strony głównej i wybranie opcji dla kandydatów*/
        WebDriver driver = getDriver();

        WebElement linkCandidates = driver.findElement(By.xpath("//*[text()='WSKAKUJ NA POKŁAD']"));
        linkCandidates.click();

        /**sprawdzanie topBar i wyświetlania elementów na pasku*/
        WebElement navBarCareer = driver.findElement(By.id("main-menu-kariera"));

        WebElement forCandidates = driver.findElement(By.xpath("//*[text()='Dla kandydata']"));
        Assertions.assertEquals("Dla kandydata", forCandidates.getAttribute("text"));

        WebElement aboutUs = driver.findElement(By.xpath("//*[text()='O nas']"));
        Assertions.assertEquals("O nas", aboutUs.getAttribute("text"));

        WebElement career = driver.findElement(By.xpath("//*[text()='Kariera']"));
        Assertions.assertEquals("Kariera", career.getAttribute("text"));

        WebElement contact = driver.findElement(By.xpath("//*[text()='Kontakt']"));
        Assertions.assertEquals("Kontakt", contact.getAttribute("text"));

        WebElement solutions = driver.findElement(By.xpath("//*[text()='Rozwiązania do biznesu']"));
        Assertions.assertEquals("Rozwiązania do biznesu", solutions.getAttribute("text"));

        /**przesunięcie na koniec strony i sprawdzanie danych kontaktowych*/
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(Keys.END);

        WebElement address = driver.findElement(By.cssSelector(".icon-address"));
        Assertions.assertEquals("ul. Obwiednia Południowa 22\n" + "44-200 Rybnik", address.getText());

        WebElement phone = driver.findElement(By.cssSelector(".icon-phone"));
        Assertions.assertEquals("+48 32 733 86 00", phone.getText());

        WebElement email = driver.findElement(By.cssSelector(".icon-email"));
        Assertions.assertEquals("info@alan-systems.com", email.getText());

        driver.quit();
    }

}
