package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import enemies.*;

class DescribeEnemy extends JPanel {
	
	private Enemy enemy;
	
	public DescribeEnemy(Enemy e) {
		this.enemy = e;
	}

	@Override
	public void paintComponent(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		// Describes selected enemy
		g.setColor(Color.black);
		Font police = new Font("Kenney Future Narrow", Font.PLAIN, 14);
		g.setFont(police);

		g.drawString("Name: " + enemy.getName(), 10, 20);
		g.drawString("Size: " + enemy.getSize()[0] + "x" + enemy.getSize()[1], 10, 35);
		g.drawString("Movement Speed: " + enemy.getMovementSpeed(), 10, 50);
		g.drawString("HP: " + enemy.getHealthPoints(), 10, 65);

	}

	// Getters and Setters

	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = (Enemy) enemy;
	}
	
}