package xadrez;


public interface IXadrez {

	public boolean iniciarTabuleiro();
	public void moverPeca(Peca peca, int linhaDestino, int colunaDestino);
	public void comerPeca(Peca p);
	public boolean pecaEhDoJogadorAtual(Peca p);
	public boolean verificaXeque(Rei rei);
	
	/**
	 * Verifica se os movimentos de uma peca sao permitidos, mediante
	 * a consulta na lista de movimentos da peca em questao. 
	 * @param linhaDestino
	 * @param colunaDestino
	 * @param peca
	 * @return boolean
	 */
	public boolean movimentoEhValido(int linhaDestino, int colunaDestino, Peca peca);

}
