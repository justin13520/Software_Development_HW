import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class temp extends JFrame{

	JPanel panel;
	JLabel caption;
	JLabel image;
	JLabel filename;
	
	JButton next;
	JButton previous;
	
	FlowLayout layout;
	BoxLayout layout1;
	
	ButtonGroup group;
	
	JRadioButton one;
	JRadioButton two;
	JRadioButton three;
	JRadioButton four;
	JRadioButton five;
	
	static String imageDirectory = "images\\";
	
	private PhotoContainer imageLibrary;
	
	static int count = 0;
	
	public static void main(String[] args) {
		temp myViewer = new temp();
		PhotoContainer p = new Library("images",1);
		
		Photo a = new Photo(imageDirectory+"IMG_1212.JPG","That's a stingray","2019-11-17",4);
		Photo b = new Photo(imageDirectory+"IMG_1220.JPG", "Turtle", "2019-11-17", 3);
		Photo c = new Photo(imageDirectory+"IMG_1228.JPG", "Coral", "2019-11-17", 5);
		Photo d = new Photo(imageDirectory+"IMG_1242.JPG", "Lighting of the Lawn", "2019-12-05", 2);
		Photo e = new Photo(imageDirectory+"IMG_1341.JPG", "Bermuda", "2020-02-14", 1);

		a.loadImageData(imageDirectory+"IMG_1212.JPG");
		b.loadImageData(imageDirectory+"IMG_1220.JPG");
		c.loadImageData(imageDirectory+"IMG_1228.JPG");
		d.loadImageData(imageDirectory+"IMG_1242.JPG");
		e.loadImageData(imageDirectory+"IMG_1341.JPG");
		
		p.addPhoto(a);
		p.addPhoto(b);
		p.addPhoto(c);
		p.addPhoto(d);
		p.addPhoto(e);
		
		myViewer.setImageLibrary(new Library("Test Library", 1));
		
		myViewer.getImageLibrary().addPhoto(a);
		myViewer.getImageLibrary().addPhoto(b);
		myViewer.getImageLibrary().addPhoto(c);
		myViewer.getImageLibrary().addPhoto(d);
		myViewer.getImageLibrary().addPhoto(e);
		
		Collections.sort(myViewer.getImageLibrary().getPhotos());
		
		javax.swing.SwingUtilities.invokeLater(()->createAndShowGUI(myViewer));
	}
	
	public temp() {
		panel = new JPanel();
		caption = new JLabel();
		filename = new JLabel();
		previous = new JButton("Previous");
		next = new JButton("Next");
		layout = new FlowLayout(FlowLayout.CENTER);
		group = new ButtonGroup();
		one = new JRadioButton("1");
		two = new JRadioButton("2");
		three = new JRadioButton("3");
		four = new JRadioButton("4");
		five = new JRadioButton("5");
		imageLibrary = new Library("images", 1);
	}
	
	public PhotoContainer getImageLibrary() {
		return this.imageLibrary;
	}
	
	public void setImageLibrary(Library l) {
		this.imageLibrary = l;
	}
	
	public static void createAndShowGUI(temp p) {
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.addComponentsToPane(p.getContentPane());
		p.setTitle("PhotoViewer");
		p.pack();
		//p.setSize(600,900);
		p.setVisible(true);
	}
	
	public void addComponentsToPane(Container pane) {
		int x = this.getX();
		int y = this.getY();
		
		class ButtonListener implements ActionListener{//allows the button to actually work
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(imageLibrary.getPhotos().get(count).getFilename());
				if(e.getActionCommand().equals("Next")) {
					count++;
					if(count == 5) {
						count = 0;
					}
					BufferedImage img;
					try {
						img = ImageIO.read(new File(imageLibrary.getPhotos().get(count).getFilename()));
					} catch (IOException a) {
						img = null;
					}
					image.setIcon(new ImageIcon(img));
					String num = Integer.toString(imageLibrary.getPhotos().get(count).getRating());
					if(num == "1") {
						one.setSelected(true);
					}
					if(num == "2") {
						two.setSelected(true);
					}
					if(num == "3") {
						three.setSelected(true);
					}
					if(num == "4") {
						four.setSelected(true);
					}
					if(num == "5") {
						five.setSelected(true);
					}
					if(count == 4) {
						System.out.println(4);
					}
				}
				BufferedImage img1;
				try {
					img1 = ImageIO.read(new File(imageLibrary.getPhotos().get(count).getFilename()));
				}
				catch (IOException a) {
					img1 = null;
				}
				image.setIcon(new ImageIcon(img1));
				if(e.getActionCommand().equals("Previous")) {
					count--;
					if(count == -1) {
						count = 4;
					}
			}
				String num = Integer.toString(imageLibrary.getPhotos().get(count).getRating());
				if(num.equals("4")) {
					four.setSelected(true);
				}
				if(num.equals("2")) {
					two.setSelected(true);
				}
				if(num.equals("3")) {
					three.setSelected(true);
				}
				if(num.equals("1")) {
					one.setSelected(true);
				}
				if(num.equals("5")) {
					five.setSelected(true);
				}
				caption.setText(imageLibrary.getPhotos().get(count).getCaption());	
				filename.setText(imageLibrary.getPhotos().get(count).getFilename());
		}
	}
		class JRadioButtonListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getActionCommand().equals("Click1")) {
					one.setSelected(true);
					imageLibrary.getPhotos().get(count).setRating(1);
				}
				if(e.getActionCommand().equals("Click2")) {
					two.setSelected(true);
					imageLibrary.getPhotos().get(count).setRating(2);
				}
				if(e.getActionCommand().equals("Click3")) {
					three.setSelected(true);
					imageLibrary.getPhotos().get(count).setRating(3);
				}
				if(e.getActionCommand().equals("Click4")) {
					four.setSelected(true);
					imageLibrary.getPhotos().get(count).setRating(4);
				}
				if(e.getActionCommand().equals("Click5")) {
					five.setSelected(true);
					imageLibrary.getPhotos().get(count).setRating(5);
				}
			}
		}
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		BufferedImage img;
		try {
			img = ImageIO.read(new File("images\\IMG_1228.JPG"));
		} catch (IOException e) {
			img = null;
		}
		image = new JLabel(new ImageIcon(img));
		image.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(image);
		
		caption = new JLabel(this.imageLibrary.getPhotos().get(0).getCaption(), SwingConstants.CENTER);
		//caption.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(caption);
		
		previous.setHorizontalAlignment(SwingConstants.CENTER);
		next.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		panel.add(previous);
		panel.add(next);
		
		filename = new JLabel(this.imageLibrary.getPhotos().get(0).getFilename());
		filename.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(filename);
		
		
		five = new JRadioButton("5",true);
		panel.add(one);
		panel.add(two);
		panel.add(three);
		panel.add(four);
		panel.add(five);
		
		group.add(one);
		group.add(two);
		group.add(three);
		group.add(four);
		group.add(five);
		
		one.setActionCommand("Click1");
		two.setActionCommand("Click2");
		three.setActionCommand("Click3");
		four.setActionCommand("Click4");
		five.setActionCommand("Click5");
		
		one.addActionListener(new JRadioButtonListener());
		two.addActionListener(new JRadioButtonListener());
		three.addActionListener(new JRadioButtonListener());
		four.addActionListener(new JRadioButtonListener());
		five.addActionListener(new JRadioButtonListener());
		
		next.setActionCommand("Next");//sets the next button to have an actionlistener
		next.addActionListener(new ButtonListener());
		
		previous.setActionCommand("Previous");
		previous.addActionListener(new ButtonListener());

		pane.add(panel);
	}
}
