import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GUILLOfFortune extends JFrame {
	JLabel instructions;
	JButton submit;
	JTextArea enterArea;
	
	JLabel livesRemaining;
	JLabel lettersEntered;
	JLabel wordOutput;
	
	
	boolean[] lettersCorrect = {false, false, false, false, false};
	int lives;
	String password;
	ArrayList<String> letters;
	
	static String[] dash = {"_"," ","_"," ","_"," ","_"," ","_"};
	
	public static void main(String[] args) {
		new GUILLOfFortune();
	}
	
	public GUILLOfFortune()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		this.setSize(width, height);
		
		password = "parth";
		lives = 5;
		letters = new ArrayList<String>();
		
		instructions = new JLabel("<html>Enter a letter to see if it's in the word!</html>" );
		submit = new JButton("ENTER");
		enterArea = new JTextArea();
		livesRemaining = new JLabel("Lives: " + lives);
		lettersEntered = new JLabel("<html>Letters Entered: " + letters + "</html>");
		wordOutput = new JLabel("_ _ _ _ _");
		wordOutput.setFont(new Font("Times", Font.BOLD, 20));
		
		instructions.setSize(23*width/60, height/6);
		submit.setSize(width/3, 50);
		enterArea.setSize(width/3, 50);
		livesRemaining.setSize(width/4, height/12);
		lettersEntered.setSize(width/3, height/3);
		wordOutput.setSize(width/2, height/6);
		
		instructions.setLocation(width/15, 1);
		submit.setLocation(width/2, height/2);
		enterArea.setLocation(width/6, height/2);
		livesRemaining.setLocation(11*width/15, 1);
		lettersEntered.setLocation(17*width/30, height/20);
		wordOutput.setLocation(width/3, height/3);
		
		submit.setActionCommand("submit");
		submit.addActionListener(new passwordButtonListener());
		
		this.add(instructions);
		this.add(submit);
		this.add(enterArea);
		this.add(livesRemaining);
		this.add(lettersEntered);
		this.add(wordOutput);
		
		this.add(new JLabel());
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class passwordButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String l = enterArea.getText();
			int index = -1;
			int count = 0;
			boolean won = false;
			String output = "";
            if(arg0.getActionCommand().equals("submit")){
            	if(l.length() == 1) {
            		if(!letters.contains(l)){//if the user has not guessed this letter yet
            			letters.add(l);
            			if(password.contains(l)) {//correct
            				System.out.println("correct");
            				index = password.indexOf(l);
            				
            				lettersCorrect[index] = true;//win mechanic
            				for(int k = 0; k < 5; k++) {
            					System.out.println(lettersCorrect[k]);
            					if(lettersCorrect[k] == false) {
            						won = false;
            						count++;
            					}
            					if(count == 0) {
            						won = true;
            					}
            				}
            				
            				dash[index*2] = l;
            				for(int j = 0; j < 9; j++) {
            					output += dash[j];
            				}
            				instructions.setText("That is one of the letters of the password!");
            				lettersEntered.setText("<html>Letters Entered: " + letters + "</html>");
            				wordOutput.setText(output);
            			}
            			else {//incorrect
            				System.out.println("incorrect");
            				lives--;
            				livesRemaining.setText("Lives: " + lives);
            				instructions.setText("That is not one of the letters of the password!");
            				lettersEntered.setText("<html>Letters Entered: " + letters + "</html>");
            				if(lives == 0) {
            					instructions.setText("You ran out of lives!");
            					submit.setActionCommand("lost");
            				}
            			}
            		}
            		else {//guessed the same letter already
            			instructions.setText("You have already guessed this letter");
            		}
            	}
            else {
            	instructions.setText("Enter only one letter");	
            	}
            if(won == true) {
            	instructions.setText("You won!");
            	submit.setActionCommand("done");
            }
            }
		}
	}
}

