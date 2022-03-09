package mkpareto;
/**
 * Represents a complete Mario Kart 8 Deluxe build
 * @author BonkTurnip
 *
 */
public class FullBuild {
	private BuildPart character;
	private BuildPart frame;
	private BuildPart tire;
	private BuildPart glider;
	private final int totalGroundSpeed;
	private final int totalWaterSpeed;
	private final int totalAirSpeed;
	private final int totalAntiGravSpeed;
	private final int totalAcceleration;
	private final int totalWeight;
	private final int totalGroundHandling;
	private final int totalWaterHandling;
	private final int totalAirHandling;
	private final int totalAntiGravHandling;
	private final int totalTraction;
	private final int totalMiniTurbo;
	private final int totalEverything;
	public FullBuild(BuildPart character, BuildPart frame, BuildPart tire, BuildPart glider) {
		this.character = character;
		this.frame = frame;
		this.tire = tire;
		this.glider = glider;
		this.totalGroundSpeed = character.getGroundSpeed() + frame.getGroundSpeed() + tire.getGroundSpeed() + glider.getGroundSpeed();
		this.totalWaterSpeed = character.getWaterSpeed() + frame.getWaterSpeed() + tire.getWaterSpeed() + glider.getWaterSpeed();
		this.totalAirSpeed = character.getAirSpeed() + frame.getAirSpeed() + tire.getAirSpeed() + glider.getAirSpeed();
		this.totalAntiGravSpeed = character.getAntiGravSpeed() + frame.getAntiGravSpeed() + tire.getAntiGravSpeed() + glider.getAntiGravSpeed();
		this.totalAcceleration = character.getAcceleration() + frame.getAcceleration() + tire.getAcceleration() + glider.getAcceleration();
		this.totalWeight = character.getWeight() + frame.getWeight() + tire.getWeight() + glider.getWeight();
		this.totalGroundHandling = character.getGroundHandling() + frame.getGroundHandling() + tire.getGroundHandling() + glider.getGroundHandling();
		this.totalWaterHandling = character.getWaterHandling() + frame.getWaterHandling() + tire.getWaterHandling() + glider.getWaterHandling();
		this.totalAirHandling = character.getAirHandling() + frame.getAirHandling() + tire.getAirHandling() + glider.getAirHandling();
		this.totalAntiGravHandling = character.getAntiGravHandling() + frame.getAntiGravHandling() + tire.getAntiGravHandling() + glider.getAntiGravHandling();
		this.totalTraction = character.getTraction() + frame.getTraction() + tire.getTraction() + glider.getTraction();
		this.totalMiniTurbo = character.getMiniTurbo() + frame.getMiniTurbo() + tire.getMiniTurbo() + glider.getMiniTurbo();
		this.totalEverything = totalGroundSpeed + totalWaterSpeed + totalAirSpeed + totalAntiGravSpeed + totalAcceleration + totalWeight + 
				totalGroundHandling + totalWaterHandling + totalAirHandling + totalAntiGravHandling + totalTraction + totalMiniTurbo;
	}
	public int getTotalGroundSpeed() {
		return totalGroundSpeed;
	}
	public int getTotalWaterSpeed() {
		return totalWaterSpeed;
	}
	public int getTotalAirSpeed() {
		return totalAirSpeed;
	}
	public int getTotalAntiGravSpeed() {
		return totalAntiGravSpeed;
	}
	public int getTotalAcceleration() {
		return totalAcceleration;
	}
	public int getTotalWeight() {
		return totalWeight;
	}
	public int getTotalGroundHandling() {
		return totalGroundHandling;
	}
	public int getTotalWaterHandling() {
		return totalWaterHandling;
	}
	public int getTotalAirHandling() {
		return totalAirHandling;
	}
	public int getTotalAntiGravHandling() {
		return totalAntiGravHandling;
	}
	public int getTotalTraction() {
		return totalTraction;
	}
	public int getTotalMiniTurbo() {
		return totalMiniTurbo;
	}
	public int getTotalEverything() {
		return totalEverything;
	}
	@Override
	public String toString() {
		return "\t" + character + "\n\t" + frame + "\n\t" + tire + "\n\t" + glider + "\n----------\n" + 
				"Ground Speed: " + totalGroundSpeed + "\nWater Speed: " + totalWaterSpeed + "\nAir Speed: " + 
				totalAirSpeed + "\nAnti-Gravity Speed: " + totalAntiGravSpeed + "\nAcceleration: " + totalAcceleration + 
				"\nWeight: " + totalWeight + "\nGround Handling: " + totalGroundHandling + "\nWater Handling: " + totalWaterHandling + 
				"\nAir Handling: " + totalAirHandling + "\nAnti-Gravity Handling: " + totalAntiGravHandling + "\nTraction: " + 
				totalTraction + "\nMini-Turbo: " + totalMiniTurbo + "\nTotal: " + totalEverything + "\n----------\n";
	}
}
