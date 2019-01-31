import java.awt.*;

/**
 * 
 * @author jrk based on cay horstmann
 *
 */
public interface ObjectMover {
	void draw(Graphics2D g2D);
	void translate(int xChange, int yChange);
	void simulateBumps(int xChange);
}