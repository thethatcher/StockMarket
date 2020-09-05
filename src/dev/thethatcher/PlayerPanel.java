package dev.thethatcher;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PlayerPanel extends JPanel {
	PlayerPanel(){
		super();
		this.add(createHeader());
		
		this.setVisible(true);
	}
	
	private JPanel createHeader() {
		JPanel header = new JPanel();
		BoxLayout bl = new BoxLayout(header,BoxLayout.X_AXIS);
		header.setLayout(bl);
		header.add(Box.createHorizontalGlue());
		header.add(new JLabel("Player"));
		header.add(Box.createHorizontalGlue());
		header.add(new JLabel("Score"));
		header.add(Box.createHorizontalGlue());
		header.add(new JLabel("Cash Out"));
		header.add(Box.createHorizontalGlue());
		header.add(new BoxSeparator(SwingConstants.HORIZONTAL));
		return header;
	}
}
