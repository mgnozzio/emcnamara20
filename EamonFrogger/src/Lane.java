import objectdraw.*;
import java.util.Random;
import java.awt.*;
/*
 * This class creates the Lane Active Object which produces Vehicle Objects that 
 * move across the screen at different directions. It passes parameters from Lane to Vehicle
 * 
 * Eamon McNamara / Purple
 * 5/19/20
 * 
 */

public class Lane extends ActiveObject {

    // Distance from front bumper to back bumper of the longest vehicle, in pixels.
    private static final int MAX_VEHICLE_SIZE = 139;
    
    // For taking setting new car image variable
    private Image cartypeRight;
    private Image cartypeLeft;
    
    // Declares vehicle method
    private Vehicle vehicle;
    
    // Starting location for lanes of both directions
    private Location carStartRight;
    private Location carStartLeft;
    
    // for keeping track of Frog passed to Vehicle
    private Frog fgy;
    
    // For keeping track of pause time passed to Vehicle
    private double pauseTime;
    
    // Keeping track of canvas passed to Vehicle
    private DrawingCanvas canvass;
    
    // Keeping track of direction passed to Vehicle
    private int direc;
    
    // Keeps track of arrays passed to Lane
    private Image[] rightCars;
    private Image[] leftCars;
    
    // For selecting random array element
    RandomIntGenerator car = new RandomIntGenerator(0,3);
    
    // For setting max and min time between new cars
    private double MIN_PAUSETIME;
    private double MAX_PAUSETIME;
    
    // For selecting a randomized pause time
    RandomIntGenerator pauseRand;

    // Takes parameters passed to lane and sets variable equal to the parameters
    public Lane(Image[] right, Image[] left, Location start, int direction, double pause, Frog fg, DrawingCanvas canvas)
    {
        // Add code to construct the lane here.
    	
    	//Sets arrays above equal to arrays passed to Lane
    	rightCars = right;
    	leftCars = left;
    	
    	// Sets locations for the start of each lane
    	carStartRight = start;
    	carStartLeft = new Location(start.getX()+ 600, start.getY());
    	
    	// Sets direc above equal to direction parameter
    	direc = direction;
    	
    	// Set pauseTime variable equal to parameter
    	pauseTime = pause;
    	
    	// Sets Frog above equal to parameter
    	fgy = fg;
    	
    	//Sets canvas above equal to parameter
    	canvass = canvas;
    	
    	//Sets max and min time between new cars
    	MIN_PAUSETIME = 2*pause*MAX_VEHICLE_SIZE;
    	MAX_PAUSETIME = 5*pause*MAX_VEHICLE_SIZE;
    	
    	//Selected a pause time in the given range
    	pauseRand = new RandomIntGenerator((int)MIN_PAUSETIME, (int)MAX_PAUSETIME);
    		

            start();

    }
    // Sets direction of lane and contains a while loop that creates new cars at randomized time intervals 
    public void run()
    {
          
    	double one = System.currentTimeMillis();
    	int gapTime = 0;
        while ( true )
        {
        	if((System.currentTimeMillis() - one) >= gapTime) {
        		one = System.currentTimeMillis();
        		gapTime = pauseRand.nextValue();
        		
        		// Selects a random image from the left and right vehicle arrays
	        	int r = car.nextValue();
	        	cartypeRight = rightCars[r];
	        	
	        	int l = car.nextValue();
	        	cartypeLeft = leftCars[l];
	        	
	        	// passes correct car image based on direction of lane
	        	if (direc == 1) {
	        		vehicle = new Vehicle(cartypeRight, carStartRight, direc, pauseTime, fgy, canvass);
	        		
	        	} else {
	        		vehicle = new Vehicle(cartypeLeft, carStartLeft, direc, pauseTime, fgy, canvass);
	        	} 
            	}
        }
    }


}