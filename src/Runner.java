/**
 * 
 * @author Caleb Kinmon (UNI: cgk2128)
 * <br><br>
 * This class can create an object of the Tester class to 
 * test the creation and movement of unicycles and a group
 * of unicycles. 
 * <br><br>
 * This program is based on the John Kender's GUI program on Courseworks.
 * The MovingObject interface, MyIcon class, and Unicyclist class are all built
 * on the foundation found on Courseworks. For further information, please see
 * each respective class.
 * <br><br>
 * The URL for testing this program can be found here: 
 * <strong><a href="https://youtu.be/hnX9-LcNBAg" /></strong>
 */
public class Runner {
	
	/**
	 * Main method for initiating program.
	 * @param args of type string array.
	 */
	public static void main(String[] args) {
		
		final Tester tester = new Tester();
	
		tester.createUnicycle(-150, 0, SIZE);
		tester.createUnicycle(-50, 0, SIZE * 2);
		tester.createUnicycle(-50, 0, SIZE /3);
		tester.createUnicycle(75, 0, SIZE / 2);
		tester.createUnicycle(50, 0, SIZE / 4);
		tester.createUnicycle(50, 0, SIZE * 3);
		
		tester.initiateMovement();
	}

	private static final int SIZE = 40;
}
