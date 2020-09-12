package dev.thethatcher;

import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PlayerPanel extends JPanel {
	JPanel playerListPanel;
	Board board;
	
	PlayerPanel(Board board){
		super();
		this.board = board;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		playerListPanel = new JPanel();
		playerListPanel.setLayout(new BoxLayout(playerListPanel,BoxLayout.Y_AXIS));
		this.add(playerListPanel);
		this.setVisible(true);
	}
	
	public void setPlayers() {
		for(PlayerData player : board.players) {
			board.playerList.add(new Player(board, player));
		}
	}

	public void drawPlayers() {
		playerListPanel.removeAll();
		for(Player player : board.playerList) {
			playerListPanel.add(player);
			playerListPanel.add(new BoxSeparator(BoxSeparator.HORIZONTAL,150));
		}
		playerListPanel.revalidate();
		playerListPanel.repaint();
	}
	
}
