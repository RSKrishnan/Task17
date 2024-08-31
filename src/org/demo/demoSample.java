package org.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class demoSample {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Action class object is created for mouse over action
		Actions actionsObj = new Actions(driver);
		//Snapdeal site is not working. So mentor given the below site for task completion
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();

		WebElement signBtn = driver.findElement(By.xpath("//li/a[text()='Log in']"));
		// used clickAndHold() method to perform click and hold of mouse action

		actionsObj.clickAndHold(signBtn).build().perform();
		// click() method is used for Log In
		Thread.sleep(2000);
		signBtn.click();
		driver.findElement(By.cssSelector("input#loginusername")).sendKeys("ram9876");
		driver.findElement(By.cssSelector("input#loginpassword")).sendKeys("ram9876");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		// Website is taking time to load after login In
		Thread.sleep(2000);
		// getText() method is used for validation
		String text = driver.findElement(By.cssSelector("a#nameofuser")).getText();
		// Validation is done with assertEquals() method
		Assert.assertEquals(text, "Welcome ram9876");

	}

}
