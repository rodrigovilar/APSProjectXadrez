package xadrez;

import JPlay.GameImage;

public class Rainha extends Peca {

	public Rainha(int peso,CorDaPeca cor, int linha, int coluna, GameImage nome) {
		super(peso, cor, linha, coluna, nome);
	}

	@Override
	public void movimentos(Tabuleiro t) {
		
		Coordenada posicao;
		
		// A Rainha possui os movimentos do Bispo e os movimentos da Torre.
		
		// Este "for" realiza os movimentos do Bispo.
		
		int a1 = 1;
		int a2 = 1;
		int a3 = 1;
		int a4 = 1;


		for(int i = 1; i <= 7; i++){
			
			if ( this.linhaAtual + a1 <= 7 && (this.colunaAtual + i <= 7)){
				posicao = new Coordenada(this.linhaAtual + i, (this.colunaAtual + i));
				if (t.getQuadrado(this.linhaAtual +i, (this.colunaAtual + i)).getPeca() != null){
					if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual + i, (this.colunaAtual +i)).getPeca())){
						this.ListaDeMovimentos.add(posicao);
						a1 = 8;
					}
					else
						a1 = 8;					
				}
				
				this.ListaDeMovimentos.add(posicao);
				++a1;
			}
			
			if (this.linhaAtual - a2 >= 0 && (this.colunaAtual - a2 >= 0)){
				posicao = new Coordenada(this.linhaAtual -i, (this.colunaAtual -i));
				if (t.getQuadrado(this.linhaAtual -i, (this.colunaAtual -i)).getPeca() != null){
					if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual - i, (this.colunaAtual -i)).getPeca())){
						this.ListaDeMovimentos.add(posicao);
						a2 = 8;
					}
					else
						a2 = 8;
				}
				this.ListaDeMovimentos.add(posicao);
				++ a2;
			}
			
			if(this.linhaAtual + a3 <= 7 && (this.colunaAtual - a3 >= 0)){
				posicao = new Coordenada(this.linhaAtual + i, (this.colunaAtual -i));
				if (t.getQuadrado(this.linhaAtual +i, (this.colunaAtual -i)).getPeca() != null){
					if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual + i, (this.colunaAtual -i)).getPeca())){
						this.ListaDeMovimentos.add(posicao);
						a3 = 8;
					}
					else
						a3 = 8;
				}
				this.ListaDeMovimentos.add(posicao);
				++ a3;

			}
			
			if(this.linhaAtual - a4 >= 0 && (this.colunaAtual +a4 <= 7)){
				posicao = new Coordenada(this.linhaAtual -i, (this.colunaAtual + i));
				if (t.getQuadrado(this.linhaAtual -i, (this.colunaAtual +i)).getPeca() != null){
					if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual - i, this.colunaAtual +i).getPeca())){
						this.ListaDeMovimentos.add(posicao);
						a4 = 8;
					}
					else
						a4 = 8;
				}
				this.ListaDeMovimentos.add(posicao);
				++ a4;

			}
		}
		
		// Os 4 "for's" abaixo realizam os movimentos da Torre.		
		
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
