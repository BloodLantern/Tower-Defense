package gui;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class Tile implements MouseListener {
	
	private Image texture;
	private String texturePath;
	private boolean isBuildable;
	private int number;
	private int secondNumber = -1;
	private int posX;
	private int posY;
	
	public Tile(String imageName, boolean isBuildable, int number) {
		
		try {
			this.setTexture(ImageIO.read(new File("assets\\Tower Defense\\textures\\tiles\\".concat(imageName).concat(".png"))));
			this.texturePath = "assets\\Tower Defense\\textures\\tiles\\".concat(imageName).concat(".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.isBuildable = isBuildable;
		this.number = number;
		
	}
	
	public Tile(String imageName, boolean isBuildable, int number, int secondNumber) {
		
		try {
			this.setTexture(ImageIO.read(new File("assets\\Tower Defense\\textures\\tiles\\".concat(imageName).concat(".png"))));
			this.texturePath = "assets\\Tower Defense\\textures\\tiles\\".concat(imageName).concat(".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.isBuildable = isBuildable;
		this.number = number;
		this.secondNumber = secondNumber;
		
	}

	public String getTexturePath() {
		return texturePath;
	}

	public void setTexturePath(String imageName) {
		
		try {
			this.texture = ImageIO.read(new File("assets\\Tower Defense\\textures\\tiles\\".concat(imageName).concat(".png")));
			this.texturePath = "assets\\Tower Defense\\textures\\tiles\\".concat(imageName).concat(".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public boolean isBuildable() {
		return isBuildable;
	}

	public void setBuildable(boolean isBuildable) {
		this.isBuildable = isBuildable;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Image getTexture() {
		return texture;
	}

	public void setTexture(Image texture) {
		this.texture = texture;
	}

	public int getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (this.isBuildable()) {
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
}
