package xadrez;

import org.junit.Test;

public class Teste {
	
	@Test
	public void criar_Jogo(){
		JogoXadrez jogo = new JogoXadrez();	
	}
	@Test
	public void teste_Tabuleiro(){
		JogoXadrez jogo = new JogoXadrez();
		jogo.iniciarTabuleiro();
	}

}
