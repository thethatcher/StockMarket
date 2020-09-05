package dev.thethatcher;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class GameBoardPanel extends JPanel {
	JButton newGame;
	RoundPanel roundPanel;
	PointPanel pointPanel;
	
	GameBoardPanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		roundPanel = new RoundPanel();
		pointPanel = new PointPanel();
		this.add(Box.createRigidArea(new Dimension(0,8)));
		this.add(roundPanel);
		this.add(Box.createRigidArea(new Dimension(0,8)));
		this.add(new BoxSeparator(JSeparator.HORIZONTAL));
		this.add(Box.createRigidArea(new Dimension(0,8)));
		this.add(pointPanel);
		this.add(Box.createRigidArea(new Dimension(0,8)));
		this.add(new BoxSeparator(JSeparator.HORIZONTAL));
		this.add(Box.createRigidArea(new Dimension(0,8)));
		this.add(Box.createVerticalGlue());
		this.add(new PlayerPanel());
		
		setVisible(true);
	}
}

