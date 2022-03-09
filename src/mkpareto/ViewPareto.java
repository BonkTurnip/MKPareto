package mkpareto;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
/**
 * Class that builds the GUI of the program.
 * @author BonkTurnip
 *
 */
public class ViewPareto {
	private JFrame frame;
	private JPanel combos;
	private JList<StatPair> pairs;
	private JScrollPane textScroll;
	private JScrollPane listScroll;
	private JTextArea textArea;
	private JComboBox<String> firstFocus;
	private JComboBox<String> secondFocus;
	private JButton genButton;
	private CalcPareto cp;
	
	public ViewPareto() {
		String[] focii = {"Ground Speed", "Water Speed", "Air Speed", "Anti-Gravity Speed", "Acceleration", "Weight", "Ground Handling", 
				"Water Handling", "Air Handling", "Anti-Gravity Handling", "Traction", "Mini-Turbo"};
		this.frame = new JFrame("Pareto Optimal Mario Kart Builds");
		this.combos = new JPanel();
		this.pairs = new JList<>();
		this.textArea = new JTextArea();
		this.textScroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.listScroll = new JScrollPane(pairs, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.firstFocus = new JComboBox<>(focii);
		this.secondFocus = new JComboBox<>(focii);
		this.genButton = new JButton("Generate");
		this.cp = null;
	}
	/**
	 * Configures all the GUI components and displays the GUI to the user. 
	 */
	public void start() {
		firstFocus.setMaximumSize(new Dimension(150, 25));
		secondFocus.setMaximumSize(new Dimension(150, 25));
		secondFocus.setSelectedIndex(11);
		genButton.setAlignmentX(0.5f);
		genButton.addActionListener(new GenListener(cp));
		textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		pairs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pairs.addListSelectionListener(new ListListener(cp, this));
		combos.setLayout(new BoxLayout(combos, BoxLayout.Y_AXIS));
		combos.add(firstFocus);
		combos.add(Box.createRigidArea(new Dimension(0, 30)));
		combos.add(secondFocus);
		combos.add(Box.createRigidArea(new Dimension(0, 30)));
		combos.add(genButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.add(combos);
		frame.add(listScroll);
		frame.add(textScroll);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
	/**
	 * Set this class' CalcPareto reference
	 * @param cp The CalcPareto reference
	 */
	public void setCalcPereto(CalcPareto cp) {
		this.cp = cp;
	}
	/**
	 * Retrieve what is selected in the first combo box.
	 * @return A String for what was selected
	 */
	public String getFirstFocus() {
		return (String)firstFocus.getSelectedItem();
	}
	/**
	 * Retrieve what is selected in the second combo box.
	 * @return A String for what was selected
	 */
	public String getSecondFocus() {
		return (String)secondFocus.getSelectedItem();
	}
	/**
	 * Get the selected StatPair from the JList
	 * @return The selected StatPair
	 */
	public StatPair getSelectedPair() {
		return pairs.getSelectedValue();
	}
	/**
	 * Display the given array of StatPairs in the JList
	 * @param sp The array of StatPairs to put in the JList
	 */
	public void displayPairs(StatPair[] sp) {
		pairs.setListData(sp);
	}
	/**
	 * Append some text to the JTextArea
	 * @param text The text to append to the JTextArea
	 */
	public void appendText(String text) {
		textArea.append(text);
	}
	/**
	 * Clear the text in the JTextArea
	 */
	public void clearText() {
		textArea.setText("");
	}
	/**
	 * Scroll to the top of the JTextArea
	 */
	public void scrollToTop() {
		textArea.setCaretPosition(0);
	}
}
