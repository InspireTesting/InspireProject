package frameworkBase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;

public class FrameworkBase {

	public static WebDriver driver = null;
	public static Properties prop = null;
	public static Select select = null;
	public static Alert alert = null;
	public static Action action = null;
	public static String path = System.getProperty("user.dir");
	public static Logger log = Logger.getLogger(FrameworkBase.class);

	public FrameworkBase() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(path + "/src/main/java/config/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void launchTheBrowser(String browsers) {

		if (browsers.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", path + "/Browser/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browsers.equalsIgnoreCase("gecko")) {

			System.setProperty("webdriver.gecko.driver", path + "/Browser/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browsers.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver", path + "/Browser/msedgedriver.exe");
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();

		driver.get(prop.getProperty("url"));

		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public static void launchTheBrowser() {

		System.setProperty("webdriver.chrome.driver", path + "/Browser/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(prop.getProperty("url"));

		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

}
