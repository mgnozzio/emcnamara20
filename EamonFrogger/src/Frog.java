import objectdraw.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/*
 * This class creates the Frog Object and defines its methods
 * 
 * Eamon McNamara / Purple
 * 5/27/20
 * 
 */
public class Frog
{
    // Height of the frog image
    private static final double FROG_HEIGHT = 48;
 
    // Starting location of frog
    private static final Location FROG_ORIGIN = new Location(300, 525);
    
    // Size of each frog movement
    private static final double HOP_SIZE = 100;

    // To make Image a Visible Image
    private VisibleImage frogImage;
    
    // Keeps track of whether frog is dead or alive
    private boolean frogDead = false;
    
    // Displayed if frog dies
    private Text ouch;
    
    
    // Makes Image a Visible Image
	// Sets text and text color
    public Frog(Image f, DrawingCanvas canvas)
    {
    	
	    frogImage = new VisibleImage(f, FROG_ORIGIN, canvas);
	    ouch = new Text("",FROG_ORIGIN.getX()+ 20, FROG_ORIGIN.getY(), canvas);
	    ouch.setColor(Color.RED);
    	
    	
    }

    // creates boolean to test whether frog and cars overlap
    public  boolean overlaps(VisibleImage vehicleImage)
    {
    	return frogImage.overlaps(vehicleImage);   
    }
    
    // Sets frogDead to true and resets text to "OUCH!"
    public void kill ()
    {
    	frogDead = true;
    	ouch.setText("OUCH!");	
    }
    // Returns frog to starting point and resets frogDead and text
    public void reincarnate()
    {
    	frogImage.hide();
    	frogImage.moveTo(FROG_ORIGIN);
    	frogImage.show();
    	frogDead = false;
    	ouch.setText("");
    }

    // Tells frog which direction to hop based on selected location
    // Calls reincarnate if frog dies
    public void hopToward( Location point )
    {
    	if (!frogDead) {
    	if(frogImage.contains(point)) {
    		return;
    	}
    	else if (point.getX() < frogImage.getX()) {
    		frogImage.move(-1*HOP_SIZE, 0);
    	}else if(point.getX() > frogImage.getX() + frogImage.getWidth()) {
    		frogImage.move(HOP_SIZE, 0);
    	} else if(point.getY() > frogImage.getY()) {
    		frogImage.move(0,HOP_SIZE);
    	}else {
    		frogImage.move(0, -1*HOP_SIZE);
    	}
    	} else reincarnate();

    }

    
    	//public boolean isAlive () {
    	//return !frogImage.isHidden();     // YOU NEED TO CHANGE THIS! I made boolean frogDead instead
    	//}

}
