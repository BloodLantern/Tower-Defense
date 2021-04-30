package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

class CustomButton extends JButton implements MouseListener {
	private String name;
	private static final String defaultTexturesPath = "assets\\Tower Defense\\textures\\ui\\buttons\\";
	private String texturePath;
	private Image texture;

	public CustomButton(String str, String textureType){
		super(str);
		this.name = str;
		this.setFont(new Font("Future", Font.PLAIN, 20));
		texturePath = defaultTexturesPath.concat(textureType);
		try {
			this.texture = ImageIO.read(new File(texturePath.concat(".png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
			this.addMouseListener(this);
    	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(texture, 0, 0, this.getWidth(), this.getHeight(), this);
		
		g2d.setColor(Color.black);
		FontMetrics fm = g2d.getFontMetrics();
		int height = fm.getHeight();
		int width = fm.stringWidth(this.name);

		// Calculating where to draw the button's name
		g2d.drawString(this.name, this.getWidth() / 2 - (width / 2), (this.getHeight() / 2) + (height / 4));
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		// Useless here because we are using actionPerformed() in all windows
	}
	
	@Override
	public void mouseEntered(MouseEvent event) {
		// When hovering the button
		try {
			this.texture = ImageIO.read(new File(texturePath.concat("Hovered.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void mouseExited(MouseEvent event) {
		// When exiting the button's surface, displays default texture
		try {
			this.texture = ImageIO.read(new File(texturePath.concat(".png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent event) {
		// When clicking, displays correct texture
		try {
			this.texture = ImageIO.read(new File(texturePath.concat("Clicked.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent event) {
		// If the mouse is still on the button when releasing its clic, then displays
		// hovered button texture
		if ((event.getY() > 0 && event.getY() < this.getHeight())
				&& (event.getX() > 0 && event.getX() < this.getWidth())) {
			try {
				this.texture = ImageIO.read(new File(texturePath.concat("Hovered.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// If outside, displays default texture
		else {
			try {
				this.texture = ImageIO.read(new File(texturePath.concat(".png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTexturePath() {
		return texturePath;
	}

	public void setTexturePath(String texturePath) {
		this.texturePath = texturePath;
	}

	public Image getTexture() {
		return texture;
	}

	public void setTexture(Image texture) {
		this.texture = texture;
	}
	
	public void resetTexture() {
		try {
			this.texture = ImageIO.read(new File(texturePath.concat(".png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.repaint();
	}
}