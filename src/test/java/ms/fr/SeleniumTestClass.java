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

		// Deux façons de valider, soit touche Entrée, soit on clique sur le bouton.
		champ_username.sendKeys(Keys.ENTER);
		// driver.findElement(By.xpath("//input[@id='login']")).click();

		assertEquals("ABC", driver.findElement(By.xpath("//div[@id='WelcomeContent']/div/span")).getText());
		assertEquals("Sign Out", driver.findElement(By.xpath("//div[@id='MenuContent']/a[position()=2]")).getText());

		driver.findElement(By.xpath("//div[@id='SidebarContent']/a[@href='/catalog/categories/FISH']")).click();

		assertEquals("Fish", driver.findElement(By.xpath("//div[@id='Catalog']/h2")).getText());

		driver.findElement(By.xpath("//a[@href='/catalog/products/FI-SW-02']")).click();
		driver.findElement(By.xpath("//a[@class='Button']")).click();

		assertEquals("Shopping Cart", driver.findElement(By.xpath("//div[@id='Cart']/h2")).getText());

		WebElement champ_quantity = driver.findElement(By.xpath("//input[@id='lines0.quantity']"));
		champ_quantity.clear();
		champ_quantity.sendKeys("2");
		driver.findElement(By.xpath("//input[@type='submit'][@name='update']")).click();

		String resultat = driver.findElement(By.xpath("//table/tbody/tr[position()=2]/td[position()=7]/span"))
				.getText();
		double resultat_num = Double.parseDouble(resultat);
		String valeur = driver.findElement(By.xpath("//table/tbody/tr[position()=2]/td[position()=6]/span")).getText();
		double valeur_num = Double.parseDouble(valeur);
		assertEquals(resultat_num, 2 * valeur_num, 0.0);
	}

	@After
	public void fermetureNav() {
		driver.quit();
	}

}
