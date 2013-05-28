package xadrez;

public class Quadrado {

	private Peca peca;
	private Coordenada inicio;
	private Coordenada fim;
	
	public Quadrado(){
		this.peca = null;

	}
	
	public Coordenada getInicio() {
		return inicio;
	}

	public Coordenada getFim() {
		return fim;
	}


	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	
	
	/**
	 * Verifica se um quadrado contem uma peca.
	 * @return boolean
	 */
	public boolean estaOcupado(){
		if(this.peca != null)
			return true;
		else
			return false;
	}
}
