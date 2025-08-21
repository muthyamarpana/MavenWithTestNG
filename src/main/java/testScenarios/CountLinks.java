package testScenarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CountLinks {
WebDriver driver;
FileReader fr;
BufferedReader br;
String src="C:\\sel\\sel@10PM(IST)_new\\TestLinks.txt";
ArrayList<String> exp_links=new ArrayList<String>();
	@Test
	public void VerifyLinkUrls() throws IOException
	{
		fr=new FileReader(src);
		br=new BufferedReader(fr);
		String li=null;
		while((li=br.readLine())!=null)
		{
			exp_links.add(li);
		}
		System.out.println("total expected links="+exp_links.size());
		driver=new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		System.out.println("total number of links="+allLinks.size());
		int i=0;
		for(WebElement link:allLinks)
		{
			
			System.out.println(link.getAttribute("href"));
			System.out.println(exp_links.get(i));
			if(exp_links.get(i).equals(link.getAttribute("href")))
			{
				System.out.println("Link Matched..");
				
			}
			else
			{
				System.out.println("Link not Matched...");
			}
			i++;
			if(i==25)
			{
				break;
			}
			
		}
		driver.quit();
		
	}
}
