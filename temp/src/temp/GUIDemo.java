package temp;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GUIDemo extends JFrame {

	private JButton actionButton;
	private JLabel infoLabel;
	private JTextField textField;
	private JTextArea textArea; 
	private JRadioButton migrateYesButton;
	private JRadioButton migrateNoButton;
	private FlowLayout layout = new FlowLayout();

	// constructor
	/*public GUIDemo() {

	}*/
	public void addComponentsToPane(Container pane) {

		// *** PANEL 1 *** -------------------------------- \\
		JPanel panel1 = new JPanel();
		// add a layout
		panel1.setLayout( layout ); // flow layout
		layout.setAlignment(FlowLayout.CENTER); // Center it 
		panel1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);


		// add three elements to the frame
		// text field
		textField = new JTextField(10);
		panel1.add(textField);

		// create an INNER class for the button action ----------------------
		class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("click")) { // action command matches ("click")
					infoLabel.setText("Button clicked");
				}
			}
		} // END inner class ButtonListener ---------------------------------


		// button
		actionButton = new JButton("Action");
		actionButton.setActionCommand("click");
		actionButton.addActionListener(new ButtonListener());
		panel1.add(actionButton);

		// label
		infoLabel = new JLabel("nothing has happened"); // this label changes to "Button clicked" in 'actionPerformed'
		panel1.add(infoLabel);


		// *** PANEL 2 *** -------------------------------- \\
		// add a second section to the form with a large text area
		JPanel panel2 = new JPanel();
		panel2.setLayout( layout );
		textArea = new JTextArea(5, 80);
		textArea.setBackground(Color.DARK_GRAY); // set the background color of text area
		textArea.setForeground(Color.CYAN); // set the color of the text
		textArea.setFont(textArea.getFont().deriveFont(14f)); // font size = 14 
		textArea.setText("You can type in this TextArea!");
		panel2.add(textArea);

		// *** PANEL 3 *** -------------------------------- \\
		// add a third section with checkboxes
		JPanel panel3 = new JPanel();
		panel3.setLayout( new GridLayout(3, 1) ); // using a GridLayout here

		panel3.add(new Checkbox("one", null, true)); 
		panel3.add(new Checkbox("two"));
		panel3.add(new Checkbox("three"));


		// *** PANEL 4 *** -------------------------------- \\
		// radio buttons
		JPanel panel4 = new JPanel();
		migrateYesButton = new JRadioButton("Yes");
		migrateNoButton = new JRadioButton("No");
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(migrateYesButton);
		buttonGroup.add(migrateNoButton);
		panel4.add(new JLabel("Are you suggesting coconuts migrate?"));
		panel4.add(migrateYesButton);
		panel4.add(migrateNoButton);

		pane.add(panel1, BorderLayout.NORTH); // Placing all panels created on the pane (North = top)
		pane.add(panel2, BorderLayout.SOUTH); // South = bottom
		pane.add(panel3, BorderLayout.EAST);  // East = right
		pane.add(panel4, BorderLayout.WEST);  // West = left 
	}
	private static void createAndShowGUI() {
		//Create and set up the window.

		GUIDemo frame = new GUIDemo();
		frame.setTitle("Demo of adding graphical components");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Set up the content pane.
		frame.addComponentsToPane(frame.getContentPane());
		//Display the window.
		frame.pack();
		frame.setVisible(true); // Important!! 
	}

	public static void main(String[] args) {
	    // Example of an anonymous class - "injected" directly in the location it is needed 
		javax.swing.SwingUtilities.invokeLater(new Runnable() { // used in conjunction with threads
			public void run() {     // a thread created by a GUI element looks for the 'run' method 
				createAndShowGUI();
			}
		});

	}


}
