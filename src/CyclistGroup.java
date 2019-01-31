import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * 
 * @author Caleb Kinmon (UNI: cgk2128)
 * <br><br>
 * An instance of this class is used to group together unicycles such that
 * they travel together, but with different sizes and positions. 
 * <br><br>
 * This class implements the MovingObject interface so that the group has
 * the ability to move and be drawn. As such, it requires the definition of
 * the draw and translate methods, which were poached from John Kender's program
 * off courseworks.
 * <br><br> 
 * This class encapsulates Unicycle objects in an ArrayList, a component
 * of the composite pattern, so that multiple unicycles can be on the screen
 * at one time. 
 *
 */
public class CyclistGroup implements ObjectMover {

	/**
	 * The default constructor creates a data structure that can
	 * be used to hold objects of type MovingObject.
	 */
	CyclistGroup(){
		cyclistGroup = new ArrayList<ObjectMover>();
	}
	
	/**
	 * This method adds a MovingObject object to the data structure.
	 * @param object of type MovingObject.
	 */
	public void add(ObjectMover object){
		cyclistGroup.add(object);
	}
	
	/**
	 * This method creates each object in the data structure, while
	 * maintaining each object's position and size.
	 * @param g2D of type Graphics2D. 
	 */
	public void draw(Graphics2D g2D){
		for(ObjectMover mover : cyclistGroup){
			mover.draw(g2D);
		}
	}
	
	/**
	 * This method adjusts/updates the position of each object in the 
	 * data structure.
	 * @param xChange of type int.
	 * @param yChange of type int.
	 */
	public void translate(int xChange, int yChange){
		for(ObjectMover mover : cyclistGroup){
			mover.translate(xChange, yChange);
		}
	}
	
	/**
	 * This method simulates up and down motion of the cyclists.
	 * @param xChange of type int.
	 */
	public void simulateBumps(int xChange){
		for(ObjectMover mover : cyclistGroup){
			mover.simulateBumps(xChange);
		}
	}
	
	private ArrayList<ObjectMover> cyclistGroup;
}
