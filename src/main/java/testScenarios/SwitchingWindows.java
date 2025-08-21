package testScenarios;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchingWindows {

	WebDriver driver;
	@Test
	public void switchWin()
	{
		driver=new EdgeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		Set<String> allWinIds=driver.getWindowHandles();
		System.out.println("total window id="+allWinIds.size());
		String win1=null;
		String win2=null;
		Iterator<String> itr=allWinIds.iterator();
		win1=itr.next();
		win2=itr.next();
		System.out.println("Win1 session id="+win1);
		System.out.println("Win2 session id="+win2);
		System.out.println("Window 1 title="+driver.getTitle());
		driver.switchTo().window(win2);
		System.out.println("Window 2 title="+driver.getTitle());
		boolean chkBtn=driver.findElement(By.xpath("//*[@id=\"tnb-login-btn\"]/span[1]")).isEnabled();
		Assert.assertEquals(chkBtn, true);
		driver.quit();// quit() closes all the windows opened by the driver object and destroys the driver but close() will
		// close only the focused window
		
	}
}
