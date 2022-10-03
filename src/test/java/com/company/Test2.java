package com.company;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://uk.wikipedia.org/";

        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[@lang = 'en']")).click();
        WebElement title = driver.findElement(By.xpath("//*[@id=\"Welcome_to_Wikipedia\"]"));
        Assert.assertEquals(title.getText(), "Welcome to Wikipedia");
        driver.findElement(By.xpath("//*[@id=\"pt-login\"]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"wpName1\"]")).sendKeys("test1");
        driver.findElement(By.xpath("//*[@id=\"wpPassword1\"]")).sendKeys("test2");
        driver.findElement(By.xpath("//*[@id=\"wpLoginAttempt\"]")).click();
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='mw-message-box-error mw-message-box']"));
        Assert.assertEquals(errorMessage.getText(), "Incorrect username or password entered. Please try again.");
        driver.close();
    }
}
