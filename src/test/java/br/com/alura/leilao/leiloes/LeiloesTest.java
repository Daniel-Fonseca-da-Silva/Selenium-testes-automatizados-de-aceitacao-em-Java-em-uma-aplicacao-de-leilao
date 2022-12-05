package br.com.alura.leilao.leiloes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	
	private LeiloesPage paginaDeLeiloes;
	
	
	
	@AfterEach
	void afterEach() {
		// Fecha browser
		this.paginaDeLeiloes.fecharBrowser();
	}
	
	@Test
	void deveriaCadastrarLeilao() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencherFormularioDeLogin("fulano", "pass");
		paginaDeLeiloes = paginaDeLogin.submeteFormulario();
		CadastroLeilaoPage paginaDeCastro = paginaDeLeiloes.carregarFormulario();
		
	}
	
}
