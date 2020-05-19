package Facebook.Facebook;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {
	@FindBy(id = "email")
	WebElement username;

	@FindBy(id = "pass")
	WebElement password;

	@FindBy(id = "loginbutton")
	WebElement loginBtn;

	WebDriver driver;

	public FacebookLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void facebookLoginPage() throws InterruptedException, AWTException {

		username.sendKeys("your facebook username");
		password.sendKeys("your facebook password");

		loginBtn.click();
		Thread.sleep(1000);
	}
}
