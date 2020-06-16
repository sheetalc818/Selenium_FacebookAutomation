package Facebook.Facebook;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookDashboardPage extends BaseTest {

	Actions actions;

	@FindBy(xpath = "//i[@class='img sp_agxEBfLchAE_1_5x sx_c2311a']")
	WebElement element;

	@CacheLookup
	@FindBy(xpath = "//div[@class='_1mf _1mj']")
	WebElement text;
	
	@CacheLookup
	////i[@class='_4a0a img sp_agxEBfLchAE_1_5x sx_238a86']
	@FindBy(xpath = "//i[@class='_4a0a img sp_UuDhLXq87T9_1_5x sx_38ab1e']")
	WebElement addPhoto;
	
	@CacheLookup
	@FindBy(xpath="//i[@class='_21or img sp_agxEBfLchAE_1_5x sx_187545']")
	WebElement publicMenu;
	
	@CacheLookup
	@FindBy(xpath="//i[@class='mrs img sp_agxEBfLchAE_1_5x sx_304207']")
	WebElement friendBtn;
	
	@FindBy(xpath="//span[contains(text(),'Post')]")
	WebElement postBtn;
	
	@FindBy(xpath = "//div[@id='userNavigationLabel']")
	WebElement dropDownMenu;

	@FindBy(xpath = "//li[@class='_54ni navSubmenu _6398 _64kz __MenuItem']")
	WebElement logoutBtn;

	public FacebookDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	public void addingPost() throws InterruptedException, AWTException {
		actions.moveToElement(driver.findElement(By.xpath("//i[@class='img sp_UuDhLXq87T9_1_5x sx_7fa72e']"))).click().build().perform();
		Thread.sleep(30000);
		text.sendKeys("I am writing automation script for facebook");
		Thread.sleep(2000);

		actions.moveToElement(addPhoto).click().build().perform();
		Thread.sleep(500);

		fileUploadWithRobot();
		Thread.sleep(1500);
		
//		publicMenu.click();
//		Thread.sleep(1000);
//		
//		friendBtn.click();
//		Thread.sleep(1000);
		
//		actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Post')]"))).click().build().perform();
//		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//i[@class='img sp_dn9DXmMgPat_1_5x sx_7e45ec']")).click();
	}

	public void fileUploadWithRobot() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		StringSelection ss1 = new StringSelection("/home/sheetal/image/nature.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
	}

	public void logoutFromApplication() throws InterruptedException {
		dropDownMenu.click();
		Thread.sleep(1000);
		logoutBtn.click();
	}
}
