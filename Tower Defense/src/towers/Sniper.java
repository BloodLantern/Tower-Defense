package towers;

public class Sniper extends Tower {

	public Sniper() {

		this.setName("Sniper");
		this.setDamage(100);
		this.setCooldown(5000);
		this.setRange(30);
		this.setRomanLevel(this.getM().toRoman(this.getLevel()));
		this.setBuildCost(500);
		this.setUpgradeCost((int) Math.round(this.getBuildCost() * 1.75));

	}

}
