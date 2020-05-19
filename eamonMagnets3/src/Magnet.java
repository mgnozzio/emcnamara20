
import objectdraw.*;
import java.awt.*;

/*
 * Definition of class of objects used to represent bar magnets.
 * This class creates a magnet method as well as methods for the movement and interaction of the magnet.
 * 
 * Eamon McNamara / Purple
 * 5/19/20
 * 
 * Complete the implementation of these methods and add 
 * the others described in the lab handout.
 */
public class Magnet {

    //  dimensions of magnets	
    private static final double MAGNET_WIDTH = 150;
    private static final double MAGNET_HEIGHT = 50;
    
    //  poles
    private Pole north;
    private Pole south;

    //  Box representing perimeter of magnet
    private FramedRect box;

    //  Create a new magnet at location upperLeft
    public Magnet(Location upperLeft, DrawingCanvas canvas) {
    	System.out.println(upperLeft.getX());
    	box = new FramedRect(upperLeft, MAGNET_WIDTH, MAGNET_HEIGHT, canvas);
    	north = new Pole(this, upperLeft.getX()+ 20, upperLeft.getY()+ MAGNET_HEIGHT/2, "N",canvas);
    	south = new Pole(this, upperLeft.getX()+ MAGNET_WIDTH - 15, upperLeft.getY()+ MAGNET_HEIGHT/2, "S",canvas);
    }

    // returns the upper-left coordinates of the magnet
    public Location getLocation() {
        return box.getLocation();
    }

    // moves object by change in x and y
    public void move(double xoff, double yoff) {
    	box.move(xoff, yoff);
    	north.move(xoff, yoff);
    	south.move(xoff, yoff);
    }

    // moves object to point selected
    public void moveTo(Location point) {
    	double dx = point.getX()- getLocation().getX();
    	double dy = point.getY()- getLocation().getY();
    	move(dx, dy);
    }
    
    // flips the poles of the magnet
    public void flip() {
    	double dxN = south.getX() - north.getX();
    	double dyN = south.getY() - north.getY();
    	double dxS = north.getX() - south.getX();
    	double dyS = north.getY() - south.getY();
    	
    	north.move(dxN, dyN);
    	south.move(dxS, dyS);
    }
    // returns Pole north
    public Pole getNorth() {
    	return north;
    }
    
    // returns Pole south
    public Pole getSouth() {
    	return south;
    }
    
    // causes poles to attract opposite poles and repel similar poles
    public void interact(Magnet other) {
    	north.attract(other.getSouth());
    	north.repel(other.getNorth());
    	south.attract(other.getNorth());
    	south.repel(other.getSouth());
    }

    // tests if the given point is inside the magnet
    public boolean contains(Location point) {
        return box.contains(point);// REPLACE THIS LINE OF CODE WITH THE CORRECT IMPLEMENTATION
    }

    // returns the width of the magnet
    public double getWidth() {
        return MAGNET_WIDTH;
    }

    // returns the height of the magnet
    public double getHeight() {
        return MAGNET_HEIGHT;
    }

}
