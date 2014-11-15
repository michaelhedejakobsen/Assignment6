import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * The class DayGUI contains the graphic user interface for a program to calculate the day after adding the number of days the user inputs.
 * The design is 1 panel using grid layout.
 * The panel contains a label with instructions, then a input text field for todays day.
 * Then 3 labels for display of the current day, the next day, and the previous day.
 * Then a text field for input the days the user wish added to today.
 * Then a button to calculate the day, and a label for displaying the result.
 * @author Michael H. Jakobsen
 * Date: 13. November 2014
 *
 */
public class DayGUI extends JFrame implements ActionListener {

	/**
	 * Create static long, containing the serial number of the version.
	 */
	private static final long serialVersionUID = 9050360097170100726L;
	
	/**
	 * Initializing variables; text fields, labels, button and panel
	 */
	public JTextField jtxSetDay, jtxAddDays;
	JLabel jlTodaysDay, jlInstructions, jlDay, jlNextDay, jlPrevDay, jlResult, jlInputNumber;
	JButton jbtCalculate;
	JPanel panelDay;
	
	/**
	 * Create new instance of the class Day.
	 */
	Day day = new Day();
	
	/**
	 * Construct new public method DayGUI to create the design of the GUI.
	 */
	public DayGUI(){	
		
		/**
		 * Creating a panel with grid layout, to display the label with the information, the text fields and the button.
		 */
		panelDay = new JPanel();
		panelDay.setLayout( new GridLayout(9,1) );
		panelDay.setBackground(Color.LIGHT_GRAY);
		
		/**
		 * Create a new labels with instructions, and for display of results.
		 */
		jlInstructions = new JLabel("  Enter todays day, first 3 letters, first letter capitalised  ");
		jlInputNumber = new JLabel("  Input days you wish to add to today, i.e. \"7\" or \"-13\"  ");
		jlDay = new JLabel("  ");
		jlNextDay = new JLabel("  ");
		jlPrevDay = new JLabel("  ");
		jlResult = new JLabel("  ");

		/**
		 * Creating 4 text fields for input of test scores, and a label for the column
		 */
		jtxSetDay= new JTextField(20);
		jtxAddDays= new JTextField(20);
		
		/**
		 * Create a new button, to calculate the day.
		 */
		jbtCalculate = new JButton("Calculate Day");
		jbtCalculate.addActionListener(this);
		
		/**
		 * Adding the labels and text fields to the panelDay.
		 */
		panelDay.add(jlInstructions);
		panelDay.add(jtxSetDay);
		panelDay.add(jlDay);
		panelDay.add(jlNextDay);
		panelDay.add(jlPrevDay);
		panelDay.add(jlInputNumber);
		panelDay.add(jtxAddDays);
		panelDay.add(jbtCalculate);
		panelDay.add(jlResult);

		/**
		 * Add the panel to the BorderLayout
		 */
		add(panelDay, BorderLayout.NORTH);

		/**
		 * Set the GUI visible and pack to fit the window
		 */
		setVisible(true);
		pack();
	}
	
	@Override
	/**
	 * Method for actionPerformed
	 */
	public void actionPerformed(ActionEvent arg0) {
		
		/**
		 * Input the value for the current day, to the setter setDay in the class day.
		 */
		day.setDay( jtxSetDay.getText());
		
		/**
		 * Input the value from the text field AddDays the method calculateDay in the class day.
		 */
		int calcDay = Integer.parseInt(jtxAddDays.getText());
		jlResult.setText("The calculated day is: " + day.calculateDay(calcDay));
		
		/**
		 * Input values from the class day into labels: jlDay, jlNextDay, and jlPrevDay.
		 */
		jlDay.setText("Today is: " + day.getDay());
		jlNextDay.setText("Tomorrow is: " + day.nextDay());
		jlPrevDay.setText("Yesterday was: " + day.prevDay());	
	}

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * Create new instance of the class DayGUI.
		 */
		new DayGUI();
	}
}