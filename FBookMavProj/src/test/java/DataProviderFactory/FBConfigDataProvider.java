package DataProviderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FBConfigDataProvider {
	
	Properties pro; //creating prop file making an obj of it
	
	//create  a constructor
	public FBConfigDataProvider(){
		
		try{  //in case cannot read the file
			pro=new Properties();
			//load the file from directory and read them
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"FBConfigarationFile/config.properties")));
		}catch(IOException e){
			System.out.println("Unanle to load properties file"+e.getMessage()); //catch the exception with this message
		}
	}
	
	public String getBrowser()//method to get the browser
	{
		return pro.getProperty("browser");
	}
	public String getStagingURL()//method to get the url
	{
		return pro.getProperty("browser");//to get the browser property
	}
	public String getValueFromProperties(String key)
	{
		return pro.getProperty(key);
	}

}
