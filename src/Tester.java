import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * @author Caleb Kinmon (UNI: cgk2128)
 * <br><br>
 * This class tests the creation of unicycles and a group of unicycles. This
 * class also tests the SpeedController class (which contains the JSlider). It
 * also serves as a way to test the movement of the unicycles.  
 * <br><br>
 */
public class Tester {
	
	/**
	 * This constructor creates a unicycle group that can contain any
	 * number of unicycle objects and calls the helper methods to create
	 * a JFrame.
	 */
	Tester(){
		unicycleGroup = new CyclistGroup();
		this.constructFrame();
		this.customizeFrame();
	}
	
	/**
	 * This helper method constructs the objects that are used to
	 * display the screen.
	 */
	private void constructFrame(){
		myFrame = new JFrame();
		slider = new SpeedController();
		panel = new JPanel();
		myIcon = new MyIcon(unicycleGroup, ICON_W, ICON_H);
		myLabel = new JLabel(myIcon);
		panel.add(slider.returnJSliderObject());
	}
	
	/**
	 * This private helper method customizes the frame that contains
	 * the display to be tested.
	 */
	private void customizeFrame(){
		myFrame.add(myLabel);
		myFrame.add(panel);
		myFrame.setLayout(new CardLayout());
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.pack();
		myFrame.setVisible(true);
	}
	
	/**
	 * This method tests the creation of a unicycle and a unicycle group.
	 * @param xPosition of type integer which represents the x position of the
	 * unicycle.
	 * @param yPosition of type integer which represents the y position of the
	 * unicycle.
	 * @param size of type integer which represents the size of the unicycle.
	 */
	public void createUnicycle(int xPosition, int yPosition, int size){
		unicycle = new Unicyclist(xPosition, yPosition, size);
		unicycleGroup.add(unicycle);
	}
	
	/**
	 * This method was taken directly from John Kender's program on Courseworks. This
	 * method tests the movement of the unicycles through a timer.
	 */
	public void initiateMovement(){
		final int DELAY = 50;
		// Milliseconds between timer ticks
		Timer myTimer = new Timer(DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int xSpeed = slider.getSpeed();
				int ySpeed = 0;
				unicycleGroup.simulateBumps(xSpeed);
				unicycleGroup.translate(xSpeed, ySpeed);
				myLabel.repaint();
			}
		});
		
		myTimer.start();
	}
	
	private JFrame myFrame;	
	private SpeedController slider;
	private ObjectMover unicycle;
	private CyclistGroup unicycleGroup;
	
	private MyIcon myIcon;	
	private JPanel panel;
	private static final int ICON_W = 1000;
	private static final int ICON_H = 350;
	private JLabel myLabel;
	
}
