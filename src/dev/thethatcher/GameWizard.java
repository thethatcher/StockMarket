package dev.thethatcher;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameWizard extends JPanel implements ActionListener {
	CardLayout cl = new CardLayout();
	GameBoardPanel gameBoard;
	NewGamePanel ngp;
	Board board;
	
	GameWizard(Board board){
		super();
		this.setLayout(cl);
		this.board = board;
		gameBoard = new GameBoardPanel(board);
		ngp = new NewGamePanel(board);
		ngp.start.addActionListener(this);
		gameBoard.roundPanel.newGame.addActionListener(this);
		this.add(ngp,"New Game");
		this.add(gameBoard, "Game Board");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Start Game") {
			for(PlayerData player : board.players) {
				player.setScore(0);
			}
			gameBoard.playerPanel.setPlayers();
			gameBoard.playerPanel.drawPlayers();
			for(Player player : board.playerList) {
				player.enableCashout(false);
			}
			cl.show(this, "Game Board");
		} else if(e.getActionCommand() == "New Game") {
			cl.show(this, "New Game");
			// Clear points and reset round to 1
			
		}
		
	}
}
