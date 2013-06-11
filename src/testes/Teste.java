package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import jogoDeXadrez.CorDaPeca;

import org.junit.Test;

import fachada.JogoXadrez;

public class Teste {
	public JogoXadrez cenario0() {
		JogoXadrez jogo = new JogoXadrez();
		jogo.movimentarPeca(1, 1, 2, 1);
		jogo.movimentarPeca(6, 3, 5, 3);
		jogo.movimentarPeca(7, 4, 3, 0);

		return jogo;
	}
	
	public JogoXadrez cenario1() {
		JogoXadrez jogo = new JogoXadrez();
		return jogo;
	}

	public JogoXadrez cenario2() {
		JogoXadrez jogo = new JogoXadrez();
		jogo.movimentarPeca(1, 0, 2, 0);
		jogo.movimentarPeca(2, 0, 3, 0);
		jogo.movimentarPeca(1, 2, 2, 2);
		jogo.movimentarPeca(1, 1, 2, 1);
		jogo.movimentarPeca(2, 2, 3, 2);
		return jogo;
	}

	public JogoXadrez cenario3() {
		JogoXadrez jogo = new JogoXadrez();
		assertTrue(jogo.movimentarPeca(1, 4, 2, 4));
		assertTrue(jogo.movimentarPeca(6, 5, 5, 5));
		assertTrue(jogo.movimentarPeca(1, 2, 2, 2));
		assertTrue(jogo.movimentarPeca(7, 4, 4, 7));
		return jogo;

	}

	public JogoXadrez cenario4() {
		JogoXadrez jogo = new JogoXadrez();
		jogo.movimentarPeca(1, 0, 2, 0);
		jogo.movimentarPeca(2, 0, 3, 0);
		jogo.movimentarPeca(3, 0, 4, 0);
		jogo.movimentarPeca(6, 1, 5, 1);

		return jogo;
	}

	public JogoXadrez cenario5() {
		JogoXadrez jogo = new JogoXadrez();
		assertTrue(jogo.movimentarPeca(1, 0, 2, 0));
		assertTrue(jogo.movimentarPeca(2, 0, 3, 0));
		assertTrue(jogo.movimentarPeca(0, 0, 1, 0));
		assertTrue(jogo.movimentarPeca(1, 0, 2, 0));
		assertTrue(jogo.movimentarPeca(2, 0, 2, 1));
		assertTrue(jogo.movimentarPeca(2, 1, 3, 1));
		assertTrue(jogo.movimentarPeca(6, 6, 5, 6));
		assertTrue(jogo.movimentarPeca(5, 6, 4, 6));
		assertTrue(jogo.movimentarPeca(6, 7, 5, 7));
		assertTrue(jogo.movimentarPeca(5, 7, 4, 7));
		assertTrue(jogo.movimentarPeca(6, 0, 5, 0));
		assertTrue(jogo.movimentarPeca(5, 0, 4, 0));

		return jogo;
	}

	public JogoXadrez cenario6() {
		JogoXadrez jogo = this.cenario5();
		assertTrue(jogo.movimentarPeca(1, 6, 2, 6));
		assertTrue(jogo.movimentarPeca(7, 1, 5, 2));

		return jogo;

	}
	
	public JogoXadrez cenario7() {
        JogoXadrez jogo = new JogoXadrez();
        assertTrue(jogo.movimentarPeca(1, 2, 2, 2));
        assertTrue(jogo.movimentarPeca(7, 1, 5, 2));

        return jogo;

	}
	
	public JogoXadrez cenario8() {
         JogoXadrez jogo = this.cenario0();
         assertTrue(jogo.movimentarPeca(0, 1, 2, 2));
         assertTrue(jogo.movimentarPeca(6, 6, 5, 6));
         assertTrue(jogo.movimentarPeca(1, 7, 2, 7));
         assertTrue(jogo.movimentarPeca(7, 5, 6, 6));
         assertTrue(jogo.movimentarPeca(2, 7, 3, 7));
         assertTrue(jogo.movimentarPeca(6, 6, 2, 2));
         
         return jogo;
 }

	@Test
	public void testeTabuleiroDoJogo() {
		JogoXadrez jogo = new JogoXadrez();
		assertEquals(true, jogo.iniciarTabuleiro());
	}

	@Test
	public void testeCorPrimeiroJogador() {
		JogoXadrez jogo = this.cenario1();
		assertEquals(CorDaPeca.BRANCA, jogo.getJogadorDaVez());
	}

	@Test
	public void testeExisteAdversarios() {
		JogoXadrez jogo = this.cenario1();
		assertEquals(CorDaPeca.BRANCA, jogo.getJogadorDaVez());
		jogo.alteraVez();
		assertEquals(CorDaPeca.PRETA, jogo.getJogadorDaVez());
	}

	@Test
	public void testePecasNoJogo() {
		JogoXadrez jogo = cenario1();
		/* Teste de posicionamento de Peças Brancas no Tabuleiro */
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
	public void testeMovimentaPeaoBranco() {
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
	public void testeMovimentaPeaoPreto() {
		JogoXadrez jogo = this.cenario1();
		assertTrue(jogo.movimentarPeca(6, 0, 5, 0));
		assertTrue(jogo.movimentarPeca(5, 0, 4, 0));
		assertTrue(jogo.movimentarPeca(6, 1, 5, 1));
		assertTrue(jogo.movimentarPeca(6, 2, 5, 2));
		assertTrue(jogo.movimentarPeca(6, 3, 5, 3));
		assertTrue(jogo.movimentarPeca(6, 4, 5, 4));
		assertTrue(jogo.movimentarPeca(6, 5, 5, 5));
		assertTrue(jogo.movimentarPeca(6, 6, 5, 6));
		assertTrue(jogo.movimentarPeca(6, 7, 5, 7));
	}

	@Test
	public void testaMovimentoValidoParaCavaloNaPosicao() {
		JogoXadrez jogo = this.cenario1();
		assertEquals(true, jogo.movimentoValido(0, 1, 2, 2));
		assertEquals(true, jogo.movimentoValido(0, 1, 2, 0));
	}

	@Test
	public void testaMovimentoInvalidoParaCavaloNaPosicao() {
		JogoXadrez jogo = this.cenario1();
		assertEquals(false, jogo.movimentoValido(0, 1, 0, 2));
		assertEquals(false, jogo.movimentoValido(0, 1, 2, 3));
	}

	@Test
	public void testaMovimentoValidoParaTorreNaPosicao() {
		JogoXadrez jogo = this.cenario2();
		assertEquals(true, jogo.movimentoValido(0, 0, 2, 0));
		assertEquals(true, jogo.movimentoValido(0, 0, 1, 0));
	}

	@Test
	public void testaMovimentoInvalidoTorreNaPosicao() {
		JogoXadrez jogo = this.cenario1();
		assertEquals(false, jogo.movimentoValido(0, 0, 0, 2));
		assertEquals(false, jogo.movimentoValido(0, 0, 3, 3));
	}

	@Test
	public void testaMovimentoValidoBispoNaPosicao() {
		JogoXadrez jogo = this.cenario2();
		assertEquals(true, jogo.movimentoValido(0, 2, 1, 1));
		assertEquals(true, jogo.movimentoValido(0, 2, 2, 0));
	}

	@Test
	public void testaMovimentoInvalidoBispoNaPosicao() {
		JogoXadrez jogo = this.cenario2();
		assertEquals(false, jogo.movimentoValido(0, 2, 0, 3));
		assertEquals(false, jogo.movimentoValido(0, 2, 1, 0));
	}

	@Test
	public void testaUmMovimentoValidoReiNaPosicao() {
		JogoXadrez jogo = this.cenario2();
		this.testeMovimentaPeaoBranco();
		assertEquals(true, jogo.movimentoValido(0, 3, 1, 2));
		assertEquals(true, jogo.movimentoValido(0, 3, 1, 3));
	}
	
	@Test 
	public void testeMovimentoInvalidoPeaoNaPosicao(){
		JogoXadrez jogo = this.cenario1();
		assertEquals(false, jogo.movimentarPeca(1, 0, 2, 1));

	}

	@Test
	public void testaMovimentoInvalidoReiNaPosicao() {
		JogoXadrez jogo = this.cenario2();
		this.testeMovimentaPeaoBranco();
		assertEquals(false, jogo.movimentoValido(0, 3, 0, 5));
		assertEquals(false, jogo.movimentoValido(0, 3, 1, 5));
	}

	@Test
	public void testaMovimentoValidoRainhaNaPosicao() {
		JogoXadrez jogo = this.cenario2();
		this.testeMovimentaPeaoBranco();
		assertEquals(true, jogo.movimentoValido(0, 4, 1, 4));
		assertTrue(jogo.movimentarPeca(0, 4, 1, 4));
		assertEquals(true, jogo.movimentoValido(1, 4, 2, 5));
	}

	@Test
	public void testaMovimentoInvalidoRainhaNaPosicao() {
		JogoXadrez jogo = this.cenario2();
		this.testeMovimentaPeaoBranco();
		assertEquals(false, jogo.movimentoValido(0, 4, 4, 0));
		assertEquals(false, jogo.movimentoValido(0, 4, -1, 4));

	}
	
	@Test
	public void movimentoSentidoforaDoTabuleiro() {
		JogoXadrez jogo = this.cenario1();
		assertEquals(false, jogo.movimentarPeca(0, 0, -1, -1));
		assertEquals(false, jogo.movimentarPeca(0, 1, 0, -1));
		assertEquals(false, jogo.movimentarPeca(0, 2, 0, -1));
		assertEquals(false, jogo.movimentarPeca(0, 3, -1, -1));
		assertEquals(false, jogo.movimentarPeca(0, 4, -1, -1));
		assertEquals(false, jogo.movimentarPeca(0, 5, -1, -1));
		assertEquals(false, jogo.movimentarPeca(0, 6, -1, -1));
		assertEquals(false, jogo.movimentarPeca(0, 7, -1, -1));
	}

	@Test
	public void testePeaoComendoPeao() {
		JogoXadrez jogo = this.cenario4();
		assertTrue(jogo.movimentarPeca(4, 0, 5, 1));
		assertEquals(CorDaPeca.BRANCA, jogo.corPeca(5, 1));
		assertEquals("Peao", jogo.getTipoDaPeca(5, 1));
	}
	
	@Test
	public void testePeaoComendoRainha() {
		JogoXadrez jogo = this.cenario0();
		assertTrue(jogo.movimentarPeca(2, 1, 3, 0));
		assertEquals(CorDaPeca.BRANCA, jogo.corPeca(3, 0));
		assertEquals("Peao", jogo.getTipoDaPeca(3, 0));

	}

	@Test
	public void testePeaoComendoBispo() {
		JogoXadrez jogo = this.cenario0();
		assertTrue(jogo.movimentarPeca(0, 2, 2, 0));
		assertTrue(jogo.movimentarPeca(2, 0, 4, 2));
		assertTrue(jogo.movimentarPeca(5, 3, 4, 2));
		assertEquals(CorDaPeca.PRETA, jogo.corPeca(4, 2));
		assertEquals("Peao", jogo.getTipoDaPeca(4, 2));
	}
	
	@Test
	public void testePeaoComendoTorre() {
		JogoXadrez jogo = this.cenario5();
		assertTrue(jogo.movimentarPeca(1, 5, 2, 5));
		assertTrue(jogo.movimentarPeca(4, 0, 3, 1));
		assertEquals(CorDaPeca.PRETA, jogo.corPeca(3, 1));
		assertEquals("Peao", jogo.getTipoDaPeca(3, 1));
	}
	
	@Test
    public void testePeaoComendoCavalo() {
            JogoXadrez jogo = this.cenario7();
            assertTrue(jogo.movimentarPeca(1, 5, 2, 5));
            assertTrue(jogo.movimentarPeca(5, 2, 3, 1));
            assertTrue(jogo.movimentarPeca(2, 2, 3, 1));
            assertEquals(CorDaPeca.BRANCA, jogo.corPeca(3, 1));
            assertEquals("Peao", jogo.getTipoDaPeca(3, 1));
    }
	
	@Test
	public void testeBispoComendoPeao() {
		JogoXadrez jogo = this.cenario4();
		assertTrue(jogo.movimentarPeca(7, 2, 5, 0));
		assertTrue(jogo.movimentarPeca(5, 0, 1, 4));
		assertEquals(CorDaPeca.PRETA, jogo.corPeca(1, 4));
		assertEquals("Bispo", jogo.getTipoDaPeca(1, 4));
	}
	
	@Test
    public void testeBispoComendoCavalo() {
        JogoXadrez jogo = this.cenario0();
        assertTrue(jogo.movimentarPeca(0, 1, 2, 2));
        assertTrue(jogo.movimentarPeca(6, 6, 5, 6));
        assertTrue(jogo.movimentarPeca(1, 7, 2, 7));
        assertTrue(jogo.movimentarPeca(7, 5, 6, 6));
        assertTrue(jogo.movimentarPeca(2, 7, 3, 7));
        assertTrue(jogo.movimentarPeca(6, 6, 2, 2));
        assertEquals(CorDaPeca.PRETA, jogo.corPeca(2, 2));
        assertEquals("Bispo", jogo.getTipoDaPeca(2, 2));
    }
	
	@Test
    public void testeBispoComendoTorre() {
            JogoXadrez jogo = this.cenario8();
            assertTrue(jogo.movimentarPeca(0, 7, 2, 7));
            assertTrue(jogo.movimentarPeca(7, 2, 2, 7));
            assertEquals(CorDaPeca.PRETA, jogo.corPeca(2, 7));
            assertEquals("Bispo", jogo.getTipoDaPeca(2, 7));
    }
	
	@Test
    public void testeBispoComendoBispo(){
            JogoXadrez jogo = this.cenario1();
            assertTrue(jogo.movimentarPeca(1, 6, 2, 6));
            assertTrue(jogo.movimentarPeca(6, 3, 5, 3));
            assertTrue(jogo.movimentarPeca(1, 0, 2, 0));
            assertTrue(jogo.movimentarPeca(7, 2, 2, 7));
            assertTrue(jogo.movimentarPeca(0, 5, 2, 7));
            assertEquals("Bispo",jogo.getTipoDaPeca(2, 7));
            assertEquals(CorDaPeca.BRANCA, jogo.corPeca(2, 7));
    }

	@Test
	public void testeCavalocomendoPeao() {
		JogoXadrez jogo = this.cenario4();
		assertTrue(jogo.movimentarPeca(7, 1, 5, 2));
		assertTrue(jogo.movimentarPeca(5, 2, 4, 0));
		assertEquals(CorDaPeca.PRETA, jogo.corPeca(4, 0));
		assertEquals("Cavalo", jogo.getTipoDaPeca(4, 0));
	}
	
	@Test
	public void testeCavaloComendoTorre() {
		JogoXadrez jogo = this.cenario6();
		assertTrue(jogo.movimentarPeca(1, 7, 2, 7));
		assertTrue(jogo.movimentarPeca(5, 2, 3, 1));
		assertEquals(CorDaPeca.PRETA, jogo.corPeca(3, 1));
		assertEquals("Cavalo", jogo.getTipoDaPeca(3, 1));
	}
	
	@Test
    public void testeCavaloComendoBispo() {
            JogoXadrez jogo = this.cenario8();
            assertTrue(jogo.movimentarPeca(0, 7, 2, 7));
            assertTrue(jogo.movimentarPeca(7, 2, 2, 7));
            assertTrue(jogo.movimentarPeca(0, 6, 2, 7));
            assertEquals(CorDaPeca.BRANCA, jogo.corPeca(2, 7));
            assertEquals("Cavalo", jogo.getTipoDaPeca(2, 7));
    }
	
	@Test
    public void testeCavaloComendoRainha() {
            JogoXadrez jogo = this.cenario8();
            assertTrue(jogo.movimentarPeca(0, 7, 2, 7));
            assertTrue(jogo.movimentarPeca(7, 2, 2, 7));
            assertTrue(jogo.movimentarPeca(0, 6, 2, 7));
            assertTrue(jogo.movimentarPeca(3, 0, 3, 5));
            assertTrue(jogo.movimentarPeca(2, 7, 3, 5));
            assertEquals(CorDaPeca.BRANCA, jogo.corPeca(3, 5));
            assertEquals("Cavalo", jogo.getTipoDaPeca(3, 5));
    }
	
	@Test
	public void testeCavaloComendoCavalo(){
		JogoXadrez jogo = this.cenario1();
		assertTrue(jogo.movimentarPeca(0, 1, 2, 0));
		assertTrue(jogo.movimentarPeca(7, 1, 5, 2));
		assertTrue(jogo.movimentarPeca(2, 0, 3, 2));
		assertTrue(jogo.movimentarPeca(5, 2, 4, 4));
		assertTrue(jogo.movimentarPeca(3, 2, 4, 4));
		assertEquals(CorDaPeca.BRANCA, jogo.corPeca(4, 4));
		assertEquals("Cavalo", jogo.getTipoDaPeca(4, 4));
	}

	@Test
	public void testeReiComendoBispo() {
		JogoXadrez jogo = this.cenario4();
		this.testeBispoComendoPeao();
		assertTrue(jogo.movimentarPeca(0, 3, 1, 4));
		assertEquals(CorDaPeca.BRANCA, jogo.corPeca(1, 4));
		assertEquals("Rei", jogo.getTipoDaPeca(1, 4));
	}
	
	@Test
	public void testeReiComendoRainha(){
		JogoXadrez jogo = this.cenario4();
		assertTrue(jogo.movimentarPeca(6, 5, 5, 5));
		assertTrue(jogo.movimentarPeca(7, 4, 4, 7));
		assertTrue(jogo.movimentarPeca(4, 7, 2, 5));
		assertTrue(jogo.movimentarPeca(2, 5, 1, 4));
		assertTrue(jogo.movimentarPeca(0, 3, 1, 4));
		assertEquals(CorDaPeca.BRANCA, jogo.corPeca(1, 4));
		assertEquals("Rei", jogo.getTipoDaPeca(1, 4));
	}
	
	@Test
	public void testeReiComendoCavalo(){
	 	JogoXadrez jogo = this.cenario4();
		assertTrue(jogo.movimentarPeca(7, 1, 5, 2));
		assertTrue(jogo.movimentarPeca(5, 2, 3, 3));
		assertTrue(jogo.movimentarPeca(3, 3, 1, 4));
		assertTrue(jogo.movimentarPeca(0, 3, 1, 4));
		assertEquals(CorDaPeca.BRANCA, jogo.corPeca(1, 4));
		assertEquals("Rei", jogo.getTipoDaPeca(1, 4));
	}
	
	@Test
	public void testeReiComendoTorre(){
		JogoXadrez jogo = this.cenario4();
		assertTrue(jogo.movimentarPeca(0, 0, 3, 0));
		assertTrue(jogo.movimentarPeca(3, 0, 3, 3));
		assertTrue(jogo.movimentarPeca(3, 3, 6, 3));
		assertTrue(jogo.movimentarPeca(7, 3, 6, 3));
		assertEquals(CorDaPeca.PRETA, jogo.corPeca(6, 3));
		assertEquals("Rei", jogo.getTipoDaPeca(6, 3));
	}
	
	@Test
	public void testeRainhaComendoPeao() {
		JogoXadrez jogo = this.cenario4();
		assertTrue(jogo.movimentarPeca(6, 3, 5, 3));
		assertTrue(jogo.movimentarPeca(7, 4, 5, 2));
		assertTrue(jogo.movimentarPeca(5, 2, 1, 6));
		assertEquals(CorDaPeca.PRETA, jogo.corPeca(1, 6));
		assertEquals("Rainha", jogo.getTipoDaPeca(1, 6));
	}
	
	@Test
	public void testeXeque() {
		JogoXadrez jogo = this.cenario3();
		assertEquals(true, jogo.verificarReiEmXeque());
	}

	@Test
	public void testeRoque() {
		JogoXadrez jogo = this.cenario1();
		assertTrue(jogo.movimentarPeca(1, 1, 2, 1));
		assertTrue(jogo.movimentarPeca(0, 1, 2, 2));
		assertTrue(jogo.movimentarPeca(0, 2, 2, 0));
		assertTrue(jogo.movimentarPeca(0, 3, 0, 1));
		assertFalse(jogo.existePeca(0, 0));
		assertEquals("Rei", jogo.getTipoDaPeca(0, 1));
		assertEquals("Torre", jogo.getTipoDaPeca(0, 2));
	}

	@Test
	public void testeTorreComendoTorre(){
		JogoXadrez jogo = this.cenario4();
		assertTrue(jogo.movimentarPeca(4, 0, 5, 1));
		assertTrue(jogo.movimentarPeca(6, 0, 5, 1));
		assertTrue(jogo.movimentarPeca(0, 0, 7, 0));
		assertEquals(CorDaPeca.BRANCA, jogo.corPeca(7, 0));
		assertEquals("Torre", jogo.getTipoDaPeca(7, 0));
	}
	
	@Test
	public void testeTorreComendoPeao() {
		JogoXadrez jogo = this.cenario4();
		this.testePeaoComendoPeao();
		assertTrue(jogo.movimentarPeca(0, 0, 6, 0));
		assertEquals(CorDaPeca.BRANCA, jogo.corPeca(6, 0));
		assertEquals("Torre", jogo.getTipoDaPeca(6, 0));
	}
	
	@Test
	public void testeTorreComendoBispo(){
		JogoXadrez jogo = this.cenario4();
		assertTrue(jogo.movimentarPeca(7, 2, 5, 0));
		assertTrue(jogo.movimentarPeca(4, 0, 5, 1));
		assertTrue(jogo.movimentarPeca(0, 0, 5, 0));
		assertEquals(CorDaPeca.BRANCA, jogo.corPeca(5, 0));
		assertEquals("Torre", jogo.getTipoDaPeca(5, 0));
	}
	
	@Test
	public void testeTorreComendoCavalo(){
		JogoXadrez jogo = this.cenario1();
		assertTrue(jogo.movimentarPeca(1, 0, 2, 0));
		assertTrue(jogo.movimentarPeca(2, 0, 3, 0));
		assertTrue(jogo.movimentarPeca(0, 0, 2, 0));
		assertTrue(jogo.movimentarPeca(2, 0, 2, 2));
		assertTrue(jogo.movimentarPeca(2, 2, 6, 2));
		assertTrue(jogo.movimentarPeca(6, 2, 7, 2));
		assertEquals(CorDaPeca.BRANCA, jogo.corPeca(7, 2));
		assertEquals("Torre", jogo.getTipoDaPeca(7, 2));
	}
	
	@Test
	public void testeTorreComendoRainha(){
		JogoXadrez jogo = this.cenario1();
		assertTrue(jogo.movimentarPeca(1, 0, 2, 0));
		assertTrue(jogo.movimentarPeca(2, 0, 3, 0));
		assertTrue(jogo.movimentarPeca(0, 0, 2, 0));
		assertTrue(jogo.movimentarPeca(2, 0, 2, 4));
		assertTrue(jogo.movimentarPeca(2, 4, 6, 4));
		assertTrue(jogo.movimentarPeca(6, 4, 7, 4));
		assertEquals(CorDaPeca.BRANCA, jogo.corPeca(7, 4));
		assertEquals("Torre", jogo.getTipoDaPeca(7, 4));
	}
	
}