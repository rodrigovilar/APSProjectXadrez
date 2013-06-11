package jogoDeXadrez;

import java.util.ArrayList;
import java.util.List;



import JPlay.GameImage;

public abstract class Peca {
	
	protected CorDaPeca cor;
	private int pesoDaPeca;
	protected int linhaAtual;
	protected int colunaAtual;
	protected List<Coordenada> ListaDeMovimentos;
	private GameImage nome;
	private String nomeDaPeca;
	
	
	public String getNomeDaPeca() {
		return nomeDaPeca;
	}

	public void setNomeDaPeca(String nomeDaPeca) {
		this.nomeDaPeca = nomeDaPeca;
	}

	/**
	 * Recupera a lista dos possiveis movimentos de uma peca.
	 * @param p peca para verificar seus movimentos
	 * @param t tabuleiro
	 * @return List<Coordenadas>.
	 */
	public List<Coordenada> getMovimentosValidos(Peca p, Tabuleiro t) {
		this.ListaDeMovimentos = new ArrayList<Coordenada>();
		p.movimentos(t);
		return ListaDeMovimentos;
	}

	public Peca(int peso,CorDaPeca cor, int linha, int coluna, GameImage nome, String nomePeca) {
		this.nomeDaPeca = nomePeca;
		this.pesoDaPeca = peso;
		this.ListaDeMovimentos = new ArrayList<Coordenada>();
		this.cor = cor;
		this.linhaAtual = linha;
		this.colunaAtual = coluna;
		this.nome = nome;
	}
	public GameImage getNome() {
		return nome;
	}

	public void setNome(GameImage nome) {
		this.nome = nome;
	}

	public int getPesoDaPeca() {
		return pesoDaPeca;
	}

	public int getLinhaAtual() {
		return linhaAtual;
	}

	public int getColunaAtual() {
		return colunaAtual;
	}
	public CorDaPeca getCor(){
		return this.cor;
	}


	public void setPosicaoAtual(int linhaAtual, int colunaAtual) {
		this.linhaAtual = linhaAtual;
		this.colunaAtual = colunaAtual;
	}
	
	/**
	 * Recupera o quadrado atual em que uma peca esta presente, pelas suas coordenadas atuais.
	 * @param tab
	 * @return Quadrado
	 */
	public Quadrado getQuadradoAtual(Tabuleiro tab){
		return tab.getQuadrado(this.linhaAtual, this.colunaAtual);
	}
	
	/**
	 * Verifica se as possibilidades de destino de
	 * uma peca n�o ultrapassarao os limites do tabuleiro (array).
	 * @param c
	 * @return boolean
	 */
	
	public boolean coordenadaEhValida(Coordenada c){
		if ( c.getLinha() >= 0 && c.getLinha() <= 7){
			if (c.getColuna() >= 0 && c.getColuna() <= 7)
				return true;
		}
		return false;
	}
	
	public boolean pecaEhAdversaria(Peca p){
		if(this.cor == p.cor)
			return false;
		
		return true;
	}
	public abstract void movimentos(Tabuleiro t);
	
}
