import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author Caleb Kinmon (UNI: cgk2128) 
 * <br><br>
 * This class is based on the program found in Courseworks, by John Kender, 
 * who based the program on cay horstmann.
 * <br><br>
 * This class implements the Icon interface which allows us to create a 
 * fixed sized image at a position. An object of this class creates an icon
 * which contains the object we desire to draw (in this case, a unicycle).  
 * This class also uses the MovingObject interface to create the unicycle on
 * the icon.
 */
public class MyIcon implements Icon {
	
	/**
	 * The default constructor takes three parameters, to define the dimensions
	 * of the icon, and to create the MovingObject shape.
	 * @param obj of type MovingObject.
	 * @param w of type int which defines the width.
	 * @param h of type int which defines the height.
	 */
	public MyIcon(ObjectMover obj, int w, int h) {
		this.obj = obj;
		this.width = w;
		this.height = h;
	}
	
	/**
	 * This method is required since we are implementing Icon.
	 * @return width of type integer.
	 */
	public int getIconWidth() {
		return width;
	}

	/**
	 * This method is required since we are implementing Icon.
	 * @return height of type integer.
	 */
	public int getIconHeight() {
		return height;
	}

	/**
	 * This method is required since we are implementing Icon, and it actually
	 * creates the Icon.  It creates a Graphics2D object, and then calls 
	 * the draw method of the MovingObject object, while passing the g2D object.
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2D = (Graphics2D) g;
		obj.draw(g2D);
	}

	private int width;
	private int height;
	private ObjectMover obj;
}
