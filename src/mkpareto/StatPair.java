package mkpareto;
/**
 * Class that stores a pair of two stat values that the user
 * wishes to focus on in their build.
 * @author BonkTurnip
 *
 */
public class StatPair implements Comparable<StatPair>{
	private final int x;
	private final int y;
	public StatPair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean equals(StatPair other) {
		return (this.x == other.x) && (this.y == other.y);
	}
	@Override
	public String toString() {
		return x+","+y;
	}
	@Override
	public int compareTo(StatPair other) {
		return this.y - other.y;
	}
}
