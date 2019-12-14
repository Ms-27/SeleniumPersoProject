package ms.fr;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTestClass {

	WebDriver driver;
	private WebElement page;

	@Before
	public void choixNav() {
		driver = TechnicalTools.choixNav(ENavigators.Opera);
	}

	@Ignore
	public void premierTest() {
		driver.get("https://lemonde.fr");

		System.out.println(driver.getTitle());
	}
	
	@Test
	public void testJpetStore() {
		driver.get("https://jpetstore.cfapps.io/catalog");
		
		driver.findElement(By.xpath("//div[@id='Menu']/div/a[@href='/login']")).click();
		
		WebElement champ_username = driver.findElement(By.name("username"));
		champ_username.clear();
		champ_username.sendKeys("j2ee");
		
		WebElement champ_pass = driver.findElement(By.name("password"));
		champ_pass.clear();
		champ_pass.sendKeys("j2ee");
		
		//Deux façons de valider, soit touche Entrée, soit on clique sur le bouton.
		champ_username.sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//input[@id='login']")).click();
		
		assertEquals("ABC", driver.findElement(By.xpath("//div[@id='WelcomeContent']/div/span")).getText());
		
		assertEquals("Sign Out", driver.findElement(By.xpath("//div[@id='MenuContent']/a[position()=2]")).getText());
	}

	@After
	public void fermetureNav() {
		driver.quit();
	}

}
