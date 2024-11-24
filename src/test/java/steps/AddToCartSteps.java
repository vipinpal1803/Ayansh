package steps;

import org.openqa.selenium.By;
import org.testng.Assert;
import hooks.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartSteps extends DriverInstance {




	@Given("user login into the application with {string} and {string}")
	public void userLoginIntoTheApplicationWithAnd(String username, String password) {
		driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys(password);

	}
	@Given("user search for a {string}")
	public void userSearchForA(String book) throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Search books or authors']")).sendKeys(book);
		driver.findElement(By.xpath("//span[@class='mdc-list-item__primary-text']")).click();
		Thread.sleep(5000);

	}
	@When("user add the book to the cart")
	public void userAddTheBookToTheCart() throws InterruptedException {
		driver.findElement(By.xpath("//span[normalize-space(text())='Add to Cart']")).click();
		Thread.sleep(8000);
	}
	@Then("the cart badge should be updated")
	public void theCartBadgeShouldBeUpdated() {
		String text = driver.findElement(By.id("mat-badge-content-0")).getText();
		System.out.println("No.of books in cart: "+text);
		Assert.assertEquals(Integer.parseInt(text) > 0, true);

	}


}
