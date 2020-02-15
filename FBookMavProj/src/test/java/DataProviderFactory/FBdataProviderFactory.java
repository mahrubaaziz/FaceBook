package DataProviderFactory;



public class FBdataProviderFactory {
	
	public static FBConfigDataProvider getConfig()
	{
		FBConfigDataProvider config =new FBConfigDataProvider();//its a config class ref obj 
		return config; // returning config
	}
	
	public static ExcelFBDataProvider getExcel()
	{
		ExcelFBDataProvider excel =new ExcelFBDataProvider();
		return excel;
	}

}
