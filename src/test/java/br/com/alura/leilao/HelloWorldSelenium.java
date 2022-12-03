package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {
	
	@Test
	public void hello() {
		// Local do driver
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		// Abre o browser
		WebDriver browser = new ChromeDriver();
		// Navega pela site
		browser.navigate().to("http://localhost:8080/leiloes");
		// Fecha o navegador
		browser.quit();
	}

}
