import objectdraw.*;
import java.awt.*;
/*
 * This class sets the background, initializes the Frog and the Lanes and extends Window controller 
 * see comments throughout for more description
 * 
 * Eamon McNamara / Purple
 * 5/19/20
 * 
 */
public class Frogger extends WindowController{

    // Constants defining the sizes of the background components.
    private static final double HIGHWAY_LENGTH = 700;
    private static final double LANE_WIDTH = 100;
    private static final int NUM_LANES = 4;
    private static final double HIGHWAY_WIDTH = LANE_WIDTH * NUM_LANES;
    private static final double LINE_WIDTH = LANE_WIDTH / 10;

    // Constants defining the locations of the background components
    private static final double HIGHWAY_LEFT = 0;
    private static final double HIGHWAY_RIGHT = HIGHWAY_LEFT + HIGHWAY_LENGTH;
    private static final double HIGHWAY_TOP = LANE_WIDTH;
    private static final double HIGHWAY_BOTTOM = HIGHWAY_TOP + HIGHWAY_WIDTH;

    // Constants describing the lines on the highway
    private static final double LINE_SPACING = LINE_WIDTH / 2;
    private static final double DASH_LENGTH = LANE_WIDTH / 3;
    private static final double DASH_SPACING = DASH_LENGTH / 2;
        
    // Constants for describing the frog
    private static final double FROG_WIDTH = 83;
    
    // Constants for each image used
    private Image frog;
    private Image jeepLeft;
    private Image jeepRight;
    private Image oldCarLeft;
    private Image oldCarRight;
    private Image taxiLeft;
    private Image taxiRight;
    private Image vanLeft;
    private Image vanRight;
    
    // Arrays for cars facing right and cars facing left
    private Image[] rightCars;
    private Image[] leftCars;
    
    // gets each image file when called
    public void getMyImages() {
    	frog = getImage("froggy.gif");
    	jeepLeft = getImage("jeep_left.gif");
    	jeepRight = getImage("jeep_right.gif");
    	oldCarLeft = getImage("oldcar_left.gif");
    	oldCarRight = getImage("oldcar_right.gif");
    	taxiLeft = getImage("taxi_left.gif");
    	taxiRight = getImage( "taxi_right.gif");
    	vanLeft = getImage("van_left.gif");
    	vanRight = getImage("van_right.gif");
    }
    
    // Constant to keep track of frog
    private Frog frg;

    // This method current just draws the highway.  
    // You will have to add instructions to create
    // the frog and the Lane ActiveObjects.
    public void begin()
    {
    // This segment gets the images and assigns them to the correct array	
    getMyImages();
    Image[] tempRight = {jeepRight, oldCarRight, taxiRight, vanRight};
    rightCars = tempRight;
    Image[] tempLeft = {jeepLeft, oldCarLeft, taxiLeft, vanLeft};
    leftCars = tempLeft;
    
	// Draw the highway background
	new FilledRect (HIGHWAY_LEFT, 
                	HIGHWAY_TOP, 
                	HIGHWAY_LENGTH, 
                	HIGHWAY_WIDTH, 
                	canvas);

	// Draw the lane dividers
	int whichLine = 1;
	while (whichLine < NUM_LANES) {
	    if (whichLine == NUM_LANES / 2) {
		// The middle line is a no passing line
		drawNoPassingLine (HIGHWAY_TOP + (whichLine * LANE_WIDTH) -
				   (LINE_SPACING / 2 + LINE_WIDTH));
	    }
	    else {
		drawPassingLine (HIGHWAY_TOP + (whichLine * LANE_WIDTH) -
				 (LINE_WIDTH / 2));
	    }
	    whichLine = whichLine + 1;
	}
	resize((int)HIGHWAY_LENGTH, (int)(HIGHWAY_WIDTH+3*LANE_WIDTH));
	
	
	
	// ADD YOUR CODE TO CREATE THE FROG AND THE LANES
	
	// initializes frog
	frg = new Frog(frog, canvas);
	
	// Array for different pause times
	int[] speeds = {11, 16, 7,20};
	
	// Assigns a direction (1 or -1 for right and left),
	//assigns speeds/pause times, and initializes NUM_LANES lanes.
	for(int i = 0; i < NUM_LANES; i++) {
		int direction = 1;
		if(i < 2) {
			direction = -1;
		}
		Location beginLane = new Location(HIGHWAY_LEFT, HIGHWAY_TOP + (i+.2)*LANE_WIDTH);
		double pauseTime = speeds[i%4];
		new Lane(rightCars, leftCars, beginLane, direction, pauseTime, frg, canvas);
	}
    }

    // Draws a pair of solid yellow lines to represent a no passing 
    // divider between lanes
    // Parameter:  y - the top of the top line
    //
    // YOU SHOULD NOT NEED TO MODIFY THIS METHOD
    //
    public void drawNoPassingLine (double y) {
	// Draw the solid dividing lines
	FilledRect topLine = new FilledRect (HIGHWAY_LEFT, 
					     y, 
					     HIGHWAY_LENGTH, 
					     LINE_WIDTH, 
					     canvas);
	topLine.setColor (Color.yellow);

	FilledRect bottomLine = new FilledRect (HIGHWAY_LEFT, 
						y + LINE_WIDTH + LINE_SPACING,
						HIGHWAY_LENGTH, 
						LINE_WIDTH, 
						canvas);
	bottomLine.setColor (Color.yellow);
    }

    // Draws a dashed white line to represent a passing line dividing two 
    // lanes of traffic
    // Parameters:  y - the top of the line.
    //
    // YOU SHOULD NOT NEED TO MODIFY THIS METHOD
    //
    public void drawPassingLine (double y) {
	double x = HIGHWAY_LEFT;
	FilledRect dash;

	while (x < HIGHWAY_RIGHT) {
	    // Draw the next dash.
	    dash = new FilledRect (x, y, DASH_LENGTH, LINE_WIDTH, canvas);
	    dash.setColor (Color.white);
	    x = x + DASH_LENGTH + DASH_SPACING;
	}

    }

    // Note: Use onMousePress rather than onMouseClick to decide when to move the frog
    // calls hopToward on press
    public void onMousePress(Location point)
    {
    	frg.hopToward(point);
    	
    	

    }
    
	public static void main(String[] args) {
    	new Frogger().startController(500,500);
    }

}




