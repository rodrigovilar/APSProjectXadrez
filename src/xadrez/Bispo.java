package xadrez;

import JPlay.GameImage;

public class Bispo extends Peca {

	public Bispo (int peso,CorDaPeca cor, int linha, int coluna, GameImage nome, String nomeDaPeca) {
		super(peso, cor, linha, coluna,nome, nomeDaPeca);
	}

	@Override
	public void movimentos(Tabuleiro t) {
		
		Coordenada posicao;
		
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
	}

}
