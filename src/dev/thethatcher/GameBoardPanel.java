package dev.thethatcher;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {
	JButton newGame;
	RoundPanel roundPanel;
	GameBoardPanel(){
		roundPanel = new RoundPanel();
		this.add(roundPanel);
		setVisible(true);
	}
}

