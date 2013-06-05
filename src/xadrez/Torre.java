package xadrez;

import JPlay.GameImage;

public class Torre extends Peca{
	
	private boolean estaNaPosicaoInicial;

	public boolean EstaNaPosicaoInicial() {
		return estaNaPosicaoInicial;
	}

	public void setEstaNaPosicaoInicial(boolean estaNaPosicaoInicial) {
		this.estaNaPosicaoInicial = estaNaPosicaoInicial;
	}

	public Torre(int peso, CorDaPeca cor, int linha, int coluna, GameImage nome, String nomeDaPeca) {
		super(peso, cor, linha, coluna, nome, nomeDaPeca);
		this.estaNaPosicaoInicial = true;
	}

	@Override
	public void movimentos(Tabuleiro t) {
		
		Coordenada posicao;
		
		for(int i = this.linhaAtual; i < 7; i++){ // varre a coluna pra cima
			posicao = new Coordenada( i + 1, this.colunaAtual);
			if (t.getQuadrado(i + 1, this.colunaAtual).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(i + 1, this.colunaAtual).getPeca())){
					this.ListaDeMovimentos.add(posicao);
					break;
				}
				else
					break;					
			}
			this.ListaDeMovimentos.add(posicao);

		}
		for(int i = this.linhaAtual; i > 0; i--){ // varre a coluna pra baixo
			posicao = new Coordenada( i - 1, this.colunaAtual);
			if (t.getQuadrado(i - 1, this.colunaAtual).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(i - 1, this.colunaAtual).getPeca())){
					this.ListaDeMovimentos.add(posicao);
					break;
				}
				else
					break;					
			}
			this.ListaDeMovimentos.add(posicao);
		}
		for(int i = this.colunaAtual; i < 7; i++){  // varre a linha pra direita
			posicao = new Coordenada(this.linhaAtual, i + 1);
			if (t.getQuadrado(this.linhaAtual, (i+1)).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual, (i +1)).getPeca())){
					this.ListaDeMovimentos.add(posicao);
					break;
				}
				else
					break;					
			}
			this.ListaDeMovimentos.add(posicao);
		}
		for(int i = this.colunaAtual; i > 0; i--){  // varre a linha para esquerda
			posicao = new Coordenada(this.linhaAtual, i - 1);
			if (t.getQuadrado(this.linhaAtual, (i -1)).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual, (i -1)).getPeca())){
					this.ListaDeMovimentos.add(posicao);
					break;
				}
				else
					break;					
			}
			this.ListaDeMovimentos.add(posicao);
		}
	}

}
