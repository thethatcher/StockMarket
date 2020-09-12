package dev.thethatcher;

import java.util.LinkedList;

import javax.swing.JFrame;

public class Board extends JFrame {
	LinkedList<PlayerData> players = new LinkedList();
	int pot;
	LinkedList<Player> playerList = new LinkedList();
	PointPanel pointPanel;
	RoundPanel roundPanel;
	
	Board(){
		super("The Stock Market Game");
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameWizard gw = new GameWizard(this);
		this.add(gw);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Board board = new Board();
	}

}
