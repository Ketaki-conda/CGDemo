package test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class ScreenshotDemo {
    public static void main(String[] args) {
        //set the location of chrome browser
        System.setProperty("webdriver.chrome.driver", "E:\\drivers\\ChromeNew\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        
        // Initialize browser
        WebDriver driver = new ChromeDriver(options);
        
        //navigate to url
        driver.get("http://adactinhotelapp.com");
        
       //Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File("E:\\Workspace\\TestAutomation\\Screenshots\\homePageScreenshot1.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Title of the page is -> " + driver.getTitle());
        
        //closing the webdriver
        driver.quit();
    }
}