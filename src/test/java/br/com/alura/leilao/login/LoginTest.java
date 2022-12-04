package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	private static final String LOGIN_FORM = "login-form";
	private static final String PASSWORD = "password";
	private static final String USERNAME = "username";
	private static final String FULANO = "fulano";
	private static final String USUARIO_LOGADO = "usuario-logado";
	private static final String LOGIN = "http://localhost:8080/login";
	private WebDriver browser;
	
	@BeforeAll
	static void beforeAll () {
		// Local do driver
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
	}

	@BeforeEach
	void beforeEach() {
		// Abre browser
		browser = new ChromeDriver();
		// Navega pelo site
		browser.navigate().to(LOGIN);
	}
	
	@AfterEach
	void afterEach() {
		// Fecha browser
		browser.quit();
	}
	
	@Test
	void deveriaEfetuarLoginComDadosValidos() {
		browser.findElement(By.id(USERNAME)).sendKeys(FULANO);
		browser.findElement(By.id(PASSWORD)).sendKeys("pass");
		browser.findElement(By.id(LOGIN_FORM)).submit();
					
		Assert.assertFalse(browser.getCurrentUrl().equals(LOGIN));
		Assert.assertEquals(FULANO, browser.findElement(By.id(USUARIO_LOGADO)).getText());
	}
	
	@Test
	void naoDeveriaLogarComDadosInvalidos() {
		browser.findElement(By.id(USERNAME)).sendKeys("fsdg");
		browser.findElement(By.id(PASSWORD)).sendKeys("123321");
		browser.findElement(By.id(LOGIN_FORM)).submit();
		
		Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
		Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
		Assert.assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id(USUARIO_LOGADO)));
	}
	
}
