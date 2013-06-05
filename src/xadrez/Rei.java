package xadrez;

import JPlay.GameImage;

public class Rei extends Peca {

	private boolean estaNaPosicaoInicial;
	private boolean usouRoque;

	public boolean estaNaPosicaoInicial(){
		return this.estaNaPosicaoInicial;
	}

	public void setEstaNaPosicaoInicial(boolean estaNaPosicaoInicial) {
		this.estaNaPosicaoInicial = estaNaPosicaoInicial;
	}

	public Rei(int peso, CorDaPeca cor, int linha, int coluna, GameImage nome, String nomeDaPeca) {
		super(peso, cor, linha, coluna, nome, nomeDaPeca);
		this.estaNaPosicaoInicial = true;
		this.usouRoque = false;

	}
	@Override
	public void movimentos(Tabuleiro t) {

		Coordenada posicao;
		Peca torreTemp;

		if((this.linhaAtual + 1) <= 7){
			posicao = new Coordenada(this.linhaAtual + 1, this.colunaAtual);
			if (t.getQuadrado(this.linhaAtual + 1, this.colunaAtual).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual + 1, this.colunaAtual).getPeca()))
					this.ListaDeMovimentos.add(posicao);
			}
			else
				this.ListaDeMovimentos.add(posicao);

		}

		if((this.colunaAtual + 1) <= 7){
			posicao = new Coordenada(this.linhaAtual, (this.colunaAtual + 1));
			if (t.getQuadrado(this.linhaAtual, (this.colunaAtual + 1)).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual, (this.colunaAtual+1)).getPeca()))
					this.ListaDeMovimentos.add(posicao);
			}
			else
				this.ListaDeMovimentos.add(posicao);
		}
		if((this.linhaAtual - 1) >= 0){

			posicao = new Coordenada(this.linhaAtual - 1, this.colunaAtual);
			if (t.getQuadrado(this.linhaAtual - 1, this.colunaAtual).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual - 1, this.colunaAtual).getPeca()))
					this.ListaDeMovimentos.add(posicao);
			}
			else
				this.ListaDeMovimentos.add(posicao);
		}

		if((this.colunaAtual - 1) >= 0){
			posicao = new Coordenada(this.linhaAtual, (this.colunaAtual - 1));
			if (t.getQuadrado(this.linhaAtual, (this.colunaAtual - 1)).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual, (this.colunaAtual-1)).getPeca()))
					this.ListaDeMovimentos.add(posicao);
			}
			else
				this.ListaDeMovimentos.add(posicao);
		}

		if((this.linhaAtual - 1) >= 0 && ( this.colunaAtual - 1) >= 0){
			posicao = new Coordenada(this.linhaAtual - 1, (this.colunaAtual - 1));
			if (t.getQuadrado(this.linhaAtual - 1, (this.colunaAtual - 1)).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual - 1, (this.colunaAtual - 1)).getPeca()))
					this.ListaDeMovimentos.add(posicao);
			}
			else
				this.ListaDeMovimentos.add(posicao);
		}
		if((this.linhaAtual + 1) <= 7 && (this.colunaAtual + 1) <= 7){
			posicao = new Coordenada(this.linhaAtual + 1, (this.colunaAtual + 1));
			if (t.getQuadrado(this.linhaAtual + 1, (this.colunaAtual + 1)).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual + 1, (this.colunaAtual + 1)).getPeca()))
					this.ListaDeMovimentos.add(posicao);
			}
			else
				this.ListaDeMovimentos.add(posicao);
		}

		if((this.linhaAtual + 1) <= 7 && (this.colunaAtual - 1) >= 0){
			posicao = new Coordenada(this.linhaAtual + 1, (this.colunaAtual - 1));
			if (t.getQuadrado(this.linhaAtual + 1, (this.colunaAtual - 1)).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual + 1, (this.colunaAtual - 1)).getPeca()))
					this.ListaDeMovimentos.add(posicao);
			}
			else
				this.ListaDeMovimentos.add(posicao);
		}
		if ((this.linhaAtual - 1) >= 0 && (this.colunaAtual + 1) <= 7){
			posicao = new Coordenada(this.linhaAtual - 1, (this.colunaAtual + 1));
			if (t.getQuadrado(this.linhaAtual - 1, (this.colunaAtual + 1)).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual - 1, (this.colunaAtual + 1)).getPeca()))
					this.ListaDeMovimentos.add(posicao);
			}
			else
				this.ListaDeMovimentos.add(posicao);
		}

		// Roque brancas

		if(this.linhaAtual == 0){

			if(this.estaNaPosicaoInicial && (! this.usouRoque)){
				// Roque a direita do rei branco
				for(int i = this.colunaAtual+1;i <= 6;i++){
					if((!t.getQuadrado(this.linhaAtual, i).estaOcupado()) && i < 6)
						continue;
					else if(t.getQuadrado(this.linhaAtual, i).estaOcupado())
						break;
					else if((!t.getQuadrado(this.linhaAtual, i).estaOcupado()) && i == 6){
						torreTemp = t.getQuadrado(linhaAtual, i + 1).getPeca();
						if(torreTemp instanceof Torre){
							if(((Torre) torreTemp).EstaNaPosicaoInicial()){
								posicao = new Coordenada(this.linhaAtual, i - 1);
								this.ListaDeMovimentos.add(posicao);
							}
						}
					}
				}
				//roque a esquerda do rei branco
				for(int i = this.colunaAtual-1; i >= 1;i--){
					if((!t.getQuadrado(this.linhaAtual, i).estaOcupado()) && i > 1)
						continue;
					else if(t.getQuadrado(this.linhaAtual, i).estaOcupado())
						break;
					else if ( (!t.getQuadrado(this.linhaAtual, i).estaOcupado()) && i == 1){
						torreTemp = t.getQuadrado(linhaAtual, i - 1).getPeca();
						if(torreTemp instanceof Torre){
							posicao = new Coordenada(this.linhaAtual, i );
							this.ListaDeMovimentos.add(posicao);
						}
					}
				}
			}

		}

		// Roque pretas

		if(this.linhaAtual == 7){

			if(this.estaNaPosicaoInicial && (! this.usouRoque)){
				//roque a direita do rei preto
				for(int i = this.colunaAtual+1;i <= 6;i++){
					if((!t.getQuadrado(this.linhaAtual, i).estaOcupado()) && i < 6)
						continue;
					else if(t.getQuadrado(this.linhaAtual, i).estaOcupado())
						break;
					else if((!t.getQuadrado(this.linhaAtual, i).estaOcupado()) && i == 6){
						torreTemp = t.getQuadrado(linhaAtual, i + 1).getPeca();
						if(torreTemp instanceof Torre){
							if(((Torre) torreTemp).EstaNaPosicaoInicial()){
								posicao = new Coordenada(this.linhaAtual, i - 1);
								this.ListaDeMovimentos.add(posicao);
							}
						}
					}
				}
				//roque a esquerda do rei preto
				for(int i = this.colunaAtual-1; i >= 1;i--){
					if((!t.getQuadrado(this.linhaAtual, i).estaOcupado()) && i > 1)
						continue;
					else if(t.getQuadrado(this.linhaAtual, i).estaOcupado())
						break;
					else if ( (!t.getQuadrado(this.linhaAtual, i).estaOcupado()) && i == 1){
						torreTemp = t.getQuadrado(linhaAtual, i - 1).getPeca();
						if(torreTemp instanceof Torre){
							posicao = new Coordenada(this.linhaAtual, i );
							this.ListaDeMovimentos.add(posicao);
						}
					}
				}
			}
		}
	}	
	public void setUsouRoque(boolean usouRoque) {
		this.usouRoque = usouRoque;
	}
}

