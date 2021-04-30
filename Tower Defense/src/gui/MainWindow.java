package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import all.Misc;
import all.Player;

public class MainWindow extends JFrame implements ActionListener {
	
	private DisplayMap displayMap = null;
	
	private JPanel container = new JPanel();
	
	private GridBagConstraints c;
	
	private static JLabel title = new JLabel("");
	
	private static JTextField usernameInput = new JTextField("");
	
	private static CustomButton playButton = new CustomButton("Play", "button");
	private static CustomButton optionsButton = new CustomButton("Options", "button");
	private static CustomButton quitButton = new CustomButton("Quit Game", "button");
	private static CustomButton fullScreenButton = new CustomButton("Fullscreen: Off", "button");
	private static CustomButton backButton = new CustomButton("Back", "button");
	private static CustomButton confirmButton = new CustomButton("Confirm", "button");

	private static CustomButton leftArrowButton = new CustomButton("", "buttonLeft");
	private static CustomButton rightArrowButton = new CustomButton("", "buttonRight");
	
	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
	
	public MainWindow() {
		
		this.setTitle("Tower Defense");
		this.setSize(new Dimension(1280, 720));
		this.setContentPane(container);
		this.setIconImage(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		container.setLayout(new GridBagLayout());
		
		initButton(playButton);
		initButton(optionsButton);
		initButton(quitButton);
		initButton(fullScreenButton);
		initButton(backButton);
		initButton(confirmButton);
		initButton(leftArrowButton);
		initButton(rightArrowButton);
		
		leftArrowButton.setPreferredSize(new Dimension(64, 64));
		rightArrowButton.setPreferredSize(new Dimension(64, 64));
		
		c = new GridBagConstraints();
		
		if (Player.firstLaunch) {
			askUsername();
		} else {
			displayMainMenu();
		}
		
	}
	
	private void displayMainMenu() {
		
		container.removeAll();
		container.setName("mainMenu");
		
		playButton.resetTexture();
		optionsButton.resetTexture();
		quitButton.resetTexture();
		
		title.setForeground(Color.orange);
		title.setFont(Misc.fontFutureNarrow);
		title.setText("Tower Defense");
		
		c.insets = new Insets(200, 400, 100, 400);
		c.gridx = 1;
		c.gridy = 0;
		container.add(title, c);
		c.insets = new Insets(0, 0, 30, 0);
		c.gridy = 1;
		container.add(playButton, c);
		c.gridy = 2;
		container.add(optionsButton, c);
		c.gridy = 3;
		container.add(quitButton, c);

		repaintThis();
		
	}
	
	private void displayOptionsMenu() {
		
		container.removeAll();
		container.setName("optionsMenu");
		
		fullScreenButton.resetTexture();
		backButton.resetTexture();
		
		title.setForeground(Color.orange);
		title.setFont(Misc.fontFutureNarrow);
		title.setText("Options");
		
		c.insets = new Insets(200, 400, 100, 400);
		c.gridx = 1;
		c.gridy = 0;
		container.add(title, c);
		c.insets = new Insets(0, 0, 10, 0);
		c.gridy = 1;
		container.add(fullScreenButton, c);
		c.insets = new Insets(100, 0, 20, 0);
		c.gridy = 10;
		container.add(backButton, c);

		repaintThis();
		
	}
	
	private void askUsername() {
		
		container.setName("selectUsername");
		
		title.setForeground(Color.orange);
		title.setFont(Misc.fontFutureNarrow);
		title.setText("Please write your username below");
		
		usernameInput.setForeground(Color.blue);
		Font f = new Font("Arial", Font.TRUETYPE_FONT, 30);
		usernameInput.setFont(f);
		usernameInput.setPreferredSize(new Dimension(400, 40));
		
		c.insets = new Insets(200, 400, 100, 400);
		c.gridx = 1;
		c.gridy = 0;
		container.add(title, c);
		c.insets = new Insets(0, 0, 30, 0);
		c.gridy = 1;
		container.add(usernameInput, c);
		c.gridy = 2;
		container.add(confirmButton, c);
		
		this.pack();
		this.setLocationRelativeTo(null);
		
	}
	
	private void displaySelectMapMenu() {
		
		container.removeAll();
		container.setName("selectMapMenu");
		
		leftArrowButton.resetTexture();
		rightArrowButton.resetTexture();
		backButton.resetTexture();
		confirmButton.resetTexture();
		
		title.setText("Select a Map");

		displayMap = new DisplayMap(1);
		displayMap.setPreferredSize(new Dimension(640, 640));

		c.gridy = 1;
		c.gridx = 2;
		c.insets = new Insets(100, 0, 30, 0);
		container.add(title, c);
		
		c.insets = new Insets(0, 10, 0, 10);
		c.gridy = 2;
		c.gridx = 1;
		container.add(leftArrowButton, c);
		c.gridx = 2;
		container.add(displayMap, c);
		
		c.gridx = 3;
		container.add(rightArrowButton, c);
		
		c.insets = new Insets(10, 100, 10, 100);
		c.gridy = 3;
		c.gridx = 1;
		container.add(backButton, c);
		c.gridx = 3;
		container.add(confirmButton, c);

		repaintThis();
		
	}
	
	TurretButtons turretButtons = new TurretButtons();
	private void displayGame() {
		
		container.removeAll();
		container.setName("game");
		
		Game game = new Game(displayMap, 2);
		game.setPreferredSize(new Dimension((int)Math.floor(this.getWidth() / 2), this.getHeight()));
		turretButtons.setPreferredSize(new Dimension((int)Math.floor(this.getWidth() / 4), this.getHeight()));
		JPanel nextWave = new JPanel();
		nextWave.setPreferredSize(new Dimension((int)Math.floor(this.getWidth() / 4), this.getHeight()));
		
		c.gridx = 1;
		c.gridy = 1;
		container.add(game, c);
		c.gridx = 2;
		container.add(turretButtons, c);
		c.gridx = 0;
		container.add(nextWave, c);
		
		repaintThis();
		
	}
	
	public static String getUsername() {
		
		return usernameInput.getText();
		
	}
	
	private void initButton(CustomButton b) {
		b.setAlignmentX(Component.CENTER_ALIGNMENT);
		b.addActionListener(this);
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		b.setFocusPainted(false);
	}
	
	/**
	 * This method invokes either JFrame.pack()
	 * if this isn't in full screen or
	 * JFrame.repaint() if it is and then
	 * calls JFrame.setLocationRelativeTo(null)
	 * to center it on the screen
	 */
	private void repaintThis() {
		if (device.getFullScreenWindow() == null) {
			this.pack();
		} else {
			this.repaint();
		}
        this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// Tests what button have been clicked
		
		if (arg0.getSource() == playButton) {
			
			displaySelectMapMenu();
			
		} else if (arg0.getSource() == optionsButton) {
			
			displayOptionsMenu();
			
		} else if (arg0.getSource() == quitButton) {
			
			System.exit(0);
			
		} else if (arg0.getSource() == fullScreenButton) {
			
			if (device.getFullScreenWindow() == this) {
				
				device.setFullScreenWindow(null);
				
				fullScreenButton.setText("Full Screen: Off");
				
		        this.pack();
		        this.setLocationRelativeTo(null);
				
			} else {
				
		        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
				device.setFullScreenWindow(this);
				
				fullScreenButton.setText("Full Screen: On");
				fullScreenButton.repaint();
		        this.setLocationRelativeTo(null);
				
			}
			
		} else if (arg0.getSource() == backButton) {
			
			if (container.getName() == "optionsMenu") {
				displayMainMenu();
			} else if (container.getName() == "selectMapMenu") {
				displayMainMenu();
			}
			
		} else if (arg0.getSource() == confirmButton) {
			
			// If username input isn't default value
			if (MainWindow.getUsername() != "" && container.getName() == "selectUsername") {
				displayMainMenu();
				Player.init();
			} else if (container.getName() == "selectMapMenu") {
				displayGame();
			}
			
		} else if (arg0.getSource() == leftArrowButton) {
			
			if (displayMap.getSelectedMap() + 1 <= displayMap.getMapCount()) {
				displayMap = new DisplayMap(displayMap.getSelectedMap() + 1);
			} else {
				displayMap = new DisplayMap(1);
			}
			
			//repaintThis();
			
		} else if (arg0.getSource() == rightArrowButton) {
			
			if (displayMap.getSelectedMap() - 1 >= 1) {
				displayMap = new DisplayMap(displayMap.getSelectedMap() - 1);
			} else {
				displayMap = new DisplayMap(displayMap.getMapCount());
			}

			//repaintThis();
			
		}
		
	}
	
}
