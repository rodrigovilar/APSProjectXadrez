package xadrez;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import JPlay.GameImage;

public class JogoXadrez implements IXadrez {

	private Tabuleiro tabuleiro;
	private List<Peca> pecasBrancasCapturadas;
	private List<Peca> pecasPretasCapturadas;
	private CorDaPeca JogadorDaVez;

	public CorDaPeca getJogadorDaVez() {
		return JogadorDaVez;
	}

	public JogoXadrez() {
		this.pecasBrancasCapturadas = new ArrayList<Peca>();
		this.pecasPretasCapturadas = new ArrayList<Peca>();
		this.JogadorDaVez = CorDaPeca.BRANCA;
		this.iniciarTabuleiro();
	}

	@Override
	public boolean iniciarTabuleiro() {
		this.tabuleiro = new Tabuleiro();
		return true;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	@Override
	public void moverPeca(Peca peca, int linhaDestino, int colunaDestino){

		Quadrado destino = tabuleiro.getQuadrado(linhaDestino, colunaDestino);
		Peca aux = null;
		int linhaAux, colunaAux;
		
		GameImage reiPreto = new GameImage("ReiPreto.png");
		GameImage reiBranco = new GameImage("ReiBranco.png");
		
		tabuleiro.getReiPreto().setNome(reiPreto);
		tabuleiro.getReiBranco().setNome(reiBranco);

		
		GameImage reiPretoXeque = new GameImage("ReiPretoX.png");
		GameImage reiBrancoXeque = new GameImage("ReiBrancoX.png");
		


		if(this.movimentoEhValido(linhaDestino, colunaDestino, peca)){

			linhaAux = peca.getLinhaAtual();
			colunaAux = peca.getColunaAtual();

			if(destino.estaOcupado()){
				if(peca.getCor() == destino.getPeca().getCor()){
					
					JOptionPane.showMessageDialog(null,"1 - Movimento invalido");
					return;
				}
				else{
					peca.getQuadradoAtual(tabuleiro).setPeca(null);
					aux = tabuleiro.getQuadrado(linhaDestino, colunaDestino).getPeca();
					tabuleiro.removerPeca(aux);
					tabuleiro.getQuadrado(linhaDestino, colunaDestino).setPeca(peca);
					peca.setPosicaoAtual(linhaDestino, colunaDestino);

					if(peca.getCor() == CorDaPeca.BRANCA){
						if(verificaXeque(tabuleiro.getReiBranco())){

							peca.setPosicaoAtual(linhaAux, colunaAux);
							peca.getQuadradoAtual(tabuleiro).setPeca(peca);
							tabuleiro.getQuadrado(linhaDestino, colunaDestino).setPeca(aux);
							tabuleiro.adicionarPeca(aux);
							JOptionPane.showMessageDialog(null, "1 - Jogada invalida: seu Rei ficara em Xeque");
							return;
						}
						if(verificaXeque(tabuleiro.getReiPreto())){
							tabuleiro.getReiPreto().setNome(reiPretoXeque);
						}
						peca.getQuadradoAtual(tabuleiro).setPeca(peca);
						tabuleiro.getQuadrado(linhaDestino, colunaDestino).setPeca(aux);
						tabuleiro.adicionarPeca(aux);
						alteraVez();
					}
					else{
						if(verificaXeque(tabuleiro.getReiPreto())){

							peca.getQuadradoAtual(tabuleiro).setPeca(peca);
							tabuleiro.getQuadrado(linhaDestino, colunaDestino).setPeca(aux);
							tabuleiro.adicionarPeca(aux);
							JOptionPane.showMessageDialog(null, "2 - Jogada invalida: seu Rei ficara em Xeque");
							return;
						}
						if(verificaXeque(tabuleiro.getReiBranco())){
							tabuleiro.getReiBranco().setNome(reiBrancoXeque);
						}

						peca.getQuadradoAtual(tabuleiro).setPeca(peca);
						tabuleiro.getQuadrado(linhaDestino, colunaDestino).setPeca(aux);
						tabuleiro.adicionarPeca(aux);
						alteraVez();
					}

				}

				this.comerPeca(destino.getPeca());
				tabuleiro.removerPeca(destino.getPeca());
				peca.getQuadradoAtual(tabuleiro).setPeca(null);
				destino.setPeca(peca);
				peca.setPosicaoAtual(linhaDestino, colunaDestino);
			}

			else{
				peca.getQuadradoAtual(tabuleiro).setPeca(null);
				tabuleiro.getQuadrado(linhaDestino, colunaDestino).setPeca(peca);
				peca.setPosicaoAtual(linhaDestino, colunaDestino);

				if(peca.getCor() == CorDaPeca.BRANCA){						
					if(verificaXeque(tabuleiro.getReiBranco())){

						peca.setPosicaoAtual(linhaAux, colunaAux);
						peca.getQuadradoAtual(tabuleiro).setPeca(peca);
						tabuleiro.getQuadrado(linhaDestino, colunaDestino).setPeca(null);
						JOptionPane.showMessageDialog(null, "3 - Jogada invalida: seu Rei ficara em Xeque");
						return;
					}

					if(verificaXeque(tabuleiro.getReiPreto())){
						tabuleiro.getReiPreto().setNome(reiPretoXeque);
					}
					else{
						if(peca instanceof Rei){
							if(colunaAux + 2 == colunaDestino){
								peca.setPosicaoAtual(linhaDestino, colunaDestino);
								aux = tabuleiro.getQuadrado(peca.getLinhaAtual(), 7).getPeca();
								tabuleiro.getQuadrado(peca.getLinhaAtual(), 7).setPeca(null);
								tabuleiro.getQuadrado(peca.getLinhaAtual(), (peca.getColunaAtual() - 1)).setPeca(aux);
								((Torre)(tabuleiro.getQuadrado(peca.getLinhaAtual(), (peca.getColunaAtual() - 1)).getPeca())).setEstaNaPosicaoInicial(false);
								tabuleiro.getQuadrado(peca.getLinhaAtual(), (peca.getColunaAtual() - 1)).getPeca().setPosicaoAtual(peca.getLinhaAtual(), (peca.getColunaAtual() - 1));
								((Rei) peca).setUsouRoque(true);
							}
							else if(colunaAux - 2 == colunaDestino){
								peca.setPosicaoAtual(linhaDestino, colunaDestino);
								aux = tabuleiro.getQuadrado(peca.getLinhaAtual(), 0).getPeca();
								tabuleiro.getQuadrado(peca.getLinhaAtual(), 0).setPeca(null);
								tabuleiro.getQuadrado(peca.getLinhaAtual(), (peca.getColunaAtual() + 1)).setPeca(aux);
								((Torre)(tabuleiro.getQuadrado(peca.getLinhaAtual(), (peca.getColunaAtual() + 1)).getPeca())).setEstaNaPosicaoInicial(false);
								tabuleiro.getQuadrado(peca.getLinhaAtual(), (peca.getColunaAtual() + 1)).getPeca().setPosicaoAtual(peca.getLinhaAtual(), (peca.getColunaAtual() + 1));
								((Rei) peca).setUsouRoque(true);
							}
							else{
								peca.setPosicaoAtual(linhaDestino, colunaDestino);
							}
						}
						else{
							peca.setPosicaoAtual(linhaDestino, colunaDestino);
						}
					}
					alteraVez();
				}
				else{
					if(verificaXeque(tabuleiro.getReiPreto())){

						peca.setPosicaoAtual(linhaAux, colunaAux);
						peca.getQuadradoAtual(tabuleiro).setPeca(peca);
						tabuleiro.getQuadrado(linhaDestino, colunaDestino).setPeca(null);
						JOptionPane.showMessageDialog(null, "4 - Jogada invalida: seu Rei ficara em Xeque");
						return;
					}
					if(verificaXeque(tabuleiro.getReiBranco())){
						tabuleiro.getReiBranco().setNome(reiBrancoXeque);
						alteraVez();
					}

					else{

						if(peca instanceof Rei){
							if(colunaAux + 2 == colunaDestino){
								peca.setPosicaoAtual(linhaDestino, colunaDestino);
								aux = tabuleiro.getQuadrado(peca.getLinhaAtual(), 7).getPeca();
								tabuleiro.getQuadrado(peca.getLinhaAtual(), 7).setPeca(null);
								tabuleiro.getQuadrado(peca.getLinhaAtual(), (peca.getColunaAtual() - 1)).setPeca(aux);
								((Torre)(tabuleiro.getQuadrado(peca.getLinhaAtual(), (peca.getColunaAtual() - 1)).getPeca())).setEstaNaPosicaoInicial(false);
								tabuleiro.getQuadrado(peca.getLinhaAtual(), (peca.getColunaAtual() - 1)).getPeca().setPosicaoAtual(peca.getLinhaAtual(), (peca.getColunaAtual() - 1));
								((Rei) peca).setUsouRoque(true);
								alteraVez();
							}
							if(colunaAux - 2 == colunaDestino){
								peca.setPosicaoAtual(linhaDestino, colunaDestino);
								aux = tabuleiro.getQuadrado(peca.getLinhaAtual(), 0).getPeca();
								tabuleiro.getQuadrado(peca.getLinhaAtual(), 0).setPeca(null);
								tabuleiro.getQuadrado(peca.getLinhaAtual(), (peca.getColunaAtual() + 1)).setPeca(aux);
								((Torre)(tabuleiro.getQuadrado(peca.getLinhaAtual(), (peca.getColunaAtual() + 1)).getPeca())).setEstaNaPosicaoInicial(false);
								tabuleiro.getQuadrado(peca.getLinhaAtual(), (peca.getColunaAtual() + 1)).getPeca().setPosicaoAtual(peca.getLinhaAtual(), (peca.getColunaAtual() + 1));
								((Rei) peca).setUsouRoque(true);
								alteraVez();
							}
							else{
								peca.setPosicaoAtual(linhaDestino, colunaDestino);
								alteraVez();
							}
						}
						else{
							peca.setPosicaoAtual(linhaDestino, colunaDestino);
							alteraVez();
						}
					}
				}
			}
		}
		else{
			JOptionPane.showMessageDialog(null,"2 - Movimento invalido");
			return;
		}

	}

	public void alteraVez(){
		if(this.JogadorDaVez == CorDaPeca.BRANCA){
			JogadorDaVez = CorDaPeca.PRETA; 
		}
		else{
			JogadorDaVez = CorDaPeca.BRANCA;
		}
	}

	@Override
	public void comerPeca(Peca p) {
		if(JogadorDaVez == CorDaPeca.PRETA){
			pecasBrancasCapturadas.add(p);
		}
		else{
			pecasPretasCapturadas.add(p);
		}
	}

	@Override
	public boolean pecaEhDoJogadorAtual(Peca p) {
		if(JogadorDaVez == p.getCor()){
			return true;
		}
		return false;

	}

	public List<Peca> xeque(Rei rei) {
		List<Peca> pecasDeXeque = new ArrayList<Peca>();
		CorDaPeca cor;

		if(rei.getCor() == CorDaPeca.BRANCA)
			cor = CorDaPeca.PRETA;
		else
			cor = CorDaPeca.BRANCA;

		/*
		 * Abaixo, verifica se cada coordenada x e y de cada peca do
		 * jogo esta na mesma coordenada do Rei passado como parametro.
		 * Se sim, imprime qual peca de xeque se trata e adiciona na
		 * lista de pecasDeXeque.
		 * 
		 */

		for(Peca peca: tabuleiro.getPecasDoJogo(cor)){
			for(Coordenada xy: peca.getMovimentosValidos(peca, tabuleiro)){
				if(xy.getLinha() == rei.getLinhaAtual()){
					if(xy.getColuna() == rei.getColunaAtual()){
						pecasDeXeque.add(peca);
						break;						
					}	
				}
			}
		}

		return pecasDeXeque;
	}

	@Override
	public boolean verificaXeque(Rei rei){
		if(xeque(rei).size() != 0)
			return true;
		return false;

	}

	@Override
	public boolean movimentoEhValido(int linhaDestino, int colunaDestino,Peca peca) {

		Coordenada proximoMovimento = new Coordenada(linhaDestino, colunaDestino);

		for( Coordenada movimento : peca.getMovimentosValidos(peca, tabuleiro)){
			if(proximoMovimento.getLinha() == movimento.getLinha() && proximoMovimento.getColuna() == movimento.getColuna())

				return true;
		}
		return false;
	}
	
	public String getTipoDaPeca(int linha, int coluna) {
		String peca = tabuleiro.getQuadrado(linha, coluna).getPeca().getNomeDaPeca();
		return peca;		
		}
	
	public boolean movimentarPeca(int linha1, int coluna1,int linhaFutura, int colunaFutura){
		Peca p = tabuleiro.getQuadrado(linha1, coluna1).getPeca();
		this.moverPeca(p, linhaFutura, colunaFutura);
		return true;
		
	}
	
}
