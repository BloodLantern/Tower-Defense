package enemies;

public class Bear extends Enemy {

	public Bear() {

		this.setName("Bear");
		this.setMovementSpeed(0.3);
		this.setSize(3, 2);
		this.setHealthPoints(250);

	}
	
	public void sleep() {
		
		//heals and then gets up
		
	}

}
