package com.fitPeo;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FitPeo {
	public static void main(String[] args) throws InterruptedException, Throwable {
		String required = "$110700";
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://fitpeo.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement RevCal_Element = driver.findElement(By.xpath("//div[text()='Revenue Calculator']"));
		RevCal_Element.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0, 2000);");   		

		WebElement Scroll_Element = driver.findElement(By.xpath("//div[@class='MuiBox-root css-19zjbfs']"));

		js.executeScript("arguments[0].scrollIntoView();",Scroll_Element);

		Actions ac = new Actions(driver);
		WebElement DragElement_820 = driver.findElement(By.xpath("//input[@data-index='0']"));
		Thread.sleep(2000);

       ac.clickAndHold(DragElement_820).moveToElement(DragElement_820, 94, 0).release().perform();
       Robot robot = new Robot();
       robot.keyPress(KeyEvent.VK_LEFT);
       robot.keyPress(KeyEvent.VK_LEFT);
		WebElement textbox = driver.findElement(By.xpath("//input[@type='number']"));
		textbox.clear();
		textbox.sendKeys(Keys.NUMPAD5);
		WebElement Choice_091 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]"));
		Choice_091.click();
		WebElement Choice_53 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]"));
		Choice_53.click();
		WebElement Choice_54 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]"));
		Choice_54.click();
		WebElement Choice_74 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[8]"));
		Choice_74.click();
		
		String validation = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-1bl0tdj'])[4]")).getText();
		System.out.println(validation);
		driver.quit();
	}

}
