package dev.thethatcher;

public class PlayerData {
	String name;
	int score, playerId;
	
	PlayerData(String name){
		this.name = name;
		this.score = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void addToScore(int points) {
		this.score += points;
	}
}
