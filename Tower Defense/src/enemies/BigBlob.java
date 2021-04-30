package enemies;

public class BigBlob extends Enemy {

	public BigBlob() {

		this.setName("Big Blob");
		this.setMovementSpeed(0.15);
		this.setSize(2, 2);
		this.setHealthPoints(50);

	}
	
	@Override
	public void die() {
		// If this is dead then divide
		if (this.getHealthPoints() <= 0) {
			// Generates a random number of Blobs
			for (int i = 0; i < (int)Math.round(Math.random() * 6); i++) {
				
				new Blob();
				
			}
			
		}
		
	}

}
