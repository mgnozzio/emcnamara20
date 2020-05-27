import objectdraw.*;
import java.awt.*;
/*
 * This class creates the Vehicle Object. It takes parameters from Lane in 
 * order to specify the image and velocity of the Vehicle.
 * 
 * Eamon McNamara / Purple
 * 5/19/20
 * 
 */
public class Vehicle extends ActiveObject
{
	// For setting Image passed to Vehicle to Visible Image
	private VisibleImage vehicle;
	
	// For keeping track of parameters passed to Vehicle
	private double dir;
	private double pausee;
	private Frog froggg;
	
	// Sets Image parameter to VisibleImage and sets variable above equal to the parameters passed to Vehicle
    public Vehicle(Image cartype, Location start, double direction, double pause, Frog frogg, DrawingCanvas canvas)
    {	
        // insert code to construct the vehicle here
        	
        vehicle = new VisibleImage(cartype, start, canvas);
        dir = direction;
        pausee = pause;
        froggg = frogg;
              start();
              
    }

    // Moves Vehicle by according to the velocity specified through parameters
    // Calls kill if Vehicle and Frog overlap
    // Removes Vehicle when it reaches end of lane
    public void run()
    {
        	double one = System.currentTimeMillis();
        while(vehicle.getX() <= 600 && vehicle.getX()+40 >= 0) {
        	if((System.currentTimeMillis() - one) >= pausee) {
        		one = System.currentTimeMillis();
        		vehicle.move(dir, 0);
        		pause(pausee);
        	}
        	if(froggg.overlaps(vehicle)) {
        		froggg.kill();
        	}
      
        	
        } vehicle.removeFromCanvas();
     }
}





