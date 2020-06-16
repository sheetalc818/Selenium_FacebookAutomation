package Facebook.Facebook;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver = null;
	
	public static void initialize() throws InterruptedException, IOException 
	{
		
		ChromeOptions options = new ChromeOptions();
		//WebDriverManager.chromedriver().setup();
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("--disable-notifications");
		//options.addArguments("--headless");
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver");
		
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}
}


