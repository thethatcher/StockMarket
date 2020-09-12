package dev.thethatcher;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Player extends JPanel implements ActionListener{
	PlayerData player;
	JLabel score;
	JButton cashout;
	Board board;
	
	Player(Board board, PlayerData player){
		super();
		this.board = board;
		this.player = player;
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		cashout = new JButton("Cash-Out");
		cashout.addActionListener(this);
		score = new JLabel(player.getScore() + "", JLabel.CENTER);
		this.add(Box.createHorizontalGlue());
		this.add(new JLabel(player.getName(), JLabel.CENTER));
		this.add(Box.createRigidArea(new Dimension(10,0)));
		this.add(score);
		this.add(Box.createRigidArea(new Dimension(10,0)));
		this.add(cashout);
		this.add(Box.createHorizontalGlue());
	}
	
	private void drawScore() {
		score.setText(player.getScore() + "");
		score.repaint();
	}
	
	public void enableCashout(boolean flag) {
		cashout.setEnabled(flag);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if(source == cashout) {
			player.addToScore(board.pot); 
			drawScore();
			cashout.setEnabled(false);
			//check if all players are cashed out
			boolean allOut = true;
			for(Player player : board.playerList) {
				if(player.cashout.isEnabled()) {
					allOut = false;
				}
			}
			if(allOut) {
				board.pointPanel.rollDice.setEnabled(false);
				board.roundPanel.enableNextRoud();
			}
		}
	}
	
}


