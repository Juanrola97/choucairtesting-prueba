package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Screens.Empleos;

public class EmpleosTest {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	public void navegationToEmpleos() throws InterruptedException {
		acceptedCookies();
		goToEmpleos();
		
		Thread.sleep(2000);
	}

	@Test
	public void serChouCairInfo() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		navegationToEmpleos();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Empleos.SER_CHOUCAIR)));

		WebElement ser_choucair = driver.findElement(By.xpath(Empleos.SER_CHOUCAIR));
		ser_choucair.click();
		
		Thread.sleep(2000);

	}

	@Test
	public void convocatoriasInfo() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		navegationToEmpleos();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Empleos.CONVOCATORIAS)));

		WebElement convocatorias = driver.findElement(By.xpath(Empleos.CONVOCATORIAS));
		convocatorias.click();

		Thread.sleep(5000);
	}
	
	@Test
	public void convocatoriasSearch() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		navegationToEmpleos();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Empleos.CONVOCATORIAS)));

		WebElement convocatorias = driver.findElement(By.xpath(Empleos.CONVOCATORIAS));
		convocatorias.click();
		
		Thread.sleep(2000);
		
		WebElement empleos_disponibles =  driver.findElement(By.xpath(Empleos.TITTLE_EMPLEOS_DISPONIBLES));
		
		WebElement palabra_clave =  driver.findElement(By.xpath(Empleos.INPUT_PALABRA_CLAVE));
		palabra_clave.sendKeys("analista");
		
		WebElement ubicacion =  driver.findElement(By.xpath(Empleos.INPUT_UBICACION));
		ubicacion.sendKeys("bogota");
		
		Thread.sleep(2000);
		
		WebElement button_search =  driver.findElement(By.xpath(Empleos.BUTTON_BUSCAR_TRABAJO));
		button_search.click();
		
		Thread.sleep(2000);
		
	}
	
	@Test
	public void praparseAplicarTest() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		navegationToEmpleos();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Empleos.PREPARSE_PARA_APLICAR)));
		
		WebElement preparse_aplicar = driver.findElement(By.xpath(Empleos.PREPARSE_PARA_APLICAR));
		preparse_aplicar.click();
		
		Thread.sleep(2000);
	}

	public void acceptedCookies() throws InterruptedException {

		WebElement petition_cookies = driver.findElement(By.xpath(Empleos.PETITION_COOKIES));
		if (petition_cookies.isEnabled()) {
			WebElement button_accept_cookies = driver.findElement(By.xpath(Empleos.BUTTON_ACCEPT_COOKIES));
			button_accept_cookies.click();
		}
	}

	public void goToEmpleos() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement button_empleos = driver.findElement(By.xpath(Empleos.BUTTON_EMPLEOS));
		button_empleos.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Empleos.IMAGE_WELCOME_EMPLEOS)));
	}

}
