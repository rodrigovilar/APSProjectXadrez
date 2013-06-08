package xadrez;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class Teste {
	
	public JogoXadrez cenario1(){
		JogoXadrez jogo = new JogoXadrez();
		return jogo;
	}
	public JogoXadrez cenario2(){
		JogoXadrez jogo = new JogoXadrez();
		jogo.movimentarPeca(1, 0, 2, 0);
		jogo.movimentarPeca(2, 0, 3, 0);
		jogo.movimentarPeca(0, 2, 0, 3);
		return jogo;
	}
	public JogoXadrez cenario3(){
		JogoXadrez jogo = new JogoXadrez();
		assertTrue(jogo.movimentarPeca(1, 4, 2, 4));
		assertTrue(jogo.movimentarPeca(6, 5, 5, 5));
		assertTrue(jogo.movimentarPeca(1, 2, 2, 2));
		assertTrue(jogo.movimentarPeca(7, 4, 4, 7));
		return jogo;
		
	}	
	public JogoXadrez cenario4(){
		JogoXadrez jogo = new JogoXadrez();
		jogo.movimentarPeca(1, 0, 2, 0);
		jogo.movimentarPeca(2, 0, 3, 0);
		jogo.movimentarPeca(3, 0, 4, 0);
		jogo.movimentarPeca(6, 1, 5, 1);
		
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
	public void testeMovimentaPeaoPreto(){
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
    public void testaUmMovimentoValidoParaCavaloBranco(){
        JogoXadrez jogo = this.cenario1();
		assertEquals(true,jogo.movimentoValido(0, 1, 2, 2));
    }
	
	@Test
    public void testaUmMovimentoInvalidoParaCavaloBranco() {
		JogoXadrez jogo = this.cenario1();
        assertEquals(false,jogo.movimentoValido(0, 1, 3, 2));
    }
	
	@Test
    public void testaUmMovimentoValidoParaTorreBranca(){
        JogoXadrez jogo = this.cenario2();      
		assertEquals(true,jogo.movimentoValido(0, 0, 2, 0));
    }
	
	@Test
    public void testaUmMovimentoInvalidoTorreBranca() {
		JogoXadrez jogo = this.cenario1();
        assertEquals(false,jogo.movimentoValido(0, 0, 2, 2));
    }
	
	@Test
    public void testaUmMovimentoValidoBispoBranco() {
		JogoXadrez jogo = this.cenario2();
        assertEquals(true,jogo.movimentoValido(0, 2, 1, 1));
    }
	
	@Test
    public void testaUmMovimentoInvalidoBispoBranco() {
		JogoXadrez jogo = this.cenario2();
        assertEquals(false,jogo.movimentoValido(0, 3, 1, 2));
    }
	
	@Test
    public void testaUmMovimentoValidoReiBranco() {
		JogoXadrez jogo = this.cenario2();
		this.testeMovimentaPeaoBranco();
        assertEquals(true,jogo.movimentoValido(0, 3, 1, 2));
    }

	@Test
    public void testaUmMovimentoInvalidoReiBranco() {
		JogoXadrez jogo = this.cenario2();
        assertEquals(false,jogo.movimentoValido(0, 2, 0, 4));
    }
	
	@Test
    public void testaUmMovimentoValidoRainhaBranca() {
		JogoXadrez jogo = this.cenario2();
		this.testeMovimentaPeaoBranco();
		assertTrue(jogo.movimentarPeca(2, 2, 3, 2));
        assertEquals(true,jogo.movimentoValido(0, 4, 4, 0));
    }
	
	@Test
    public void testaUmMovimentoInvalidoRainhaBranca() {
		JogoXadrez jogo = this.cenario2();
		this.testeMovimentaPeaoBranco();
        assertEquals(false,jogo.movimentoValido(0, 4, 4, 0));
    }
	
	@Test
	public void testeMovimentoValidoEInvalidoPecasBrancas(){

		JogoXadrez jogo = this.cenario1();
		//Movimentando para uma dada posicao ae será verificado se é irregular ou não
		assertEquals(true , jogo.movimentoValido(1, 0, 2, 0));
		assertEquals(false ,jogo.movimentoValido(0, 0, 5, 0));
		assertEquals(true , jogo.movimentoValido(0, 1, 2, 2));
		assertEquals(true , jogo.movimentoValido(1, 3, 3, 3));
		assertEquals(false , jogo.movimentoValido(0, 2, 3, 5));
	}
	
	@Test
	public void testePeaoComendoPeao(){
		JogoXadrez jogo = this.cenario4();
		assertTrue(jogo.movimentarPeca(4, 0, 5, 1));
		assertEquals(CorDaPeca.BRANCA,jogo.corPeca(5, 1));
	}
	
	@Test
	public void testeBispoComendoPeao(){
		JogoXadrez jogo = this.cenario4();
		assertTrue(jogo.movimentarPeca(7, 2, 5, 0));
		assertTrue(jogo.movimentarPeca(5, 0, 1, 4));
		assertEquals(CorDaPeca.PRETA,jogo.corPeca(1, 4));
	}
	
	@Test
	public void testeCavalocomendoPeao(){
		JogoXadrez jogo = this.cenario4();
		assertTrue(jogo.movimentarPeca(7, 1, 5, 2));
		assertTrue(jogo.movimentarPeca(5, 2, 4, 0));
		assertEquals(CorDaPeca.PRETA,jogo.corPeca(4, 0));
	}

	@Test
	public void testeReiComendoPeca(){
		JogoXadrez jogo = this.cenario4();
		this.testeBispoComendoPeao();
		assertTrue(jogo.movimentarPeca(0, 3, 1, 4));
		assertEquals(CorDaPeca.BRANCA, jogo.corPeca(1, 4));
	}
	
	@Test
	public void testeRainhaComendoPeao(){
		JogoXadrez jogo = this.cenario4();
		assertTrue(jogo.movimentarPeca(6, 3, 5, 3));
		assertTrue(jogo.movimentarPeca(7, 4, 5, 2));
		assertTrue(jogo.movimentarPeca(5, 2, 1, 6));
		assertEquals(CorDaPeca.PRETA, jogo.corPeca(1, 6));
	}
	
	public void testeTorreComendoPeao(){
		JogoXadrez jogo = this.cenario4();
		this.testePeaoComendoPeao();
		assertTrue(jogo.movimentarPeca(0, 0, 6, 0));
		assertEquals(CorDaPeca.BRANCA, jogo.corPeca(6, 0));
	}
	
	@Test
	public void testeXeque(){
		JogoXadrez jogo = this.cenario3();
		assertEquals(true,jogo.verificarReiEmXeque());
	}
	
	@Test
	public void testeRoque(){	
		JogoXadrez jogo = this.cenario1();
		assertTrue(jogo.movimentarPeca(1, 1, 2, 1));
		assertTrue(jogo.movimentarPeca(0, 1, 2, 2));
		assertTrue(jogo.movimentarPeca(0, 2, 2, 0));
		assertTrue(jogo.movimentarPeca(0, 3, 0, 1));
		assertFalse(jogo.existePeca(0, 0));
		assertEquals("Rei",jogo.getTipoDaPeca(0, 1));
		assertEquals("Torre",jogo.getTipoDaPeca(0, 2));	
	}
	
	@Test
	public void movimentoSentidoforaDoTabuleiro(){
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


}






