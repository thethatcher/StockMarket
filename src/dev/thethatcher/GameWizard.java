package dev.thethatcher;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameWizard extends JPanel implements ActionListener {
	CardLayout cl = new CardLayout();
	
	GameWizard(){
		super();
		this.setLayout(cl);
		GameBoardPanel gameBoard = new GameBoardPanel();
		NewGamePanel ngp = new NewGamePanel();
		ngp.start.addActionListener(this);
		gameBoard.roundPanel.newGame.addActionListener(this);
		this.add(ngp,"New Game");
		this.add(gameBoard, "Game Board");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Start Game") {
			cl.show(this, "Game Board");
		} else if(e.getActionCommand() == "New Game") {
			cl.show(this, "New Game");
			// Clear points and reset round to 1
			
		}
		
	}
}
