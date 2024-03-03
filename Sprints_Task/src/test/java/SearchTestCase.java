import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class SearchTestCase {
    private WebDriver d;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
        d = new ChromeDriver();
        d.get("https://egyptlaptop.com");
        d.manage().window().maximize();
        wait = new WebDriverWait(d, Duration.ofSeconds(100));
    }

    @Test
    public void search() throws InterruptedException {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/form/input[9]")));
        searchInput.sendKeys("laptop");
        searchInput.submit();
        Thread.sleep(500);
    }

    @AfterTest
    public void exit() {
        d.quit();
    }
}
