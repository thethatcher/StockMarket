package dev.thethatcher;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.sun.prism.paint.Color;

public class RoundPanel extends JPanel implements ActionListener {
	JButton nextRound;
	JButton newGame;
	JLabel roundLabel;
	int roundCounter;
	
	RoundPanel(){
		super();
		roundCounter = 1;
		nextRound = new JButton("Next Round");
		nextRound.addActionListener(this);
		newGame = new JButton("New Game");
		roundLabel = new JLabel("Round " + roundCounter,JLabel.CENTER);
		roundLabel.setFont(roundLabel.getFont().deriveFont(24f));
		BoxLayout bl = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(bl);
		this.add(Box.createHorizontalGlue());
		this.add(newGame);
		this.add(Box.createRigidArea(new Dimension(35,0)));
		this.add(roundLabel);
		this.add(Box.createRigidArea(new Dimension(35,0)));
		this.add(nextRound);
		this.add(Box.createHorizontalGlue());
		this.setVisible(true);
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
