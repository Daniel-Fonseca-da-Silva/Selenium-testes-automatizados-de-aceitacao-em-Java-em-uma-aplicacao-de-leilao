package br.com.alura.leilao.leiloes;

import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {
	
	private WebDriver browser;
	
	public CadastroLeilaoPage(WebDriver browser) {
		this.browser = browser;
	}

	public void fecharBrowser() {
		this.browser.quit();
	}
		
}
