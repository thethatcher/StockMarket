package dev.thethatcher;

import javax.swing.JFrame;

public class Board extends JFrame {
	Board(){
		super("The Stock Market Game");
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameWizard gw = new GameWizard();
		this.add(gw);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Board board = new Board();
	}

}
