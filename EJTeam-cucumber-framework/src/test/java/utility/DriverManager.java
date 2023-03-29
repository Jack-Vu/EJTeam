package utility;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

	private static final String DRIVER_MAC = "src/test/resources/drivers/chromedriver_mac";
	private static final String DRIVER_MAC1 = "src/test/resources/drivers/chromedriver_mac1";
	private static final String DRIVER_WINDOWS = "src/test/resources/drivers/chromedriver_windows.exe";
	private static WebDriver driver;

	private DriverManager() {
	}

	public static WebDriver getInstance() {
		try {
			if (driver == null) {
				driver = new ChromeDriver();
			}
			System.setProperty("webdriver.chrome.driver", getDriverPath());
			ChromeOptions cOption = new ChromeOptions();
			cOption.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(cOption);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false, e.getMessage());
		}
		return driver;
	}
	
	public static void tearDown() {
		if(driver != null) {
			driver.quit();
			driver = null; 
		}
	}

	private static String getDriverPath() throws Exception {
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name").toLowerCase();
		String archType = prop.getProperty("os.arch").toLowerCase();

		if (os.startsWith("mac")) {
			if (archType.startsWith("aarch64")) {
				return DRIVER_MAC1;
			} else {
				return DRIVER_MAC;
			}
		} else if (os.startsWith("windows")) {
			return DRIVER_WINDOWS;
		} else {
			throw new Exception("No driver avaliable for you operating system");
		}
	}
}
