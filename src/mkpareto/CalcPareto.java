package mkpareto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * Class that represents the "brain" of the program.
 * Does all of the making of builds and StatPairs as well as other things.
 * @author BonkTurnip
 *
 */
public class CalcPareto {
	/**
	 * ArrayList containing all of the characters in Mario Kart
	 */
	private ArrayList<BuildPart> characters;
	/**
	 * ArrayList containing all of the frames in Mario Kart
	 */
	private ArrayList<BuildPart> frames;
	/**
	 * ArrayList containing all of the tires in Mario Kart
	 */
	private ArrayList<BuildPart> tires;
	/**
	 * ArrayList containing all of the gliders in Mario Kart
	 */
	private ArrayList<BuildPart> gliders;
	/**
	 * ArrayList containing all of the possible builds in Mario Kart
	 */
	private ArrayList<FullBuild> builds;
	/**
	 * List containing all of the Pareto optimal StatPairs for the selected stats
	 */
	private ArrayList<StatPair> paretoPairs;
	private ViewPareto vp;
	
	public CalcPareto(ViewPareto vp) {
		this.characters = new ArrayList<>();
		this.frames = new ArrayList<>();
		this.tires = new ArrayList<>();
		this.gliders = new ArrayList<>();
		this.builds = new ArrayList<>();
		this.paretoPairs = new ArrayList<>();
		this.vp = vp;
	}
	/**
	 * Read all of the BuildParts from the parts.txt file and generate
	 * all the possible builds from them.
	 */
	public void start() {
		int lineNum = 0;
		try(Scanner input = new Scanner(this.getClass().getResourceAsStream("parts.txt"))) {
			while(input.hasNextLine()) {
				processLine(input.nextLine(), lineNum);
				lineNum++;
			}
		} catch(NullPointerException npe) {
			System.err.println(npe);
		}
		generateBuilds();
	}
	/**
	 * Process a given line from parts.txt and turn it into a BuildPart object
	 * @param line String containing the line from parts.txt
	 * @param lineNum The line number of the current line
	 */
	private void processLine(String line, int lineNum) {
		if((line.isEmpty()) || (line.charAt(0) == '#')) {
			return;
		}
		String[] split = line.split(";");
		if(split.length != 14) {
			System.err.println("Malformed data on line " + lineNum);
			return;
		}
		ArrayList<BuildPart> proper;
		PartType pt;
		if(split[0].equals("c")) {
			proper = characters;
			pt = PartType.DRIVER;
			makePart(proper, pt, split, lineNum);
			return;
		}
		if(split[0].equals("f")) {
			proper = frames;
			pt = PartType.FRAME;
			makePart(proper, pt, split, lineNum);
			return;
		}
		if(split[0].equals("t")) {
			proper = tires;
			pt = PartType.TIRE;
			makePart(proper, pt, split, lineNum);
			return;
		}
		if(split[0].equals("g")) {
			proper = gliders;
			pt = PartType.GLIDER;
			makePart(proper, pt, split, lineNum);
			return;
		}
		System.err.println("Unknown part type on line " + lineNum);
	}
	/**
	 * Makes a BuildPart using the given information and adds it to the BuildPart list.
	 * @param list The BuildPart list
	 * @param pt The PartType of the BuildPart
	 * @param args The list of values for the stats
	 * @param lineNum The line number of parts.txt that was read from
	 */
	private void makePart(ArrayList<BuildPart> list, PartType pt, String[] args, int lineNum) {
		try {
			list.add(new BuildPart(pt, args[1], 
					Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]), 
					Integer.parseInt(args[6]), Integer.parseInt(args[7]), Integer.parseInt(args[8]), Integer.parseInt(args[9]), 
					Integer.parseInt(args[10]), Integer.parseInt(args[11]), Integer.parseInt(args[12]), Integer.parseInt(args[13])));
		} catch(NumberFormatException nfe) {
			System.err.println("Malformed data on line " + lineNum);
		}
	}
	/**
	 * Use the completed lists of BuildParts to generate all of the possible FullBuilds
	 */
	private void generateBuilds() {
		for(int i = 0; i < characters.size(); i++) {
			for(int j = 0; j < frames.size(); j++) {
				for(int k = 0; k < tires.size(); k++) {
					for(int m = 0; m < gliders.size(); m++) {
						builds.add(new FullBuild(characters.get(i), frames.get(j), tires.get(k), gliders.get(m)));
					}
				}
			}
		}
	}
	/**
	 * List all of the FullBuilds that have a certain StatPair
	 * @param sp The required StatPair
	 */
	public void listBuildsWithStatPair(StatPair sp) {
		vp.clearText();
		if(sp == null) {
			return;
		}
		int x = sp.getX();
		int y = sp.getY();
		for(int i = 0; i < builds.size(); i++) {
			if((getStatTotal(vp.getFirstFocus(), i) == x) && (getStatTotal(vp.getSecondFocus(), i) == y)) {
				vp.appendText(builds.get(i).toString());
			}
		}
		vp.scrollToTop();
	}
	/**
	 * Create a list of all Pareto optimal StatPairs
	 */
	public void generateStatPairs() {
		paretoPairs.clear();
		String firstFocus = vp.getFirstFocus();
		String secondFocus = vp.getSecondFocus();
		for(int i = 0; i < builds.size(); i++) {
			int firstStat = getStatTotal(firstFocus, i);
			int secondStat = getStatTotal(secondFocus, i);
			StatPair sp = new StatPair(firstStat, secondStat);
			if(isPairAlreadyPresent(sp)) {
				continue;
			}
			if(!hasBetterPair(sp)) {
				paretoPairs.add(sp);
			}
		}
		for(int i = 0; i < paretoPairs.size(); i++) {
			if(hasBetterPair(paretoPairs.get(i))) {
				paretoPairs.remove(i);
				i--;
			}
		}
		Collections.sort(paretoPairs);
		StatPair[] spArr = new StatPair[paretoPairs.size()];
		
		vp.displayPairs(paretoPairs.toArray(spArr));
	}
	/**
	 * Checks if a given StatPair is already in the list of Pareto optimal pairs
	 * @param sp The StatPair to check
	 * @return True if it already exists and false otherwise
	 */
	private boolean isPairAlreadyPresent(StatPair sp) {
		for(int i = 0; i < paretoPairs.size(); i++) {
			if(paretoPairs.get(i).equals(sp)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Check if a given StatPair has a better StatPair in the list of Pareto pairs
	 * @param sp The StatPair to check
	 * @return True if it has a better pair and false otherwise
	 */
	private boolean hasBetterPair(StatPair sp) {
		for(int i = 0; i < paretoPairs.size(); i++) {
			StatPair test = paretoPairs.get(i);
			if((test.getX() > sp.getX()) || (test.getY() > sp.getY())) {
				if((test.getX() >= sp.getX()) && (test.getY() >= sp.getY())) {
					//System.out.println(test + " is better than " + sp);
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Get the total value of a given stat in a given build
	 * @param stat The stat whose value should be retrieved
	 * @param index The index of the build in the list of all builds
	 * @return The desired stat total or -1 if an invalid stat was requested
	 */
	private int getStatTotal(String stat, int index) {
		if(stat.equals("Ground Speed")) {
			return builds.get(index).getTotalGroundSpeed();
		}
		if(stat.equals("Water Speed")) {
			return builds.get(index).getTotalWaterSpeed();
		}
		if(stat.equals("Air Speed")) {
			return builds.get(index).getTotalAirSpeed();
		}
		if(stat.equals("Anti-Gravity Speed")) {
			return builds.get(index).getTotalAntiGravSpeed();
		}
		if(stat.equals("Acceleration")) {
			return builds.get(index).getTotalAcceleration();
		}
		if(stat.equals("Weight")) {
			return builds.get(index).getTotalWeight();
		}
		if(stat.equals("Ground Handling")) {
			return builds.get(index).getTotalGroundHandling();
		}
		if(stat.equals("Water Handling")) {
			return builds.get(index).getTotalWaterHandling();
		}
		if(stat.equals("Air Handling")) {
			return builds.get(index).getTotalAirHandling();
		}
		if(stat.equals("Anti-Gravity Handling")) {
			return builds.get(index).getTotalAntiGravHandling();
		}
		if(stat.equals("Traction")) {
			return builds.get(index).getTotalTraction();
		}
		if(stat.equals("Mini-Turbo")) {
			return builds.get(index).getTotalMiniTurbo();
		}
		return -1;
	}
}
