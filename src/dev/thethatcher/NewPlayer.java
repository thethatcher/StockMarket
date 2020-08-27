package dev.thethatcher;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class NewPlayer extends JPanel implements ActionListener {
	NewGamePanel newGamePanel;
	String playerName;
	
	NewPlayer(NewGamePanel ngp,String name){
		super();
		newGamePanel = ngp;
		playerName = name;
		BoxLayout bl = new BoxLayout(this,BoxLayout.X_AXIS);
		setLayout(bl);
		
		JButton deletePlayer = new JButton("X");
		deletePlayer.addActionListener(this);
		JLabel nameLabel = new JLabel(playerName,SwingConstants.RIGHT);
		this.add(nameLabel);
		this.add(Box.createRigidArea(new Dimension(3,0)));
		this.add(deletePlayer);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if(e.getActionCommand() == "X") {
			newGamePanel.removePlayer(playerName);
		}
		
	}

}
