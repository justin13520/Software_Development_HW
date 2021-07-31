package inClassDay22;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyWindow extends JFrame{
	
	JPanel panel;
	JLabel infoLabel;
	JLabel results;
	JTextField textField;
	JButton actionButton;
	FlowLayout layout;
	
	public MyWindow() {
		panel = new JPanel();
		infoLabel = new JLabel("Please type in a number of Kilometers. It will be converted to miles.");
		textField = new JTextField(20);
		actionButton = new JButton("Click for result");
		layout = new FlowLayout();
		results = new JLabel();
	}
	
	public static void main(String[] args) {
		
		WindowRunnable myRunner = new WindowRunnable();
		javax.swing.SwingUtilities.invokeLater( myRunner);
	}
	
	public static void createAndShowGUI() {
		MyWindow frame = new MyWindow();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setSize(500, 100);
		frame.setVisible(true);
	}
	
	public void addComponentsToPane(Container pane) {
		class ButtonListener implements ActionListener{//allows the button to actually work
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("click")) {
					String KToM = textField.getText();
					try {
						System.out.println(KToM);
						double j = Double.parseDouble(KToM);
						results.setVisible(true);
						results.setText("Result: " + j/1.609344 +"km");
					}
					catch (NumberFormatException n){
						results.setVisible(true);
						results.setText("Not a Valid Input");
					}
				}
			}
		}	
		panel.setLayout(layout);
		panel.add(infoLabel);
		panel.add(textField);
		actionButton = new JButton("action");
		actionButton.setActionCommand("click");
		actionButton.addActionListener(new ButtonListener());
		panel.add(actionButton);
		panel.add(results);
		results.setVisible(false);
		pane.add(panel);
	}

}
class WindowRunnable implements Runnable {
	public void run() {
		MyWindow.createAndShowGUI();
	}
}

