package resources;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base 
{
	public WebDriver driver;
	public WebDriver initializeDriver(String browserName) throws IOException
	{
	
		if(browserName.equals("chrome"))
		{
			// As SSL certificate got expired I used below to proceed to url
			DesiredCapabilities cap=DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			ChromeOptions c= new ChromeOptions();
			c.merge(cap);
			String path = System.getProperty("user.dir")+"\\Browsers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path);
			driver=new ChromeDriver(c);
		}
		else if (browserName.equals("firefox"))
		{
			DesiredCapabilities cap=DesiredCapabilities.firefox();
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			FirefoxOptions f= new FirefoxOptions();
			f.merge(cap);
			String path = System.getProperty("user.dir")+"\\Browsers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", path);
			driver=new FirefoxDriver(f);
			
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
		
	}

}
