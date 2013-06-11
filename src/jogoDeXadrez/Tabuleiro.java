package jogoDeXadrez;

import java.util.ArrayList;
import java.util.List;

import fachada.JogoXadrez;



import JPlay.GameImage;

public class Tabuleiro {

	private static final Quadrado[][] TABULEIRO = new Quadrado[8][8];
	private List<Peca> pecasDoJogo;
	private Rei reiBranco = null;
	private Rei reiPreto = null;


	public Tabuleiro(){
		
		pecasDoJogo = new ArrayList<Peca>();
		
		for(int i = 0;i < 8;i++){
			for(int j = 0;j < 8;j++){
				TABULEIRO[i][j] = new Quadrado();
			}
		}
		
		// White pieces
		CorDaPeca branca = CorDaPeca.BRANCA;
		
		GameImage TorreBranca1 = new GameImage("TorreBranca1.png");
		TABULEIRO[0][0].setPeca(new Torre(2, branca, 0, 0, TorreBranca1,"Torre"));
		Torre torre1 = (Torre) TABULEIRO[0][0].getPeca();
		torre1.setEstaNaPosicaoInicial(true);
		pecasDoJogo.add(TABULEIRO[0][0].getPeca());
		
		GameImage CavaloBranco1 = new GameImage("CavaloBranco1.png");
		TABULEIRO[0][1].setPeca(new Cavalo(4, branca, 0, 1, CavaloBranco1,"Cavalo"));
		pecasDoJogo.add(TABULEIRO[0][1].getPeca());
		
		GameImage BispoBranco1 = new GameImage("BispoBanco1.png");
		TABULEIRO[0][2].setPeca(new Bispo(3, branca, 0, 2, BispoBranco1,"Bispo"));
		pecasDoJogo.add(TABULEIRO[0][2].getPeca());
		
//		Rei reiBranco = new Rei(-1, branca, 0, 3,"  |K(B)| ");
		GameImage ReiBranco = new GameImage("ReiBranco.png");
		TABULEIRO[0][3].setPeca(new Rei(-1, branca, 0, 3, ReiBranco,"Rei"));
		Rei reiBranco = (Rei) TABULEIRO[0][3].getPeca();
		reiBranco.setEstaNaPosicaoInicial(true);
		pecasDoJogo.add(reiBranco);
		this.reiBranco = reiBranco;
		
		GameImage RainhaBranca = new GameImage("RainhaBranca.png");
		TABULEIRO[0][4].setPeca(new Rainha(5, branca, 0, 4, RainhaBranca,"Rainha"));
		pecasDoJogo.add(TABULEIRO[0][4].getPeca());
		
		GameImage BispoBranco2 = new GameImage("BispoBranco2.png");
		TABULEIRO[0][5].setPeca(new Bispo(3, branca, 0, 5, BispoBranco2,"Bispo"));
		pecasDoJogo.add(TABULEIRO[0][5].getPeca());
		
		GameImage CavaloBranco2 = new GameImage("CavaloBranco2.png");
		TABULEIRO[0][6].setPeca(new Cavalo(4, branca, 0, 6, CavaloBranco2,"Cavalo"));
		pecasDoJogo.add(TABULEIRO[0][6].getPeca());
		
		GameImage TorreBranca2 = new GameImage("TorreBranca2.png");
		TABULEIRO[0][7].setPeca(new Torre(2, branca, 0, 7, TorreBranca2,"Torre"));
		Torre torre2 = (Torre) TABULEIRO[0][7].getPeca();
		torre2.setEstaNaPosicaoInicial(true);
		pecasDoJogo.add(TABULEIRO[0][7].getPeca());
		
		GameImage peaoBranco1 = new GameImage("peaoBranco1.png");
		TABULEIRO[1][0].setPeca(new Peao(1, branca, 1, 0, peaoBranco1,"Peao"));
		Peao peao1 = (Peao) TABULEIRO[1][0].getPeca();
		peao1.setEstaNaPosicaoInicial(true);
		
		GameImage peaoBranco2 = new GameImage("peaoBranco2.png");
		TABULEIRO[1][1].setPeca(new Peao(1, branca, 1, 1, peaoBranco2,"Peao"));
		Peao peao2 = (Peao) TABULEIRO[1][1].getPeca();
		peao2.setEstaNaPosicaoInicial(true);
		
		GameImage peaoBranco3 = new GameImage("peaoBranco3.png");
		TABULEIRO[1][2].setPeca(new Peao(1, branca, 1, 2, peaoBranco3,"Peao"));
		Peao peao3 = (Peao) TABULEIRO[1][2].getPeca();
		peao3.setEstaNaPosicaoInicial(true);
		
		GameImage peaoBranco4 = new GameImage("peaoBranco4.png");
		TABULEIRO[1][3].setPeca(new Peao(1, branca, 1, 3, peaoBranco4,"Peao"));
		Peao peao4 = (Peao) TABULEIRO[1][3].getPeca();
		peao4.setEstaNaPosicaoInicial(true);
		
		GameImage peaoBranco5 = new GameImage("peaoBranco5.png");
		TABULEIRO[1][4].setPeca(new Peao(1, branca, 1, 4, peaoBranco5,"Peao"));
		Peao peao5 = (Peao) TABULEIRO[1][4].getPeca();
		peao5.setEstaNaPosicaoInicial(true);
		
		GameImage peaoBranco6 = new GameImage("peaoBranco6.png");
		TABULEIRO[1][5].setPeca(new Peao(1, branca, 1, 5, peaoBranco6,"Peao"));
		Peao peao6 = (Peao) TABULEIRO[1][5].getPeca();
		peao6.setEstaNaPosicaoInicial(true);
		
		GameImage peaoBranco7 = new GameImage("peaoBranco7.png");
		TABULEIRO[1][6].setPeca(new Peao(1, CorDaPeca.BRANCA, 1, 6, peaoBranco7,"Peao"));
		Peao peao7 = (Peao) TABULEIRO[1][6].getPeca();
		peao7.setEstaNaPosicaoInicial(true);
		
		GameImage peaoBranco8 = new GameImage("peaoBranco8.png");
		TABULEIRO[1][7].setPeca(new Peao(1, branca, 1, 7, peaoBranco8,"Peao"));
		Peao peao8 = (Peao) TABULEIRO[1][7].getPeca();
		peao8.setEstaNaPosicaoInicial(true);

		
		
		// Black pieces
		CorDaPeca preta = CorDaPeca.PRETA;
		
		GameImage TorrePreta1 = new GameImage("TorrePreta1.png");
		TABULEIRO[7][0].setPeca(new Torre(2, preta, 7, 0, TorrePreta1,"Torre"));
		Torre torreP1 = (Torre) TABULEIRO[0][0].getPeca();
		torreP1.setEstaNaPosicaoInicial(true);
		pecasDoJogo.add(TABULEIRO[7][0].getPeca());
		
		GameImage CavaloPreto1 = new GameImage("CavaloPreto1.png");
		TABULEIRO[7][1].setPeca(new Cavalo(4, preta, 7, 1, CavaloPreto1,"Cavalo"));
		pecasDoJogo.add(TABULEIRO[7][1].getPeca());
		
		GameImage BispoPreto1 = new GameImage("BispoPreto1.png");
		TABULEIRO[7][2].setPeca(new Bispo(3, preta, 7, 2, BispoPreto1,"Bispo"));
		pecasDoJogo.add(TABULEIRO[7][2].getPeca());
		
//		Rei reiBranco = new Rei(-1, branca, 0, 3,"  |K(B)| ");
		GameImage ReiPreto = new GameImage("ReiPreto.png");
		TABULEIRO[7][3].setPeca(new Rei(-1, preta, 7, 3, ReiPreto,"Rei"));
		Rei reiPreto = (Rei) TABULEIRO[7][3].getPeca();
		reiBranco.setEstaNaPosicaoInicial(true);
		pecasDoJogo.add(reiPreto);
		this.reiPreto = reiPreto;
		
		GameImage RainhaPreta = new GameImage("RainhaPreta.png");
		TABULEIRO[7][4].setPeca(new Rainha(5, preta, 7, 4, RainhaPreta,"Rainha"));
		pecasDoJogo.add(TABULEIRO[7][4].getPeca());
		
		GameImage BispoPreto2 = new GameImage("BispoPreto2.png");
		TABULEIRO[7][5].setPeca(new Bispo(3, preta, 7, 5, BispoPreto2,"Bispo"));
		pecasDoJogo.add(TABULEIRO[7][5].getPeca());
		
		GameImage CavaloPreto2 = new GameImage("CavaloPreto2.png");
		TABULEIRO[7][6].setPeca(new Cavalo(4, preta, 7, 6, CavaloPreto2,"Cavalo"));
		pecasDoJogo.add(TABULEIRO[7][6].getPeca());
		
		GameImage TorrePreta2 = new GameImage("TorrePreta2.png");
		TABULEIRO[7][7].setPeca(new Torre(2, preta, 7, 7, TorrePreta2,"Torre"));
		Torre torreP2 = (Torre) TABULEIRO[0][7].getPeca();
		torreP2.setEstaNaPosicaoInicial(true);
		pecasDoJogo.add(TABULEIRO[7][7].getPeca());
		
		GameImage peaoPreto1 = new GameImage("peaoPreto1.png");
		TABULEIRO[6][0].setPeca(new Peao(1, preta, 6, 0, peaoPreto1,"Peao"));
		Peao peaoP1 = (Peao) TABULEIRO[6][0].getPeca();
		peaoP1.setEstaNaPosicaoInicial(true);
		
		GameImage peaoPreto2 = new GameImage("peaoPreto2.png");
		TABULEIRO[6][1].setPeca(new Peao(1, preta, 6, 1, peaoPreto2,"Peao"));
		Peao peaoP2 = (Peao) TABULEIRO[6][1].getPeca();
		peaoP2.setEstaNaPosicaoInicial(true);
		
		GameImage peaoPreto3 = new GameImage("peaoPreto3.png");
		TABULEIRO[6][2].setPeca(new Peao(1, preta, 6, 2, peaoPreto3,"Peao"));
		Peao peaoP3 = (Peao) TABULEIRO[6][2].getPeca();
		peaoP3.setEstaNaPosicaoInicial(true);
		
		GameImage peaoPreto4 = new GameImage("peaoPreto4.png");
		TABULEIRO[6][3].setPeca(new Peao(1, preta, 6, 3, peaoPreto4,"Peao"));
		Peao peaoP4 = (Peao) TABULEIRO[6][3].getPeca();
		peaoP4.setEstaNaPosicaoInicial(true);
		
		GameImage peaoPreto5 = new GameImage("peaoPreto5.png");
		TABULEIRO[6][4].setPeca(new Peao(1, preta, 6, 4, peaoPreto5,"Peao"));
		Peao peaoP5 = (Peao) TABULEIRO[6][4].getPeca();
		peaoP5.setEstaNaPosicaoInicial(true);
		
		GameImage peaoPreto6 = new GameImage("peaoPreto6.png");
		TABULEIRO[6][5].setPeca(new Peao(1, preta, 6, 5, peaoPreto6,"Peao"));
		Peao peaoP6 = (Peao) TABULEIRO[6][5].getPeca();
		peaoP6.setEstaNaPosicaoInicial(true);
		
		GameImage peaoPreto7 = new GameImage("peaoPreto7.png");
		TABULEIRO[6][6].setPeca(new Peao(1, preta, 6, 6, peaoPreto7,"Peao"));
		Peao peaoP7 = (Peao) TABULEIRO[6][6].getPeca();
		peaoP7.setEstaNaPosicaoInicial(true);
		
		GameImage peaoPreto8 = new GameImage("peaoPreto8.png");
		TABULEIRO[6][7].setPeca(new Peao(1, preta, 6, 7, peaoPreto8,"Peao"));
		Peao peaoP8 = (Peao) TABULEIRO[6][7].getPeca();
		peaoP8.setEstaNaPosicaoInicial(true);
		
		
	}

	public List<Peca> getPecasDoJogo(CorDaPeca cor){
		List<Peca> pecas = new ArrayList<Peca>();
		for(Peca p: pecasDoJogo){
			if(p.getCor()== cor){
				pecas.add(p);
			}
		}
		return pecas;
	}
	
	public void removerPeca(Peca p){
		for(Peca peca:pecasDoJogo){
			if(p.equals(peca)){
				pecasDoJogo.remove(p);
				break;
			}
		}
	}
	public void adicionarPeca(Peca p){
		pecasDoJogo.add(p);
	}
	
	public Quadrado getQuadrado(int linha, int coluna){
		return TABULEIRO[linha][coluna];
	}
	public Quadrado[][] getArrayTabuleiro(){
		return TABULEIRO;
	}
	
	public Rei getReiBranco() {
		return reiBranco;
	}
	
	public Rei getReiPreto() {
		return reiPreto;
	}
	
	public void toString(JogoXadrez jogo){
				
		for(int i = 0;i < TABULEIRO.length;i++){
			for(int j = 0;j < TABULEIRO.length;j++){
				if(TABULEIRO[i][j].getPeca() != null){
					TABULEIRO[i][j].getPeca().getNome().setPosition( (j * 62.5 ) + 123, (i * 62.5) + 95);
					TABULEIRO[i][j].getPeca().getNome().draw();
					 
				}
			}	
		}
	}
}

