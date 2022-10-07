package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\drivers\\ChromeNew\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://demoqa.com/alerts");
	    
	    driver.findElement(By.id("timerAlertButton")).click();
	    
	    WebDriverWait wait = new WebDriverWait(driver,5);
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	    System.out.println("Changes to alert handling");
	    
	    driver.switchTo().alert().accept();

	}

}
