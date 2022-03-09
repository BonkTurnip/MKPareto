package mkpareto;
/**
 * The class containing the main method for running this program
 * @author BonkTurnip
 *
 */
public class RunPareto {
	public static void main(String[] args) {
		ViewPareto vp = new ViewPareto();
		CalcPareto cp = new CalcPareto(vp);
		vp.setCalcPereto(cp);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				vp.start();
			}
		});
		cp.start();
	}
}
