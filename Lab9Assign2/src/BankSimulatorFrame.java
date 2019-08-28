
/*
 * Name: Patrick Czermak
 * Student ID: 040389514
 * Course & Section: CST3182 312
 * Assignment: Lab 9 / Assignment 2
 * Date: April 18, 2019
 */

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * The purpose of this Class is to create the GUI layout, formatting, and logic
 * for each aspect of the GUI. Conducts user input error checking when an
 * account is being created, when a transaction is being attempted, when an
 * account is attempted to display, and when all accounts are being attempted to
 * be displayed. Adds an account to the Bank.
 * 
 * @author Patrick Czermak
 * @version 1.3
 * @since JDK 1.8
 */
public class BankSimulatorFrame extends JFrame {

	/* class variables */
	private Bank bank;
	private static final long serialVersionUID = 1L;
	private Panel panelDisplayPrint;
	private Panel addAccountPanel;
	private Panel panelQuit;
	private JTextField textFieldAccountNumber;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldEmailAddress;
	private JTextField textFieldOpeningBalance;
	private JTextField textFieldMinimumBalance;
	private JTextField textFieldInterestRate;
	private JTextField textFieldMonthlyFee;
	private JTextField textFieldDepositAmount;
	private JTextField textFieldWithdrawAmount;
	private JTextField textFieldDisplayAccountNumber;
	private JTextArea textAreaDisplayPrintAccounts;
	private JTextField textFieldTransactionAccountNumber;
	private JRadioButton rdbtnSavingsAccount;
	private JRadioButton rdbtnChequingAccount;
	private JLabel lblMinimumBalance;
	private JLabel lblInterestRate;
	private JLabel lblMonthlyFee;
	private JLabel lblErrorAccountNumber;
	private JLabel lblErrorFirstName;
	private JLabel lblErrorLastName;
	private JLabel lblErrorPhoneNumber;
	private JLabel lblErrorEmailAddress;
	private JLabel lblErrorOpeningBalance;
	private JLabel lblErrorMinimumBalance;
	private JLabel lblErrorInterestRate;
	private JLabel lblErrorMonthlyFee;
	private JLabel lblErrorDepositAmount;
	private JLabel lblErrorWithdrawAmount;
	private JLabel lblErrorDisplayAccountNumber;
	private JLabel lblErrorTransactionAccountNumber;
	private JLabel lblTransactionAccountNumber;
	private JButton btnAddAccount;
	private JButton btnPrintAllAccounts;
	private JButton btnDisplayAccount;
	private JButton btnRunMonthlyUpdate;
	private JButton btnReadRecords;
	private JButton btnWriteRecords;
	private JButton btnTransaction;
	private JScrollPane scrollPaneDisplayPrintAccounts;

	/**
	 * Constructor which hold the layout/formatting specifications for Firemaster's
	 * Bank Simulator GUI.
	 */
	public BankSimulatorFrame() {

		bank = new Bank(); // instance of Bank Class
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes program from running in background when exited.
		setTitle("FIREMASTER'S BANK SIMULATOR"); // sets title of GUI

		/* TAB'S */
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(192, 192, 192));
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));

		/* ADD ACCOUNT PANEL */
		addAccountPanel = new Panel();
		addAccountPanel.setBackground(new Color(192, 192, 192));
		addAccountPanel.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		tabbedPane.addTab("ADD", null, addAccountPanel, null);
		GridBagLayout gblAddAccountPanel = new GridBagLayout();
		gblAddAccountPanel.columnWidths = new int[] { 25, 121, 10, 225, 0, 291, 0 };
		gblAddAccountPanel.rowHeights = new int[] { 10, 25, 0, 5, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0,
				10, 0, 20, 50, 0 };
		gblAddAccountPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gblAddAccountPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		addAccountPanel.setLayout(gblAddAccountPanel);

		/* ADD ACCOUNT PANEL, ACCOUNT TYPE LABEL */
		JLabel lblAccountType = new JLabel("Account Type: ");
		lblAccountType.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcLblAccountType = new GridBagConstraints();
		gbcLblAccountType.anchor = GridBagConstraints.EAST;
		gbcLblAccountType.insets = new Insets(0, 0, 5, 5);
		gbcLblAccountType.gridx = 1;
		gbcLblAccountType.gridy = 1;
		addAccountPanel.add(lblAccountType, gbcLblAccountType);

		/* ADD ACCOUNTS PANEL, SAVINGS ACCOUNT RADIO BUTTON */
		rdbtnSavingsAccount = new JRadioButton("Savings Account");
		rdbtnSavingsAccount.setBackground(new Color(192, 192, 192));
		rdbtnSavingsAccount.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcRdbtnSavingsAccount = new GridBagConstraints();
		gbcRdbtnSavingsAccount.anchor = GridBagConstraints.NORTHWEST;
		gbcRdbtnSavingsAccount.insets = new Insets(0, 0, 5, 5);
		gbcRdbtnSavingsAccount.gridx = 3;
		gbcRdbtnSavingsAccount.gridy = 1;
		addAccountPanel.add(rdbtnSavingsAccount, gbcRdbtnSavingsAccount);
		rdbtnSavingsAccount.setSelected(true); // sets savings account radio button to be checked upon opening ADD pane
												// as default.

		/* ADD ACCOUNT PANEL, CHEQUING ACCOUNT RADIO BUTTON */
		rdbtnChequingAccount = new JRadioButton("Chequing Account");
		rdbtnChequingAccount.setBackground(new Color(192, 192, 192));
		rdbtnChequingAccount.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcRdbtnChequingAccount = new GridBagConstraints();
		gbcRdbtnChequingAccount.insets = new Insets(0, 0, 5, 5);
		gbcRdbtnChequingAccount.anchor = GridBagConstraints.NORTHWEST;
		gbcRdbtnChequingAccount.gridx = 3;
		gbcRdbtnChequingAccount.gridy = 2;
		addAccountPanel.add(rdbtnChequingAccount, gbcRdbtnChequingAccount);

		/* ADD ACCOUNT PANEL, ACCOUNT NUMBER LABEL */
		JLabel lblAccountNumber = new JLabel("Account Number: ");
		lblAccountNumber.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcLblAccountNumber = new GridBagConstraints();
		gbcLblAccountNumber.anchor = GridBagConstraints.EAST;
		gbcLblAccountNumber.insets = new Insets(0, 0, 5, 5);
		gbcLblAccountNumber.gridx = 1;
		gbcLblAccountNumber.gridy = 4;
		addAccountPanel.add(lblAccountNumber, gbcLblAccountNumber);

		/* ADD ACCOUNT PANEL, ACCOUNT NUMBER TEXT FIELD */
		textFieldAccountNumber = new JTextField();
		textFieldAccountNumber.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		GridBagConstraints gbcTextFieldAccountNumber = new GridBagConstraints();
		gbcTextFieldAccountNumber.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldAccountNumber.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldAccountNumber.gridx = 3;
		gbcTextFieldAccountNumber.gridy = 4;
		addAccountPanel.add(textFieldAccountNumber, gbcTextFieldAccountNumber);
		textFieldAccountNumber.setColumns(10); // sets column width to a minimum of 10

		/* ADD ACCOUNT PANEL, ERROR ACCOUNT NUMBER LABEL */
		lblErrorAccountNumber = new JLabel("");
		lblErrorAccountNumber.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblErrorAccountNumber.setForeground(Color.RED);
		GridBagConstraints gbcLblErrorAccountNumber = new GridBagConstraints();
		gbcLblErrorAccountNumber.anchor = GridBagConstraints.WEST;
		gbcLblErrorAccountNumber.insets = new Insets(0, 0, 5, 0);
		gbcLblErrorAccountNumber.gridx = 5;
		gbcLblErrorAccountNumber.gridy = 4;
		addAccountPanel.add(lblErrorAccountNumber, gbcLblErrorAccountNumber);

		/* ADD ACCOUNT LABEL, FIRST NAME LABEL */
		JLabel lblFirstName = new JLabel("First Name: ");
		lblFirstName.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcLblFirstName = new GridBagConstraints();
		gbcLblFirstName.anchor = GridBagConstraints.EAST;
		gbcLblFirstName.insets = new Insets(0, 0, 5, 5);
		gbcLblFirstName.gridx = 1;
		gbcLblFirstName.gridy = 6;
		addAccountPanel.add(lblFirstName, gbcLblFirstName);

		/* ADD ACCOUNT LABEL, FIRST NAME TEXT FIELD */
		textFieldFirstName = new JTextField();
		textFieldFirstName.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		GridBagConstraints gbcTextFieldFirstName = new GridBagConstraints();
		gbcTextFieldFirstName.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldFirstName.gridx = 3;
		gbcTextFieldFirstName.gridy = 6;
		addAccountPanel.add(textFieldFirstName, gbcTextFieldFirstName);
		textFieldFirstName.setColumns(10); // sets column width to a minimum of 10

		/* ADD ACCOUNT LABEL, ERROR FIRST NAME LABEL */
		lblErrorFirstName = new JLabel("");
		lblErrorFirstName.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblErrorFirstName.setForeground(Color.RED);
		GridBagConstraints gbcLblErrorFirstName = new GridBagConstraints();
		gbcLblErrorFirstName.anchor = GridBagConstraints.WEST;
		gbcLblErrorFirstName.insets = new Insets(0, 0, 5, 0);
		gbcLblErrorFirstName.gridx = 5;
		gbcLblErrorFirstName.gridy = 6;
		addAccountPanel.add(lblErrorFirstName, gbcLblErrorFirstName);

		/* ADD ACCOUNT PANEL, LAST NAME LABEL */
		JLabel lblLastName = new JLabel("Last Name: ");
		lblLastName.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcLblLastName = new GridBagConstraints();
		gbcLblLastName.anchor = GridBagConstraints.EAST;
		gbcLblLastName.insets = new Insets(0, 0, 5, 5);
		gbcLblLastName.gridx = 1;
		gbcLblLastName.gridy = 8;
		addAccountPanel.add(lblLastName, gbcLblLastName);

		/* ADD ACCOUNT PANEL, LAST NAME TEXT FIELD */
		textFieldLastName = new JTextField();
		textFieldLastName.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		GridBagConstraints gbcTextFieldLastName = new GridBagConstraints();
		gbcTextFieldLastName.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldLastName.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldLastName.gridx = 3;
		gbcTextFieldLastName.gridy = 8;
		addAccountPanel.add(textFieldLastName, gbcTextFieldLastName);
		textFieldLastName.setColumns(10); // sets column width to a minimum of 10

		/* ADD ACCOUNT PANEL, ERROR LAST NAME LABEL */
		lblErrorLastName = new JLabel("");
		lblErrorLastName.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblErrorLastName.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbcLblErrorLastName = new GridBagConstraints();
		gbcLblErrorLastName.anchor = GridBagConstraints.WEST;
		gbcLblErrorLastName.insets = new Insets(0, 0, 5, 0);
		gbcLblErrorLastName.gridx = 5;
		gbcLblErrorLastName.gridy = 8;
		addAccountPanel.add(lblErrorLastName, gbcLblErrorLastName);

		/* ADD ACCOUNT PANEL, PHONE NUMBER LABEL */
		JLabel lblPhoneNumber = new JLabel("Phone Number: ");
		lblPhoneNumber.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcLblPhoneNumber = new GridBagConstraints();
		gbcLblPhoneNumber.anchor = GridBagConstraints.EAST;
		gbcLblPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbcLblPhoneNumber.gridx = 1;
		gbcLblPhoneNumber.gridy = 10;
		addAccountPanel.add(lblPhoneNumber, gbcLblPhoneNumber);

		/* ADD ACCOUNT PANEL, PHONE NUMBER TEXT FIELD */
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		GridBagConstraints gbcTextFieldPhoneNumber = new GridBagConstraints();
		gbcTextFieldPhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldPhoneNumber.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldPhoneNumber.gridx = 3;
		gbcTextFieldPhoneNumber.gridy = 10;
		addAccountPanel.add(textFieldPhoneNumber, gbcTextFieldPhoneNumber);
		textFieldPhoneNumber.setColumns(10); // sets column width to a minimum of 10

		/* ADD ACCOUNT PANEL, ERROR PHONE NUMBER LABEL */
		lblErrorPhoneNumber = new JLabel("");
		lblErrorPhoneNumber.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblErrorPhoneNumber.setForeground(Color.RED);
		GridBagConstraints gbcLblErrorPhoneNumber = new GridBagConstraints();
		gbcLblErrorPhoneNumber.anchor = GridBagConstraints.WEST;
		gbcLblErrorPhoneNumber.insets = new Insets(0, 0, 5, 0);
		gbcLblErrorPhoneNumber.gridx = 5;
		gbcLblErrorPhoneNumber.gridy = 10;
		addAccountPanel.add(lblErrorPhoneNumber, gbcLblErrorPhoneNumber);

		/* ADD ACCOUNT PANEL, EMAIL ADDRESS LABEL */
		JLabel lblEmailAddress = new JLabel("Email Address: ");
		lblEmailAddress.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcLblEmailAddress = new GridBagConstraints();
		gbcLblEmailAddress.anchor = GridBagConstraints.EAST;
		gbcLblEmailAddress.insets = new Insets(0, 0, 5, 5);
		gbcLblEmailAddress.gridx = 1;
		gbcLblEmailAddress.gridy = 12;
		addAccountPanel.add(lblEmailAddress, gbcLblEmailAddress);

		/* ADD ACCOUNT PANEL, EMAIL ADDRESS TEXT FIELD */
		textFieldEmailAddress = new JTextField();
		textFieldEmailAddress.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		GridBagConstraints gbcTextFieldEmailAddress = new GridBagConstraints();
		gbcTextFieldEmailAddress.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldEmailAddress.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldEmailAddress.gridx = 3;
		gbcTextFieldEmailAddress.gridy = 12;
		addAccountPanel.add(textFieldEmailAddress, gbcTextFieldEmailAddress);
		textFieldEmailAddress.setColumns(10); // sets column width to a minimum of 10

		/* ADD ACCOUNT PANEL, ERROR EMAIL ADDRESS LABEL */
		lblErrorEmailAddress = new JLabel("");
		lblErrorEmailAddress.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblErrorEmailAddress.setForeground(Color.RED);
		GridBagConstraints gbcLblErrorEmailAddress = new GridBagConstraints();
		gbcLblErrorEmailAddress.anchor = GridBagConstraints.WEST;
		gbcLblErrorEmailAddress.insets = new Insets(0, 0, 5, 0);
		gbcLblErrorEmailAddress.gridx = 5;
		gbcLblErrorEmailAddress.gridy = 12;
		addAccountPanel.add(lblErrorEmailAddress, gbcLblErrorEmailAddress);

		/* ADD ACCOUNT PANEL, OPENING BALANCE LABEL */
		JLabel lblOpeningBalance = new JLabel("Opening Balance: ");
		lblOpeningBalance.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcLblOpeningBalance = new GridBagConstraints();
		gbcLblOpeningBalance.anchor = GridBagConstraints.EAST;
		gbcLblOpeningBalance.insets = new Insets(0, 0, 5, 5);
		gbcLblOpeningBalance.gridx = 1;
		gbcLblOpeningBalance.gridy = 14;
		addAccountPanel.add(lblOpeningBalance, gbcLblOpeningBalance);

		/* ADD ACCOUNT PANEL, OPENING BALANCE TEXT FIELD */
		textFieldOpeningBalance = new JTextField();
		textFieldOpeningBalance.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		GridBagConstraints gbcTextFieldOpeningBalance = new GridBagConstraints();
		gbcTextFieldOpeningBalance.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldOpeningBalance.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldOpeningBalance.gridx = 3;
		gbcTextFieldOpeningBalance.gridy = 14;
		addAccountPanel.add(textFieldOpeningBalance, gbcTextFieldOpeningBalance);
		textFieldOpeningBalance.setColumns(10); // sets column width to a minimum of 10

		/* ADD ACCOUNT PANEL, ERROR OPENING BALANCE LABEL */
		lblErrorOpeningBalance = new JLabel("");
		lblErrorOpeningBalance.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblErrorOpeningBalance.setForeground(Color.RED);
		GridBagConstraints gbcLblErrorOpeningBalance = new GridBagConstraints();
		gbcLblErrorOpeningBalance.anchor = GridBagConstraints.WEST;
		gbcLblErrorOpeningBalance.insets = new Insets(0, 0, 5, 0);
		gbcLblErrorOpeningBalance.gridx = 5;
		gbcLblErrorOpeningBalance.gridy = 14;
		addAccountPanel.add(lblErrorOpeningBalance, gbcLblErrorOpeningBalance);

		/* ADD ACCOUNT PANEL, MINIMUM BALANCE LABEL */
		lblMinimumBalance = new JLabel("Minimum Balance: ");
		lblMinimumBalance.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcLblMinimumBalance = new GridBagConstraints();
		gbcLblMinimumBalance.anchor = GridBagConstraints.EAST;
		gbcLblMinimumBalance.insets = new Insets(0, 0, 5, 5);
		gbcLblMinimumBalance.gridx = 1;
		gbcLblMinimumBalance.gridy = 16;
		addAccountPanel.add(lblMinimumBalance, gbcLblMinimumBalance);

		/* ADD ACCOUNT PANEL, MINIMUM BALANCE TEXT FIELD */
		textFieldMinimumBalance = new JTextField();
		textFieldMinimumBalance.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		GridBagConstraints gbcTextFieldMinimumBalance = new GridBagConstraints();
		gbcTextFieldMinimumBalance.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldMinimumBalance.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldMinimumBalance.gridx = 3;
		gbcTextFieldMinimumBalance.gridy = 16;
		addAccountPanel.add(textFieldMinimumBalance, gbcTextFieldMinimumBalance);
		textFieldMinimumBalance.setColumns(10); // sets column width to a minimum of 10

		/* ADD ACCOUNT PANEL, ERROR MINIMUM BALANCE LABEL */
		lblErrorMinimumBalance = new JLabel("");
		lblErrorMinimumBalance.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblErrorMinimumBalance.setForeground(Color.RED);
		GridBagConstraints gbcLblErrorMinimumBalance = new GridBagConstraints();
		gbcLblErrorMinimumBalance.anchor = GridBagConstraints.WEST;
		gbcLblErrorMinimumBalance.insets = new Insets(0, 0, 5, 0);
		gbcLblErrorMinimumBalance.gridx = 5;
		gbcLblErrorMinimumBalance.gridy = 16;
		addAccountPanel.add(lblErrorMinimumBalance, gbcLblErrorMinimumBalance);

		/* ADD ACCOUNT PANEL, INTEREST RATE LABEL */
		lblInterestRate = new JLabel("Interest Rate: ");
		lblInterestRate.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcLblInterestRate = new GridBagConstraints();
		gbcLblInterestRate.anchor = GridBagConstraints.EAST;
		gbcLblInterestRate.insets = new Insets(0, 0, 5, 5);
		gbcLblInterestRate.gridx = 1;
		gbcLblInterestRate.gridy = 18;
		addAccountPanel.add(lblInterestRate, gbcLblInterestRate);

		/* ADD ACCOUNT PANEL, INTEREST RATE TEXT FIELD */
		textFieldInterestRate = new JTextField();
		textFieldInterestRate.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		GridBagConstraints gbcTextFieldInterestRate = new GridBagConstraints();
		gbcTextFieldInterestRate.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldInterestRate.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldInterestRate.gridx = 3;
		gbcTextFieldInterestRate.gridy = 18;
		addAccountPanel.add(textFieldInterestRate, gbcTextFieldInterestRate);
		textFieldInterestRate.setColumns(10); // sets column width to a minimum of 10

		/* ADD ACCOUNT PANEL, ERROR INTEREST RATE LABEL */
		lblErrorInterestRate = new JLabel("");
		lblErrorInterestRate.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblErrorInterestRate.setForeground(Color.RED);
		GridBagConstraints gbcLblErrorInterestRate = new GridBagConstraints();
		gbcLblErrorInterestRate.anchor = GridBagConstraints.WEST;
		gbcLblErrorInterestRate.insets = new Insets(0, 0, 5, 0);
		gbcLblErrorInterestRate.gridx = 5;
		gbcLblErrorInterestRate.gridy = 18;
		addAccountPanel.add(lblErrorInterestRate, gbcLblErrorInterestRate);

		/* ADD ACCOUNT PANEL, MONTHLY FEE LABEL */
		lblMonthlyFee = new JLabel("Monthly Fee: ");
		lblMonthlyFee.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcLblMonthlyFee = new GridBagConstraints();
		gbcLblMonthlyFee.anchor = GridBagConstraints.EAST;
		gbcLblMonthlyFee.insets = new Insets(0, 0, 5, 5);
		gbcLblMonthlyFee.gridx = 1;
		gbcLblMonthlyFee.gridy = 20;
		addAccountPanel.add(lblMonthlyFee, gbcLblMonthlyFee);
		lblMonthlyFee.setEnabled(false); // sets monthly fee label to be greyed out by default as it is not part of the
											// savings account parameters(savings account parameters are highlighted as
											// a default)

		/* ADD ACCOUNT PANEL, MONTHLY FEE TEXT FIELD */
		textFieldMonthlyFee = new JTextField();
		textFieldMonthlyFee.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		GridBagConstraints gbcTextFieldMonthlyFee = new GridBagConstraints();
		gbcTextFieldMonthlyFee.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldMonthlyFee.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldMonthlyFee.gridx = 3;
		gbcTextFieldMonthlyFee.gridy = 20;
		addAccountPanel.add(textFieldMonthlyFee, gbcTextFieldMonthlyFee);
		textFieldMonthlyFee.setColumns(10); // sets column width to a minimum of 10

		/* ADD ACCOUNT PANEL, ERROR MONTHLY FEE LABEL */
		lblErrorMonthlyFee = new JLabel("");
		lblErrorMonthlyFee.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblErrorMonthlyFee.setForeground(Color.RED);
		GridBagConstraints gbcLblErrorMonthlyFee = new GridBagConstraints();
		gbcLblErrorMonthlyFee.anchor = GridBagConstraints.WEST;
		gbcLblErrorMonthlyFee.insets = new Insets(0, 0, 5, 0);
		gbcLblErrorMonthlyFee.gridx = 5;
		gbcLblErrorMonthlyFee.gridy = 20;
		addAccountPanel.add(lblErrorMonthlyFee, gbcLblErrorMonthlyFee);

		/* ADD ACCOUNT PANEL, ADD ACCOUNT BUTTON */
		btnAddAccount = new JButton("ADD ACCOUNT");
		btnAddAccount.setForeground(new Color(0, 0, 0));
		btnAddAccount.setBackground(new Color(0, 128, 0));
		btnAddAccount.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcBtnAddAccount = new GridBagConstraints();
		gbcBtnAddAccount.fill = GridBagConstraints.BOTH;
		gbcBtnAddAccount.insets = new Insets(0, 0, 0, 5);
		gbcBtnAddAccount.gridx = 3;
		gbcBtnAddAccount.gridy = 22;
		addAccountPanel.add(btnAddAccount, gbcBtnAddAccount);

		/* TRANSACTION PANEL */
		Panel panelTransaction = new Panel();
		panelTransaction.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("TRANSACTIONS", null, panelTransaction, null);
		GridBagLayout gblPanelDeposit = new GridBagLayout();
		gblPanelDeposit.columnWidths = new int[] { 50, 126, 10, 225, 10, 177, 0 };
		gblPanelDeposit.rowHeights = new int[] { 50, 34, 50, 0, 35, 0, 35, 50, 0 };
		gblPanelDeposit.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gblPanelDeposit.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelTransaction.setLayout(gblPanelDeposit);

		/* TRANSACTION PANEL, ACCOUNT NUMBER LABEL */
		lblTransactionAccountNumber = new JLabel("Account Number: ");
		lblTransactionAccountNumber.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcLblTransactionAccountNumber = new GridBagConstraints();
		gbcLblTransactionAccountNumber.anchor = GridBagConstraints.EAST;
		gbcLblTransactionAccountNumber.insets = new Insets(0, 0, 5, 5);
		gbcLblTransactionAccountNumber.gridx = 1;
		gbcLblTransactionAccountNumber.gridy = 1;
		panelTransaction.add(lblTransactionAccountNumber, gbcLblTransactionAccountNumber);

		/* TRANSACTION PANEL, ACCOUNT NUMBER TEXT FIELD */
		textFieldTransactionAccountNumber = new JTextField();
		textFieldTransactionAccountNumber.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		GridBagConstraints gbcTextFieldTransactionAccountNumber = new GridBagConstraints();
		gbcTextFieldTransactionAccountNumber.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldTransactionAccountNumber.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldTransactionAccountNumber.gridx = 3;
		gbcTextFieldTransactionAccountNumber.gridy = 1;
		panelTransaction.add(textFieldTransactionAccountNumber, gbcTextFieldTransactionAccountNumber);
		textFieldTransactionAccountNumber.setColumns(10); // sets column width to a minimum of 10

		/* TRANSACTION PANEL, ACCOUNT NUMBER ERROR LABEL */
		lblErrorTransactionAccountNumber = new JLabel("");
		lblErrorTransactionAccountNumber.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblErrorTransactionAccountNumber.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbcLblErrorTransactionAccountNumber = new GridBagConstraints();
		gbcLblErrorTransactionAccountNumber.anchor = GridBagConstraints.WEST;
		gbcLblErrorTransactionAccountNumber.insets = new Insets(0, 0, 5, 0);
		gbcLblErrorTransactionAccountNumber.gridx = 5;
		gbcLblErrorTransactionAccountNumber.gridy = 1;
		panelTransaction.add(lblErrorTransactionAccountNumber, gbcLblErrorTransactionAccountNumber);

		/* TRANSACTION PANEL, DEPOSIT AMOUNT LABEL */
		JLabel lblDepositAmount = new JLabel("Deposit Amount: ");
		lblDepositAmount.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcLblDepositAmount = new GridBagConstraints();
		gbcLblDepositAmount.anchor = GridBagConstraints.EAST;
		gbcLblDepositAmount.insets = new Insets(0, 0, 5, 5);
		gbcLblDepositAmount.gridx = 1;
		gbcLblDepositAmount.gridy = 3;
		panelTransaction.add(lblDepositAmount, gbcLblDepositAmount);

		/* TRANSACTION PANEL, DEPOSIT AMOUNT TEXT FIELD */
		textFieldDepositAmount = new JTextField();
		textFieldDepositAmount.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		GridBagConstraints gbcTextFieldDepositAmount = new GridBagConstraints();
		gbcTextFieldDepositAmount.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldDepositAmount.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldDepositAmount.gridx = 3;
		gbcTextFieldDepositAmount.gridy = 3;
		panelTransaction.add(textFieldDepositAmount, gbcTextFieldDepositAmount);
		textFieldDepositAmount.setColumns(10); // sets column width to a minimum of 10

		/* TRANSACTION PANEL, DEPOSIT AMOUNT ERROR LABEL */
		lblErrorDepositAmount = new JLabel("");
		lblErrorDepositAmount.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblErrorDepositAmount.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbcLblErrorDepositAmount = new GridBagConstraints();
		gbcLblErrorDepositAmount.anchor = GridBagConstraints.WEST;
		gbcLblErrorDepositAmount.insets = new Insets(0, 0, 5, 0);
		gbcLblErrorDepositAmount.gridx = 5;
		gbcLblErrorDepositAmount.gridy = 3;
		panelTransaction.add(lblErrorDepositAmount, gbcLblErrorDepositAmount);

		/* TRANSACTION PANEL, WITHDRAW AMOUNT LABEL */
		JLabel lblWithdrawAmount = new JLabel("Withdraw Amount: ");
		lblWithdrawAmount.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcLblWithdrawAmount = new GridBagConstraints();
		gbcLblWithdrawAmount.anchor = GridBagConstraints.EAST;
		gbcLblWithdrawAmount.insets = new Insets(0, 0, 5, 5);
		gbcLblWithdrawAmount.gridx = 1;
		gbcLblWithdrawAmount.gridy = 5;
		panelTransaction.add(lblWithdrawAmount, gbcLblWithdrawAmount);

		/* TRANSACTION PANEL, WITHDRAW AMOUNT TEXT FIELD */
		textFieldWithdrawAmount = new JTextField();
		textFieldWithdrawAmount.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		GridBagConstraints gbcTextFieldWithdrawAmount = new GridBagConstraints();
		gbcTextFieldWithdrawAmount.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldWithdrawAmount.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldWithdrawAmount.gridx = 3;
		gbcTextFieldWithdrawAmount.gridy = 5;
		panelTransaction.add(textFieldWithdrawAmount, gbcTextFieldWithdrawAmount);
		textFieldWithdrawAmount.setColumns(10); // sets column width to a minimum of 10

		/* TRANSACTION PANEL, WITHDRAW AMOUNT ERROR LABEL */
		lblErrorWithdrawAmount = new JLabel("");
		lblErrorWithdrawAmount.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblErrorWithdrawAmount.setForeground(Color.RED);
		GridBagConstraints gbcLblErrorWithdrawAmount = new GridBagConstraints();
		gbcLblErrorWithdrawAmount.anchor = GridBagConstraints.WEST;
		gbcLblErrorWithdrawAmount.insets = new Insets(0, 0, 5, 5);
		gbcLblErrorWithdrawAmount.gridx = 5;
		gbcLblErrorWithdrawAmount.gridy = 5;
		panelTransaction.add(lblErrorWithdrawAmount, gbcLblErrorWithdrawAmount);

		/* TRANSACTION PANEL, TRANSACTION BUTTON */
		btnTransaction = new JButton("TRANSACTION");
		btnTransaction.setBackground(new Color(0, 128, 0));
		btnTransaction.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcBtnNewButton = new GridBagConstraints();
		gbcBtnNewButton.fill = GridBagConstraints.BOTH;
		gbcBtnNewButton.insets = new Insets(0, 0, 0, 5);
		gbcBtnNewButton.gridx = 3;
		gbcBtnNewButton.gridy = 7;
		panelTransaction.add(btnTransaction, gbcBtnNewButton);

		/* DISPLAY/PRINT PANEL */
		panelDisplayPrint = new Panel();
		panelDisplayPrint.setBackground(new Color(192, 192, 192));
		panelDisplayPrint.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		tabbedPane.addTab("DISPLAY/PRINT", null, panelDisplayPrint, null);
		GridBagLayout gblPanelWithdraw = new GridBagLayout();
		gblPanelWithdraw.columnWidths = new int[] { 15, 134, 252, 0, 350, 5, 0 };
		gblPanelWithdraw.rowHeights = new int[] { 25, 0, 5, 50, 25, 50, 0, 0, 0 };
		gblPanelWithdraw.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gblPanelWithdraw.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panelDisplayPrint.setLayout(gblPanelWithdraw);

		/* DISPLAY/PRINT PANEL, DISPLAY ACCOUNT NUMBER LABEL */
		JLabel lblDisplayAccountNumber = new JLabel("Display Account Number: ");
		lblDisplayAccountNumber.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcLblDisplayAccountNumber = new GridBagConstraints();
		gbcLblDisplayAccountNumber.anchor = GridBagConstraints.EAST;
		gbcLblDisplayAccountNumber.insets = new Insets(0, 0, 5, 5);
		gbcLblDisplayAccountNumber.gridx = 1;
		gbcLblDisplayAccountNumber.gridy = 1;
		panelDisplayPrint.add(lblDisplayAccountNumber, gbcLblDisplayAccountNumber);

		/* DISPLAY/PRINT PANEL, DISPLAY ACCOUNT NUMBER TEXT FIELD */
		textFieldDisplayAccountNumber = new JTextField();
		textFieldDisplayAccountNumber.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));
		GridBagConstraints gbcTextFieldDisplayAccountNumber = new GridBagConstraints();
		gbcTextFieldDisplayAccountNumber.insets = new Insets(0, 0, 5, 5);
		gbcTextFieldDisplayAccountNumber.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFieldDisplayAccountNumber.gridx = 2;
		gbcTextFieldDisplayAccountNumber.gridy = 1;
		panelDisplayPrint.add(textFieldDisplayAccountNumber, gbcTextFieldDisplayAccountNumber);
		textFieldDisplayAccountNumber.setColumns(10); // sets column width to a minimum of 10

		/* DISPLAY/PRINT PANEL, DISPLAY ACCOUNT NUMBER ERROR LABEL */
		lblErrorDisplayAccountNumber = new JLabel("");
		lblErrorDisplayAccountNumber.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblErrorDisplayAccountNumber.setForeground(Color.RED);
		GridBagConstraints gbcLblErrorDisplayAccountNumber = new GridBagConstraints();
		gbcLblErrorDisplayAccountNumber.anchor = GridBagConstraints.WEST;
		gbcLblErrorDisplayAccountNumber.insets = new Insets(0, 0, 5, 5);
		gbcLblErrorDisplayAccountNumber.gridx = 4;
		gbcLblErrorDisplayAccountNumber.gridy = 1;
		panelDisplayPrint.add(lblErrorDisplayAccountNumber, gbcLblErrorDisplayAccountNumber);

		/* DISPLAY/PRINT PANEL, DISPLAY ACCOUNT BUTTON */
		btnDisplayAccount = new JButton("DISPLAY ACCOUNT");
		btnDisplayAccount.setBackground(new Color(0, 128, 0));
		btnDisplayAccount.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcBtnDisplayAccount = new GridBagConstraints();
		gbcBtnDisplayAccount.fill = GridBagConstraints.BOTH;
		gbcBtnDisplayAccount.insets = new Insets(0, 0, 5, 5);
		gbcBtnDisplayAccount.gridx = 2;
		gbcBtnDisplayAccount.gridy = 3;
		panelDisplayPrint.add(btnDisplayAccount, gbcBtnDisplayAccount);

		/* DISPLAY/PRINT PANEL, PRINT ALL ACCOUNTS BUTTON */
		btnPrintAllAccounts = new JButton("PRINT ALL ACCOUNTS");
		btnPrintAllAccounts.setBackground(new Color(0, 128, 0));
		btnPrintAllAccounts.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcBtnPrintAllAccounts = new GridBagConstraints();
		gbcBtnPrintAllAccounts.fill = GridBagConstraints.BOTH;
		gbcBtnPrintAllAccounts.insets = new Insets(0, 0, 5, 5);
		gbcBtnPrintAllAccounts.gridx = 2;
		gbcBtnPrintAllAccounts.gridy = 5;
		panelDisplayPrint.add(btnPrintAllAccounts, gbcBtnPrintAllAccounts);

		/* DISPLAY/PRINT PANEL, DISPLAY PRINT ACCOUNTS SCROLL PANE */
		scrollPaneDisplayPrintAccounts = new JScrollPane();
		GridBagConstraints gbcScrollPaneDisplayPrintAccounts = new GridBagConstraints();
		gbcScrollPaneDisplayPrintAccounts.insets = new Insets(0, 0, 0, 5);
		gbcScrollPaneDisplayPrintAccounts.gridwidth = 4;
		gbcScrollPaneDisplayPrintAccounts.fill = GridBagConstraints.BOTH;
		gbcScrollPaneDisplayPrintAccounts.gridx = 1;
		gbcScrollPaneDisplayPrintAccounts.gridy = 7;
		panelDisplayPrint.add(scrollPaneDisplayPrintAccounts, gbcScrollPaneDisplayPrintAccounts);

		/* DISPLAY/PRINT PANEL, TEXT AREA DISPLAY PRINT ACCOUNTS */
		textAreaDisplayPrintAccounts = new JTextArea();
		scrollPaneDisplayPrintAccounts.setViewportView(textAreaDisplayPrintAccounts);
		textAreaDisplayPrintAccounts.setEditable(false);
		textAreaDisplayPrintAccounts.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 15));

		/* MONTHLY UPDATE PANEL */
		Panel panelMonthlyUpdate = new Panel();
		panelMonthlyUpdate.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("MONTHLY UPDATE", null, panelMonthlyUpdate, null);
		GridBagLayout gblPanel3 = new GridBagLayout();
		gblPanel3.columnWidths = new int[] { 300, 225, 300, 0 };
		gblPanel3.rowHeights = new int[] { 67, 50, 300, 0 };
		gblPanel3.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gblPanel3.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelMonthlyUpdate.setLayout(gblPanel3);

		/* MONTHLY UPDATE PANEL, RUN MONTHLY UPDATE BUTTON */
		btnRunMonthlyUpdate = new JButton("RUN MONTHLY UPDATE");
		btnRunMonthlyUpdate.setBackground(new Color(0, 128, 0));
		btnRunMonthlyUpdate.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcBtnRunMonthlyUpdate = new GridBagConstraints();
		gbcBtnRunMonthlyUpdate.fill = GridBagConstraints.BOTH;
		gbcBtnRunMonthlyUpdate.insets = new Insets(0, 0, 5, 5);
		gbcBtnRunMonthlyUpdate.gridx = 1;
		gbcBtnRunMonthlyUpdate.gridy = 1;
		panelMonthlyUpdate.add(btnRunMonthlyUpdate, gbcBtnRunMonthlyUpdate);

		/* READ/WRITE PANEL */
		Panel panelReadWrite = new Panel();
		panelReadWrite.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("READ/WRITE", null, panelReadWrite, null);
		GridBagLayout gblPanelRead = new GridBagLayout();
		gblPanelRead.columnWidths = new int[] { 150, 225, 75, 225, 150, 0 };
		gblPanelRead.rowHeights = new int[] { 67, 50, 300, 0 };
		gblPanelRead.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gblPanelRead.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelReadWrite.setLayout(gblPanelRead);

		/* READ/WRITE PANEL, READ RECORDS BUTTON */
		btnReadRecords = new JButton("READ RECORDS");
		btnReadRecords.setBackground(new Color(0, 128, 0));
		btnReadRecords.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcBtnReadRecords = new GridBagConstraints();
		gbcBtnReadRecords.fill = GridBagConstraints.BOTH;
		gbcBtnReadRecords.insets = new Insets(0, 0, 5, 5);
		gbcBtnReadRecords.gridx = 1;
		gbcBtnReadRecords.gridy = 1;
		panelReadWrite.add(btnReadRecords, gbcBtnReadRecords);

		/* READ/WRITE PANEL, WRITE RECORDS BUTTON */
		btnWriteRecords = new JButton("WRITE RECORDS");
		btnWriteRecords.setBackground(new Color(0, 128, 0));
		btnWriteRecords.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbcBtnWriteRecords = new GridBagConstraints();
		gbcBtnWriteRecords.fill = GridBagConstraints.BOTH;
		gbcBtnWriteRecords.insets = new Insets(0, 0, 5, 5);
		gbcBtnWriteRecords.gridx = 3;
		gbcBtnWriteRecords.gridy = 1;
		panelReadWrite.add(btnWriteRecords, gbcBtnWriteRecords);

		/* QUIT PANEL */
		panelQuit = new Panel();
		panelQuit.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("QUIT", null, panelQuit, null);

		setupListeners(); // calls setupListeners method below

	}

	/**
	 * Method holds all of the listeners for the GUI.
	 */
	private void setupListeners() {

		/*
		 * Anonymous class which specifies what happens when the Savings Account radio
		 * button is selected. Ensures only fields relevant for a Savings account are
		 * enabled to take input.
		 */
		rdbtnSavingsAccount.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnSavingsAccount.isSelected()) { 
					rdbtnChequingAccount.setSelected(false); 
					textFieldMonthlyFee.setEnabled(false); 
					textFieldMonthlyFee.setText(""); 
					textFieldMinimumBalance.setEnabled(true); 
					textFieldInterestRate.setEnabled(true); 
					lblMonthlyFee.setEnabled(false);
					lblInterestRate.setEnabled(true); 
					lblMinimumBalance.setEnabled(true); 
					lblErrorMonthlyFee.setText("");
				}
			}
		});

		/*
		 * Anonymous Class which specifies what happens when the Chequing Account radio
		 * button is selected. Ensures only fields relevant for a Chequing account is
		 * enabled to take input.
		 */
		rdbtnChequingAccount.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnChequingAccount.isSelected()) { 
					rdbtnSavingsAccount.setSelected(false); 
					textFieldMinimumBalance.setEnabled(false); 
					textFieldMinimumBalance.setText("");
					textFieldInterestRate.setEnabled(false); 
					textFieldInterestRate.setText(""); 
					textFieldMonthlyFee.setEnabled(true); 
					lblInterestRate.setEnabled(false); 
					lblMinimumBalance.setEnabled(false); 
					lblMonthlyFee.setEnabled(true); 
					lblErrorInterestRate.setText(""); 
					lblErrorMinimumBalance.setText(""); 
				}
			}
		});

		/*
		 * Anonymous Class adds either a Saving or Chequing account to the @accounts
		 * ArrayList. Displays a confirmation message when account is successfully
		 * added.
		 */
		btnAddAccount.addActionListener(e -> {
				if (addAccountErrorChecking()) { // if add account error checking is successful, continue
					Client accHolder = new Client(textFieldFirstName.getText(), textFieldLastName.getText(),
							textFieldPhoneNumber.getText(), textFieldEmailAddress.getText()); // pass user input into
																								// Client
					if (rdbtnSavingsAccount.isSelected()) { // if savings account radio button is selected, do the
															// following
						SavingsAccount savAcc = new SavingsAccount(Long.parseLong(textFieldAccountNumber.getText()),
								Double.parseDouble(textFieldOpeningBalance.getText()),
								Double.parseDouble(textFieldInterestRate.getText()),
								Double.parseDouble(textFieldMinimumBalance.getText()), accHolder);// parse specific to
																									// saving account
																									// text fields to
																									// take
																									// appropriate
																									// values.
						bank.getAccounts().add(savAcc); // add the Savings account to Bank.
					} else { // else Savings account radio button isn't selected, must be Chequing account
								// radio button, do the following
						ChequingAccount cheqAcc = new ChequingAccount(Long.parseLong(textFieldAccountNumber.getText()),
								Double.parseDouble(textFieldOpeningBalance.getText()),
								Double.parseDouble(textFieldMonthlyFee.getText()), accHolder);// parse specific to
																								// Chequing account text
																								// fields to take
																								// appropriate values.

						bank.getAccounts().add(cheqAcc); // add the Chequing account to Bank.
					}
					JOptionPane.showMessageDialog(rootPane, "ACCOUNT SUCCESSFULLY ADDED", "CONFIRMATION",
							JOptionPane.INFORMATION_MESSAGE); // confirmation pop-up window.
				}
		});

		/*
		 * Anonymous Class changes the Transaction Button to display "DEPOSIT" whenever
		 * the Deposit Text Field is clicked into.
		 * 
		 */
		textFieldDepositAmount.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				btnTransaction.setText("DEPOSIT");
				textFieldWithdrawAmount.setText("");
			}
		});

		/*
		 * Anonymous Class changes the Transaction Button to display "WITHDRAW" whenever
		 * the Withdraw Text Field is clicked into.
		 */
		textFieldWithdrawAmount.addFocusListener(new FocusAdapter() {
			
			public void focusGained(FocusEvent e) {
				btnTransaction.setText("WITHDRAW");
				textFieldDepositAmount.setText("");
			}
		});

		/*
		 * Anonymous Class performs either a Deposit or a Withdraw transaction on a
		 * specified account. Completes error checking to ensure specified account is
		 * valid and transaction value is valid, displays error message in GUI if
		 * invalid account or transaction value. Pop-up window displays confirmation if
		 * transaction successfully completed.
		 */
		btnTransaction.addActionListener(e->{
				lblErrorTransactionAccountNumber.setText(""); 
				lblErrorDepositAmount.setText(""); 
				lblErrorWithdrawAmount.setText(""); 
				if (btnTransaction.getText().equals("DEPOSIT")) { // if transaction button says "DEPOSIT", do the
																	// following
					lblErrorTransactionAccountNumber.setText("");
					if (!textFieldDepositAmount.getText().equals("")) { // if deposit amount text field isn't empty, do
																		// the following
						char tempDepositChar = textFieldDepositAmount.getText()
								.charAt(textFieldDepositAmount.getText().length() - 1); // setting to equal
																						// tempDepositChar
																						// for efficiency in code
																						// repetition
						if ((tempDepositChar == 'd') || (tempDepositChar == 'D') || (tempDepositChar == 'f')
								|| (tempDepositChar == 'F')) { // if any of the following characters are at the end of
																// the deposit amount, do the following.
							lblErrorDepositAmount.setText("INVALID AMOUNT"); // error message
							return;
						}
					}
					String message = "";
					try { 
						long accountNum = textFieldTransactionAccountNumber.getText().equals("") ? 0
								: Long.parseLong(textFieldTransactionAccountNumber.getText()); // ternary operator: if
																								// account text field is
																								// blank return 0, else
																								// parse text field as a
																								// long value.
						int index = bank.findAccount(accountNum); // setting method call equal to variable index
						if (index >= 0) { // if account exists, do the following
							try { 
								double deposit = Double.parseDouble(textFieldDepositAmount.getText()); // parse text
																										// field as a
																										// double.

								if (deposit < 0) { // if deposit amount is negative value, do the following
									lblErrorDepositAmount.setText("INVALID, AMOUNT MUST BE POSITIVE"); // error message
								} else { // else deposit amount is fully validated, do the following
									if (!textFieldDepositAmount.getText().equals("")) { // if deposit amount text field
																						// isn't empty, do the following
										message = bank.getAccounts().get(index).deposit(deposit); // set method call to
																									// variable
																									// "message"
										JOptionPane.showMessageDialog(rootPane, message, "CONFIRMATION",
												JOptionPane.INFORMATION_MESSAGE); // confirmation pop-up window
										textFieldDepositAmount.setText(""); 
									}
								}
							} catch (NumberFormatException ex) { // catch any invalid numbers related to deposit amount text field, do the following
								lblErrorDepositAmount.setText("INVALID AMOUNT"); // error message
							}
						} else { // else account doesn't exist, do the following
							lblErrorTransactionAccountNumber.setText("ACCOUNT DOESN'T EXIST"); // error message
						}
					} catch (NumberFormatException ex) { // catch any invalid numbers related to account number text field, do the following 
						lblErrorTransactionAccountNumber.setText("INVALID ACCOUNT"); // error message
					}

				} else if (btnTransaction.getText().equals("WITHDRAW")) { // if transaction button says "WITHDRAW", do
																			// the following
					lblErrorTransactionAccountNumber.setText(""); 
					if (!textFieldWithdrawAmount.getText().equals("")) { // if withdraw amount text field isn't empty,
																			// do the following
						char tempWithdrawChar = textFieldWithdrawAmount.getText()
								.charAt(textFieldWithdrawAmount.getText().length() - 1); // setting to equal
																							// tempWithdrawChar for
																							// efficiency in code
																							// repetition
						if ((tempWithdrawChar == 'd') || (tempWithdrawChar == 'D') || (tempWithdrawChar == 'f')
								|| (tempWithdrawChar == 'F')) { // if any of the following characters are at the end of
																// the deposit amount, do the following error code.
							lblErrorWithdrawAmount.setText("INVALID AMOUNT"); // error message
							return;
						}
					}
					String message = "";
					try { 
						long accountNum = textFieldTransactionAccountNumber.getText().equals("") ? 0
								: Long.parseLong(textFieldTransactionAccountNumber.getText()); // ternary operator: if
																								// transaction account
																								// number text field is
																								// blank return 0, else
																								// parse text field as a
																								// long value.
						int index = bank.findAccount(accountNum); // setting method call equal to variable index
						if (index >= 0) { // if account exists, do the following
							lblErrorTransactionAccountNumber.setText(""); 
							try { 
								double withdraw = Double.parseDouble(textFieldWithdrawAmount.getText()); // parse text
																											// field as
																											// a double.
								if (withdraw < 0) { // if withdraw amount is a negative value, do the following
									lblErrorWithdrawAmount.setText("INVALID, AMOUNT MUST BE POSITIVE"); // error message
								} else if (withdraw > bank.getAccounts().get(index).balance) { // if withdraw amount is
																								// greater than the
																								// account balance, do
																								// the following.
									lblErrorWithdrawAmount.setText("INSUFFICIENT FUNDS"); // error message
								} else { // else the withdraw amount is fully validated, do the following
									if (!textFieldWithdrawAmount.getText().equals("")) { // if withdraw amount text
																							// field isn't empty, do the
																							// following
										message = bank.getAccounts().get(index).withdraw(withdraw); // set method call
																									// to variable
																									// "message"
										JOptionPane.showMessageDialog(rootPane, message, "CONFIRMATION",
												JOptionPane.INFORMATION_MESSAGE); // confirmation pop-up window

										textFieldWithdrawAmount.setText(""); 
									}
								}
							} catch (NumberFormatException ex) { // catches any invalid numbers related to withdraw amount text field, do the following
								lblErrorWithdrawAmount.setText("INVALID AMOUNT"); // error message
							}
						} else { // if account doesn't exist, do the following
							lblErrorTransactionAccountNumber.setText("ACCOUNT DOESN'T EXIST"); // error message
						}
					} catch (NumberFormatException ex) { // catches any invalid numbers related to account number text field, do the following
						lblErrorTransactionAccountNumber.setText("INVALID ACCOUNT"); // error message
					}

				} else { // else the transaction button displays "TRANSACTION", do the following
					try {
						long accountNum = textFieldTransactionAccountNumber.getText().equals("") ? 0
								: Long.parseLong(textFieldTransactionAccountNumber.getText()); // ternary operator: if
																								// transaction account
																								// number text field is
																								// blank return 0, else
																								// parse text field as a
																								// long value.
						if (accountNum == 0) { // if account number text field is blank, ternary operator returned 0, do the following
							lblErrorTransactionAccountNumber.setText("ENTER ACCOUNT NUMBER"); // error message
						} else { // else account number text field inputed, but no deposit or withdraw amount inputed, do the following
							lblErrorTransactionAccountNumber.setText("ENTER DEPOSIT/WITHDRAW AMOUNT");
						}
					} catch (NumberFormatException ex) {  // catches any exception related to account number text field, do the following
						lblErrorTransactionAccountNumber.setText("ENTER PROPER ACCOUNT NUMBER"); // error message
					}

				}
		});

		/*
		 * Anonymous class loops through the @accounts ArrayLisy and displays every
		 * account to the GUI. Pop-up window displays error message if no accounts in
		 * bank to display.
		 */
		btnPrintAllAccounts.addActionListener(e ->  {
				textAreaDisplayPrintAccounts.setText(""); 

				for (BankAccount accounts : bank.getAccounts()) { // loop through all of the Bank Accounts
					textAreaDisplayPrintAccounts.append(accounts.toString() + "\n\n"); // output all found Bank Accounts
																						// into display print accounts
																						// text area
				}
				textAreaDisplayPrintAccounts.setCaretPosition(0); // sets display text area to open at the top most
																	// left corner of the text area.

				if (textAreaDisplayPrintAccounts.getText().equals("")) { // if text area for display and print accounts
																			// is empty
					JOptionPane.showMessageDialog(rootPane, "NO ACCOUNTS EXIST TO DISPLAY", "ERROR",
							JOptionPane.ERROR_MESSAGE); // error pop-up window
				}
		});

		/*
		 * Anonymous Class calls displayAccount() when "DISPLAY BUTTON" is selected, and
		 * either the requested account is displayed in GUI or an error message if
		 * account doesn't exist.
		 */
		btnDisplayAccount.addActionListener(e -> {
				try { 
					lblErrorDisplayAccountNumber.setText(""); 
					long accountNumber = Long.parseLong(textFieldDisplayAccountNumber.getText()); // parse text field as
																									// a Long value
					if (bank.displayAccount(accountNumber).equals("ERROR")) { // if displayAccount(accountNumber) method
																				// call returns an ERROR message, do the
																				// following
						lblErrorDisplayAccountNumber.setText("ACCOUNT NOT FOUND"); // error message

					} else { // else displayAccount(accountNumber) method call returns valid, do the
								// following
						textAreaDisplayPrintAccounts.setText(bank.displayAccount(accountNumber)); // display the
																									// specific account
																									// info to display
																									// print account
																									// text area
					}
					textAreaDisplayPrintAccounts.setCaretPosition(0); // set the display print account text area to open
																		// in the top left most corner of the text area
				} catch (Exception ex) { // catches any exception related to account number text field, do the following
					JOptionPane.showMessageDialog(rootPane, "NO ACCOUNT TO DISPLAY", "ERROR",
							JOptionPane.ERROR_MESSAGE); // error pop-up window
				}
				textFieldDisplayAccountNumber.setText(""); 
		});

		/*
		 * Anonymous Class calls monthlyUpdate() when "RUN MONTHLY UPDATE" button is
		 * selected, and all @accounts are updated accordingly. Pop-up window displays a
		 * message for each account either successful or unsuccessful.
		 */
		btnRunMonthlyUpdate.addActionListener(e -> {
				String message = bank.monthlyUpdate(); // setting monthlyUpdate method call to equal variable "message"
				if (!message.equals("")) { // if there are accounts in the Bank to update, do the following
					JOptionPane.showMessageDialog(rootPane, message, "CONFIRMATION", JOptionPane.INFORMATION_MESSAGE); // pop-up
																														// information
																														// window
				} else { // else there are no accounts in the Bank to update, do the following
					JOptionPane.showMessageDialog(rootPane, "NO ACCOUNTS TO PERFORM UPDATE ON", "ERROR",
							JOptionPane.ERROR_MESSAGE); // error pop-up message
				}
		});

		/*
		 * Anonymous Class calls readRecords() when "READ RECORDS" button is selected,
		 * and records are read from an input file and added to the Bank.
		 */
		btnReadRecords.addActionListener(e -> bank.readRecords(rootPane));

		/*
		 * Anonymous Class calls printAccountDetails() when "WRITE RECORDS" button is
		 * selected, all @accounts in Bank are written to [bankDataOutput.txt] file.
		 */
		btnWriteRecords.addActionListener(e -> {
				if (bank.getAccounts() != null && bank.getAccounts().size() > 0) { // if there are accounts in the Bank,
																					// do the following
					bank.printAccountDetails(); // calls Bank Class printAccountDetails method
				} else { // else there are no accounts in the Bank, do the following
					JOptionPane.showMessageDialog(rootPane, "NO ACCOUNTS EXIST TO WRITE", "ERROR",
							JOptionPane.ERROR_MESSAGE); // error pop-up window
				}
		});

		/*
		 * Anonymous Class closes the GUI when the "QUIT" tab is selected.
		 */
		panelQuit.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				dispose(); // Call the dispose method from the parent class of this frame.
			}
		});
	}

	/**
	 * Method to complete error checking on all input text fields for Add Account
	 * panel.
	 * 
	 * @return true when all user input for creating an account of
	 *         either Chequing or Savings is valid.
	 */
	private boolean addAccountErrorChecking() {
		long tempAccountNumber = 0;
		boolean valid = true; // return variable, true confirms valid fields, false confirms invalid fields

		if (textFieldAccountNumber.getText().equals("")) { // if account number text field is empty, do the following
			lblErrorAccountNumber.setText("EMPTY FIELD"); // error message
			valid = false;
		} else { // else account number text field has input, do the following
			try { 
				tempAccountNumber = Long.parseLong(textFieldAccountNumber.getText()); // parse text field as a Long
																						// value
				if (tempAccountNumber <= 0 || tempAccountNumber > 999999999) { // if temp account number is zero or
																				// less, or greater than 9 digits, do
																				// the following
					lblErrorAccountNumber.setText("INVALID, MUST BE 1-8 NUMBERS IN LENGTH"); // error message
					valid = false; 
				}
				lblErrorAccountNumber.setText(""); 
			} catch (Exception e) { // catches any exceptions related to account number text field, do the following
				lblErrorAccountNumber.setText("INVALID, MUST BE IN NUMBER FORM"); // error message
				valid = false; 
			}
		}

		long doesAccountNumberExist = 0;
		doesAccountNumberExist = bank.findAccount(tempAccountNumber); // set Bank Class findAccount(tempAccountNumber)
																		// method call to equal variable
																		// "doesAccountNumberExist"
		if (doesAccountNumberExist >= 0) { // if account number already exists, do the following
			lblErrorAccountNumber.setText("INVALID, ACCOUNT ALREADY EXISTS"); // error message
			valid = false; 
		}

		String firstName = textFieldFirstName.getText(); // set first name text field input equal to variable
															// "firstName"
		if (textFieldFirstName.getText().equals("")) { // if first name text field is empty, do the following
			lblErrorFirstName.setText("EMPTY FIELD"); // error message
			valid = false; 
		} else { // else first name text field has input, do the following
			lblErrorFirstName.setText(""); 
			if (!firstName.matches("[a-zA-Z]+")) { // if first name user input doesn't match, do the following
				lblErrorFirstName.setText("INVALID, MUST BE CHARACTERS"); // error message
				valid = false; 
			}
		}

		String lastName = textFieldLastName.getText(); // set last name text field input equal to variable "lastName"
		if (textFieldLastName.getText().equals("")) { // if the last name text field is empty, do the following
			lblErrorLastName.setText("EMPTY FIELD"); // error message
			valid = false; 
		} else { // else last name text field isn't empty, do the following
			lblErrorLastName.setText(""); 
			if (!lastName.matches("[a-zA-Z]+")) { // if last name doesn't match only upper or lower case characters, do
													// the following
				lblErrorLastName.setText("INVALID, MUST BE CHARACTERS"); // error message
				valid = false; 
			}
		}

		String phoneNumber = textFieldPhoneNumber.getText(); // set text field phone number input equal to variable
																// "phoneNumber"
		if (textFieldPhoneNumber.getText().equals("")) { // if phone number text field is empty, do the following
			lblErrorPhoneNumber.setText("EMPTY FIELD"); // error message
			valid = false; 
		} else { // else phone number text field has input, do the following
			lblErrorPhoneNumber.setText(""); 
			if ((!phoneNumber.matches("[0-9]{10,11}") || phoneNumber.contains(" "))) { // if phone number doesn't match
																						// digits 0-9, and 10 or 11 in
																						// total, do the following
				lblErrorPhoneNumber.setText("INVALID, MUST BE 10-11 NUMBERS IN LENGTH"); // error message
				valid = false; 
			}
		}

		String emailAddress = textFieldEmailAddress.getText(); // set email address text field to equal variable
																// "emailAddress"
		if (textFieldEmailAddress.getText().equals("")) { // if email address text field is empty, do the following
			lblErrorEmailAddress.setText("EMPTY FIELD"); // error message
			valid = false; 
		} else { // else email address text field has input, do the following
			lblErrorEmailAddress.setText(""); 
			if (!emailAddress.matches("^[a-zA-Z.0-9]{2,}+\\@[a-zA-Z0-9]{2,}+\\.[a-z]{2,3}$")) { // if email address
																								// doesn't match the
																								// regex pattern
				lblErrorEmailAddress.setText("INVALID, MUST BE AT A MINIMUM [cc@cc.cc]"); // error message
				valid = false; 
			}
		}

		double openingBalance = 0.0;
		if (textFieldOpeningBalance.getText().equals("")) { // if opening balance text field is empty, do the following
			lblErrorOpeningBalance.setText("EMPTY FIELD"); // error message
			valid = false; // not valid
		} else { // if opening balance text field has input, do the following
			try { 
				openingBalance = Double.parseDouble(textFieldOpeningBalance.getText()); // parse text field as a Double
																						// value
				lblErrorOpeningBalance.setText("");
				if (openingBalance < 0) { // if opening balance input is less than zero, do the following
					lblErrorOpeningBalance.setText("INVALID, MUST BE A POSITIVE NUMBER"); // error message
					valid = false; 
				}
				for (char i : textFieldOpeningBalance.getText().toCharArray()) { // enhanced for each loop which places
																					// all of opening balance text field
																					// input into a character array
					if (i == 'd' || i == 'f' || i == 'D' || i == 'F') { // if any of the following characters are at the
																		// end of
																		// the opening balance input, do the following
																		// error code.
						lblErrorOpeningBalance.setText("INVALID AMOUNT"); // error message
						valid = false; 
						break; 
					}
				}
			} catch (Exception e) { // catches any exception related to opening balance text field, do the following
				lblErrorOpeningBalance.setText("INVALID, MUST BE IN NUMBER FORM"); // error message
				valid = false; 
			}
		}

		if (rdbtnSavingsAccount.isSelected()) { // if the Savings account radio button is selected, do the following
			if (textFieldMinimumBalance.getText().equals("")) { // if the minimum balance text field is empty, do the
																// following
				lblErrorMinimumBalance.setText("EMPTY FIELD"); // error message
				valid = false; // not valid
			} else { // if the minimum balance text field has input, do the following
				try { 
					double minimumBalance = Double.parseDouble(textFieldMinimumBalance.getText()); // parse text field
																									// as a Double
																									// value
					lblErrorMinimumBalance.setText(""); 
					if (minimumBalance < 0) { // if the minimum balance input is less than zero, do the following
						lblErrorMinimumBalance.setText("INVALID, MUST BE A POSITIVE NUMBER"); // error message
						valid = false;
					}
					if (minimumBalance > openingBalance) { // if minimum balance input is larger than the opening
															// balance, do the following
						lblErrorMinimumBalance.setText("INVALID, MUST BE LESS THAN OPENING BALANCE"); // error message
						valid = false; 
					}
					for (char i : textFieldMinimumBalance.getText().toCharArray()) { // enhanced for each loop which
																						// places
																						// all of opening balance text
																						// field
																						// input into a character array
						if (i == 'd' || i == 'f' || i == 'D' || i == 'F') { // if any of the following characters are at
																			// the end of
																			// the opening balance input, do the
																			// following error code.
							lblErrorMinimumBalance.setText("INVALID AMOUNT"); // error message
							valid = false; 
							break; 
						}
					}
				} catch (Exception e) { // catches any exception related to minimum balance text field, do the following
					lblErrorMinimumBalance.setText("INVALID, MUST BE IN NUMBER FORM"); // error message
					valid = false; 
				}
			}

			if (textFieldInterestRate.getText().equals("")) { // if interest rate text field is empty, do the following
				lblErrorInterestRate.setText("EMPTY FIELD"); // error message
				valid = false; // not valid
			} else { // else the interest rate text field has input, do the following
				try {
					double interestRate = Double.parseDouble(textFieldInterestRate.getText()); // parse text field as a
																								// Double
																								// value
					lblErrorInterestRate.setText(""); 
					if (interestRate < 0 || interestRate > 1) { // if the interest rate input is less than zero or greater than one, do the following
						lblErrorInterestRate.setText("INVALID, MUST BE BETWEEN [0.00-1.00]"); // error message
						valid = false; 
					}
					for (char i : textFieldInterestRate.getText().toCharArray()) { // enhanced for each loop which
																					// places
																					// all of opening balance text field
																					// input into a character array
						if (i == 'd' || i == 'f' || i == 'D' || i == 'F') { // if any of the following characters are at
																			// the end of
																			// the opening balance input, do the
																			// following error code.
							lblErrorInterestRate.setText("INVALID AMOUNT "); // error message
							valid = false; 
							break; 
						}
					}
				} catch (Exception e) { // catches any exception related to interest rate text field, do the following
					lblErrorInterestRate.setText("INVALID, MUST BE A POSITIVE NUMBER"); // error message
					valid = false; 
				}
			}
			
		} else { // else the Savings account radio button isn't selected(must be Chequing account), do the following
			if (textFieldMonthlyFee.getText().equals("")) { // if monthly fee text field is empty, do the following
				lblErrorMonthlyFee.setText("EMPTY FIELD "); // error message
				valid = false; 
			} else { // else the monthly fee text field has input, do the following
				try { 
					double monthlyFee = Double.parseDouble(textFieldMonthlyFee.getText()); // parse text field as a
																							// Double value
					lblErrorMonthlyFee.setText(""); 
					if (monthlyFee < 0) { // if monthly fee input is less than zero, do the following
						lblErrorMonthlyFee.setText("INVALID, MUST BE A POSITIVE NUMBER "); // error message
						valid = false; 
					}
					for (char i : textFieldMonthlyFee.getText().toCharArray()) { // enhanced for each loop which places
																					// all of opening balance text field
																					// input into a character array
						if (i == 'd' || i == 'f' || i == 'D' || i == 'F') { // if any of the following characters are at
																			// the end of
																			// the opening balance input, do the
																			// following error code.
							lblErrorMonthlyFee.setText("INVALID AMOUNT "); // error message
							valid = false; 
							break; 
						}
					}
 				} catch (Exception e) { // catches any exception related to monhtly fee text field, do the following
					lblErrorMonthlyFee.setText("INVALID, MUST BE IN NUMBER FORM "); // error message
					valid = false; 
				}
			}
		}
		
		if (valid) { // if all user input is valid, do the following
			lblErrorFirstName.setText(""); 
			lblErrorLastName.setText(""); 
			lblErrorPhoneNumber.setText("");
			lblErrorEmailAddress.setText(""); 
			lblErrorOpeningBalance.setText(""); 
			lblErrorMinimumBalance.setText(""); 
			lblErrorInterestRate.setText(""); 
			lblErrorMonthlyFee.setText(""); 
		}
		return valid; // return all user input error checking as valid 
	}
}
