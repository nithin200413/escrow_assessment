package assessment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Flipkart {

	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://flipkart.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Bluetooth Speakers",Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Brand']")).click();
		driver.findElement(By.xpath("//div[text()='boAt']")).click();
		driver.findElement(By.xpath("//div[text()='✕']/following-sibling::div"));
		
		driver.findElement(By.xpath("//div[text()='4★ & above']")).click();
		driver.findElement(By.xpath("//div[text()='✕']/following-sibling::div[text()='4★ & above']"));
		
		WebElement price=driver.findElement(By.xpath("//div[text()='Price -- Low to High']"));
		price.click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(price, "class", "dKeN6y"));
		
		List <WebElement> products=driver.findElements(By.xpath("//a[@class='pIpigb']"));

		products.get(0).click();


		String id=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String s:windows)
		{
			if(!s.equals(id))
			{
				driver.switchTo().window(s);
			}
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Available offers']")));
		WebElement offer=driver.findElement(By.xpath("//div[text()='Available offers']"));
		if(offer.isDisplayed())
		{
			driver.findElement(By.xpath("//span[contains(text(),'more offers')]")).click();
//			Thread.sleep(1000);
			
			List <WebElement> offers=driver.findElements(By.xpath("//div[@class='kXRMKo']/span"));
			System.out.println("Total "+offers.size()+" offers are available");
		}
		WebElement btn=driver.findElement(By.xpath("//button[text()='Add to cart']"));
		if(btn.isEnabled())
		{
			btn.click();
			Thread.sleep(2000);
			takeScreenshot(driver,"cart_result");
		}
		else
		{
			WebElement msg=driver.findElement(By.xpath("//div[contains(text(),'out of stock')]"));
			if(!btn.isEnabled()||msg.isDisplayed())
			{
				takeScreenshot(driver,"result");
			}
			System.out.println("Product unavailable - could not be added to cart");
		}
		driver.quit();

	}
	public static void takeScreenshot(WebDriver driver, String name) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\Screenshots\\"+name+".png");
		Files.copy(src, dest);
	}

}
