package dev.thethatcher;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.sun.prism.paint.Color;
import com.sun.xml.internal.ws.api.Component;

public class PointPanel extends JPanel implements ActionListener{
	JButton rollDice = new JButton("Roll Dice");
	private JLabel die1, die2;
	ImageIcon[] diceIcons = new ImageIcon[6];
	JLabel currentPot,pointsLabel;
	Board board;
	int rollCount = 1;
	
	PointPanel(Board board){
		super();
		this.board = board;
		BoxLayout bl = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(bl);
		rollDice.addActionListener(this);
		this.add(Box.createHorizontalGlue());
		this.add(createDicePane());
		this.add(Box.createRigidArea(new Dimension(10,0)));
		this.add(new BoxSeparator(JSeparator.VERTICAL, 100));
		this.add(Box.createRigidArea(new Dimension(10,0)));
		this.add(createPointsPane());
		this.add(Box.createRigidArea(new Dimension(10,0)));
		this.add(new BoxSeparator(JSeparator.VERTICAL,100));
		this.add(Box.createRigidArea(new Dimension(10,0)));
		this.add(createPotPane());
		this.add(Box.createHorizontalGlue());		
		this.setVisible(true);
	}
	
	private JPanel createPointsPane() {
		JPanel pointsPane = new JPanel();
		BoxLayout bl = new BoxLayout(pointsPane,BoxLayout.X_AXIS);
		pointsPane.setLayout(bl);
		pointsLabel = new JLabel("Roll the dice!",JLabel.CENTER);
		pointsLabel.setFont(pointsLabel.getFont().deriveFont(20f));
		pointsPane.add(pointsLabel);
		return pointsPane;
	}

	private JPanel createPotPane() {
		
		JPanel potPane = new JPanel();
		BoxLayout bl = new BoxLayout(potPane,BoxLayout.Y_AXIS);
		potPane.setMaximumSize(new Dimension(200,100));
		potPane.setLayout(bl);
		JLabel potLabel = new JLabel("Pot",JLabel.CENTER);
		potLabel.setFont(potLabel.getFont().deriveFont(24f));
		currentPot = new JLabel("123,456",JLabel.CENTER);
		potPane.add(potLabel);
		potPane.add(Box.createRigidArea(new Dimension(5,0)));
		potPane.add(new BoxSeparator(SwingConstants.HORIZONTAL));
		potPane.add(currentPot);
		potPane.add(Box.createVerticalGlue());
		return potPane;
	}
	
	private JPanel createDicePane() {
		JPanel dicePane = new JPanel();
		BoxLayout bl = new BoxLayout(dicePane,BoxLayout.Y_AXIS);
		dicePane.setLayout(bl);
		JPanel dicePanel = createDice();
		dicePanel.setAlignmentX(CENTER_ALIGNMENT);
		rollDice.setAlignmentX(CENTER_ALIGNMENT);
		dicePane.add(rollDice);
		dicePane.add(dicePanel);
		dicePane.setVisible(true);
		dicePane.setMaximumSize(new Dimension(100,100)); // This helps, but only for the left most pane...
		return dicePane;
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
	
	private void drawDice(int d1, int d2) {
		this.die1.setIcon(diceIcons[d1]);
		die2.setIcon(diceIcons[d2]);
		this.die1.revalidate();
		this.die1.repaint();
		die2.revalidate();
		die2.repaint();
	}
	
	private void drawPointsLabel() {
		pointsLabel.revalidate();
		pointsLabel.repaint();
	}
	
	public void drawPointsLabel(String text) {
		pointsLabel.setText(text);
		drawPointsLabel();
	}
	
	public void drawPotLabel() {
		currentPot.setText(board.pot + "");
		currentPot.revalidate();
		currentPot.repaint();
	}
	
	private void marketOpenDiceRoll(int num1, int num2) {
		if(num1 + num2 == 7) {
			//bust
			board.pot = 0;
			pointsLabel.setText("Busted!");
			drawPotLabel();
			drawPointsLabel();
			for(Player player : board.playerList) {
				player.enableCashout(false);
			}
			rollDice.setEnabled(false);
			board.roundPanel.nextRound.setEnabled(true);
		} else if (num1 == num2) {
			//doubles
			board.pot = board.pot * 2;
			pointsLabel.setText("Doubles!");
			drawPotLabel();
			drawPointsLabel();
		} else {
			int points = ((num1 + num2) * 10);
			board.pot += points;
			drawPotLabel();
			pointsLabel.setText(points + " points!");
			drawPointsLabel();
		}
	}
	
	private void marketClosedRollDice(int num1, int num2) {
		int sum = num1 + num2;
			board.pot += (10*sum);
			drawPotLabel();
			pointsLabel.setText( (sum*10) + " points!!");
			drawPointsLabel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if(source == rollDice) {
			int num1 = rollDie();
			int num2 = rollDie();
			
			drawDice(num1 - 1,num2 -1);
			if(rollCount <= 3) {
				marketClosedRollDice(num1,num2);
				rollCount++;
				if(rollCount == 4) {
					for(Player player : board.playerList) {
						player.enableCashout(true);
					}
				}
			} else {
				marketOpenDiceRoll(num1,num2);	
				rollCount++;
			}
		}
	}
}
