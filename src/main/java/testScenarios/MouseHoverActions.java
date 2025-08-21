package testScenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHoverActions {

	WebDriver driver;
	
	@Test(priority=1)
	public void dragAndDrop() throws InterruptedException
	{
		driver=new EdgeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		//action.dragAndDrop(drag, drop).build().perform();
		action.clickAndHold(drag).moveToElement(drop).release(drag).build().perform();
		Thread.sleep(5000);
		
		driver.quit();
		
	}
	
	@Test(priority=2)
	public void datePicker() throws InterruptedException
	{
		driver=new EdgeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Integer exp_yr=2026;
		String exp_month="May";
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		
		while(true)
		{
			String act_month=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
			String act_year=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[2]")).getText();
			System.out.println(act_month+"\t"+act_year);
			if(act_month.equals(exp_month) && act_year.equals(String.valueOf(exp_yr)))
			{
				//Day to be selected
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[4]/a")).click();
				break;
			}
			if(exp_yr<2025)
			{
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
			}
			else
			{
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
				
			}
			//Thread.sleep(2000);	
			
			
		}
		driver.quit();
		
		
	}
}
