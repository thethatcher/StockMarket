package dev.thethatcher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLDocument.Iterator;

public class NewGamePanel extends JPanel implements ActionListener{
	LinkedList<PlayerData> players;
	Board board;
	JPanel playerPanel;
	JButton addPlayer, start;
	NewGamePanel(Board board){
		super();
		this.board = board;
		this.players = board.players;
		this.setLayout(new BorderLayout());
		addPlayer = new JButton("Add Player");
		start = new JButton("Start Game");
		JPanel southButtons = new JPanel();
		southButtons.add(addPlayer);
		southButtons.add(start);
		addPlayer.addActionListener(this);
		playerPanel = new JPanel();
		playerPanel.setVisible(true);
		BoxLayout bl = new BoxLayout(playerPanel, BoxLayout.PAGE_AXIS);
		playerPanel.setLayout(bl);
		add(playerPanel,BorderLayout.NORTH);
		add(southButtons,BorderLayout.SOUTH);
		this.setVisible(true);		
	}
	
	private void drawPlayers() {
		playerPanel.removeAll();
		for(int i = 0; i < players.size(); i++) {
			playerPanel.add(new NewPlayer(this,players.get(i)));
		}
		playerPanel.revalidate();
		playerPanel.repaint();
	}
	
	public void removePlayer(PlayerData player) {
		players.remove(player);
		drawPlayers();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		String player;
		if(source == addPlayer) {
			player = JOptionPane.showInputDialog(null, "Enter Player Name", "Add Player", JOptionPane.QUESTION_MESSAGE);
			players.add(new PlayerData(player));
			drawPlayers();
		}
	}
	
}
