package helloworldjenkins;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class helloworld1 {

	static WebDriver driver;

	@Test
	public void Hello() {
		// set path to chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "E:\\RMS\\RMS_Dec-22\\src\\test\\resources\\drivers\\chromedriver.exe");
		// create chrome instance
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://inidrrmstsrv01:8080/rms");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("RMS | Dashboard")) {
			System.out.println("User is loged in into RMS app");
			String name = driver.findElement(By.xpath("//a[@class='dropdown-toggle']/span")).getText();
			if (name.equalsIgnoreCase("saajan soni")) {
				System.out.println("Logged in user is : " + name);
			} else {
				System.out.println("Invalid user");
			}
		} else {
			System.out.println("user is not logged into rms");
		}
	}

}
