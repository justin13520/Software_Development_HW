import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimpleWindow extends JFrame{
	
	JPanel panel;
	JLabel helloLabel;
	JLabel infoLabel;
	JTextField textField;
	JButton actionButton;
	JTextArea textArea;
	FlowLayout layout;
	
	public SimpleWindow() {
		panel = new JPanel();
		helloLabel = new JLabel("Hello");
		infoLabel = new JLabel("Here is some important information.");
		textField = new JTextField(40);
		actionButton = new JButton("action");
		textArea = new JTextArea("Four score and 7 years ago...");
		textArea.setEditable(false);
		layout = new FlowLayout();
	}
	
	public static void main(String[] args) {
		
		WindowRunnable myRunner = new WindowRunnable();
		javax.swing.SwingUtilities.invokeLater( myRunner);
		
	}
	public static void createAndShowGUI() {
		SimpleWindow frame = new SimpleWindow();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	
	public void addComponentsToPane(Container pane) {
		
		panel.setLayout(layout);
		
		panel.add(helloLabel);
		panel.add(infoLabel);
		panel.add(textField);
		panel.add(actionButton);
		panel.add(textArea);
		pane.add(panel);
		}

}
class WindowRunnable implements Runnable {
	public void run() {
		SimpleWindow.createAndShowGUI();
	}
}
