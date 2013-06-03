package xadrez;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Teste {
	JogoXadrez jogo = new JogoXadrez();
	Peao peao = (Peao) jogo.getTabuleiro().getQuadrado(1, 0).getPeca();
	@Test
	public void teste_criar_Jogo(){
		jogo = new JogoXadrez();	
	}	
	@Test
	public void teste_Tabuleiro(){
		assertEquals(true,jogo.iniciarTabuleiro());
	}
	@Test
	public void teste_Peao_Na_Posicao_Inicial(){
		assertEquals(true, peao.isEstaNaPosicaoInicial());
	}	
	@Test
	public void teste_Peao_Inimigo(){
		assertFalse(peao.pecaEhAdversaria(peao));
	}
	@Test
	public void teste_Movimento_Valido_Peao(){
		assertTrue(jogo.movimentoEhValido(2, 0, peao));
	}
	@Test
	public void teste_Movimento_Invalido_Peao(){
		assertEquals(false, jogo.movimentoEhValido(2, 1, peao));
	}
	
	
	

}
