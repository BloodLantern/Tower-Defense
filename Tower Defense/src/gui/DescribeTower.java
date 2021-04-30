package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import towers.*;

class DescribeTower extends JPanel {
	
	private Tower tower;
	
	public DescribeTower(Tower t) {
		this.tower = t;
	}

	@Override
	public void paintComponent(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		// Describes selected tower
		g.setColor(Color.black);
		Font police = new Font("Kenney Future Narrow", Font.PLAIN, 14);
		g.setFont(police);

		g.drawString("Name: " + tower.getName() + " " + tower.getRomanLevel(), 10, 20);
		g.drawString("Damage per shot: " + tower.getDamage(), 10, 50);
		g.drawString("Cooldown between shots: " + tower.getCooldown() + "ms", 10, 65);
		g.drawString("Range: " + tower.getRange() + " tiles", 10, 80);
		g.drawString("Enemies killed: " + tower.getKillCount(), 10, 95);
		g.drawString("Upgrade cost: " + tower.getUpgradeCost() + "$", 10, 125);

	}

	// Getters and Setters

	public Tower getTower() {
		return tower;
	}

	public void setTower(Tower tower) {
		this.tower = (Tower) tower;
	}

}
