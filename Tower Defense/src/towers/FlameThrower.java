package towers;

public class FlameThrower extends Tower {

	public FlameThrower() {

		this.setName("Roaster");
		this.setDamage(1);
		this.setCooldown(20);
		this.setRange(5);
		this.setRomanLevel(this.getM().toRoman(this.getLevel()));
		this.setBuildCost(100);
		this.setUpgradeCost((int) Math.round(this.getBuildCost() * 1.75));

	}

}
