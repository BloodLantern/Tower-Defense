package towers;

public class Rifle extends Tower {

	public Rifle() {

		this.setName("Rifle");
		this.setDamage(10);
		this.setCooldown(250);
		this.setRange(7);
		this.setRomanLevel(this.getM().toRoman(this.getLevel()));
		this.setBuildCost(25);
		this.setUpgradeCost((int) Math.round(this.getBuildCost() * 1.75));

	}

}
