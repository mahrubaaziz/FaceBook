package helperFB;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class fbBrowserFactory {

	public static WebDriver startApplication(String browserName, String appURL)
		{
		WebDriver driver=null;
		
		if(browserName.equalsIgnoreCase("FireFox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Chrome"))
		{//we  are setting the driver and then after getting it from directory
			System.setProperty("webdriver,chrome,driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			driver= new InternetExplorerDriver();
		}
		return driver;
	}
}
