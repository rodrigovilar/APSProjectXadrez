package xadrez;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Teste {
	JogoXadrez jogo = new JogoXadrez();	
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
		Peao peao = (Peao) jogo.getTabuleiro().getQuadrado(1, 0).getPeca();
		assertEquals(true, peao.isEstaNaPosicaoInicial());
	}	
	@Test
	public void teste_Peao_Inimigo(){
		Peao peao = (Peao) jogo.getTabuleiro().getQuadrado(1, 0).getPeca();
		jogo.moverPeca(peao, 3, 0);
		assertFalse(peao.pecaEhAdversaria(peao));
	}
	
	

}
