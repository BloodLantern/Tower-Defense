package towers;

public class Cat extends Tower {

	public Cat() {

		this.setName("Cat");
		this.setDamage(100);
		this.setCooldown(1000);
		this.setRange(5);
		this.setRomanLevel(this.getM().toRoman(this.getLevel()));
		this.setBuildCost(1500);
		this.setUpgradeCost((int) Math.round(this.getBuildCost() * 1.75));

	}
	
	public void run() {
		System.out.print("a");
	}

}
