
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 8
 * Date: April 7, 2019
 */

import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

/**
 * The purpose of this class is to hold the GUI layout specifications. Holds the logic
 * and execution of the tip calculator.
 * 
 * @author Patrick Czermak
 * @version 1.0
 * @since JDK 1.8
 */
public class TipCalculatorFrame extends JFrame {

	// class declared and instantiated variables.
	private static final long serialVersionUID = 1L;
	private JLabel amountLabel = null;
	private JLabel tipPercentageLabel = null;
	private JLabel tipLabel = null;
	private JLabel totalLabel = null;
	private JLabel errorLabel = null;
	private JSlider tipPercentageSlider = null;
	private JTextField tipTextField = null;
	private JTextField totalTextField = null;
	private JTextField amountTextField = null;
	private JButton calculateButton = null;
	private int tipPercentage = 15; // default tipPercentage value.
	static final DecimalFormat DF = new DecimalFormat("$0.00"); // sets decimalForamt to be the same throughout class.

	/**
	 * Constructor which creates GUI, sets all of the fields to specific values.
	 * Specifies which field communicates and acts with the other specific fields.
	 */
	public TipCalculatorFrame() {
		super("Tip Calculator"); // sets GUI label/header.
		super.setSize(300, 225); // sets the GUI dimensions.
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes GUI operation so doesn't run in background.

		setupLayout(); 
		setupListeners(); 
	}

	/**
	 * Method holds the actual calculations of the tip calculator. Ensures that only
	 * real numbers of either integer or double value are inputed, or an error
	 * message is displayed in the tip text field. Method displays the appropriate
	 * values to the "tipTextField" and "totalTextField".
	 */
	void calculateResults() {

		if (amountTextField.getText().matches("\\d+(\\.\\d*+)?")) {
			// REGEX "\\d+(\\.\\*d+)? Must be a real integer number before optional decimal
			// point, and after decimal point if included must be a real number.
			errorLabel.setText("");
			double amount = Double.parseDouble(amountTextField.getText()); // parse String value into Double value.
			double tip = amount * tipPercentage / 100;
			double total = amount + tip;
			tipTextField.setText(DF.format(tip));
			totalTextField.setText(DF.format(total));

		} else {
			if (amountTextField.getText().length() != 0)
				errorLabel.setText("INVALID AMOUNT ENTRY");
			else { // sets errorLabel, tipTextField, and totalTextfield's to empty string when
					// amountTextfield is deleted.
				errorLabel.setText("");
				tipTextField.setText("");
				totalTextField.setText("");
			}
		}
	}

	/**
	 * Method holds the setup specifications for the layout of the GUI fields.
	 */
	private void setupLayout() {
// GUI LAYOUT specifications.
		GridBagLayout gridBagLayout = new GridBagLayout(); // creates instance of GridBagLayout to be used throughout
															// class.
		gridBagLayout.columnWidths = new int[] { 70, 5, 187, 10, 0 }; // sets the column width for the gridBagLayout
																		// used in the GUI.
		gridBagLayout.rowHeights = new int[] { 5, 0, 0, 10, 5, 0, 5, 0, 5, 0, 5, 0, 0 }; // sets the row height for the
																							// gridBagLayout used in the
																							// GUI.
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE }; // default column weight
																								// set so won't grow to
																								// fill space in the
																								// column.
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE }; // default row weight set so won't grow to fill space in the row.
		getContentPane().setLayout(gridBagLayout); // adds gridBagLayout style to contentPane.

// AMOUNT-LABEL specifications.
		amountLabel = new JLabel("Amount"); // setting amountLabel to be a JLable called Amount.
		GridBagConstraints gbc_AmountLabel = new GridBagConstraints(); // instance of GridBagLayout used for
																		// amountLabel.
		gbc_AmountLabel.anchor = GridBagConstraints.EAST; // sets label to display to the right of the field.
		gbc_AmountLabel.insets = new Insets(0, 0, 5, 5); // creates additional space between label and GUI border.
		gbc_AmountLabel.gridx = 0; // horizontally sets where to add the text in the field.
		gbc_AmountLabel.gridy = 1; // vertically sets where to add the text into the field.
		getContentPane().add(amountLabel, gbc_AmountLabel); // adds amountLabel to contentPane.

// AMOUNT TEXT FIELD specifications.
		amountTextField = new JTextField(); // setting amountTextField to be a JTextField.
		GridBagConstraints gbc_AmountTextField = new GridBagConstraints(); // instance of GridBagConstraints used for
																			// amountTextField.
		gbc_AmountTextField.fill = GridBagConstraints.BOTH; // fills field and resizes the text both vertically and
															// horizontally
		gbc_AmountTextField.insets = new Insets(0, 0, 5, 5); // creates additional space between text field and GUI
																// border.
		gbc_AmountTextField.gridx = 2; // horizontally sets where to add the text in the field.
		gbc_AmountTextField.gridy = 1; // vertically sets where to add the text into the field.
		getContentPane().add(amountTextField, gbc_AmountTextField); // adds amountTextField to contentPane.
		amountTextField.setColumns(10);

// ERROR-LABEL specifications.
		errorLabel = new JLabel(""); // setting errorLabel to be a JLabel. also to only show the field when an
										// invalid entry is typed in.
		errorLabel.setForeground(Color.RED); // sets labels font to red.
		GridBagConstraints gbc_errorLabel = new GridBagConstraints(); // instance of GridBagConstraints used for
																		// errorLabel.
		gbc_errorLabel.insets = new Insets(0, 0, 5, 5); // creates additional space between label and GUI border.
		gbc_errorLabel.gridx = 2; // horizontally sets where to add the text in the field.
		gbc_errorLabel.gridy = 3; // vertically sets where to add the text into the field.
		getContentPane().add(errorLabel, gbc_errorLabel); // adds errorLabel to contentPane.

// TIP-PERCENTAGE-LABEL specifications.
		tipPercentageLabel = new JLabel("%"); // setting tipPercentageLabel to be a JLabel
		GridBagConstraints gbc_TipPercentageLabel = new GridBagConstraints(); // instance of GridBagConstraints used for
																				// tipPercentageLabel
		gbc_TipPercentageLabel.anchor = GridBagConstraints.EAST; // sets label to display to the right of the field.
		gbc_TipPercentageLabel.insets = new Insets(0, 0, 5, 5); // creates additional space between label and GUI
																// border.
		gbc_TipPercentageLabel.gridx = 0; // horizontally sets where to add the text in the field.
		gbc_TipPercentageLabel.gridy = 5; // vertically sets where to add the text into the field.
		getContentPane().add(tipPercentageLabel, gbc_TipPercentageLabel); // adds tipPercentageLabel to contentPane.

// TIP-PERCENTAGE-SLIDER specifications.
		tipPercentageSlider = new JSlider(); // setting tipPercentageSlider to be a JSlider.
		GridBagConstraints gbc_TipPercentageSlider = new GridBagConstraints(); // instance of GridBagConstraints used
																				// for tipPercentageSlider.
		gbc_TipPercentageSlider.fill = GridBagConstraints.HORIZONTAL; // fills field to display slider horizontally.
		gbc_TipPercentageSlider.insets = new Insets(0, 0, 5, 5); // creates additional space between slider and GUI
																	// border.
		gbc_TipPercentageSlider.gridx = 2; // horizontally sets where to add the slider within the slider field
		gbc_TipPercentageSlider.gridy = 5; // vertically sets where to add the slider within the slider field.
		getContentPane().add(tipPercentageSlider, gbc_TipPercentageSlider); // adds tipPercentageSlider to contentPane.

// TIP-LABEL FIELD specifications.
		tipLabel = new JLabel("Tip"); // setting tipLabel to be a JLabel called Tip.
		GridBagConstraints gbc_TipLabel = new GridBagConstraints(); // instance of GridBagConstraints used for tipLabel.
		gbc_TipLabel.anchor = GridBagConstraints.EAST; // sets label to display to the right of the field.
		gbc_TipLabel.insets = new Insets(0, 0, 5, 5); // creates additional space between label and GUI border.
		gbc_TipLabel.gridx = 0; // horizontally sets where to add the text in the field.
		gbc_TipLabel.gridy = 7; // vertically sets where to add the text into the field.
		getContentPane().add(tipLabel, gbc_TipLabel); // adds tipLabel to contentPane.

// TIP TEXT FIELD specifications.
		tipTextField = new JTextField(); // setting tipTextField to be a JTextFild.
		GridBagConstraints gbc_textField = new GridBagConstraints(); // instance of GridBagConstraints used for
																		// tipTextField.
		gbc_textField.fill = GridBagConstraints.BOTH; // fills field and resizes the text both vertically and
														// horizontally.
		gbc_textField.insets = new Insets(0, 0, 5, 5); // creates additional space between text field and GUI border.
		gbc_textField.gridx = 2; // horizontally sets where to add the text in the field.
		gbc_textField.gridy = 7; // vertically sets where to add the text into the field.
		getContentPane().add(tipTextField, gbc_textField); // adds tipTextField to contentPane.
		tipTextField.setColumns(10);

// TOTAL-LABEL FIELD specifications.
		totalLabel = new JLabel("Total"); // setting totalLabel to be a JLabel called Total.
		GridBagConstraints gbc_lblTotal = new GridBagConstraints(); // instance of GridBagConstraints used for
																	// totalLabel.
		gbc_lblTotal.anchor = GridBagConstraints.EAST; // sets label to display to the right of the field.
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5); // creates additional space between label and GUI border.
		gbc_lblTotal.gridx = 0; // horizontally sets where to add the text in the field.
		gbc_lblTotal.gridy = 9; // vertically sets where to add the text into the field.
		getContentPane().add(totalLabel, gbc_lblTotal); // adds totlaLabel to contentPane.

// TOTAL TEXT FIELD specifications.
		totalTextField = new JTextField(); // setting totalTextField to be a JTextField.
		GridBagConstraints gbc_textField1 = new GridBagConstraints(); // instance of GridBayConstraints used for
																		// totalTextField.
		gbc_textField1.fill = GridBagConstraints.HORIZONTAL; // fills field to display text horizontally.
		gbc_textField1.insets = new Insets(0, 0, 5, 5); // creates additional space between text field and GUI border.
		gbc_textField1.gridx = 2; // horizontally sets where to add the text in the field.
		gbc_textField1.gridy = 9; // vertically sets where to add the text in the field.
		getContentPane().add(totalTextField, gbc_textField1); // adds totalTextField to contentPane.
		totalTextField.setColumns(10); // sets number of columns in textField.

// CALCULATE BUTTON specifications.
		calculateButton = new JButton("Calculate"); // setting calculateButton to be a JButton called Calculate.
		GridBagConstraints gbc_btnCalculate = new GridBagConstraints(); // instance of GridBagConstraints used for
																		// JButton.
		gbc_btnCalculate.insets = new Insets(0, 0, 0, 5); // creates additional space between button and GUI border.
		gbc_btnCalculate.fill = GridBagConstraints.HORIZONTAL; // fills button text "calculate" horizontally.
		gbc_btnCalculate.gridx = 2; // horizontally sets where to add the text in the field.
		gbc_btnCalculate.gridy = 11; // vertically sets where to add the text in the field.
		getContentPane().add(calculateButton, gbc_btnCalculate); // adds calculateButton to contentPane.

	}

	/**
	 * Method to setup the initial listeners for class variables.
	 */
	private void setupListeners() {
		/**
		 * Nested Class ChangeListener holds one method which calls setTipPercentage(). Sets the
		 * tip Percentage to the user selected specific slider value. New syntax is:
		 * "tipPercentageSlider.addChangeListener(e -> setTipPercentage(tipPercentageSlider.getValue()));"
		 */
		tipPercentageSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				setTipPercentage(tipPercentageSlider.getValue());
			}
		});
		tipPercentageSlider.setValue(tipPercentage); // sets the tipPercentageLabel to match the slider as it is moved.
		tipPercentageSlider.setMaximum(30); // max value slider can be set to.

		/**
		 * Nested Class KeyListener holds three methods which all call calculateResults().
		 * Calculates in real time the calculations after each key is released for
		 * amountTextField. New syntax is: 
		 * "amountTextField.addKeyListener(e -> calculateResuls());"
		 */
		amountTextField.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				calculateResults();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				this.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				this.keyReleased(e);
			}
		});

		/**
		 * Nested Class ActionListener holds one method which calls calculateResults() when
		 * action is performed on calculate button (although not necessary due to real
		 * time amountTextField update...kept in code to satisfy lab requirements and
		 * inform professor that am aware of proper syntax for programming it should it
		 * ever be required. New syntax is: 
		 * "calculateButton.addACtionLlistener(e -> calculateResults());"
		 */
		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calculateResults();
			}

		});
	}

	/**
	 * Method sets and displays the tipPercentageLabel field to the value that the
	 * user specifies on the tipPercentageSlider.
	 * 
	 * @param value 	user specified tip percentage slider choice.
	 */
	public void setTipPercentage(int value) {
		tipPercentage = value;
		tipPercentageLabel.setText(tipPercentage + " %");
	}

}
