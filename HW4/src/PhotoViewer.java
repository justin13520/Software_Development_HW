import java.awt.BorderLayout;
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
//imports for PhotoViewer to work
public class PhotoViewer extends JFrame{//extends JFrame

	JPanel panelForPicture;//panel just for picture
	JPanel panelForButtons;//panel just for previous and next button
	JPanel panelForRatings;//panel just for JRadioButton
	JLabel caption;//caption of the photo
	JLabel image;//label for the photo
	JLabel filename;//filename of the photo
	
	JButton next;//Button that shows the next picture
	JButton previous;//Button that shows the previous picture
	
	FlowLayout layout;//Used for the horizontal of components
	BoxLayout layout1;//Used for the vertical of panelForPicture
	
	ButtonGroup group;//Used to keep only one JRadioButton selected
	
	JRadioButton one;//These are the JRadioButton
	JRadioButton two;
	JRadioButton three;
	JRadioButton four;
	JRadioButton five;
	
	static String imageDirectory = "images\\";//I have a windows
	
	private PhotoContainer imageLibrary;
	
	static int count = 0;//counter to keep track of the photos when using the buttons
	
	public static void main(String[] args) {
		PhotoViewer myViewer = new PhotoViewer();
		PhotoContainer p = new Library("images",1);
		
		Photo a = new Photo(imageDirectory+"IMG_1212.JPG","That's a stingray","2019-11-17",4);//These are the photos
		Photo b = new Photo(imageDirectory+"IMG_1220.JPG", "Turtle", "2019-11-17", 3);
		Photo c = new Photo(imageDirectory+"IMG_1228.JPG", "Coral", "2019-11-17", 5);
		Photo d = new Photo(imageDirectory+"IMG_1242.JPG", "Lighting of the Lawn", "2019-12-05", 2);
		Photo e = new Photo(imageDirectory+"IMG_1341.JPG", "Bermuda", "2020-02-14", 5);

		a.loadImageData(imageDirectory+"IMG_1212.JPG");//uploading the photos from the folder
		b.loadImageData(imageDirectory+"IMG_1220.JPG");
		c.loadImageData(imageDirectory+"IMG_1228.JPG");
		d.loadImageData(imageDirectory+"IMG_1242.JPG");
		e.loadImageData(imageDirectory+"IMG_1341.JPG");
		
		p.addPhoto(a);//adding the photo to the photocontainer object
		p.addPhoto(b);
		p.addPhoto(c);
		p.addPhoto(d);
		p.addPhoto(e);
		
		myViewer.setImageLibrary(new Library("Test Library", 1));//because photocontainer is abstract, have to 
		
		myViewer.getImageLibrary().addPhoto(a);//adds the photo to the viewer from the library
		myViewer.getImageLibrary().addPhoto(b);
		myViewer.getImageLibrary().addPhoto(c);
		myViewer.getImageLibrary().addPhoto(d);
		myViewer.getImageLibrary().addPhoto(e);
		
		Collections.sort(myViewer.getImageLibrary().getPhotos());//sorts the photos based on date, rating, and caption
		
		javax.swing.SwingUtilities.invokeLater(()->createAndShowGUI(myViewer));//runs the program
	}
	
	public PhotoViewer() {//constructor
		panelForPicture = new JPanel();
		panelForPicture.setBounds(0,0,this.getX(),this.getY()/2);
		panelForButtons = new JPanel();
		panelForRatings = new JPanel();
		caption = new JLabel();
		filename = new JLabel();
		previous = new JButton("Previous");
		next = new JButton("Next");
		layout = new FlowLayout(FlowLayout.CENTER);
		layout1 = new BoxLayout(panelForPicture, BoxLayout.Y_AXIS);
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
	
	public static void createAndShowGUI(PhotoViewer p) {//creates and shows the GUI when called
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.addComponentsToPane(p.getContentPane());
		p.setTitle("PhotoViewer");
		p.pack();
		p.setVisible(true);
	}
	
	public void addComponentsToPane(Container pane) {//adds the components to be shown on the window
		class ButtonListener implements ActionListener{//allows the button to actually work
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Next")) {//actions of the next button
					count++;//increases counter to get the next photo
					if(count == 5) {//once the counter is out of the range of the library, wraps back to the first photo
						count = 0;
					}
				}
				if(e.getActionCommand().equals("Previous")) {
					count--;
					if(count == -1) {//once the counter goes backwards out of range, wraps to the last photo
						count = 4;
					}
			}
				String num = Integer.toString(imageLibrary.getPhotos().get(count).getRating());//gets the rating
				//selects the JRadioButton corresponding to the rating
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
				
				//gets the picture from the folder
				BufferedImage img1;
				try {
					img1 = ImageIO.read(new File(imageLibrary.getPhotos().get(count).getFilename()));
				}
				catch (IOException a) {//if the photo isn't there
					img1 = null;
				}
				image.setIcon(new ImageIcon(img1));//sets the JLabel image to change to the new photo
				caption.setText(imageLibrary.getPhotos().get(count).getCaption());	//changes the caption shown
				filename.setText(imageLibrary.getPhotos().get(count).getFilename());//changes the filename shown
		}
	}
		
		class JRadioButtonListener implements ActionListener{//allows the JRadioButton to change rating if the user wants to change it
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
		
		layout1 = new BoxLayout(panelForPicture, BoxLayout.Y_AXIS);//layout for panelForPicture
		panelForPicture.setLayout(layout1);

		BufferedImage img;
		try {
			img = ImageIO.read(new File("images\\IMG_1228.JPG"));//ensures the first picture shown is always this one
		} catch (IOException e) {
			img = null;
		}
		
		image = new JLabel(new ImageIcon(img));//sets the first photo
		image.setHorizontalAlignment(SwingConstants.CENTER);
		panelForPicture.add(image);
		
		caption = new JLabel(this.imageLibrary.getPhotos().get(0).getCaption(), SwingConstants.CENTER);//sets the caption to be that of the first photo always
		//caption.setHorizontalAlignment(SwingConstants.CENTER);
		panelForPicture.add(caption);
		
		previous.setHorizontalAlignment(SwingConstants.CENTER);//sets them centered
		next.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelForButtons.setLayout(layout);//sets layout for the buttons, left to right by default by flowlayout
		
		panelForButtons.add(previous);//adds them to their panel
		panelForButtons.add(next);
		
		filename = new JLabel(this.imageLibrary.getPhotos().get(0).getFilename());//gets the filename of the first photo
		filename.setHorizontalAlignment(SwingConstants.CENTER);
		panelForPicture.add(filename);
		
		panelForRatings.setLayout(layout);//sets it so that it goes left to right
		
		five = new JRadioButton("5",true);//selects the rating of the first photo at first
		panelForRatings.add(one);
		panelForRatings.add(two);
		panelForRatings.add(three);
		panelForRatings.add(four);
		panelForRatings.add(five);
		
		group.add(one);//allows only one button to be selected
		group.add(two);
		group.add(three);
		group.add(four);
		group.add(five);
		
		one.setActionCommand("Click1");//sets the action command for each of the JRadioButton
		two.setActionCommand("Click2");
		three.setActionCommand("Click3");
		four.setActionCommand("Click4");
		five.setActionCommand("Click5");
		
		one.addActionListener(new JRadioButtonListener());//adds it so that it can be registered by the JRadioButtonListener class
		two.addActionListener(new JRadioButtonListener());
		three.addActionListener(new JRadioButtonListener());
		four.addActionListener(new JRadioButtonListener());
		five.addActionListener(new JRadioButtonListener());
		
		next.setActionCommand("Next");//sets the next button to have an actionlistener
		next.addActionListener(new ButtonListener());
		
		previous.setActionCommand("Previous");//sets the previous button to have an actionlistener
		previous.addActionListener(new ButtonListener());

		pane.add(panelForPicture,BorderLayout.NORTH);//adds it at the north border
		pane.add(panelForButtons);//adds it below the pictures
		pane.add(panelForRatings,BorderLayout.SOUTH);//adds it at the very bottom of the window
	}
}
