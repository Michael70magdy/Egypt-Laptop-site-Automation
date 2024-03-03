import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTestCase
{
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
    public void addToCart() throws InterruptedException {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/form/input[9]")));
        searchInput.sendKeys("laptop");
        searchInput.submit();
        WebElement productLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"products_search_pagination_contents\"]/div[1]/div/form/div/div[1]")));
        productLink.click();
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div[3]/div/div[1]/div/div/div[1]/div[2]/div[2]/form/div[7]/div[2]/div/button")));
        addToCartButton.click();
    }

    @AfterTest
    public void exit() {
        d.quit();
    }


}
