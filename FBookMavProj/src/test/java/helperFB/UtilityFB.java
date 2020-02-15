package helperFB;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UtilityFB {
	//using method overloading to find element
	public static WebElement waitForWebElement(WebDriver driver, By element)
	{	//initializing webDriverWait element
		WebDriverWait wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return driver.findElement(element);
	}
	public static WebElement waitForWebElement(WebDriver driver, WebElement Element)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(Element));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
		return Element;
	}
	//validating message providing  by the locactor as per parameter
	public static void validateMessage(WebElement element, String msg)
	{	//the message pop up that need to be verified
		Assert.assertEquals(element.getText(), msg);
	}
	
	public static void validatePartialText(WebElement element, String msg)
	{
		Assert.assertTrue(element.getText().contains(msg));//we are validating partial message we are in the page so donot need the driver
	}

	public static void validateContainTitle(WebDriver driver, String title)
	{
		boolean status= new WebDriverWait(driver,30).until(ExpectedConditions.titleIs(title));//validating title when boolean is true
		Assert.assertTrue(status);
	}
	public static void validateContainsTitle(WebDriver driver, String url)
	{
		boolean status =new WebDriverWait(driver, 30).until(ExpectedConditions.titleContains(url));
		Assert.assertTrue(status);//we are just going to cacpture the url of the page and validate it
	}
	
	public static void verrifyCurrentURL(WebDriver driver,String url)//verifying are we in a correct page or not
	{
		boolean status= new WebDriverWait(driver, 30).until(ExpectedConditions.urlContains(url));
		Assert.assertTrue(status);//verify we ar ein the correct page
	}
	
	public void dismissAlert(WebDriver driver)
	{
		new WebDriverWait(driver,30).until(ExpectedConditions.alertIsPresent()).dismiss();//if any alert msg pop up that will dismiss
	}
	
	public void acceptAlert(WebDriver driver)
	{
		new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent()).accept();//accept the alert
	}
	
	public void verfyAlertMsg(WebDriver driver, String msg)//taking the alert message as text
	{
		boolean status = new WebDriverWait(driver,30).until(ExpectedConditions.alertIsPresent()).getText().equalsIgnoreCase(msg);
	}
	
	public void ndleFrame(WebDriver driver, int index)
	{
		new WebDriverWait(driver,30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}
	public static String captureScreenshot(WebDriver driver)
	{
		String time=getTime();
		String dest=System.getProperty("user.dir")+"Screenshot/FB"+time+".png";//create a screenshot obj
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src= ts.getScreenshotAs(OutputType.FILE);
		
		try{
		org.openqa.selenium.io.FileHandler.copy(src, new File(dest));
		}catch(IOException e){
			System.out.println("Screenshot Failed"+e.getMessage());
			
		}
		return dest;
	}
	
	public static String getTime() //create a method for getTime
	{
		DateFormat dateFormat= new SimpleDateFormat("HH_mm_ss_MM_yyyy");
		return dateFormat.format(new Date());
	}
}
