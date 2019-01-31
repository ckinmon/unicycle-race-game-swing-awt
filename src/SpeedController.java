import javax.swing.*;
import javax.swing.event.*;

/**
 * 
 * @author Caleb Kinmon (UNI: cgk2128)
 * <br><br>
 * This class creates a JSlider that can be used to control the speed
 * of the unicycles as they move across the screen in the x direction.
 * <br><br>
 * This class implements ChangeListener so that when the slider speed is changed,
 * the moving object's speed changes along with it.
 *
 */
public class SpeedController implements ChangeListener {
	
	/**
	 * This constructor creates a JSlider object. The default
	 * bounds are 0 and 20, with tick marks located at
	 * every position between 0 and 20. I chose 0 so that the 
	 * object can completely halt, and 20 because the average top
	 * speed of unicyclists is 17 mph but I wanted a clean round number.
	 */
	SpeedController(){
		slider = new JSlider(0, 20, 1);
		slider.setPaintTrack(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(5);
		slider.setMinorTickSpacing(1);
		slider.addChangeListener(this);
	}
	
	/**
	 * This method is required if implementing ChangeListener. This
	 * checks for a change in the JSlider object, and gets its new value.
	 * @param e of type ChangeEvent.
	 */
	public void stateChanged(ChangeEvent e){
		JSlider source = (JSlider)e.getSource();
		if (source.getValueIsAdjusting()){
			speed = (int)source.getValue();
		}
	}
	
	/**
	 * This method gets the speed of the JSlider.
	 * @return speed of type integer.
	 */
	public int getSpeed(){
		return speed;
	}
	
	/**
	 * This method gets the JSlider object to be used.
	 * @return slider of type JSlider.
	 */
	public JSlider returnJSliderObject(){
		return slider;
	}
	
	private JSlider slider;
	private int speed = 1;
	
}
