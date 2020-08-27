package dev.thethatcher;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoardPanel extends JPanel {
	GameBoardPanel(){
		JLabel label = new JLabel("Success");
		add(label);
		setVisible(true);
	}
}
