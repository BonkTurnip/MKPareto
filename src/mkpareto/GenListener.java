package mkpareto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The ActionListener for the Generate button
 * @author BonkTurnip
 *
 */
public class GenListener implements ActionListener {
	private CalcPareto cp;
	
	public GenListener(CalcPareto cp) {
		this.cp = cp;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		cp.generateStatPairs();
	}
}
