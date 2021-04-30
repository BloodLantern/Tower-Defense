package gui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

import enemies.Enemy;

class Game extends JPanel {
	
	int currentWave;
	int difficulty;
	ArrayList<Enemy> nextWave = new ArrayList<Enemy>();
	
	public Game(DisplayMap map, int difficulty) {
		
		if (difficulty > 0 && difficulty < 4)
			this.difficulty = difficulty;
		
		System.out.println("Starting game with difficulty " + this.difficulty);
		
		map.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		
		this.add(map);
		
		map.repaint();
		
	}
	
}
