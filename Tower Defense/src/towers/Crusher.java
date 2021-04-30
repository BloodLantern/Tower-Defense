package towers;

public class Crusher extends Tower {

	public Crusher() {

		this.setName("Crusher");
		this.setDamage(500);
		this.setCooldown(5000);
		this.setRange(4);
		this.setRomanLevel(this.getM().toRoman(this.getLevel()));
		this.setBuildCost(1000);
		this.setUpgradeCost((int) Math.round(this.getBuildCost() * 1.75));

	}

}
