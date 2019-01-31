import java.awt.*;
import java.awt.geom.*;

/**
 * 
 * @author Caleb Kinmon (UNI: cgk2128) 
 * <br><br>
 * This class is based on the program found in Courseworks, by John Kender, 
 * who based the program off of cay horstmann.
 * <br><br>
 * This class implements the MovingObject interface, which defines the two methods
 * translate() and draw().
 * <br><br>
 * The purpose of Unicyclist is to create an image of a unicycle, where the size and 
 * position is relative based on what the user wants.  This class also provides the 
 * ability for the unicycle to move across the screen along the x axis.  When the
 * unicycle reaches the end of the screen, its position is reset and appears to
 * wrap around to the other side and travel across the screen again.
 * <br><br>
 * This class was extended such that the unicycle bumps up and down as it
 * travels (see simulateBumps() method).  
 *
 */
public class Unicyclist implements ObjectMover {

	/**
	 * This is the default constructor. It must take three parameters
	 * because we need to know the x and y position of the unicycle,
	 * and we need to know its size (unit). 
	 * @param x of type integer which represents the position on x axis.
	 * @param y of type integer which represents the position on y axis.
	 * @param unit of type integer which represents its size.
	 */
	public Unicyclist(int x, int y, int unit) {
		this.x = x;
		this.y = y;
		this.unit = unit;
	}

	/**
	 * This method updates the position of the unicycle.
	 * This method was extneded such that the unicle wraps around
	 * the screen and it simulates an up-and-down motion.
	 * @param xChange of type integer which represents the change in x position.
	 * @param yChange of type integer which represents the change in y position.
	 */
	public void translate(int xChange, int yChange) {
		x += xChange;
		this.wrapAroundScreen();
	}

	/**
	 * This method draws the shape of the unicycle. It calls private methods
	 * to draw each component of the unicycle.
	 * @param g2D of type Graphics2D.
	 */
	public void draw(Graphics2D g2D) {
		
		xCenter = x + unit / 2;
		
		this.drawWheel();
		this.drawBody();
		this.drawSeat();
		this.createGeneralPath();

		g2D.fill(seat);
		g2D.draw(bike);
	}
	
	/**
	 * This helper method ensures that the unicycle wraps around the
	 * screen when it reaches the end.
	 */
	private void wrapAroundScreen(){
		if(x > screenSize.getWidth()){
			x = 0;
		}
	}
	
	/**
	 * This helper method changes the y position plus and minus one pixel
	 * so that the unicycle bounces up and down.
	 */
	public void simulateBumps(int xChange){
		if(xChange != 0){
			if(y == 0){
				y++;
			}
			else{
				y--;
			}
		}else{
			y = 0;
		}
	}
	
	/**
	 * This method creates two circles, one nested inside the other,
	 * that simulates the wheel of the unicycle.
	 */
	private void drawWheel(){
		
		// inside circle
		int innerCircleXPosition = x;
		int innerCircleYPosition = seatYPosition + (int)(unit * 2.5);
		insideRadius = unit;
		innerCircle = new Ellipse2D.Double(innerCircleXPosition, innerCircleYPosition, insideRadius, insideRadius);
		
		// outerCircle circle
		int outerCircleXPosition = x - (unit / 2);
		int outerCircleYPosition = seatYPosition + (unit * 2);
		int outsideRadius = unit * 2;
		outerCircle = new Ellipse2D.Double(outerCircleXPosition, outerCircleYPosition, outsideRadius, outsideRadius);
	}
	
	/**
	 * This method creates a line from the center of the inner circle to the
	 * bottom of the rectangle to simulate the frame/body of the unicycle.
	 */
	private void drawBody(){
		
		int bodyXTopPosition = xCenter;
		int bodyYTopPosition = seatYPosition;
		int bodyXBotPosition = xCenter;
		int bodyYBotPosition = unit * 5;
		body = new Line2D.Double(bodyXTopPosition, bodyYTopPosition, bodyXBotPosition, bodyYBotPosition);
	}

	/**
	 * This helper method creates a rectangle that is positioned on top of the
	 * body/frame to simulate the seat of the unicycle.
	 */
	private void drawSeat(){
	
		int seatXPosition = x;
		seatYPosition = y + (unit * 2);
		int seatWidth = unit;
		int seatLength = unit / 2;
		seat = new Rectangle2D.Double(seatXPosition, seatYPosition, seatWidth, seatLength);
	}

	/**
	 * This helper method pulls together the wheel and body of the unicycle.
	 */
	private void createGeneralPath(){
		bike = new GeneralPath();
		bike.append(body, false);
		bike.append(innerCircle, false);
		bike.append(outerCircle, false);
	}

	private int x;
	private int y;
	private int unit;
	private Ellipse2D.Double innerCircle;
	private Ellipse2D.Double outerCircle;
	private Line2D.Double body;
	private Rectangle2D.Double seat;
	private GeneralPath bike;
	private int xCenter;
	private int seatYPosition;
	private int insideRadius;
	// I took this code from here to get screen size for wrapping objects:
	// https://alvinalexander.com/blog/post/jfc-swing/how-determine-get-screen-size-java-swing-app
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
}
