package towers;

public class MachineGun extends Tower {

	public MachineGun() {

		this.setName("Machine Gun");
		this.setDamage(10);
		this.setCooldown(100);
		this.setRange(10);
		this.setRomanLevel(this.getM().toRoman(this.getLevel()));
		this.setBuildCost(250);
		this.setUpgradeCost((int) Math.round(this.getBuildCost() * 1.75));

	}

}
