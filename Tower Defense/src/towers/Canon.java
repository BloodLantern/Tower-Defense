package towers;

public class Canon extends Tower {

	public Canon() {

		this.setName("Canon");
		this.setDamage(150);
		this.setCooldown(2000);
		this.setRange(15);
		this.setRomanLevel(this.getM().toRoman(this.getLevel()));
		this.setBuildCost(500);
		this.setUpgradeCost((int) Math.round(this.getBuildCost() * 1.75));

	}

}
