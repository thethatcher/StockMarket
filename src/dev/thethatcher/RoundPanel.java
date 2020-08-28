package dev.thethatcher;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoundPanel extends JPanel implements ActionListener {
	JButton nextRound;
	JButton newGame;
	JLabel roundLabel;
	int roundCounter = 1;
	
	RoundPanel(){
		super();
		nextRound = new JButton("Next Round");
		nextRound.addActionListener(this);
		newGame = new JButton("New Game");
		roundLabel = new JLabel("Round " + roundCounter,JLabel.CENTER);
		GridLayout gl = new GridLayout(1,3);
		setLayout(gl);
		add(newGame);
		add(roundLabel);
		add(nextRound);
		setVisible(true);
	}
	
	private void nextRound() {
		roundCounter++;
		roundLabel.setText("Round " + roundCounter);
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if(source == nextRound) {
			nextRound();
		}
		
	}
}
