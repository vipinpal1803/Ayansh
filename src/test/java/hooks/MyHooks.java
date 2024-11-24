package hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class MyHooks extends DriverInstance {
	@Before
	public void beforeScenario(Scenario scenario)
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://bookcart.azurewebsites.net");
		driver.manage().window().maximize();
		//System.out.println(driver.getTitle());
	}
	
	@After
	public void afterScenario(Scenario scenario)
	{
		boolean failed = scenario.isFailed();
		System.out.println("is Failed? "+failed);
		
		if (failed) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
		driver.quit();
	}
	
	@BeforeStep
	public void beforeStep(Scenario scenario)
	{
		
	}
	
	@AfterStep
	public void afterStep(Scenario scenario)
	{
		
	}
	

}
