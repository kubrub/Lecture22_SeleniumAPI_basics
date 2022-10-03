package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Test1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://uk.wikipedia.org/";
//Kubikrubik1
        //Kubikrubik12
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[@lang = 'en']")).click();
        WebElement title = driver.findElement(By.xpath("//*[@id=\"Welcome_to_Wikipedia\"]"));
        Assert.assertEquals(title.getText(), "Welcome to Wikipedia");
        driver.findElement(By.xpath("//span[normalize-space()='Log in']")).click();

        driver.findElement(By.xpath("//*[@id=\"wpName1\"]")).sendKeys("Kubikrubik1");
        driver.findElement(By.xpath("//*[@id=\"wpPassword1\"]")).sendKeys("Kubikrubik12");
        driver.findElement(By.xpath("//*[@id=\"userloginForm\"]/form/div/div[3]/div/div/label")).click();
        driver.findElement(By.xpath("//*[@id=\"wpLoginAttempt\"]")).click();

        WebElement myName = driver.findElement(By.xpath("//*[@id=\"pt-userpage\"]/a/span"));
        Assert.assertEquals(myName.getText(), "Kubikrubik1");
        WebElement searchInformation = driver.findElement(By.id("searchInput"));
        searchInformation.sendKeys("Ukraine");
        searchInformation.submit();

        WebElement ukrainianPage = driver.findElement(By.xpath("//span[@class='mw-page-title-main' and contains(text(),'Ukraine')]"));
        Assert.assertEquals(ukrainianPage.getText(), "Ukraine");
        driver.close();
    }
}
