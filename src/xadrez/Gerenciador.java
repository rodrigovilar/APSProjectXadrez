package xadrez;

import javax.swing.JOptionPane;
import JPlay.GameImage;
import JPlay.Mouse;
import JPlay.Window;

public class Gerenciador {

	public void iniciar(){

		Window janela = new Window(747, 687);
		Mouse mouse = janela.getMouse();		
		GameImage backGround = new GameImage("tabuleiro2.png");
		GameImage borda = new GameImage("marca.png");
		GameImage reiniciar = new GameImage("new game.png");
		GameImage sair = new GameImage("sair.png");

		JogoXadrez xadrez = new JogoXadrez();
		int linhaInicio, colunaInicio;

		int linhaDestino = 0;
		int colunaDestino = 0;	
		Peca p;
		while (true){
			backGround.draw();
			xadrez.getTabuleiro().toString(xadrez);
			reiniciar.setPosition(270, 30);
			sair.setPosition(378, 30);
			reiniciar.draw();
			sair.draw();
			janela.display();

			linhaInicio = 0;
			colunaInicio = 0;
			
			
			if(mouse.isLeftButtonPressed()){
				verificaReinicio(mouse.getPosition().x, mouse.getPosition().y, reiniciar, janela);
				verificaSair(mouse.getPosition().x, mouse.getPosition().y, sair, janela);
				colunaInicio = (int)((mouse.getPosition().x - 123) / 62.5);
				if(colunaInicio >= 0 && colunaInicio <= 7){
					linhaInicio = (int) ((mouse.getPosition().y - 95) / 62.5);
					if(linhaInicio >= 0 && linhaInicio <= 7){
						p = xadrez.getTabuleiro().getQuadrado(linhaInicio, colunaInicio).getPeca();
						if(p != null){
							if(p.getCor() == xadrez.getJogadorDaVez()){
								borda.setPosition((colunaInicio * 62.5) + 118, (linhaInicio * 62.5) + 90);
								borda.draw();
								janela.display();
								while (true){
									linhaDestino = 0;
									colunaDestino = 0;

									if(mouse.isLeftButtonPressed()){	
										verificaReinicio(mouse.getPosition().x, mouse.getPosition().y, reiniciar, janela);
										verificaSair(mouse.getPosition().x, mouse.getPosition().y, sair, janela);
										colunaDestino = (int) ((mouse.getPosition().x - 125) / 62.5);
										if(colunaDestino >= 0 && colunaDestino <= 7){
											linhaDestino = (int)((mouse.getPosition().y - 95) / 62.5);
											if(linhaDestino >= 0 && linhaDestino <= 7){
												p = xadrez.getTabuleiro().getQuadrado(linhaDestino, colunaDestino).getPeca();
												if(p != null){
													if(p.getCor() == xadrez.getJogadorDaVez()){
														linhaInicio = linhaDestino;
														colunaInicio = colunaDestino;														
														borda.setPosition((colunaInicio * 62.5) + 118, (linhaInicio * 62.5) + 90);
														backGround.draw();
														xadrez.getTabuleiro().toString(xadrez);
														borda.draw();
														reiniciar.setPosition(270, 30);
														sair.setPosition(378, 30);
														reiniciar.draw();
														sair.draw();
														janela.display();
														continue;
													}
												}
												Peca peca = xadrez.getTabuleiro().getQuadrado(linhaInicio, colunaInicio).getPeca();
												xadrez.moverPeca(peca, linhaDestino, colunaDestino);
												break;	
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	public void verificaReinicio(int x, int y, GameImage g, Window janela){
		if(x > 270 && x <= 370){
			if(y > 30 && y <= 60){
				g = new GameImage("new game2.png");
				g.setPosition(270, 30);
				g.draw();
				janela.display();
				int opcao = JOptionPane.showConfirmDialog(null, "INICIAR UM NOVO JOGO?", "New Game", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(opcao == 0)
					iniciar();
				else{
					g = new GameImage("new game.png");
					g.setPosition(270, 30);
					g.draw();
					janela.display();
				}
			}
		}
	}
	public boolean verificaSair(int x, int y, GameImage g, Window janela){
		if(x > 378 && x <= 478){
			if(y > 30 && y <= 60){
				g = new GameImage("sair2.png");
				g.setPosition(378, 30);
				g.draw();
				janela.display();
				int opcao = JOptionPane.showConfirmDialog(null, "DESEJA SAIR?", "End Game", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(opcao == 0)
					janela.exit();
					
				else{
					g = new GameImage("sair.png");
					g.setPosition(378, 30);
					g.draw();
					janela.display();
					return false;
				}
			}
		}
		return true;
		
	}
}



