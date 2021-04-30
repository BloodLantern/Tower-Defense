package towers;

import java.awt.Image;

import all.Misc;
import enemies.Enemy;
import towers.projectiles.Projectile;

public abstract class Tower implements Runnable {
	
	private String name = "Tower";
	private int damagePerShot;
	private int shotCooldown; // In milliseconds (ms)
	private int currentCooldown;
	private int killCount = 0;
	private int range;
	private int level = 1;
	private String romanLevel;
	private Misc m = new Misc();
	private int buildCost;
	private int upgradeCost;
	private Image Texture;
	private Projectile projectile;
	private Enemy target;
	
	public Tower() {}
	
	public void run() {}
	
	public void upgrade() {
		
		this.setDamage((int) Math.round(this.getDamage() * 1.3));
		this.setCooldown((int) Math.round(this.getCooldown() / 1.1));
		this.setRange((int) Math.round(this.getRange() * 1.1));
		this.setUpgradeCost((int) Math.round(this.getUpgradeCost() * 1.5));
		this.setLevel(this.getLevel() + 1);
		this.setRomanLevel(this.getM().toRoman(this.getLevel()));
		
	}
	
	// Getters and Setters
	
	
	// Getters
	
	public String getName() {
		return this.name;
	}
	
	public int getDamage() {
		return this.damagePerShot;
	}
	
	public int getCooldown() {
		return this.shotCooldown;
	}
	
	public int getKillCount() {
		return this.killCount;
	}
	
	public int getRange() {
		return this.range;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public String getRomanLevel() {
		return romanLevel;
	}
	
	public Misc getM() {
		return m;
	}
	
	public int getUpgradeCost() {
		return upgradeCost;
	}
	
	public int getBuildCost() {
		return buildCost;
	}
	
	public int getCurrentCooldown() {
		return currentCooldown;
	}
	
	public Image getTexture() {
		return Texture;
	}
	
	public Projectile getProjectile() {
		return projectile;
	}
	
	public Enemy getTarget() {
		return target;
	}
	
	// Setters
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setDamage(int newDamage) {
		this.damagePerShot = newDamage;
	}
	
	public void setCooldown(int newCooldown) {
		this.shotCooldown = newCooldown;
	}
	
	public void setKillCount(int newKillCount) {
		this.killCount = newKillCount;
	}
	
	public void setRange(int newRange) {
		this.range = newRange;
	}
	
	public void setLevel(int newLevel) {
		this.level = newLevel;
	}
	
	public void setRomanLevel(String romanLevel) {
		this.romanLevel = romanLevel;
	}
	
	public void setM(Misc m) {
		this.m = m;
	}
	
	public void setUpgradeCost(int upgradeCost) {
		this.upgradeCost = upgradeCost;
	}
	
	public void setBuildCost(int buildCost) {
		this.buildCost = buildCost;
	}
	
	public void setCurrentCooldown(int currentCooldown) {
		this.currentCooldown = currentCooldown;
	}
	
	public void setTexture(Image texture) {
		Texture = texture;
	}
	
	public void setProjectile(Projectile projectile) {
		this.projectile = projectile;
	}
	
	public void setTarget(Enemy target) {
		this.target = target;
	}
	
}
