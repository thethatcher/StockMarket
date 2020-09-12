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
	PlayerPanel playerPanel;
	Board board;
	
	GameBoardPanel(Board board){
		this.board = board;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		roundPanel = new RoundPanel(board);
		pointPanel = new PointPanel(board);
		playerPanel = new PlayerPanel(board);
		board.pointPanel = this.pointPanel;
		board.roundPanel = this.roundPanel;
		board.roundPanel.nextRound.setEnabled(false);
		this.add(Box.createRigidArea(new Dimension(0,8)));
		this.add(roundPanel);
		this.add(Box.createRigidArea(new Dimension(0,8)));
		this.add(new BoxSeparator(JSeparator.HORIZONTAL));
		this.add(Box.createRigidArea(new Dimension(0,8)));
		this.add(pointPanel);
		this.add(Box.createRigidArea(new Dimension(0,8)));
		this.add(new BoxSeparator(JSeparator.HORIZONTAL));
		this.add(Box.createRigidArea(new Dimension(0,8)));
		
		this.add(playerPanel);
		this.add(Box.createVerticalGlue());
		setVisible(true);
	}
}

