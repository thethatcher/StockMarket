package dev.thethatcher;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class GameBoardPanel extends JPanel {
	JButton newGame;
	RoundPanel roundPanel;
	PointPanel pointPanel;
	
	GameBoardPanel(){
		JPanel rp = new JPanel();
		roundPanel = new RoundPanel();
		rp.add(roundPanel);
		this.setLayout(new BoxLayout(this,javax.swing.BoxLayout.Y_AXIS));
		pointPanel = new PointPanel();
		this.add(Box.createRigidArea(new Dimension(0,8)));
		this.add(roundPanel);
		this.add(Box.createRigidArea(new Dimension(0,8)));
		this.add(new JSeparator(SwingConstants.HORIZONTAL));
		this.add(pointPanel);
		//TODO add the PlayerPanel
		setVisible(true);
	}
}

