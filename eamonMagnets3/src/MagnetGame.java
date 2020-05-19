import objectdraw.*;
import java.awt.*;

/*
 * This class initializes the magnets and calls their methods appropriately to create MagnetGame.
 * 
 * Eamon McNamara / Purple
 * 5/19/20
 * 
 */
public class MagnetGame extends WindowController {
	
	// two magnets
	private Magnet m1; 
	private Magnet m2; 
	
	// tracks which magnet is selected
	private Magnet moving;
	private Magnet other;
	
	// tracks the previous point
	private Location prior;

	
	//initializes two magnets
	public void begin() {
		m1 = new Magnet(new Location(100,100), canvas);
		m2 = new Magnet(new Location(300,300), canvas);
			
	}

	// tests whether the user has pressed on a magnet and sets magnets moving and other if true
    public void onMousePress(Location point) {
    	if (m1.contains(point)) {
    		moving = m1;
    		other = m2;
    		prior = point;
    	} 
    	else if (m2.contains(point)) {
    		moving = m2;
    		other = m1;
    		prior = point;
    	} else {
    		moving = null;
    		other = null;
    		prior = null;
    	}
    	
    }

    // drags selected magnet
    public void onMouseDrag(Location point) {
    	if (moving != null && other != null && prior != null) {
    		double dx = point.getX() - prior.getX();
    		double dy = point.getY() - prior.getY();
    		
    		moving.move(dx, dy);
    		prior = point;
    		moving.interact(other);
    	}

    }

    // flips poles if magnet is clicked on
    public void onMouseClick(Location point) {
    	if(m1.contains(point)) {
    		m1.flip();
    		m1.interact(m2);
    	}
    	else if(m2.contains(point)) {
    		m2.flip();
    		m2.interact(m1);
    	}

    }
    
    // creates 500x500 window
    public static void main(String[] args) {
    	new MagnetGame().startController(500,500);
    }

}

