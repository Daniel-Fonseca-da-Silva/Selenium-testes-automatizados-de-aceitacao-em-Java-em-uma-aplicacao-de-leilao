package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	
	private static final String LOGIN_FORM = "login-form";
	private static final String LOGIN = "http://localhost:8080/login";
	private WebDriver browser;
	
	public LoginPage() {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		this.browser = new ChromeDriver();
		this.browser.navigate().to(LOGIN);
	}

	public void fecharBrowser() {
		this.browser.quit();
	}

	public void preencherFormularioDeLogin(String username, String password) {
		browser.findElement(By.id("username")).sendKeys(username);
		browser.findElement(By.id("password")).sendKeys(password);
	}

	public void submeteFormulario() {
		browser.findElement(By.id(LOGIN_FORM)).submit();
	}

	public boolean isPaginaDeLogin() {
		return browser.getCurrentUrl().equals(LOGIN);
	}

	public String getNomeUsuarioLogado() {
		try {
			return browser.findElement(By.id("usuario-logado")).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
		
	}

	public void navegaParaPaginaDeLances() {
		this.browser.navigate().to("http://localhost:8080/leiloes/2");
	}

	public boolean contemTexto(String texto) {
		return browser.getPageSource().contains(texto);
	}

	public boolean PaginaDeLoginComDadosInvalidos() {
		return browser.getCurrentUrl().equals(LOGIN + "?error");
	}
	
}
