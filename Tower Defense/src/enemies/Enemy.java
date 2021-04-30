package enemies;

import java.awt.Image;

public abstract class Enemy implements Runnable {

	private String name = "Enemy";
	private double movementSpeed; // In tiles per seconds
	private int[] size = new int[2];
	private int healthPoints;
	private Image Texture;
	private int killReward;

	public Enemy() {}
	
	public void run() {}
	
	public void die() {
		this.setTexture(null);
	}

	// Getters and Setters
	

	// Getters
	
	public String getName() {
		return this.name;
	}

	public double getMovementSpeed() {
		return this.movementSpeed;
	}

	public int[] getSize() {
		return this.size;
	}

	public int getHealthPoints() {
		return this.healthPoints;
	}

	public int getKillReward() {
		return killReward;
	}
	
	public Image getTexture() {
		return Texture;
	}
	
	// Setters

	public void setTexture(Image texture) {
		Texture = texture;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public void setMovementSpeed(double newMovementSpeed) {
		this.movementSpeed = newMovementSpeed;
	}

	public void setSize(int newSizeX, int newSizeY) {
		this.size[0] = newSizeX;
		this.size[1] = newSizeY;
	}

	public void setHealthPoints(int newHealthPoints) {
		this.healthPoints = newHealthPoints;
	}
	
	public void setKillReward(int killReward) {
		this.killReward = killReward;
	}

}
