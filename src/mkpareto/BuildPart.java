package mkpareto;
/**
 * Class that describes one component of a Mario Kart
 * build. Could be a character, kart, wheel, or glider.
 * @author BonkTurnip
 *
 */
public class BuildPart {
	private final int groundSpeed;
	private final int waterSpeed;
	private final int airSpeed;
	private final int antiGravSpeed;
	private final int acceleration;
	private final int weight;
	private final int groundHandling;
	private final int waterHandling;
	private final int airHandling;
	private final int antiGravHandling;
	private final int traction;
	private final int miniTurbo;
	private final PartType type;
	private final String descriptor;
	public BuildPart(PartType pt, String desc, int gs, int ws, int as, int ags, int acc, int wei, int gh, int wh, int ah, int agh, int trac, int mt) {
		this.groundSpeed = gs;
		this.waterSpeed = ws;
		this.airSpeed = as;
		this.antiGravSpeed = ags;
		this.acceleration = acc;
		this.weight = wei;
		this.groundHandling = gh;
		this.waterHandling = wh;
		this.airHandling = ah;
		this.antiGravHandling = agh;
		this.traction = trac;
		this.miniTurbo = mt;
		this.type = pt;
		this.descriptor = desc;
	}
	public int getGroundSpeed() {
		return groundSpeed;
	}
	public int getWaterSpeed() {
		return waterSpeed;
	}
	public int getAirSpeed() {
		return airSpeed;
	}
	public int getAntiGravSpeed() {
		return antiGravSpeed;
	}
	public int getAcceleration() {
		return acceleration;
	}
	public int getWeight() {
		return weight;
	}
	public int getGroundHandling() {
		return groundHandling;
	}
	public int getWaterHandling() {
		return waterHandling;
	}
	public int getAirHandling() {
		return airHandling;
	}
	public int getAntiGravHandling() {
		return antiGravHandling;
	}
	public int getTraction() {
		return traction;
	}
	public int getMiniTurbo() {
		return miniTurbo;
	}
	public PartType getType() {
		return type;
	}
	@Override
	public String toString() {
		return descriptor;
	}
}
