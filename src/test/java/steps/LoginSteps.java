package steps;

import org.openqa.selenium.By;
import org.testng.Assert;
import hooks.DriverInstance;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends DriverInstance {



	@And("User clicks on the login button")
	public void userClicksOnTheLoginButton() {
		driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
	}

	@Given("User enter the username as {string}")
	public void userEnterTheUsernameAs(String username) {
		driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(username);
	}
	@Given("User enter the password as {string}")
	public void userEnterThePasswordAs(String password) {
		driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(password);
	}

	
	/*
	 * @And("User enter the username as ortoni") public void
	 * userEnterTheUsernameAsOrtoni() {
	 * driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("ortoni")
	 * ; }
	 * 
	 * @And("User enter the password as Pass1234") public void
	 * userEnterThePasswordAsPass1234() {
	 * driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(
	 * "Pass1234"); }
	 */
	@When("User click on the login button")
	public void userClickOnTheLoginButton() {
		driver.findElement(By.xpath("//button[@class='mdc-button mdc-button--raised mat-mdc-raised-button mat-primary mat-mdc-button-base']//span[@class='mdc-button__label'][normalize-space()='Login']")).click();
	}

	@Then("Login should be success")
	public void loginShouldBeSuccess() {
		String text =driver.findElement(By.xpath("//span[contains(text(),'ortoni')]")).getText();
		System.out.println(text);
	}

	/*
	 * @Given("User enter the username as vipin") public void
	 * userEnterTheUsernameAsVipin() {
	 * driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("vipin");
	 * }
	 * 
	 * @Given("User enter the password as Pass21") public void
	 * userEnterThePasswordAsPass21() {
	 * driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("Pass21")
	 * ; }
	 */
	@When("Login should fail")
	public void loginShouldFail() {
		String errorText = driver.findElement(By.xpath("//mat-error[normalize-space(text())='Username or Password is incorrect.']")).getText();
		Assert.assertEquals(errorText, "Username or Password is incorrect.");
	}



}
