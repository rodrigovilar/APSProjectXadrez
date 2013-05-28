package xadrez;

import static org.junit.Assert.*;

import org.junit.Test;


public class TesteMoverPeca {

	@Test
	public void test() {

		JogoXadrez jogo = new JogoXadrez();
		jogo.iniciarTabuleiro();
		
		Peao peao = (Peao) jogo.getTabuleiro().getQuadrado(1, 0).getPeca();
		jogo.moverPeca(peao, 3, 0);
		Peao peao2 = (Peao) jogo.getTabuleiro().getQuadrado(6, 0).getPeca();
		jogo.moverPeca(peao2, 4, 0);
		Peao peao3 = (Peao) jogo.getTabuleiro().getQuadrado(1, 4).getPeca();
		
		Peao peao4 = (Peao) jogo.getTabuleiro().getQuadrado(1, 3).getPeca();
		jogo.moverPeca(peao4, 2, 3);
//		Peao peao2 = (Peao) jogo.getTabuleiro().getQuadrado(6, 3).getPeca();
//		jogo.moverPeca(peao2, 5, 3);
		
		Rei rei = (Rei) jogo.getTabuleiro().getQuadrado(0, 3).getPeca();
		jogo.moverPeca(rei, 1, 3);
		
		assertEquals(false, rei.estaNaPosicaoInicial());
		
		
		/*Peca p = jogo.getTabuleiro().getQuadrado(0, 0).getPeca();
		jogo.getTabuleiro().removerPeca(p);
		boolean existe = false;
		for(Peca peca: jogo.getTabuleiro().getPecasDoJogo(p.getCor())){
			if(peca == p){
				existe = true;
				break;
			}
		}
		assertEquals(existe,false);*/
		
		
		/*Peca p1 = jogo.getTabuleiro().getQuadrado(1, 0).getPeca();
		jogo.moverPeca(p1, 2, 0);
		
		assertEquals(0, jogo.verificaXeque(jogo.getTabuleiro().getReiBranco()));
		assertEquals(0, jogo.verificaXeque(jogo.getTabuleiro().getReiBranco()));

		Peca p2 = jogo.getTabuleiro().getQuadrado(6, 1).getPeca();
		jogo.moverPeca(p2, 5, 1);
		
		p1 = jogo.getTabuleiro().getQuadrado(2, 0).getPeca();
		jogo.moverPeca(p1, 3, 0);
		
		p2 = jogo.getTabuleiro().getQuadrado(5, 1).getPeca();
		jogo.moverPeca(p2, 4, 1);
		
		p1 = jogo.getTabuleiro().getQuadrado(3, 0).getPeca();
		jogo.moverPeca(p1, 4, 1);
		
		if(jogo.getTabuleiro().getQuadrado(2, 1).estaOcupado()){
			jogo.comerPeca(p);
		}
		
		jogo.getTabuleiro().getQuadrado(2, 1).setPeca(null);
		
		assertEquals(jogo.getTabuleiro().getQuadrado(2, 1).getPeca(),null);
		
		jogo.moverPeca(p1, 2, 1);
		
		assertEquals(jogo.getTabuleiro().getQuadrado(0, 2).getPeca(),null);
		
		assertEquals(jogo.getTabuleiro().getQuadrado(2, 1).getPeca(),p1);
		
		System.out.println(p1.toString());
		
		
		
		Peca p2 = jogo.getTabuleiro().getQuadrado(0, 3).getPeca();
		System.out.println(jogo.getTabuleiro().getQuadrado(0, 3).getPeca());

		assertEquals(p1, p2);*/
		
		

	}

}
