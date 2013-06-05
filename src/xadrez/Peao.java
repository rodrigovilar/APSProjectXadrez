package xadrez;

import JPlay.GameImage;

public class Peao extends Peca {
	
	private boolean estaNaPosicaoInicial;
	
	public boolean isEstaNaPosicaoInicial() {
		return estaNaPosicaoInicial;
	}

	public void setEstaNaPosicaoInicial(boolean estaNaPosicaoInicial) {
		this.estaNaPosicaoInicial = estaNaPosicaoInicial;
	}

	public Peao(int peso,CorDaPeca cor, int linha, int coluna, GameImage nome,String nomePeca) {
		super(peso, cor, linha, coluna, nome, nomePeca);
		this.estaNaPosicaoInicial = true;
	}
	
	public boolean getPosicaoAtual(){
		return this.estaNaPosicaoInicial;
	}
	
	@Override
	public void movimentos(Tabuleiro t) {
		
		Coordenada posicao;
		
		if(this.cor == CorDaPeca.BRANCA){
			if(this.estaNaPosicaoInicial){
				posicao = new Coordenada(this.linhaAtual+2 ,this.colunaAtual);
				this.ListaDeMovimentos.add(posicao);
				this.estaNaPosicaoInicial = false;

			}
			
			
			if(! t.getQuadrado(linhaAtual +1, colunaAtual).estaOcupado()){
				posicao = new Coordenada(this.linhaAtual+1, this.colunaAtual);
				this.ListaDeMovimentos.add(posicao);
			}
			
			posicao = new Coordenada(this.linhaAtual +1, (this.colunaAtual-1));
			if(coordenadaEhValida(posicao) && t.getQuadrado(this.linhaAtual +1, (this.colunaAtual -1)).estaOcupado()){
				if(t.getQuadrado(this.linhaAtual +1, (this.colunaAtual-1)).getPeca().getCor() == CorDaPeca.PRETA)
					this.ListaDeMovimentos.add(posicao);
			}

			posicao = new Coordenada(this.linhaAtual +1, (this.colunaAtual +1));
			if(coordenadaEhValida(posicao) && t.getQuadrado(this.linhaAtual +1, (this.colunaAtual +1)).estaOcupado() ){
				if(t.getQuadrado(this.linhaAtual +1, (this.colunaAtual +1)).getPeca().getCor() == CorDaPeca.PRETA)
					this.ListaDeMovimentos.add(posicao);
			}
		}
		else{
			
			if(this.estaNaPosicaoInicial){
				posicao = new Coordenada(this.linhaAtual-2 ,this.colunaAtual);
				this.ListaDeMovimentos.add(posicao);
				this.estaNaPosicaoInicial = false;
			}
			
			if(! t.getQuadrado(linhaAtual -1, colunaAtual).estaOcupado()){
				posicao = new Coordenada(this.linhaAtual-1, this.colunaAtual);
				this.ListaDeMovimentos.add(posicao);
			}
			
			posicao = new Coordenada(this.linhaAtual -1, (this.colunaAtual -1));
			if(coordenadaEhValida(posicao) && t.getQuadrado(this.linhaAtual -1, (this.colunaAtual -1)).estaOcupado()){
				if(t.getQuadrado(this.linhaAtual -1, this.colunaAtual -1).getPeca().getCor() == CorDaPeca.BRANCA)
					this.ListaDeMovimentos.add(posicao);
			}
			posicao = new Coordenada(this.linhaAtual -1, this.colunaAtual +1);
			if(coordenadaEhValida(posicao) && t.getQuadrado(this.linhaAtual -1, (this.colunaAtual +1)).estaOcupado()){
				if(t.getQuadrado(this.linhaAtual -1, this.colunaAtual +1).getPeca().getCor() == CorDaPeca.BRANCA)
					this.ListaDeMovimentos.add(posicao);
			}
		}
		
	}

}
