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
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTestClass {
	
	WebDriver driver;
	
	@Before
	public void choixNav() {
		driver = TechnicalTools.choixNav(ENavigators.Opera);
	}
	
	@Test
	public void premierTest() {
		driver.get("https://lemonde.fr");
		
		System.out.println(driver.getTitle());
	}
	
	@After
	public void fermetureNav() {
		driver.quit();
	}

}
