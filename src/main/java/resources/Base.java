package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
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

			//Belows to your local browser
			ChromeOptions c= new ChromeOptions();
			c.merge(cap);
			//FirefoxOptions f=new FirefoxOptions();
			//f.merge(ch);
			String path = System.getProperty("user.dir")+"\\Browsers\\chromedriver.exe";
			//File f=new File(path);
			System.setProperty("webdriver.chrome.driver", path);
			driver=new ChromeDriver(c);
		}
		else if (browserName.equals("firefox"))
		{
			DesiredCapabilities cap=DesiredCapabilities.firefox();
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			//Belows to your local browser
			FirefoxOptions f= new FirefoxOptions();
			f.merge(cap);
			//FirefoxOptions f=new FirefoxOptions();
			//f.merge(ch);
			String path = System.getProperty("user.dir")+"\\Browsers\\geckodriver.exe";
			//File f=new File(path);
			System.setProperty("webdriver.gecko.driver", path);
			driver=new FirefoxDriver(f);
			
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
		
	}

}
