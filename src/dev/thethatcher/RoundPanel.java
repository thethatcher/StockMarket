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
	int roundCounter = 1;
	
	RoundPanel(){
		super();
		nextRound = new JButton("Next Round");
		nextRound.addActionListener(this);
		newGame = new JButton("New Game");
		roundLabel = new JLabel("Round " + roundCounter,JLabel.CENTER);
		roundLabel.setFont(roundLabel.getFont().deriveFont(24f));
		BoxLayout bl = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(bl);
		add(Box.createHorizontalGlue());
		add(newGame);
		add(Box.createRigidArea(new Dimension(35,0)));
		add(roundLabel);
		add(Box.createRigidArea(new Dimension(35,0)));
		add(nextRound);
		add(Box.createHorizontalGlue());
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
