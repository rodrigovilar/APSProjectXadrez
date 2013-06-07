package xadrez;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Teste {
	public JogoXadrez cenario1(){
		JogoXadrez jogo = new JogoXadrez();
		return jogo;
	}
	public JogoXadrez cenario2(){
		JogoXadrez jogo = new JogoXadrez();
		//Peao
		jogo.movimentarPeca(1, 0, 3, 0);
		//Peao
		jogo.movimentarPeca(6, 1, 4, 1);
		//Peao
		jogo.movimentarPeca(1, 4, 2, 4);
		return jogo;
	}
	public JogoXadrez cenario3(){
		JogoXadrez jogo = new JogoXadrez();
		jogo.movimentarPeca(6, 4, 4, 4);
		jogo.movimentarPeca(1, 0, 4, 0);
		jogo.movimentarPeca(7, 5, 4, 2);
		jogo.movimentarPeca(1, 7, 2, 7);
		jogo.movimentarPeca(7, 3, 3, 7);
		jogo.movimentarPeca(1, 1, 3, 1);
		
		return jogo;
		
	}
	
	@Test
	public void testeTabuleiroDoJogo(){
		JogoXadrez jogo = new JogoXadrez();
		assertEquals(true,jogo.iniciarTabuleiro());
	}
	@Test
	public void testePecasNoJogo(){
		JogoXadrez jogo = cenario1();	
        /*Teste de posicionamento de Peças Brancas no Tabuleiro */        
		assertEquals("Torre", jogo.getTipoDaPeca(0, 0));
		assertEquals("Cavalo", jogo.getTipoDaPeca(0, 1));
		assertEquals("Bispo", jogo.getTipoDaPeca(0, 2));
		assertEquals("Rei", jogo.getTipoDaPeca(0, 3));
		assertEquals("Rainha", jogo.getTipoDaPeca(0, 4));
		assertEquals("Bispo", jogo.getTipoDaPeca(0, 5));
		assertEquals("Cavalo", jogo.getTipoDaPeca(0, 6));
		assertEquals("Torre", jogo.getTipoDaPeca(0, 7));
		assertEquals("Peao", jogo.getTipoDaPeca(1, 0));
		assertEquals("Peao", jogo.getTipoDaPeca(1, 1));
		assertEquals("Peao", jogo.getTipoDaPeca(1, 2));
		assertEquals("Peao", jogo.getTipoDaPeca(1, 3));
		assertEquals("Peao", jogo.getTipoDaPeca(1, 4));
		assertEquals("Peao", jogo.getTipoDaPeca(1, 5));
		assertEquals("Peao", jogo.getTipoDaPeca(1, 6));
		assertEquals("Peao", jogo.getTipoDaPeca(1, 7));
		/* Teste de posicionamento de Peças Pretas no Tabuleiro */        
		assertEquals("Torre", jogo.getTipoDaPeca(7, 0));
		assertEquals("Cavalo", jogo.getTipoDaPeca(7, 1));
		assertEquals("Bispo", jogo.getTipoDaPeca(7, 2));
		assertEquals("Rei", jogo.getTipoDaPeca(7, 3));
		assertEquals("Rainha", jogo.getTipoDaPeca(7, 4));
		assertEquals("Bispo", jogo.getTipoDaPeca(7, 5));
		assertEquals("Cavalo", jogo.getTipoDaPeca(7, 6));
		assertEquals("Torre", jogo.getTipoDaPeca(7, 7));
		assertEquals("Peao", jogo.getTipoDaPeca(6, 0));
		assertEquals("Peao", jogo.getTipoDaPeca(6, 1));
		assertEquals("Peao", jogo.getTipoDaPeca(6, 2));
		assertEquals("Peao", jogo.getTipoDaPeca(6, 3));
		assertEquals("Peao", jogo.getTipoDaPeca(6, 4));
		assertEquals("Peao", jogo.getTipoDaPeca(6, 5));
		assertEquals("Peao", jogo.getTipoDaPeca(6, 6));
		assertEquals("Peao", jogo.getTipoDaPeca(6, 7));
	}
	@Test
	public void testeMovimentaPeaoBranco(){
		JogoXadrez jogo = this.cenario1();
		assertTrue(jogo.movimentarPeca(1, 0, 2, 0));
		assertTrue(jogo.movimentarPeca(1, 1, 2, 1));
		assertTrue(jogo.movimentarPeca(1, 2, 2, 2));
		assertTrue(jogo.movimentarPeca(1, 3, 2, 3));
		assertTrue(jogo.movimentarPeca(1, 4, 2, 4));
		assertTrue(jogo.movimentarPeca(1, 5, 2, 5));
		assertTrue(jogo.movimentarPeca(1, 6, 2, 6));
		assertTrue(jogo.movimentarPeca(1, 7, 2, 7));
	}
	@Test
	public void testeMovimentaPecasPoderosasBrancas(){
		JogoXadrez jogo = this.cenario1();
		/*É necessário movimentar os Peoes brancos para liberar espaço no tabuleiro*/
		this.testeMovimentaPeaoBranco();
		/*Movimento do 1º Torre (Esqueda p/ Direita)*/
		assertTrue(jogo.movimentarPeca(0, 0, 1, 0));
		/*Como o Cavalo se move por 3 linhas é necessario Mover 1 Peao para liberar mais espaço no tabuleiro*/
		assertTrue(jogo.movimentarPeca(2, 2, 3, 2));
		/*Movimento do 1º Cavalo (Esqueda p/ Direita)*/
		assertTrue(jogo.movimentarPeca(0, 1, 2, 2));
		/*Movimento do 1º Bispo (Esqueda p/ Direita)*/
		assertTrue(jogo.movimentarPeca(0, 2, 1, 1));
		/*Movimento do 1º Rei (Esqueda p/ Direita)*/
		assertTrue(jogo.movimentarPeca(0, 3, 1, 2));
		/*Movimento do 1º Rainha (Esqueda p/ Direita)*/
		assertTrue(jogo.movimentarPeca(0, 4, 1, 3));
		/*Movimento do 2º Bispo (Esqueda p/ Direita)*/
		assertTrue(jogo.movimentarPeca(0, 5, 1, 4));
		/*Como o Cavalo se move por 3 linhas é necessario Mover 1 Peao para liberar mais espaço no tabuleiro*/
		assertTrue(jogo.movimentarPeca(2, 7, 3, 7));
		/*Movimento do 2º Cavalo (Esqueda p/ Direita)*/
		assertTrue(jogo.movimentarPeca(0, 6, 2, 7));
		/*Movimento do 2º Torre (Esqueda p/ Direita)*/
		assertTrue(jogo.movimentarPeca(0, 7, 1, 7));	
	}
	public void testeMovimentaPeaoPreto(){
		JogoXadrez jogo = this.cenario1();
		assertTrue(jogo.movimentarPeca(6, 0, 4, 0));
		assertTrue(jogo.movimentarPeca(6, 1, 4, 1));
		assertTrue(jogo.movimentarPeca(6, 2, 4, 2));
		assertTrue(jogo.movimentarPeca(6, 3, 4, 3));
		assertTrue(jogo.movimentarPeca(6, 4, 4, 4));
		assertTrue(jogo.movimentarPeca(6, 5, 4, 5));
		assertTrue(jogo.movimentarPeca(6, 6, 4, 6));
		assertTrue(jogo.movimentarPeca(6, 7, 4, 7));
	}
	public void testeMovimentaPecasPoderosasPretas(){
		JogoXadrez jogo = this.cenario1();
		/*É necessário movimentar os Peoes brancos para liberar espaço no tabuleiro*/
		this.testeMovimentaPeaoPreto();
		/*Movimento do 1º Torre (Esqueda p/ Direita)*/
		assertTrue(jogo.movimentarPeca(7, 0, 6, 0));
		/*Movimento do 1º Cavalo (Esqueda p/ Direita)*/
		assertTrue(jogo.movimentarPeca(7, 1, 5, 5));
		/*Movimento do 1º Bispo (Esqueda p/ Direita)*/
		assertTrue(jogo.movimentarPeca(7, 2, 6, 1));
		/*Movimento do 1º Rei (Esqueda p/ Direita)*/
		assertTrue(jogo.movimentarPeca(7, 3, 6, 2));
		/*Movimento do 1º Rainha (Esqueda p/ Direita)*/
		assertTrue(jogo.movimentarPeca(7, 4, 6, 3));
		/*Movimento do 2º Bispo (Esqueda p/ Direita)*/
		assertTrue(jogo.movimentarPeca(7, 5, 6, 4));
		/*Movimento do 2º Cavalo (Esqueda p/ Direita)*/
		assertTrue(jogo.movimentarPeca(7, 6, 5, 5));
		/*Movimento do 2º Torre (Esqueda p/ Direita)*/
		assertTrue(jogo.movimentarPeca(7, 7, 6, 7));
	}
	@Test
	public void testeMovimentoInvalidoPecasBrancas(){

		JogoXadrez jogo = this.cenario1();
		this.testeMovimentaPeaoBranco();
		//Movimentando Peao para uma posicao irregular
		//assertFalse(jogo.movimentarPeca(2, 0, 1, 1));
		//Movimentando Peao para uma posicao irregular
		//assertFalse(jogo.movimentarPeca(0, 0, 1, 1));
	}
	public void testeMovimentoInvalidoPecasPretas(){
		
	}
	@Test
	public void testeComerPecas(){

		//Carregando alguns movimentos dos peoes
		JogoXadrez jogo = this.cenario2();
		//Verificando se existe peca na posicao
		assertTrue(jogo.existePeca(4, 1));
		//Testando a Cor da peca na posicao
		assertEquals(CorDaPeca.PRETA, jogo.corPeca(4, 1));
		//Peao Branco comendo peao Preto
		assertTrue(jogo.movimentarPeca(3, 0, 4, 1));
		//Verificando se a posição 4,1 agora tem uma peça Branca
		assertEquals(CorDaPeca.BRANCA, jogo.corPeca(4,1));
		//Verificando se a posicão 4,0 tem um peao preto
		assertFalse(jogo.existePeca(4, 0));
		//Torre Branca comendo peao Preto
		assertTrue(jogo.movimentarPeca(0, 0, 6, 0));
		//verificando a cor da peça que estar na posicao 4,0
		assertEquals(CorDaPeca.BRANCA,jogo.corPeca(6, 0));
		//Verificando se a peca realmente foi movida
		assertFalse(jogo.existePeca(0, 0));
		//Movendo Cavalo Preto
		assertTrue(jogo.movimentarPeca(7, 1, 5, 0));
		//Necessario mover a peca 4,1 para o bispo comer o cavalo
		assertTrue(jogo.existePeca(4, 1));
		assertTrue(jogo.movimentarPeca(4, 1, 5, 1));
		//Bispo comendo o Cavalo
		assertTrue(jogo.movimentarPeca(0, 5, 5, 0));
		assertEquals(CorDaPeca.BRANCA,jogo.corPeca(5, 0));
		
	}
	
	
	public void testeXequeMate(){

		JogoXadrez jogo = this.cenario3();
		jogo.movimentarPeca(4, 2, 1, 5);
	}
	public void testeRoque(){

		
	}
	
	

}





