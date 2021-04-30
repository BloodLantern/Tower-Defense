package towers.projectiles;

import java.awt.Image;
import towers.*;

public abstract class Projectile extends Tower {
	
	private double[] Motion = new double[2];
	private Image Texture;
	private int[] Size = new int[2];

	public Projectile() {}
	
	public void run() {}

}
