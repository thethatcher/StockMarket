package dev.thethatcher;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PointPanel extends JPanel {
	JButton rollDice = new JButton("Roll Dice");
	private JLabel die1, die2;
	ImageIcon[] diceIcons = new ImageIcon[6];
	
	PointPanel(){
		super();
		BoxLayout bl = new BoxLayout(this,BoxLayout.Y_AXIS);
		this.setLayout(bl);
		JPanel dicePanel = createDice();
		this.add(rollDice);
		this.add(dicePanel);
		this.setVisible(true);
	}
	
	private JPanel createDice() {
		JPanel dice = new JPanel();
		createDiceIcons();
		this.die1 = new JLabel(diceIcons[rollDie() - 1 ]);
		this.die2 = new JLabel(diceIcons[rollDie() - 1]);
		dice.add(die1);
		dice.add(die2);
		dice.setVisible(true);		
		return dice;
	}
	
	private void createDiceIcons() {
		for(int i = 0; i < 6; i++) {
			diceIcons[i] = new ImageIcon( (i+1) + ".png");
		}
	}
	
	private int rollDie() {
		return (int) Math.ceil((Math.random() * 6));
	}
}
