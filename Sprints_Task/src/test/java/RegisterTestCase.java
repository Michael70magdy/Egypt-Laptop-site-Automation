import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RegisterTestCase {
    private WebDriver driver;
    public static String Fname = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
    public static String Lname = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
    public static String Mail = new StringBuilder().append(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8)).append("@gmail.com").toString();

    public static String Pass = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);


    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://egyptlaptop.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testRegistration() {

        WebElement dropmenu = driver.findElement(By.xpath("//*[@id=\"account_info_4699\"]"));
        dropmenu.click();
        WebElement registerLink = driver.findElement(By.xpath("//*[@id=\"dropdown_624\"]/div[3]/a[2]"));
        registerLink.click();
        WebElement firstname = driver.findElement(By.xpath("//*[@id=\"elm_6\"]"));
        WebElement lastname = driver.findElement(By.xpath("//*[@id=\"elm_7\"]"));
        WebElement Phone = driver.findElement(By.xpath("//*[@id=\"elm_9\"]"));
        WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"password1\"]"));
        WebElement Confirmpass = driver.findElement(By.xpath("//*[@id=\"password2\"]"));
        WebElement Register = driver.findElement(By.xpath("//*[@id=\"login_pass\"]/div/form/div[6]/button"));

        firstname.sendKeys(Fname);
        lastname.sendKeys(Lname);
        Phone.sendKeys("01111111111");
        email.sendKeys(Mail);
        pass.sendKeys(Pass);
        Confirmpass.sendKeys(Pass);


        Register.click();

       }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
