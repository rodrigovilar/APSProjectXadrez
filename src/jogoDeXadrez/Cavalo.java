package jogoDeXadrez;

import JPlay.GameImage;

public class Cavalo extends Peca {

	public Cavalo(int peso, CorDaPeca cor, int linha, int coluna, GameImage nome, String nomeDaPeca) {
		super(peso, cor, linha, coluna, nome, nomeDaPeca);
	}

	@Override
	public void movimentos(Tabuleiro t) {
		
		Coordenada posicao;
		
		if(this.linhaAtual + 1 <= 7 && (this.colunaAtual + 2) <= 7){
			posicao = new Coordenada(this.linhaAtual + 1, (this.colunaAtual + 2));
			if (t.getQuadrado(this.linhaAtual +1, (this.colunaAtual + 2)).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual + 1, (this.colunaAtual +2)).getPeca())){
					this.ListaDeMovimentos.add(posicao);
				}
			}
			else
				this.ListaDeMovimentos.add(posicao);
		}
		
		if(this.linhaAtual + 2 <= 7 && (this.colunaAtual + 1) <= 7){
			posicao = new Coordenada(this.linhaAtual + 2, (this.colunaAtual + 1));
			if (t.getQuadrado(this.linhaAtual +2, (this.colunaAtual + 1)).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual + 2, (this.colunaAtual +1)).getPeca())){
					this.ListaDeMovimentos.add(posicao);
				}
			}
			else
				this.ListaDeMovimentos.add(posicao);
		}
		
		if(this.linhaAtual - 1 >= 0 && (this.colunaAtual - 2) >= 0){
			posicao = new Coordenada(this.linhaAtual - 1, (this.colunaAtual - 2));
			if (t.getQuadrado(this.linhaAtual -1, (this.colunaAtual - 2)).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual - 1, (this.colunaAtual -2)).getPeca())){
					this.ListaDeMovimentos.add(posicao);
				}
			}
			else
				this.ListaDeMovimentos.add(posicao);
		}		
		if(this.linhaAtual - 2 >= 0 && (this.colunaAtual - 1) >= 0){
			posicao = new Coordenada(this.linhaAtual - 2, (this.colunaAtual - 1));
			if (t.getQuadrado(this.linhaAtual -2, (this.colunaAtual - 1)).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual -2, (this.colunaAtual -1)).getPeca())){
					this.ListaDeMovimentos.add(posicao);
				}
			}
			else
				this.ListaDeMovimentos.add(posicao);
		}
		
		if(this.linhaAtual + 1 <= 7 && (this.colunaAtual - 2) >= 0){
			posicao = new Coordenada(this.linhaAtual + 1, (this.colunaAtual - 2));
			if (t.getQuadrado(this.linhaAtual +1, (this.colunaAtual - 2)).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual + 1, (this.colunaAtual -2)).getPeca())){
					this.ListaDeMovimentos.add(posicao);
				}
			}
			else
				this.ListaDeMovimentos.add(posicao);
		}
		
		if(this.linhaAtual + 2 <= 7 && (this.colunaAtual -1) >= 0){
			posicao = new Coordenada(this.linhaAtual + 2, (this.colunaAtual - 1));
			if (t.getQuadrado(this.linhaAtual +2, (this.colunaAtual -1)).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual + 2, (this.colunaAtual -1)).getPeca())){
					this.ListaDeMovimentos.add(posicao);
				}
			}
			else
				this.ListaDeMovimentos.add(posicao);
		}
		
		if(this.linhaAtual - 1 >= 0 && (this.colunaAtual + 2) <= 7){
			posicao = new Coordenada(this.linhaAtual - 1, (this.colunaAtual + 2));
			if (t.getQuadrado(this.linhaAtual -1, (this.colunaAtual + 2)).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual - 1, (this.colunaAtual +2)).getPeca())){
					this.ListaDeMovimentos.add(posicao);
				}
			}
			else
				this.ListaDeMovimentos.add(posicao);
		}
		
		if(this.linhaAtual -2 >= 0 && (this.colunaAtual +1) <= 7){
			posicao = new Coordenada(this.linhaAtual - 2, (this.colunaAtual + 1));
			if (t.getQuadrado(this.linhaAtual -2, (this.colunaAtual + 1)).getPeca() != null){
				if(pecaEhAdversaria(t.getQuadrado(this.linhaAtual -2, (this.colunaAtual +1)).getPeca())){
					this.ListaDeMovimentos.add(posicao);
				}
			}
			else
				this.ListaDeMovimentos.add(posicao);
		}
		
	}

}
