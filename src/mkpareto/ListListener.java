package mkpareto;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 * The ListSelectionListener that gets called when the user
 * selects a StatPair from the JList.
 * @author BonkTurnip
 *
 */
public class ListListener implements ListSelectionListener {
	private CalcPareto cp;
	private ViewPareto vp;
	
	public ListListener(CalcPareto cp, ViewPareto vp) {
		this.cp = cp;
		this.vp = vp;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		cp.listBuildsWithStatPair(vp.getSelectedPair());
	}

}
