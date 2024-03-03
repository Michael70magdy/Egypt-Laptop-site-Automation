package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://egyptlaptop.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement menu = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div/div[1]/div/div/div/div[3]/div[2]/div/div[1]"));
        menu.click();

        WebElement login = driver.findElement(By.xpath("//*[@id=\"dropdown_624\"]/div[3]/a[1]"));
        login.click();

        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"login_popup4699\"]"));
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"psw_popup4699\"]"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login_pass\"]/form/div[5]/div[1]/button"));

        emailInput.sendKeys("Testmail@gmail.com");
        passwordInput.sendKeys("TestPassword");

        loginButton.click();


    }
}