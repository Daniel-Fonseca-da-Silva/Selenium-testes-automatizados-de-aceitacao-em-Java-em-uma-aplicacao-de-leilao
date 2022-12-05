package br.com.alura.leilao.leiloes;

import org.openqa.selenium.WebDriver;

public class LeiloesPage {
	
	private WebDriver browser;
	private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
	
	public LeiloesPage(WebDriver browser) {
		this.browser = browser;
	}

	public void fecharBrowser() {
		this.browser.quit();
	}

	public CadastroLeilaoPage carregarFormulario() {
		this.browser.navigate().to(URL_CADASTRO_LEILAO);
		return new CadastroLeilaoPage(browser);
	}
		
}
